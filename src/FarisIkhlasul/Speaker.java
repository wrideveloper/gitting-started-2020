package PBO1;

/**
 *
 * @author Faris Ikhlasul H
 */
public class Speaker {

    private String tipeSpeaker;
    private String merkSpeaker;
    private String warna;
    private int volume;
    private int bass;
    private int treable;
    private int fade;
    public void setWarna(String newValues) {
        warna = newValues;
    }
    public void tipeSpeaker(String newValues) {
        tipeSpeaker = newValues;
    }
    public void merkSpeaker(String newValues) {
        merkSpeaker = newValues;
    }
    public void volume(int newValues) {
        volume = newValues;
    }
    public void treable(int newValues) {
        treable = newValues;
    }
    public void bass(int newValues) {
        bass = newValues;
    }
    public void fade(int newValues) {
        fade = newValues;
    }
    public void setTambahVolume(int increment) {
        volume = volume + increment;
    }
    public void setKurangVolume(int decrement) {
        volume = volume - decrement;
    }
    public void setTambahBass(int increment) {
        bass = bass + increment;
    }
    public void setKurangBass(int decrement) {
        bass = bass - decrement;
    }
    public void setTambahTreable(int increment) {
        treable = treable + increment;
    }
    public void setKurangTreable(int decrement) {
        treable = treable - decrement;
    }
    public void setAturKiriFade(int increment) {
        fade = fade + increment;
    }
    public void setAturKananFade(int decrement) {
        fade = fade - decrement;
    }
    public void cetakStatus() {
        System.out.println();
        System.out.println("Merk            : " + merkSpeaker);
        System.out.println("Tipe Printer    : " + tipeSpeaker);
        System.out.println("Warna Printer   : " + warna);
        System.out.println("Volume          : " + volume);
        System.out.println("Trable          : " + treable);
        System.out.println("Bass            : " + bass);
        System.out.println("Fade            : " + fade);
    }
}
