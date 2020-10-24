package PBO1;

/**
 *
 * @author Faris Ikhlasul H
 */
public class Printer {

    private String merek;
    private String warna;
    private int cetak;
    private int tinta;
    public void setMerek(String newValue) {
        merek = newValue;
    }
    public void setWarna(String newValues) {
        warna = newValues;
    }
    public void cetakKertas(int increment) {
        cetak = cetak + increment;
    }
    public void tintaBertambah(int increment) {
        tinta = tinta + increment;
    }
    public void tintaBerkurang(int decrement) {
        tinta = tinta - decrement;
    }
    public void cetakStatus() {
        System.out.println();
        System.out.println("Merek         : " + merek);
        System.out.println("Warna           : " + warna);
        System.out.println("Jumlah Cetakan  : " + cetak);
        System.out.println("tinta           : " + tinta + " " + "ml");
    }
}