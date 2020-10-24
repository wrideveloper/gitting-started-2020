/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CaesarCipher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Mashaa
 */
public class CaesarCipher_Controller {
    private Cipher cipher;
    CaesarCipher cc = new CaesarCipher();
    private List<Integer> list = new ArrayList<>();

    public CaesarCipher_Controller(Cipher chiper) {
        this.cipher = chiper;
        this.cipher.getjButtonBaca().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                proses();
            }
        });
         this.cipher.getjButtonSimpan().addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 save();
             }
         });
    }
    private void proses() {
             JFileChooser loadFile = cipher.getLoadFile();
             StyledDocument doc = cipher.getjTextPane().getStyledDocument();
             if (JFileChooser.APPROVE_OPTION == loadFile.showOpenDialog(cipher)) {
                 BufferedInputStream reader = null;
                 try {
                     reader = new BufferedInputStream(new FileInputStream(loadFile.getSelectedFile()));
                     doc.insertString(0, "", null);
                     int temp = 0;
                     List<Integer> list = new ArrayList<>();
                     while ((temp=reader.read()) != -1) {                    
                         list.add(temp);
                     }
                     int countword = 0;
                    char ascii;
                    String word;
                    int countchar = 0;
                    int lines = 0;
                     LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(loadFile.getSelectedFile()));
                     while ((word = lineNumberReader.readLine()) != null) {
                     
                     String[] wording = word.split("\\s+");
                     System.out.println("" + word + " at line " + lineNumberReader.getLineNumber());
                     
                     countword += wording.length;
                     countchar += word.length();
                 }
                     lines += lineNumberReader.getLineNumber(); 
                     if (!list.isEmpty()) {
                         byte[] dt = new byte[list.size()];
                         int i = 0;
                         for (Integer integer : list) {
                             dt[i]=integer.byteValue();
                             i++;
                         }
                         String decrypt = cc.decrypt(new String(dt), -7).toString();
                         doc.insertString(doc.getLength(), decrypt, null);
                         JOptionPane.showMessageDialog(cipher, "File Opened!\n"
                                 + "Numbers of line : " + lines 
                                 + "\nNumber of Word : " + countword 
                                 + "\nNumber of Char : " + countchar, "Informasi", JOptionPane.INFORMATION_MESSAGE);
                     }
                 } catch (FileNotFoundException ex) {
                     Logger.getLogger(CaesarCipher_Controller.class.getName()).log(Level.SEVERE, null, ex);
                 } catch (IOException | BadLocationException ex) {
                     Logger.getLogger(CaesarCipher_Controller.class.getName()).log(Level.SEVERE, null, ex);
                 } finally {
                     if (reader != null) {
                         try {
                             reader.close();
                         } catch (IOException ex) {
                             Logger.getLogger(CaesarCipher_Controller.class.getName()).log(Level.SEVERE, null, ex);
                         }
                     }
                 }
             }
     }

     private void save() {
         String encrypt = cc.encrypt(cipher.getjTextPane().getText(), 7).toString();
         JFileChooser loadFile = cipher.getLoadFile();
         if (JFileChooser.APPROVE_OPTION == loadFile.showSaveDialog(cipher)) {
             BufferedOutputStream writer = null;
             try {
                 String contents = encrypt;
                 if (contents != null && !contents.isEmpty()) {
                     writer = new BufferedOutputStream(new FileOutputStream(loadFile.getSelectedFile()));
                     writer.write(contents.getBytes());
                     JOptionPane.showMessageDialog(cipher, "File Saved.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                 }

             } catch (FileNotFoundException ex) {
                 Logger.getLogger(CaesarCipher_Controller.class.getName()).log(Level.SEVERE, null, ex);
             } catch (IOException ex) {
                 Logger.getLogger(CaesarCipher_Controller.class.getName()).log(Level.SEVERE, null, ex);
             } finally {
                 if (writer != null) {
                     try {
                         writer.flush();
                         writer.close();
                         cipher.getjTextPane().setText("");
                     } catch (IOException ex) {
                         Logger.getLogger(CaesarCipher_Controller.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
             }
         }
     }
}
