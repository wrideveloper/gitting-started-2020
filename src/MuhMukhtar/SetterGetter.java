/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Soal1;

/**
 *
 * @author Mukhtar
 */
public class SetterGetter {

    private String nama;
    private int nim;
    
    public SetterGetter(String nama, int nim){
        this.nama = nama;
        this.nim = nim;
    }

//    public void setNama(String nama) {
//        this.nama = nama;
//    }

    public String getNama() {
        return nama;
    }

//    public void setNim(int nim) {
//        this.nim = nim;
//    }

    public int getNim() {
        return nim;
    }
}
