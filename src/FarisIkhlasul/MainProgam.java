package uas_smt2;

import java.util.Scanner;

/**
 *
 * @author Faris Ikhlasul H
 */
public class MainProgam {

    static void menu() {
        System.out.println("===================================");
        System.out.println(" UJIAN AKHIR SEMESTER PENJUALAN CD ");
        System.out.println("===================================");
        System.out.println("1.CD Masuk");
        System.out.println("2.CD Keluar");
        System.out.println("3.CD Rusak");
        System.out.println("4.Tampilkan Semua Data");
        System.out.println("5.Pencarian CD (Berdasarkan Kode CD)");
        System.out.println("6.Keluar");
        System.out.println("==================================");
    }

    public static void main(String[] args) throws Exception {
        Scanner faris = new Scanner(System.in);
        Scanner haq = new Scanner(System.in);
        DoubleLinkedList ddl = new DoubleLinkedList();
        String nama, judul;
        int stock, menu, idx, kode, rusak, kodecari;
        do {
            menu();
            System.out.print(">>");
            menu = faris.nextInt();
            System.out.println("==================================");
            switch (menu) {
                case 1:
                    System.out.print("Kode\t\t: ");
                    kode = faris.nextInt();
                    System.out.print("Judul\t\t:");
                    judul = haq.next();
                    System.out.print("Distributor\t: ");
                    nama = faris.next();
                    System.out.print("Jumlah Stock\t:");
                    stock = faris.nextInt();
                    System.out.print("Jumlah Rusak\t:");
                    rusak = faris.nextInt();
                    ddl.addFirst(kode, judul, nama, stock, rusak);
                    break;
                case 2:
                    System.out.print("Masukkan Posisi Index Data Yang Ingin Dikeluarkan: ");
                    idx = faris.nextInt();
                    ddl.remove(idx);
                    ddl.print();
                    break;
                case 3:
//                    System.out.println("CD yang rusak : "+rusak);
                    break;
                case 4:
                    ddl.Urut();
                    ddl.print();
                    break;
                case 5:
                    System.out.print("Masukkan Kode CD   : ");
                    kodecari = faris.nextInt();
                    ddl.pencarian(kodecari);
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        } while (menu == 1 || menu == 2 || menu == 3 || menu == 4 || menu == 5 || menu == 6);
    }
}
