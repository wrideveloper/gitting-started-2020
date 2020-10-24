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
public class MainSetGet {

    public static void main(String[] args) {
        SetterGetter mhs = new SetterGetter("Muhammad Mukhtar", 1941720194);

//        mhs.setNama("Muhammad Mukhtar");
//        mhs.setNim(1941720194);

        System.out.println("Data Mahasiswa : ");
        System.out.println("Nama : " + mhs.getNama());
        System.out.println("NIM : " + mhs.getNim());
    }
}
