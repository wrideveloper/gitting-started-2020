package PBO1;

/**
 *
 * @author Faris Ikhlasul H
 */
public class LaptopUltrabook extends Laptop {

    private String jenis;
    private String numpad;

    public void setJenis(String newValue) {
        jenis = newValue;
    }
    public void setNumpad(String newValue) {
        numpad = newValue;
    }
    public void cetakStatus() {
        super.cetakStatus();
        System.out.println("Jenis   \t\t\t: " + jenis);
        System.out.println("Numpad  \t\t\t: " + numpad);
    }
}
