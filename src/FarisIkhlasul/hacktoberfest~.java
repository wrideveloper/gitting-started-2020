package fungsi2;

import java.util.Scanner;

public class hacktoberfest~ {

    public static void main(String[] args) {
        int bln;
        Scanner faris = new Scanner(System.in);
        System.out.println("REKURSIF PERKEMBANGBIAKAN KELINCI");
        System.out.println("==================================");
        System.out.print("Masukan Bulan : ");
        bln = faris.nextInt();

        System.out.println("Produkttif = " + Produksi(bln));
        System.out.println("Belum Produktif = " + NonProduksi(bln));
        System.out.println("Total Pasangan = " + total(bln));
    }

    public static int Produksi(int a) {
        if (a <= 2) {
            return 0;
        } else if (a == 3) {
            return 1;
        } else {
            return Produksi(a - 1) + Produksi(a - 2);
        }
    }

    public static int NonProduksi(int b) {
        if (b == 0) {
            return 0;
        } else if (b <= 3) {
            return 1;
        } else {
            return NonProduksi(b - 1) + NonProduksi(b - 2);
        }
    }

    public static int total(int c) {
        if (c == 0) {
            return 0;
        } else if (c == 1) {
            return 1;
        } else {
            return total(c - 1) + total(c - 2);
        }
    }
}
