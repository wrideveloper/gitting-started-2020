/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dharma.pertemuan03.bab33;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author dharma
 */
public class Praktikum33 {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Syntax - FileInputStreamDemo file");
            return;
        }

        try {
            InputStream fileInput = new FileInputStream(args[0]);
            int data = fileInput.read();

            while (data != -1) {
                System.out.write(data);
                data = fileInput.read();
            }
            fileInput.close();
        } catch (IOException e) {
            System.err.println("I/O Error - " + e);
        }
    }
}
