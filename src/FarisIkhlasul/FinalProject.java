package pkgfinal.project;

/**
 *
 * @author Faris Ikhlasul H
 */
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Random;

public class FinalProject {
    //Deklarasi Global Dan Scanner ========================================================================

    static Scanner Final = new Scanner(System.in);
    static Scanner Spasi = new Scanner(System.in);
    static Random bebas = new Random();
    static int save = 0;
    static int save1 = 0;
    static int number = bebas.nextInt(99999999);
    static char jenisKirim, jenisBarang, jenisPackaging, Asuransi, CtkResi;
    static double berat, MsknUang, total = 0, pajak = 0, kembalian, pajakPerlindungan = 0;
    static String Wilayah, Kecamatan, Identitas, NamaAnda, NamaTujuan;

    //Khusus Array ========================================================================================
    static String[] provinsi
            = {"Jawa Timur", "Jawa Tengah", "Jawa Barat", "Sumatra Selatan", "Bali", "Kalimantan Selatan"};
    static String[][] Kota
            = {
                //Jawa Timur
                {"Gresik", "Surabaya", "Ngawi", "Nganjuk", "Jombang", "Madiun"},
                //Jawa Tengah
                {"Semarang", "Pekalongan", "Pemalang", "Solo", "Sragen", "Magelang"},
                //Jawa Barat
                {"Bandung", "Sukabumi", "Cirebon", "Subang", "Karawang", "Indramayu"},
                //Sumatra Selatan
                {"Lampung", "Palembang", "Pagar Alam", "Muara Enim", "Baturaja", "Lahat"},
                //Bali
                {"Denpasar", "Singaraja", "Buleleng", "Gianyar", "Karangasem", "Tabanan"},
                //Kalimantan Selatan
                {"Banjarmasin", "Banjarbaru", "Martapura", "Tanjung", "Batulicin", "Amuntai"}
            };
    static String[] PengecekanResi = {"262131455", "275677856", "133467546"};
    static String[][] PengecekanBarang
            = {
                {"Nama Pengiriman     : Dhimas Arbis Sukma Himawan\n"
                    + "Nama Penerima       : Faris Ikhlasul Haq\n"
                    + "Nomor Resi          : 262131455\n"
                    + "Dari Prov/Kota/Kec  : Kalimantan Selatan/Martapura/Sisingmaraja \n"
                    + "Tujuan              : Jawa Timur/Malang/Karangploso \n"
                    + "Berat Barang        : 10 Kg\n"
                    + "Jenis Pengiriman    : YES (Yakin Esok Sampai)\n"
                    + "Jenis Bahan         : Fragile(Mudah Rusak/ Pecah Belah)\n"
                    + "Status Pengiriman   : Manifest Martapura"},
                {"Nama Pengiriman     : Khoirul Wahyudin\n"
                    + "Nama Penerima       : Faris Ikhlasul Haq\n"
                    + "Nomor Resi          : 275677856\n"
                    + "Dari Prov/Kota/Kec  : Bali/Denpasar/Buleleng \n"
                    + "Tujuan              : Jawa Timur/Malang/Karangploso \n"
                    + "Berat Barang        : 20 Kg\n"
                    + "Jenis Pengiriman    : Regular \n"
                    + "Jenis Bahan         : Standar\n)"
                    + "Status Pengiriman   : On The Way"},
                {"Nama Pengiriman     : Rasyed Renaldi\n"
                    + "Nama Penerima       : Faris Ikhlasul Haq\n"
                    + "Nomor Resi          : 133467546\n"
                    + "Dari Prov/Kota/Kec  : Kalimantan Selatan/Banjarmasin/Banjar \n"
                    + "Tujuan              : Jawa Timur/Malang/Karangploso \n"
                    + "Berat Barang        : 5 Kg\n"
                    + "Jenis Pengiriman    : Ekonomis\n"
                    + "Jenis Bahan         : Standar \n"
                    + "Status Pengiriman   : Deliver Branch Malang"}

            };

    public static void main(String[] args) {
        String username, password;
        boolean cek = true;
        boolean test;
        System.out.println("==================================================");
        System.out.println("||||| SELAMAT DATANG DI SISTEM HiF EKSPEDISI |||||");
        System.out.println("|||||||||||| Politeknik Negeri Malang ||||||||||||");
        System.out.println("||||||||||||||||| WILAYAH MALANG |||||||||||||||||");
        System.out.println("==================================================");
        System.out.println();
        System.out.println("Silahkan Login Akun Anda");
        System.out.println("========================");
        System.out.print("Masukkan Username Anda : ");
        username = Final.nextLine();
        System.out.print("Masukkan Password Anda : ");
        password = Final.nextLine();
        test = (username.equalsIgnoreCase("faris")) && (password.equalsIgnoreCase("polinema"));
        while (test == !cek) {
            System.out.println();
            System.out.println("Username/Password yang Anda Masukkan Salah");
            System.out.println("==========================================");
            System.out.println();
            System.out.print("Masukkan Username Anda : ");
            username = Final.nextLine();
            System.out.print("Masukkan Password Anda : ");
            password = Final.nextLine();
            test = (username.equalsIgnoreCase("faris")) && (password.equalsIgnoreCase("polinema"));
        }
        System.out.println();
        cek(Login());
    }

    static char Login() {
        char jenis;
        System.out.println("");
        System.out.println("-----] ANDA BERHASIL LOGIN [-----");
        System.out.println("1. Pengiriman Barang");
        System.out.println("2. Pengecakan Barang");
        System.out.println("3. Keluar");
        System.out.print("Pilih (1-3) Yang Anda Inginkan :");
        jenis = Final.next().charAt(0);
        return jenis;
    }

    static void cek(char a) {
        switch (a) {
            case '1':
                PengirimanBarang();
                break;
            case '2':
                PengecekanBarang();
                break;
            case '3':
                Keluar();
                break;
            default:
                cek(Login());
        }
    }

    static void PengirimanBarang() {
        String Provinsi;
        System.out.println("====== Anda Masuk Ke Pengiriman Barang ======");
        System.out.println();
        System.out.print("Masukkan Nama Anda : ");
        NamaAnda = Spasi.nextLine();
        System.out.println("----------------------------------------------");
        System.out.print("Masukkan Nama Tujuan : ");
        NamaTujuan = Spasi.nextLine();
        System.out.println();
        System.out.println("1. Pengiriman YES (Yakin Esok Sampai (1-2 Hari))");
        System.out.println("2. Pengiriman Reguler (3-5 Hari)");
        System.out.println("3. Keluar");
        System.out.print("Pilih Jenis Pengiriman Anda (1-3):");
        jenisKirim = Final.next().charAt(0);
//== Jenis Kirim YES ===============================================================================
        if (jenisKirim == '1') {
            System.out.println("===========================");
            System.out.println("Anda Memilih Pengiriman YES");
            JenisBarang();
//=== Jenis Barang Standar (YES) =======================================================
            if (jenisBarang == '1') {
                System.out.println("Tidak Ada Tambahan Biaya Untuk Jenis Barang Ini");
                System.out.println("Tambahan Pajak 10 % Sesuai Peraturan Pemerintahan Indonesia");
                System.out.println("1. BubbleWrap");
                System.out.println("2. Kayu");
                System.out.print("Pilih Jenis Packaging Anda (1-2) : ");
                jenisPackaging = Final.next().charAt(0);
                if (jenisPackaging == '1') {
                    Pencarian();
                    IdentitasLanjutan();
                    if (Kota[save][save1] == "Martapura" || Kota[save][save1] == "Banjarbaru" || Kota[save][save1] == "Tanjung") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 5500 + PPN 10%");
                            pajak = berat * 5500 * 0.1;
                            total = (berat * 5500) + pajak + 5000;
                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 5500 + PPN 10%");
                            pajak = berat * 5500 * 0.1;
                            total = (berat * 5500) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Banjarmasin" || Kota[save][save1] == "Palembang" || Kota[save][save1] == "Pagar Alam") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 4900 + PPN 10%");
                            pajak = berat * 4900 * 0.1;
                            total = (berat * 4900) + pajak + 5000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 4900 + PPN 10%");
                            pajak = berat * 4900 * 0.1;
                            total = (berat * 4900) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Lampung" || Kota[save][save1] == "Denpasar" || Kota[save][save1] == "Singaraja") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 4500 + PPN 10%");
                            pajak = berat * 4500 * 0.1;
                            total = (berat * 4500) + pajak + 5000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {
                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 4500 + PPN 10%");
                            pajak = berat * 4500 * 0.1;
                            total = (berat * 4500) + pajak;

                            System.out.println("Total Pajak Anda Adalah : Rp. " + pajak);
                            System.out.println("Total Biaya Anda Adalah : Rp. " + total);
                            System.out.print("Masukkan Jumlah Uang Anda : Rp. ");
                            MsknUang = Final.nextDouble();
                            kembalian = MsknUang - total;
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Buleleng" || Kota[save][save1] == "Gianyar" || Kota[save][save1] == "Karangasem") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 3900 + PPN 10%");
                            pajak = berat * 3900 * 0.1;
                            total = (berat * 3900) + pajak + 5000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 3900 + PPN 10%");
                            pajak = berat * 3900 * 0.1;
                            total = (berat * 3900) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Bandung" || Kota[save][save1] == "Sukabumi" || Kota[save][save1] == "Karawang") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 3400 + PPN 10%");
                            pajak = berat * 3400 * 0.1;
                            total = (berat * 3400) + pajak + 5000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {
                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 3400 + PPN 10%");
                            pajak = berat * 3400 * 0.1;
                            total = (berat * 3400) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Cirebon" || Kota[save][save1] == "Subang" || Kota[save][save1] == "Pemalang") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 2900 + PPN 10%");
                            pajak = berat * 2900 * 0.1;
                            total = (berat * 2900) + pajak + 5000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 2900 + PPN 10%");
                            pajak = berat * 2900 * 0.1;
                            total = (berat * 2900) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Pekalongan" || Kota[save][save1] == "Semarang" || Kota[save][save1] == "Magelang") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 2400 + PPN 10%");
                            pajak = berat * 2400 * 0.1;
                            total = (berat * 2400) + pajak + 5000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 2400 + PPN 10%");
                            pajak = berat * 2400 * 0.1;
                            total = (berat * 2400) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Solo" || Kota[save][save1] == "Sragen" || Kota[save][save1] == "Ngawi") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 1800 + PPN 10%");
                            pajak = berat * 1800 * 0.1;
                            total = (berat * 1800) + pajak + 5000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 1800 + PPN 10%");
                            pajak = berat * 1800 * 0.1;
                            total = (berat * 1800) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Madiun" || Kota[save][save1] == "Nganjuk" || Kota[save][save1] == "Jombang") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 1300 + PPN 10%");
                            pajak = berat * 1300 * 0.1;
                            total = (berat * 1300) + pajak + 5000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();

                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 1300 + PPN 10%");
                            pajak = berat * 1300 * 0.1;
                            total = (berat * 1300) + pajak;

                            System.out.println("Total Pajak Anda Adalah : Rp. " + pajak);
                            System.out.println("Total Biaya Anda Adalah : Rp. " + total);
                            System.out.print("Masukkan Jumlah Uang Anda : Rp. ");
                            MsknUang = Final.nextDouble();
                            kembalian = MsknUang - total;
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Gresik" || Kota[save][save1] == "Surabaya") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 900 + PPN 10%");
                            pajak = berat * 900 * 0.1;
                            total = (berat * 900) + pajak + 5000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 900 + PPN 10%");
                            pajak = berat * 900 * 0.1;
                            total = (berat * 900) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else {
                        Keluar();
                    }
//========== PACKAGING KAYU =======================================================================================================================
                } else if (jenisPackaging == '2') {
                    Pencarian();
                    IdentitasLanjutan();
                    if (Kota[save][save1] == "Martapura" || Kota[save][save1] == "Banjarbaru" || Kota[save][save1] == "Tanjung") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.3000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 6500 + PPN 10%");
                            pajak = berat * 6500 * 0.1;
                            total = (berat * 6500) + pajak + 3000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 6500 + PPN 10%");
                            pajak = berat * 6500 * 0.1;
                            total = (berat * 6500) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {
                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Banjarmasin" || Kota[save][save1] == "Palembang" || Kota[save][save1] == "Pagar Alam") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.3000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 5900 + PPN 10%");
                            pajak = berat * 5900 * 0.1;
                            total = (berat * 5900) + pajak + 3000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 5900 + PPN 10%");
                            pajak = berat * 5900 * 0.1;
                            total = (berat * 5900) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Lampung" || Kota[save][save1] == "Denpasar" || Kota[save][save1] == "Singaraja") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.3000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 5000 + PPN 10%");
                            pajak = berat * 5000 * 0.1;
                            total = (berat * 5000) + pajak + 3000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {
                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 5000 + PPN 10%");
                            pajak = berat * 5000 * 0.1;
                            total = (berat * 5000) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Buleleng" || Kota[save][save1] == "Gianyar" || Kota[save][save1] == "Karangasem") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.3000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 4700 + PPN 10%");
                            pajak = berat * 4700 * 0.1;
                            total = (berat * 4700) + pajak + 3000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 4700 + PPN 10%");
                            pajak = berat * 4700 * 0.1;
                            total = (berat * 4700) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Bandung" || Kota[save][save1] == "Sukabumi" || Kota[save][save1] == "Karawang") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.3000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 3500 + PPN 10%");
                            pajak = berat * 3500 * 0.1;
                            total = (berat * 3500) + pajak + 3000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {
                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 3500 + PPN 10%");
                            pajak = berat * 3500 * 0.1;
                            total = (berat * 3500) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Cirebon" || Kota[save][save1] == "Subang" || Kota[save][save1] == "Pemalang") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.3000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 3200 + PPN 10%");
                            pajak = berat * 3200 * 0.1;
                            total = (berat * 3200) + pajak + 5000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 3200 + PPN 10%");
                            pajak = berat * 3200 * 0.1;
                            total = (berat * 3200) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Pekalongan" || Kota[save][save1] == "Semarang" || Kota[save][save1] == "Magelang") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.3000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 2900 + PPN 10%");
                            pajak = berat * 2900 * 0.1;
                            total = (berat * 2900) + pajak + 5000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 2900 + PPN 10%");
                            pajak = berat * 2900 * 0.1;
                            total = (berat * 2900) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Solo" || Kota[save][save1] == "Sragen" || Kota[save][save1] == "Ngawi") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.3000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 2500 + PPN 10%");
                            pajak = berat * 2500 * 0.1;
                            total = (berat * 2500) + pajak + 3000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 2500 + PPN 10%");
                            pajak = berat * 2500 * 0.1;
                            total = (berat * 2500) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Madiun" || Kota[save][save1] == "Nganjuk" || Kota[save][save1] == "Jombang") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.3000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 2400 + PPN 10%");
                            pajak = berat * 2400 * 0.1;
                            total = (berat * 2400) + pajak + 3000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();

                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 2400 + PPN 10%");
                            pajak = berat * 2400 * 0.1;
                            total = (berat * 2400) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Gresik" || Kota[save][save1] == "Surabaya") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.3000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 2000 + PPN 10%");
                            pajak = berat * 2000 * 0.1;
                            total = (berat * 2000) + pajak + 3000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 2000 + PPN 10%");
                            pajak = berat * 2000 * 0.1;
                            total = (berat * 2000) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else {
                        Keluar();
                    }

                } else {
                    System.out.println("============================");
                    System.out.println("Kode Yang Anda Masukkan Salah");
                    cek(Login());
                }
//==== JENIS BARANG FRAGILE (YES) ==================================================================================================
            } else if (jenisBarang == '2') {
                System.out.println("Tambahan Rp.7000 Untuk Jenis Barang Ini");
                System.out.println("Tambahan Pajak 10 % Sesuai Peraturan Pemerintahan Indonesia");
                System.out.println("Tambahan Pajak Kerusakan 20 %");
                System.out.println("Hanya Tersedia Packing Kayu Demi Keamanan Barang");

                System.out.println("1. Kayu");
                System.out.println("2. Keluar");
                System.out.print("Pilih Jenis Packaging Anda (1-2) : ");
                jenisPackaging = Final.next().charAt(0);
//=========================== Jenis Packaging 1 =====================================================================================
                if (jenisPackaging == '1') {
                    Pencarian();
                    IdentitasLanjutan();
                    if (Kota[save][save1] == "Martapura" || Kota[save][save1] == "Banjarbaru" || Kota[save][save1] == "Tanjung") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 5500 + PPN 10%");
                            pajak = berat * 5500 * 0.1;
                            pajakPerlindungan = berat * 5500 * 0.2;
                            total = (berat * 5500) + pajak + 5000 + 7000 + pajakPerlindungan;
                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 5500 + PPN 10%");
                            pajak = berat * 5500 * 0.1;
                            pajakPerlindungan = berat * 5500 * 0.2;
                            total = (berat * 5500) + pajak + 7000 + pajakPerlindungan;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Banjarmasin" || Kota[save][save1] == "Palembang" || Kota[save][save1] == "Pagar Alam") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 4900 + PPN 10%");
                            pajak = berat * 4900 * 0.1;
                            pajakPerlindungan = berat * 4900 * 0.2;
                            total = (berat * 4900) + pajak + 5000 + 7000 + pajakPerlindungan;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 4900 + PPN 10%");
                            pajak = berat * 4900 * 0.1;
                            pajakPerlindungan = berat * 4900 * 0.2;
                            total = (berat * 4900) + pajak + 7000 + pajakPerlindungan;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Lampung" || Kota[save][save1] == "Denpasar" || Kota[save][save1] == "Singaraja") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 4500 + PPN 10%");
                            pajak = berat * 4500 * 0.1;
                            pajakPerlindungan = berat * 4500 * 0.2;
                            total = (berat * 4500) + pajak + 5000 + 7000 + pajakPerlindungan;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {
                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 4500 + PPN 10%");
                            pajak = berat * 4500 * 0.1;
                            pajakPerlindungan = berat * 4500 * 0.2;
                            total = (berat * 4500) + pajak + 7000 + pajakPerlindungan;

                            Biaya();
                            kembalian = MsknUang - total;
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Buleleng" || Kota[save][save1] == "Gianyar" || Kota[save][save1] == "Karangasem") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 3900 + PPN 10%");
                            pajak = berat * 3900 * 0.1;
                            pajakPerlindungan = berat * 3900 * 0.2;
                            total = (berat * 3900) + pajak + 5000 + 7000 + pajakPerlindungan;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 3900 + PPN 10%");
                            pajak = berat * 3900 * 0.1;
                            pajakPerlindungan = berat * 3900 * 0.2;
                            total = (berat * 3900) + pajak + 7000 + pajakPerlindungan;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Bandung" || Kota[save][save1] == "Sukabumi" || Kota[save][save1] == "Karawang") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 3400 + PPN 10%");
                            pajak = berat * 3400 * 0.1;
                            pajakPerlindungan = berat * 3400 * 0.2;
                            total = (berat * 3400) + pajak + 5000 + 7000 + pajakPerlindungan;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {
                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 3400 + PPN 10%");
                            pajak = berat * 3400 * 0.1;
                            pajakPerlindungan = berat * 3400 * 0.2;
                            total = (berat * 3400) + pajak + 7000 + pajakPerlindungan;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Cirebon" || Kota[save][save1] == "Subang" || Kota[save][save1] == "Pemalang") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 2900 + PPN 10%");
                            pajak = berat * 2900 * 0.1;
                            pajakPerlindungan = berat * 2900 * 0.2;
                            total = (berat * 2900) + pajak + 5000 + 7000 + pajakPerlindungan;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 2900 + PPN 10%");
                            pajak = berat * 2900 * 0.1;
                            pajakPerlindungan = berat * 2900 * 0.2;
                            total = (berat * 2900) + pajak + 7000 + pajakPerlindungan;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Pekalongan" || Kota[save][save1] == "Semarang" || Kota[save][save1] == "Magelang") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 2400 + PPN 10%");
                            pajak = berat * 2400 * 0.1;
                            pajakPerlindungan = berat * 2400 * 0.2;
                            total = (berat * 2400) + pajak + 7000 + 5000 + pajakPerlindungan;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 2400 + PPN 10%");
                            pajak = berat * 2400 * 0.1;
                            pajakPerlindungan = berat * 2400 * 0.2;
                            total = (berat * 2400) + pajak + 7000 + pajakPerlindungan;
                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Solo" || Kota[save][save1] == "Sragen" || Kota[save][save1] == "Ngawi") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 1800 + PPN 10%");
                            pajak = berat * 1800 * 0.1;
                            pajakPerlindungan = berat * 1800 * 0.2;
                            total = (berat * 1800) + pajak + 5000 + 7000 + pajakPerlindungan;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 1800 + PPN 10%");
                            pajak = berat * 1800 * 0.1;
                            pajakPerlindungan = berat * 1800 * 0.2;
                            total = (berat * 1800) + pajak + 7000 + pajakPerlindungan;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Madiun" || Kota[save][save1] == "Nganjuk" || Kota[save][save1] == "Jombang") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 1300 + PPN 10%");
                            pajak = berat * 1300 * 0.1;
                            pajakPerlindungan = berat * 1300 * 0.2;
                            total = (berat * 1300) + pajak + 5000 + 7000 + pajakPerlindungan;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();

                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 1300 + PPN 10%");
                            pajak = berat * 1300 * 0.1;
                            pajakPerlindungan = berat * 1300 * 0.2;
                            total = (berat * 1300) + pajak + 7000 + pajakPerlindungan;

                            System.out.println("Total Pajak Anda Adalah : Rp. " + pajak);
                            System.out.println("Total Biaya Anda Adalah : Rp. " + total);
                            System.out.print("Masukkan Jumlah Uang Anda : Rp. ");
                            MsknUang = Final.nextDouble();
                            kembalian = MsknUang - total;
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Gresik" || Kota[save][save1] == "Surabaya") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 900 + PPN 10%");
                            pajak = berat * 1300 * 0.1;
                            pajakPerlindungan = berat * 1300 * 0.2;
                            total = (berat * 1300) + pajak + 7000 + pajakPerlindungan;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 900 + PPN 10%");
                            pajak = berat * 900 * 0.1;
                            pajakPerlindungan = berat * 900 * 0.2;
                            total = (berat * 900) + pajak + 7000 + pajakPerlindungan;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else {
                        Keluar();
                    }
//=========================== Jenis Packaging (KELUAR)  =====================================================================================
                } else if (jenisPackaging == '2') {
                    Keluar();
                }
//== Keluar ============================================================================================
            } else if (jenisBarang == '3') {
                Keluar();
//== Salah =============================================================================================
            } else {
                Salah();
            }
//== Jenis Kirim Regular ===============================================================================                      
        } else if (jenisKirim == '2') {
            System.out.println("===========================");
            System.out.println("Anda Memilih Pengiriman REGULAR");
            JenisBarang();
//=== Jenis Barang Standar (REGULAR) =======================================================
            if (jenisBarang == '1') {
                System.out.println("Tidak Ada Tambahan Biaya Untuk Jenis Barang Ini");
                System.out.println("Tambahan Pajak 10 % Sesuai Peraturan Pemerintahan Indonesia");
                System.out.println("Untuk Pengiriman Regular Hanya Tersedia Packing BubbleWrap dan Kardus");
                System.out.println("1. BubbleWrap");
                System.out.println("2. Kardus");
                System.out.print("Pilih Jenis Packaging Anda (1-2) : ");
                jenisPackaging = Final.next().charAt(0);
//======== Packing BubbleWrap =========================================================================
                if (jenisPackaging == '1') {
                    Pencarian();
                    IdentitasLanjutan();
                    if (Kota[save][save1] == "Martapura" || Kota[save][save1] == "Banjarbaru" || Kota[save][save1] == "Tanjung") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 3000 + PPN 10%");
                            pajak = berat * 3000 * 0.1;
                            total = (berat * 3000) + pajak + 5000;
                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 3000 + PPN 10%");
                            pajak = berat * 3000 * 0.1;
                            total = (berat * 3000) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Banjarmasin" || Kota[save][save1] == "Palembang" || Kota[save][save1] == "Pagar Alam") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 2500 + PPN 10%");
                            pajak = berat * 2500 * 0.1;
                            total = (berat * 2500) + pajak + 5000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 2500 + PPN 10%");
                            pajak = berat * 2500 * 0.1;
                            total = (berat * 2500) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Lampung" || Kota[save][save1] == "Denpasar" || Kota[save][save1] == "Singaraja") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 2000 + PPN 10%");
                            pajak = berat * 2000 * 0.1;
                            total = (berat * 2000) + pajak + 5000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {
                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 2000 + PPN 10%");
                            pajak = berat * 2000 * 0.1;
                            total = (berat * 2000) + pajak;

                            System.out.println("Total Pajak Anda Adalah : Rp. " + pajak);
                            System.out.println("Total Biaya Anda Adalah : Rp. " + total);
                            System.out.print("Masukkan Jumlah Uang Anda : Rp. ");
                            MsknUang = Final.nextDouble();
                            kembalian = MsknUang - total;
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Buleleng" || Kota[save][save1] == "Gianyar" || Kota[save][save1] == "Karangasem") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 1800 + PPN 10%");
                            pajak = berat * 1800 * 0.1;
                            total = (berat * 1800) + pajak + 5000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 1800 + PPN 10%");
                            pajak = berat * 1800 * 0.1;
                            total = (berat * 1800) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Bandung" || Kota[save][save1] == "Sukabumi" || Kota[save][save1] == "Karawang") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 1500 + PPN 10%");
                            pajak = berat * 1500 * 0.1;
                            total = (berat * 1500) + pajak + 5000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {
                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 1500 + PPN 10%");
                            pajak = berat * 1500 * 0.1;
                            total = (berat * 1500) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Cirebon" || Kota[save][save1] == "Subang" || Kota[save][save1] == "Pemalang") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 1200 + PPN 10%");
                            pajak = berat * 1200 * 0.1;
                            total = (berat * 1200) + pajak + 5000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 1200 + PPN 10%");
                            pajak = berat * 1200 * 0.1;
                            total = (berat * 1200) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Pekalongan" || Kota[save][save1] == "Semarang" || Kota[save][save1] == "Magelang") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 1050 + PPN 10%");
                            pajak = berat * 1050 * 0.1;
                            total = (berat * 1050) + pajak + 5000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 1050 + PPN 10%");
                            pajak = berat * 1050 * 0.1;
                            total = (berat * 1050) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Solo" || Kota[save][save1] == "Sragen" || Kota[save][save1] == "Ngawi") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 900 + PPN 10%");
                            pajak = berat * 900 * 0.1;
                            total = (berat * 900) + pajak + 5000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 900 + PPN 10%");
                            pajak = berat * 900 * 0.1;
                            total = (berat * 900) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Madiun" || Kota[save][save1] == "Nganjuk" || Kota[save][save1] == "Jombang") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 600 + PPN 10%");
                            pajak = berat * 600 * 0.1;
                            total = (berat * 600) + pajak + 5000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();

                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 600 + PPN 10%");
                            pajak = berat * 600 * 0.1;
                            total = (berat * 600) + pajak;

                            System.out.println("Total Pajak Anda Adalah : Rp. " + pajak);
                            System.out.println("Total Biaya Anda Adalah : Rp. " + total);
                            System.out.print("Masukkan Jumlah Uang Anda : Rp. ");
                            MsknUang = Final.nextDouble();
                            kembalian = MsknUang - total;
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Gresik" || Kota[save][save1] == "Surabaya") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 300 + PPN 10%");
                            pajak = berat * 300 * 0.1;
                            total = (berat * 300) + pajak + 5000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 300 + PPN 10%");
                            pajak = berat * 300 * 0.1;
                            total = (berat * 300) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else {
                        Keluar();
                    }
//========================  PACKAGING KARDUS ===============================================================================================================
                } else if (jenisPackaging == '2') {
                    Pencarian();
                    IdentitasLanjutan();
                    if (Kota[save][save1] == "Martapura" || Kota[save][save1] == "Banjarbaru" || Kota[save][save1] == "Tanjung") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.3000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 4500 + PPN 10%");
                            pajak = berat * 4500 * 0.1;
                            total = (berat * 4500) + pajak + 3000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 4500 + PPN 10%");
                            pajak = berat * 4500 * 0.1;
                            total = (berat * 4500) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {
                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Banjarmasin" || Kota[save][save1] == "Palembang" || Kota[save][save1] == "Pagar Alam") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.3000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 4200 + PPN 10%");
                            pajak = berat * 4200 * 0.1;
                            total = (berat * 4200) + pajak + 3000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 4200 + PPN 10%");
                            pajak = berat * 4200 * 0.1;
                            total = (berat * 4200) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Lampung" || Kota[save][save1] == "Denpasar" || Kota[save][save1] == "Singaraja") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.3000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 3800 + PPN 10%");
                            pajak = berat * 3800 * 0.1;
                            total = (berat * 3800) + pajak + 3000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {
                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 3800 + PPN 10%");
                            pajak = berat * 3800 * 0.1;
                            total = (berat * 3800) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Buleleng" || Kota[save][save1] == "Gianyar" || Kota[save][save1] == "Karangasem") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.3000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 3500 + PPN 10%");
                            pajak = berat * 3500 * 0.1;
                            total = (berat * 3500) + pajak + 3000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 3500 + PPN 10%");
                            pajak = berat * 3500 * 0.1;
                            total = (berat * 3500) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Bandung" || Kota[save][save1] == "Sukabumi" || Kota[save][save1] == "Karawang") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.3000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 2900 + PPN 10%");
                            pajak = berat * 2900 * 0.1;
                            total = (berat * 2900) + pajak + 3000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {
                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 2900 + PPN 10%");
                            pajak = berat * 2900 * 0.1;
                            total = (berat * 2900) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Cirebon" || Kota[save][save1] == "Subang" || Kota[save][save1] == "Pemalang") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.3000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 2400 + PPN 10%");
                            pajak = berat * 2400 * 0.1;
                            total = (berat * 2400) + pajak + 5000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 2400 + PPN 10%");
                            pajak = berat * 2400 * 0.1;
                            total = (berat * 2400) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Pekalongan" || Kota[save][save1] == "Semarang" || Kota[save][save1] == "Magelang") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.3000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 2200 + PPN 10%");
                            pajak = berat * 2200 * 0.1;
                            total = (berat * 2200) + pajak + 5000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 2200 + PPN 10%");
                            pajak = berat * 2200 * 0.1;
                            total = (berat * 2200) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Solo" || Kota[save][save1] == "Sragen" || Kota[save][save1] == "Ngawi") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.3000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 1900 + PPN 10%");
                            pajak = berat * 1900 * 0.1;
                            total = (berat * 1900) + pajak + 3000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 1900 + PPN 10%");
                            pajak = berat * 1900 * 0.1;
                            total = (berat * 1900) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Madiun" || Kota[save][save1] == "Nganjuk" || Kota[save][save1] == "Jombang") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.3000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 1400 + PPN 10%");
                            pajak = berat * 1400 * 0.1;
                            total = (berat * 1400) + pajak + 3000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();

                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 1400 + PPN 10%");
                            pajak = berat * 1400 * 0.1;
                            total = (berat * 1400) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Gresik" || Kota[save][save1] == "Surabaya") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.3000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 1125 + PPN 10%");
                            pajak = berat * 1125 * 0.1;
                            total = (berat * 1125) + pajak + 3000;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 2000 + PPN 10%");
                            pajak = berat * 1125 * 0.1;
                            total = (berat * 1125) + pajak;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else {
                        Keluar();
                    }

                } else {
                    System.out.println("============================");
                    System.out.println("Kode Yang Anda Masukkan Salah");
                    cek(Login());
                }
//==== JENIS BARANG FRAGILE (REGULAR) ==================================================================================================
            } else if (jenisBarang == '2') {
                System.out.println("Tidak Ada Tambahan Rp.7000 Untuk Jenis Barang Ini Karena Pengiriman REGULAR");
                System.out.println("Tambahan Pajak 10 % Sesuai Peraturan Pemerintahan Indonesia");
                System.out.println("Tambahan Pajak Kerusakan 20 %");
                System.out.println("Hanya Tersedia Packing Kayu Demi Keamanan Barang");

                System.out.println("1. Kayu");
                System.out.println("2. Keluar");
                System.out.print("Pilih Jenis Packaging Anda (1-2) : ");
                jenisPackaging = Final.next().charAt(0);
//=========================== Jenis Packaging 1 =====================================================================================
                if (jenisPackaging == '1') {
                    Pencarian();
                    IdentitasLanjutan();
                    if (Kota[save][save1] == "Martapura" || Kota[save][save1] == "Banjarbaru" || Kota[save][save1] == "Tanjung") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 5500 + PPN 10%");
                            pajak = berat * 5500 * 0.1;
                            pajakPerlindungan = berat * 5500 * 0.2;
                            total = (berat * 5500) + pajak + 5000 + pajakPerlindungan;
                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 5500 + PPN 10%");
                            pajak = berat * 5500 * 0.1;
                            pajakPerlindungan = berat * 5500 * 0.2;
                            total = (berat * 5500) + pajak + pajakPerlindungan;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Banjarmasin" || Kota[save][save1] == "Palembang" || Kota[save][save1] == "Pagar Alam") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 4900 + PPN 10%");
                            pajak = berat * 4900 * 0.1;
                            pajakPerlindungan = berat * 4900 * 0.2;
                            total = (berat * 4900) + pajak + 5000 + pajakPerlindungan;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 4900 + PPN 10%");
                            pajak = berat * 4900 * 0.1;
                            pajakPerlindungan = berat * 4900 * 0.2;
                            total = (berat * 4900) + pajak + pajakPerlindungan;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Lampung" || Kota[save][save1] == "Denpasar" || Kota[save][save1] == "Singaraja") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 4500 + PPN 10%");
                            pajak = berat * 4500 * 0.1;
                            pajakPerlindungan = berat * 4500 * 0.2;
                            total = (berat * 4500) + pajak + 5000 + pajakPerlindungan;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {
                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 4500 + PPN 10%");
                            pajak = berat * 4500 * 0.1;
                            pajakPerlindungan = berat * 4500 * 0.2;
                            total = (berat * 4500) + pajak + pajakPerlindungan;

                            Biaya();
                            kembalian = MsknUang - total;
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Buleleng" || Kota[save][save1] == "Gianyar" || Kota[save][save1] == "Karangasem") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 3900 + PPN 10%");
                            pajak = berat * 3900 * 0.1;
                            pajakPerlindungan = berat * 3900 * 0.2;
                            total = (berat * 3900) + pajak + 5000 + pajakPerlindungan;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 3900 + PPN 10%");
                            pajak = berat * 3900 * 0.1;
                            pajakPerlindungan = berat * 3900 * 0.2;
                            total = (berat * 3900) + pajak + pajakPerlindungan;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Bandung" || Kota[save][save1] == "Sukabumi" || Kota[save][save1] == "Karawang") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 3400 + PPN 10%");
                            pajak = berat * 3400 * 0.1;
                            pajakPerlindungan = berat * 3400 * 0.2;
                            total = (berat * 3400) + pajak + 5000 + pajakPerlindungan;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {
                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 3400 + PPN 10%");
                            pajak = berat * 3400 * 0.1;
                            pajakPerlindungan = berat * 3400 * 0.2;
                            total = (berat * 3400) + pajak + pajakPerlindungan;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Cirebon" || Kota[save][save1] == "Subang" || Kota[save][save1] == "Pemalang") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 2900 + PPN 10%");
                            pajak = berat * 2900 * 0.1;
                            pajakPerlindungan = berat * 2900 * 0.2;
                            total = (berat * 2900) + pajak + 5000 + pajakPerlindungan;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 2900 + PPN 10%");
                            pajak = berat * 2900 * 0.1;
                            pajakPerlindungan = berat * 2900 * 0.2;
                            total = (berat * 2900) + pajak + pajakPerlindungan;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Pekalongan" || Kota[save][save1] == "Semarang" || Kota[save][save1] == "Magelang") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 2400 + PPN 10%");
                            pajak = berat * 2400 * 0.1;
                            pajakPerlindungan = berat * 2400 * 0.2;
                            total = (berat * 2400) + pajak + 5000 + pajakPerlindungan;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 2400 + PPN 10%");
                            pajak = berat * 2400 * 0.1;
                            pajakPerlindungan = berat * 2400 * 0.2;
                            total = (berat * 2400) + pajak + pajakPerlindungan;
                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Solo" || Kota[save][save1] == "Sragen" || Kota[save][save1] == "Ngawi") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Standar) Rp. 1800 + PPN 10%");
                            pajak = berat * 1800 * 0.1;
                            pajakPerlindungan = berat * 1800 * 0.2;
                            total = (berat * 1800) + pajak + 5000 + pajakPerlindungan;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 1800 + PPN 10%");
                            pajak = berat * 1800 * 0.1;
                            pajakPerlindungan = berat * 1800 * 0.2;
                            total = (berat * 1800) + pajak + pajakPerlindungan;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Madiun" || Kota[save][save1] == "Nganjuk" || Kota[save][save1] == "Jombang") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 1300 + PPN 10%");
                            pajak = berat * 1300 * 0.1;
                            pajakPerlindungan = berat * 1300 * 0.2;
                            total = (berat * 1300) + pajak + 5000 + pajakPerlindungan;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();

                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 1300 + PPN 10%");
                            pajak = berat * 1300 * 0.1;
                            pajakPerlindungan = berat * 1300 * 0.2;
                            total = (berat * 1300) + pajak + pajakPerlindungan;

                            System.out.println("Total Pajak Anda Adalah : Rp. " + pajak);
                            System.out.println("Total Biaya Anda Adalah : Rp. " + total);
                            System.out.print("Masukkan Jumlah Uang Anda : Rp. ");
                            MsknUang = Final.nextDouble();
                            kembalian = MsknUang - total;
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else if (Kota[save][save1] == "Gresik" || Kota[save][save1] == "Surabaya") {
                        System.out.print("Apakah Anda Ingin Menambah Asurani Pegiriman (Y/T) : ");
                        Asuransi = Final.next().charAt(0);
                        if (Asuransi == ('Y') || Asuransi == ('y')) {
                            System.out.println("Biaya Asuransi Sebesar Rp.5000");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 900 + PPN 10%");
                            pajak = berat * 1300 * 0.1;
                            pajakPerlindungan = berat * 1300 * 0.2;
                            total = (berat * 1300) + pajak + pajakPerlindungan;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        } else {
                            System.out.println("Anda tidak Menambah Asuransi");
                            System.out.println("Biaya Ditambahkan pada Pembayaran");
                            System.out.println("Biaya Per Kilogram (Bahan Fragile) Rp. 900 + PPN 10%");
                            pajak = berat * 900 * 0.1;
                            pajakPerlindungan = berat * 900 * 0.2;
                            total = (berat * 900) + pajak + pajakPerlindungan;

                            Biaya();
                            if (MsknUang >= total) {
                                PilihanCtk();
                                if (CtkResi == ('Y') || CtkResi == ('y')) {

                                    CetakkResi();
                                    Keluar();
                                } else {
                                    System.out.println("Anda Telah Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
                                    Keluar();
                                }
                            } else {
                                System.out.println("Mohon Maaf Uang Anda Tidak Cukup Anda Tidak Dapat Melakukan Pengiriman");
                                Keluar();
                            }
                        }
                    } else {
                        Keluar();
                    }
//=========================== Jenis Packaging Keluar  =====================================================================================
                } else if (jenisPackaging == '2') {
                    Keluar();
                } else {
                    Keluar();
                }
//== Keluar ============================================================================================
            } else if (jenisBarang == '3') {
                Keluar();
//== Salah =============================================================================================
            } else {
                Salah();
            }
//== Jenis Kirim Keluar ================================================================================                      
        } else if (jenisKirim == '3') {
            Keluar();

//== Salah Input =======================================================================================                      
        } else {
            cek(Login());
        }
    }

    static void PengecekanBarang() {
        String cekBarang;
        int cek2 = 0;
        Scanner cek = new Scanner(System.in);
        System.out.println("===== Anda Masuk Ke Pengecekan Barang ======");
        System.out.println("Masukan Nomor Resi Resi Anda : ");
        cekBarang = Final.next();
//Pengecekan Resi ==================================================
        for (int i = 0; i < PengecekanResi.length; i++) {
            if (cekBarang.equalsIgnoreCase(PengecekanResi[i])) {
                cek2 = i;
                break;
            }
        }
        if (cekBarang.equalsIgnoreCase(PengecekanResi[cek2])) {
            System.out.println("Nomer Resi DiTemukan");
            System.out.println();
            System.out.println(PengecekanBarang[cek2][0]);
        }else{
            System.out.println("No Resi Tdk Ditemukan");
        }
    }

    static void Biaya() {
        System.out.println("//////////////////////////////////////");
        System.out.println("Total Pajak Anda Adalah : Rp. " + pajak + " //");
        System.out.println("Total Biaya Anda Adalah : Rp. " + total + " //");
        System.out.println("//////////////////////////////////////");
        System.out.print("Masukkan Jumlah Uang Anda : Rp. ");
        MsknUang = Final.nextDouble();
        kembalian = MsknUang - total;
    }

    static void PilihanCtk() {
        System.out.println("Anda Akan Melakukan Pengiriman Ke Kota " + Kota[save][save1]);
        System.out.println();
        System.out.print("Apakah Anda Ingin Mencetak Resi (Y/T) : ");
        CtkResi = Final.next().charAt(0);
    }

    static void CetakkResi() {

        System.out.println();
        System.out.println("===================================");
        System.out.println("|||||||| RESI HiF Ekspress ||||||||");
        System.out.println("===================================");
        System.out.println();
        System.out.println("Waktu Sekarang          : " + Waktu());
        System.out.println("Tanggal Sekarang        : " + Tanggal());
        System.out.println("Nama Pengirim           : " + NamaAnda);
        System.out.println("Nama Penerima           : " + NamaTujuan);
        System.out.println("Tujuan Prov/Kota/Kec    : " + provinsi[save] + "/" + Kota[save][save1] + "/" + Kecamatan);
        System.out.println("Berat Barang            : " + berat + " Kg");
        System.out.println("Jenis Pengiriman        : " + jenisKirim);
        System.out.println("Jenis Packaging         : " + jenisPackaging);
        System.out.println("Jenis Barang            : " + jenisBarang);
        System.out.println("Asuransi                : " + Asuransi);
        System.out.println("Tambahan                : " + Identitas);
        System.out.println("Nomor Resi              : " + number);
        System.out.println("Total Pembayaran        : Rp. " + total);
        System.out.println("Uang Anda               : Rp. " + MsknUang);
        System.out.println("Uang Kembalian Anda     : Rp. " + kembalian);
        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println("NOTE : \n"
                + "Jenis Kirim 1 = YES , 2 = REGULAR\n"
                + "Jenis Barang 1 = STANDAR , 2 = FRAGILE\n"
                + "Jenis Packaging = \n"
                + "YES-STANDAR = BUBBLE(1) WRAP DAN KAYU(2)\n"
                + "YES-FRAGILE = KAYU(1)\n"
                + "REGULAR-STANDAR = BUBBLE(1) DAN KARDUS(2)\n"
                + "REGULAR-FRAGILE = KAYU(1)\n");
        System.out.println("-----------------------------------");
    }

    static void Pencarian() {
        String Provinsi, Wilayah, Kecamatan;
        double berat;
        char jenisPackaging;
        //Menampilkan Provinsi Yang Tersedia
        System.out.println();
        for (String j : provinsi) {
            System.out.println(" @ " + j + "");
        }
        System.out.println();
        System.out.print("Masukan Provinsi Tujuan Anda : ");
        Provinsi = Spasi.nextLine();
        //System Cek Provinsi
        for (int k = 0; k < provinsi.length; k++) {
            if (Provinsi.equalsIgnoreCase(provinsi[k])) {
                save = k;
                break;
            }
        }
        System.out.println("SAVE : "+save);
        if (Provinsi.equalsIgnoreCase(provinsi[save])) {
            //Menampilkan Kota Yang Tersedia
            System.out.println("NOTE : ");
            System.out.println("Untuk Wilayah Indramayu, Muara Enim , Baturaja"
                    + ", Lahat, Tabanan\n, Amuntai, Batulicin (BELUM DI RESMIKAN)");
            System.out.println();
            for (String ArrayFaris[] : Kota) {
                for (String j : ArrayFaris) {
                    System.out.print(" * " + j);
                }
                System.out.println(" ");
            }
            System.out.println();
            System.out.print("Masukkan Kota Tujuan Anda : ");
            Wilayah = Final.next();
            //System Cek Kota
            for (int l = 0; l < Kota[0].length; l++) {
                if (Wilayah.equalsIgnoreCase(Kota[save][l])) {
                    save1 = l;
                    break;
                }
            }
            System.out.println("SAVE 1 : "+save1);

            if (Wilayah.equalsIgnoreCase(Kota[save][save1])) {
                System.out.println("= === Anda Masuk Ke Data Lanjutan === =");
            } else {
                cek(Login());
            }
        } else {
            cek(Login());
        }
    }

    static void IdentitasLanjutan() {
        System.out.print("Masukkan Kecamatan Anda : ");
        Kecamatan = Spasi.nextLine();
        System.out.println();
        System.out.print("Masukkan Berat Barang Anda (Kg) : ");
        berat = Final.nextDouble();
        System.out.println();
        System.out.print("Masukkan Identitas Tambahan Barang Anda :");
        Identitas = Spasi.nextLine();
        System.out.println();
    }

    static void JenisBarang() {
        System.out.println("===========================");
        System.out.println("1. Bahan Standar");
        System.out.println("2. Bahan Fragile");
        System.out.println("3. Keluar");
        System.out.println("---------------------------");
        System.out.print("Pilih Jenis Barang Anda :");
        jenisBarang = Final.next().charAt(0);
        System.out.println();
    }

    static void Keluar() {
        System.out.println("Terima Kasih Telah Memakai Progam by Faris Ikhlasul Haq");
    }

    static void Salah() {
        System.out.println("Anda Salah Masukkkan Inputan");
    }

    static String Tanggal() {
        DateFormat formatTanggal = new SimpleDateFormat("yyyy/mm/dd");
        Date Tanggal = new Date();
        return formatTanggal.format(Tanggal);
    }

    static String Waktu() {
        DateFormat formatWaktu = new SimpleDateFormat("HH:mm:ss");
        Date waktu = new Date();
        return formatWaktu.format(waktu);
    }
}
