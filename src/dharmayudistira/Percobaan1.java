/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dharma.pertemuan02;

import java.net.UnknownHostException;
import java.net.InetAddress;
/**
 *
 * @author dharma
 */
public class Percobaan1 {
    public static void main(String[] args) {
        try {
            InetAddress inet1 = InetAddress.getByName("psmi.poltek-malang.ac.id");
            System.out.println("Host Address = " + inet1.getHostAddress());
            InetAddress inet2 = InetAddress.getByName("192.168.134.134");
            System.out.println("Host Name = " + inet2.getHostName());
            
            if (inet1.equals(inet2)) {
                System.out.println("Alamat sama!");
            }else {
                System.out.println("Alamat tidak sama");
            }
        }catch(UnknownHostException ex) {
            ex.printStackTrace();
        }
    }
}
