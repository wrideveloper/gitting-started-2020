package PBO1;

/**
 *
 * @author Faris Ikhlasul H
 */
public class Kabel {

    private String merek;
    private String warna;
    private String serat;
    private int muai;

    public void setMerek(String newValue) {
        merek = newValue;
    }
    public void setWarna(String newValues) {
        warna = newValues;
    }
    public void setSerat(String newValues) {
        serat = newValues;
    }
    public void kabelMemuai(int increment) {
        muai = muai + increment;
    }
    public void cetakStatus() {
        System.out.println();
        System.out.println("");
        System.out.println("Merek                : " + merek);
        System.out.println("Warna                : " + warna);
        System.out.println("Serat                : " + serat);
        System.out.println("Kabel Setelah Memuai : " + muai + " " + "cm");
    }
}
