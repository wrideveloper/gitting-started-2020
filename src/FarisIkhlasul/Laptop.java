package PBO1;

/**
 *
 * @author Faris Ikhlasul H
 */
public class Laptop {

    private String tipeLaptop;
    private String merkLaptop;
    private String warna;
    private int kb;
    public void setWarna(String newValues) {
        warna = newValues;
    }
    public void tipeLaptop(String newValues) {
        tipeLaptop = newValues;
    }
    public void merkLaptop(String newValues) {
        merkLaptop = newValues;
    }
    public void baterai(int newValues) {
        kb = newValues;
    }
    public void kesehatanBaterai(int decrement) {
        kb = kb - decrement;
    }
    public void cetakStatus() {
        System.out.println();
        System.out.println("Merk                         : " + merkLaptop);
        System.out.println("Tipe Laptop                  : " + tipeLaptop);
        System.out.println("Warna Laptop                 : " + warna);
        System.out.println("Kesehatan Baterai Sekarang   : " + kb + "" + "%");
    }
}
