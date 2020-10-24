package PBO1;

/**
 *
 * @author Faris Ikhlasul H
 */
public class KabelLan extends Kabel {

    private String tipeKabel;

    public void tipeKabel(String newValue) {
        tipeKabel = newValue;
    }

    public void cetakStatus() {
        super.cetakStatus();
        System.out.println("Tipe Kabel \t: " + tipeKabel);

    }
}
