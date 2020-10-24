/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dharma.pertemuan02;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author dharma
 */
public class Percobaan2 {
    public static void main(String[] args) {
        Scanner scString = new Scanner(System.in);
        
        System.out.println("Masukkan nama host: ");
        cariAlamatIP(scString.next());
    }
    
    private static void cariAlamatIP(String namaHost) {
        try {
            InetAddress inet1 = InetAddress.getByName(namaHost);
            System.out.println("ALamat IP = " + inet1.getHostAddress());
        }catch(UnknownHostException ex) {
            ex.printStackTrace();
        }
    }
}
