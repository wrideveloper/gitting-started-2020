package uas_smt2;

/**
 *
 * @author Faris Ikhlasul H
 */
public class Node {

    int stock, rusak,kode;
    String nama, judul;
    Node prev, next;

    public Node(Node prev, String judul, String nama, int kode, int rusak, int stock, Node next) {
        this.prev = prev;
        this.next = next;
        this.kode = kode;
        this.nama = nama;
        this.stock = stock;
        this.rusak = rusak;
        this.judul = judul;
    }
}
