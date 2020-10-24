package PBO1;
/**
 *
 * @author Faris Ikhlasul H
 */
public class LaptopGaming extends Laptop {

    private String kartuGrafis;
    private String keyboard;
    private String Processor;
    private int clock;
    public void setJenisKartu(String newValue) {
        kartuGrafis = newValue;
    }
    public void setJenisKeyboard(String newValues) {
        keyboard = newValues;
    }
    public void setJenisProcessor(String newValues) {
        Processor = newValues;
    }
    public void setClock(int newValues) {
        clock = newValues;
    }
    public void clockUp(int increment) {
        clock = clock + increment;
    }
    public void clockDown(int decrement) {
        clock = clock + decrement;
    }
    public void cetakStatus() {
        super.cetakStatus();
        System.out.println("Kartu Grafis         : " + kartuGrafis);
        System.out.println("Jenis Keyboard       : " + keyboard);
        System.out.println("Jenis Processor      : " + Processor);
        System.out.println("Clock Sekarang       : " + clock + " " + "Mhz");
    }
}
