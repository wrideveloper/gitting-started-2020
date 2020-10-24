package PBO1;

public class Tugas {

    public static void main(String[] args) {

        Printer print = new Printer();
        Laptop lp = new Laptop();
        LaptopGaming lpg = new LaptopGaming();
        LaptopUltrabook lpu = new LaptopUltrabook();
        Kabel kb = new Kabel();
        KabelLan Lan = new KabelLan();
        Speaker spk = new Speaker();

        System.out.println("===== PRINTER =====");
        print.setMerek("Epson");
        print.setWarna("Hitam");
        print.cetakKertas(2);
        print.tintaBertambah(12);
        print.tintaBerkurang(6);
        print.tintaBerkurang(3);
        print.cetakKertas(3);
        print.cetakStatus();

        System.out.println("===== KABEL =====");
        kb.setMerek("Firstmedia");
        kb.setWarna("Abu-Abu");
        kb.setSerat("Tembaga");
        kb.kabelMemuai(4);
        kb.cetakStatus();

        System.out.println("===== KABEL LAN =====");
        Lan.setMerek("Biznet");
        Lan.setWarna("Kuning");
        Lan.setSerat("Serat Kaca");
        Lan.kabelMemuai(4);
        Lan.tipeKabel("Fiber Optic");
        Lan.cetakStatus();

        System.out.println("===== LAPTOP =====");
        lp.merkLaptop("ACER");
        lp.setWarna("Abu-Abu");
        lp.tipeLaptop("E5-475G");
        lp.baterai(100);
        lp.kesehatanBaterai(10);
        lp.kesehatanBaterai(5);
        lp.kesehatanBaterai(20);
        lp.kesehatanBaterai(5);
        lp.cetakStatus();

        System.out.println("===== SPEAKER =====");
        spk.merkSpeaker("Harman Kardon");
        spk.tipeSpeaker("Bluetooth Speaker");
        spk.setWarna("Hitam");
        spk.volume(90);
        spk.treable(20);
        spk.bass(15);
        spk.fade(10);
        spk.setTambahVolume(3);
        spk.setKurangVolume(7);
        spk.setTambahTreable(10);
        spk.setKurangTreable(5);
        spk.setAturKananFade(5);
        spk.setAturKiriFade(3);
        spk.setTambahBass(5);
        spk.setKurangBass(4);
        spk.cetakStatus();
        System.out.println("");

        System.out.println("===== LAPTOP GAMING =====");
        lpg.merkLaptop("ASUS");
        lpg.setWarna("Abu-Abu");
        lpg.tipeLaptop("FX505DT");
        lpg.baterai(100);
        lpg.kesehatanBaterai(10);
        lpg.kesehatanBaterai(3);
        lpg.setJenisKartu("GTX 1650");
        lpg.setJenisProcessor("Ryzen 5 3550H");
        lpg.setJenisKeyboard("RGB");
        lpg.setClock(3500);
        lpg.clockDown(2100);
        lpg.clockUp(1100);
        lpg.clockDown(500);
        lpg.clockUp(500);
        lpg.clockDown(100);
        lpg.cetakStatus();
        System.out.println("");

        System.out.println("===== LAPTOP ULTRABOOK =====");
        lpu.merkLaptop("ASUS");
        lpu.setWarna("Abu-Abu");
        lpu.tipeLaptop("UX451U");
        lpu.baterai(100);
        lpu.kesehatanBaterai(4);
        lpu.kesehatanBaterai(9);
        lpu.setJenis("Tablet Touch");
        lpu.setNumpad("In Screen");
        lpu.cetakStatus();
    }
}
