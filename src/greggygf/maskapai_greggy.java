import java.util.Scanner;

class maskapai_greggy
{
	/* 
        Greggy Gianini Firmansyah
        1741720088
        1FamilyNyimenk // D-IV Teknik Informatika
        Politeknik Negeri Malang
    */
            
	static void daftarMaskapai(String[] daftar_maskapai)
	{
		System.out.println(""); 
        System.out.println(" --------------------------------------------------");
        System.out.println("           MASKAPAI YANG TERSEDIA SAAT INI         ");
        System.out.println(" --------------------------------------------------");
        for(int x=0; x<daftar_maskapai.length ; x++)
        {
            System.out.println(" " + (x+1) + ". " + daftar_maskapai[x]);
        }
        System.out.println("");
	}

    static void menuMaskapai(int maskapai,String[] daftar_maskapai,String[][] daftar_tujuan)
    {
        System.out.println("");
        System.out.println(" --------------------------------------------------");
        System.out.println("               MASKAPAI " + daftar_maskapai[maskapai-1]);
        System.out.println(" --------------------------------------------------");

        System.out.println(" Berikut pilihan tujuan yang tersedia :");

        for(int x = 0;x<3;x++)
        {
            System.out.println(" " + (x+1) + ". " + daftar_tujuan[maskapai-1][x]);
        }

        System.out.println("");
    }

    static double hitungTotalBiaya(int harga,int jumlah_tiket_dewasa,int jumlah_tiket_anak,int pilihan_tiket)
    {
        double total_biaya;

        if(pilihan_tiket == 1)
        {
            total_biaya = (harga * jumlah_tiket_dewasa )+(( 0.5 * harga ) * jumlah_tiket_anak );
        }
        else
        {
            total_biaya = 2*((harga * jumlah_tiket_dewasa )+(( 0.5 * harga ) * jumlah_tiket_anak ));
        }
        
        return total_biaya;
    }
    static double hitungPajak(double total_biaya)
    {
        double pajak;
        pajak = 0.1 * total_biaya;
        return pajak;
    }

    static void daftarLayananTiket()
    {
        String[] layanan = {"1X Keberangkatan","Pulang-Pergi (2X Keberangkatan)"};

        System.out.println(" --------------------------------------------------");
        System.out.println("                   LAYANAN TIKET                   ");
        System.out.println(" --------------------------------------------------");

        for(int x=0 ; x<layanan.length ; x++)
        {
            System.out.println(" " + (x+1) + ". " + layanan[x]);
        }

        System.out.println("");
    }
    
    static void daftarBank()
    {
        String[] bank = {"BRI","MANDIRI","BCA"};

        System.out.println(" --------------------------------------------------");
        System.out.println("                     DAFTAR BANK                   ");
        System.out.println(" --------------------------------------------------");

        for(int x=0 ; x<bank.length ; x++)
        {
            System.out.println(" " + (x+1) + " - " + bank[x]);
        }

        System.out.println("");
    }

    static void daftarMetode()
    {
        String[] metode = {"Transfer","Debit"};
        System.out.println(" --------------------------------------------------");
        System.out.println("                  METODE PEMBAYARAN                ");
        System.out.println(" --------------------------------------------------");
        for(int x=0 ; x<metode.length ; x++)
        {
            System.out.println(" " + (x+1) + " - " + metode[x]);
        }
        
        System.out.println("");
    }

    static void metodeTransfer(int kode_bank,double total_biaya_fix)
    {
        String[] daftar_bank        = {"BRI","MANDIRI","BCA"};
        String[] daftar_rekening    = {"0111-01-1-1","0222-02-1-1","0333-03-1-3"};
        String bank,rekening;

        bank = daftar_bank[kode_bank-1];
        rekening = daftar_rekening[kode_bank-1];

        System.out.println(" Silahkan transfer ke rekening " + bank + " dengan nomor "+ rekening + " a/n Greggy Gianini Firmansyah sebesar Rp." + total_biaya_fix + " dalam waktu 1x24 jam");
    }

    static int inputTujuan(int tujuan)
    {
        Scanner input = new Scanner(System.in); 
        do
        {
            System.out.print(" Masukkan Tujuan (1/2/3)\t: ");
            tujuan = input.nextInt();
        }
        while(tujuan <=0 || tujuan >=4);

        return tujuan;
    }

    static int inputTiketDewasa(int jumlah_tiket_dewasa)
    {
        Scanner input = new Scanner(System.in);

        System.out.print(" Dewasa \t[ Umur diatas 12 tahun ] \t: ");
        jumlah_tiket_dewasa = input.nextInt();

        return jumlah_tiket_dewasa; 
    }

    static int inputTiketAnak(int jumlah_tiket_anak)
    {
        Scanner input = new Scanner(System.in);

        System.out.print(" Anak-Anak \t[ Umur 2-12 tahun ] \t\t: ");
        jumlah_tiket_anak = input.nextInt();

        return jumlah_tiket_anak; 
    }

    static int inputTiketBayi(int jumlah_tiket_bayi)
    {
        Scanner input = new Scanner(System.in);

        System.out.print(" Bayi \t\t[ Umur dibawah 2 tahun ] \t: ");
        jumlah_tiket_bayi = input.nextInt();

        return jumlah_tiket_bayi; 
    }

// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in); 
        Scanner Stringinput = new Scanner(System.in);

        String tanggal_keberangkatan    = " ";
        String tanggal_kembali          = " ";
        String nama                     = " ";
        String email                    = " ";
        String nomor_identitas          = " ";
        String pilihan_maskapai         = " ";
        String pilihan_tujuan           = " ";
        String nomor_kartu;
        char pilihan                    = ' ';
        int harga                       = ' ';

        int[][] daftar_harga            = {{250000,350000,500000},      // Daftar Harga Tujuan 1,2,3 dari Maskapai Sriwijaya Air
                                           {400000,600000,800000},      // Daftar Harga Tujuan 1,2,3 dari Maskapai Garuda Indonesia
                                           {800000,1000000,1250000}};   // Daftar Harga Tujuan 1,2,3 dari Maskapai Lion Air

        String[][] daftar_tujuan        = {{"Malang - Surabaya \t( SBY - Juanda )","Malang - Yogyakarta ( JOG - Adisutjipto )","Malang - Jakarta \t( CGK - Soekarno Hatta )"},
                                           {"Malang - Semarang \t( SRG - Achmad Yani )","Malang - Bandung \t( BDO - Husein Sastranegara )","Malang - Palembang \t( PLM - Sultan Mahmud Badaruddin II )"},
                                           {"Malang - Denpasar \t( DPS - Ngurah Rai )","Malang - Makassar \t( UPG - Hasanuddin )","Malang - Medan \t( KNO - Kuala Namu )"}};

        String[] daftar_maskapai        = {"Sriwijaya Air","Garuda Indonesia","Lion Air"};

        String[] penumpang_dewasa       = {};
        String[] penumpang_anak         = {};
        String[] penumpang_bayi         = {};

        int tujuan                      = 0;
        int no                          = 0;
        int jumlah_tiket_dewasa         = 0;
        int jumlah_tiket_anak           = 0;
        int jumlah_tiket_bayi           = 0;
        int jumlah_total, pilihan_tiket, maskapai, metode, jumlah, kode_bank;
        double pajak, total_biaya;
        double total_biaya_fix          = 0;

        System.out.println("");
        System.out.println("\t\t\t\t------------------------------------------------------------------");
        System.out.println("\t\t\t\t   Selamat Datang di E-Tiket Bandara Abdul Rachman Saleh Malang   ");
        System.out.println("\t\t\t\t------------------------------------------------------------------");
        System.out.println("\t\t\tJl. Komodor Udara Abdul Rahman Saleh, Bunut Wetan, Pakis, Malang, Jawa Timur 65154");
        System.out.println("");
        System.out.println("");

        daftarLayananTiket(); // menampilkan daftar layanan tiket

    //  ------------------------------------INPUT PILIHAN TIKET----------
        do
        {
        	System.out.print(" Masukkan Pilihan Tiket (1/2)\t\t: ");
        	pilihan_tiket = input.nextInt();
        }
        while(pilihan_tiket <=0 || pilihan_tiket >=3);
    //  ------------------------------------------------------------------

        System.out.println("");

        System.out.print(" Masukkan Tanggal Keberangkatan \t: ");
        tanggal_keberangkatan = Stringinput.nextLine();

        if(pilihan_tiket == 2) // Jika pilihan tiket yang dipilih itu Pulang-Pergi maka membutuhkan tanggal kembali
        {
            System.out.print(" Masukkan Tanggal Kembali \t\t: ");
            tanggal_kembali = Stringinput.nextLine();
        }

        System.out.println("");

        if(pilihan_tiket == 1 || pilihan_tiket == 2)
        {
            System.out.println(" --------------------------------------------------");
            System.out.println(" MASUKKAN JUMLAH TIKET ( JUMLAH TIKET MAKSIMAL 7 )");
            System.out.println(" --------------------------------------------------");

            jumlah_tiket_dewasa = inputTiketDewasa(jumlah_tiket_dewasa);
            penumpang_dewasa = new String[jumlah_tiket_dewasa];
            
            jumlah_tiket_anak = inputTiketAnak(jumlah_tiket_anak);
            penumpang_anak = new String[jumlah_tiket_anak];
            
            jumlah_tiket_bayi = inputTiketBayi(jumlah_tiket_bayi);
            penumpang_bayi = new String[jumlah_tiket_bayi];
            
            System.out.println("");
            jumlah_total = jumlah_tiket_dewasa + jumlah_tiket_anak + jumlah_tiket_bayi;

            if( jumlah_total <= 0 || jumlah_tiket_dewasa < 0 || jumlah_tiket_anak < 0 || jumlah_tiket_bayi < 0 )
            {
                System.out.println(" -- INVALID JUMLAH TIKET / TIDAK BOLEH NEGATIF --");
            }
            else if( jumlah_total > 7 )
            {
                System.out.println(" -- JUMLAH TIKET MELEBIHI 7 ! JUMLAH TIKET SAAT INI ADALAH " + jumlah_total + " --");
            }
            else
            {
                System.out.println(" --------------------------------------------------");
                System.out.println("             MASUKKAN DATA PENUMPANG               ");
                System.out.println(" --------------------------------------------------");

                if(jumlah_tiket_dewasa>0)
                {
                    for(int x=0 ; x<jumlah_tiket_dewasa ; x++)
                    {
                        System.out.println(" Dewasa " + (x+1));
                        System.out.println(" --------");
                        System.out.print(" Nama Lengkap \t: ");
                        penumpang_dewasa[x] = Stringinput.nextLine();

                        System.out.println();
                    }
                }

                if(jumlah_tiket_anak>0)
                {
                    for(int x=0 ; x<jumlah_tiket_anak ; x++)
                    {
                        System.out.println(" Anak " + (x+1));
                        System.out.println(" --------");
                        System.out.print(" Nama Lengkap \t: ");
                        penumpang_anak[x] = Stringinput.nextLine();

                        System.out.println();
                    }
                }

                if(jumlah_tiket_bayi>0)
                {
                    for(int x=0 ; x<jumlah_tiket_bayi ; x++)
                    {
                        System.out.println(" Bayi " + (x+1));
                        System.out.println(" --------");
                        System.out.print(" Nama Lengkap \t: ");
                        penumpang_bayi[x] = Stringinput.nextLine();

                        System.out.println();
                    }
                }

                daftarMaskapai(daftar_maskapai); // Menampilkan Daftar Maskapai

            //  ------------------------------------------------INPUT MASKAPAI----
                do
                {
                	System.out.print(" Masukkan Maskapai (1/2/3)\t: "); 
                	maskapai = input.nextInt();
                }
                while(maskapai <=0 || maskapai >=4);
            //  ------------------------------------------------------------------

                pilihan_maskapai = daftar_maskapai[maskapai-1];
                menuMaskapai(maskapai,daftar_maskapai,daftar_tujuan); // Menampilkan Menu Maskapai

            //  --------------------------------------------------INPUT TUJUAN----
                tujuan = inputTujuan(tujuan);
            //  ------------------------------------------------------------------ 

                harga = daftar_harga[maskapai-1][tujuan-1]; // Memilih harga berdasarkan array daftar_harga
                pilihan_tujuan = daftar_tujuan[maskapai-1][tujuan-1]; // Memilih tujuan berdasarkan array daftar_tujuan

                System.out.println("");
            }
        }

        if(tujuan == 1 || tujuan == 2 || tujuan == 3)
        {
            System.out.print(" Masukkan Nama Pemesan \t\t: ");
            nama = Stringinput.nextLine();

            System.out.print(" Masukkan No.Identitas \t\t: ");
            nomor_identitas = Stringinput.nextLine();

            System.out.print(" Masukkan Email \t\t: ");
            email = Stringinput.nextLine();

            System.out.println("");
        }

        if(tujuan == 1 || tujuan == 2 || tujuan == 3)
        {
            total_biaya = hitungTotalBiaya(harga,jumlah_tiket_dewasa,jumlah_tiket_anak,pilihan_tiket);

            pajak = hitungPajak(total_biaya);
            total_biaya_fix = total_biaya+pajak;

            System.out.println("");
            System.out.println(" ---------------------------------------------------------------------------");
            System.out.println("                             DETAIL PEMESANAN                              ");
            System.out.println(" ---------------------------------------------------------------------------");
            System.out.println("");
            System.out.println(" Nama Pemesan \t\t: " + nama);
            System.out.println(" Nomor Identitas \t: " + nomor_identitas);
            System.out.println(" Email \t\t\t: " + email);
            System.out.println("");
            System.out.println(" Maskapai \t\t: " + pilihan_maskapai);
            System.out.println(" Tujuan \t\t: " + pilihan_tujuan);
            System.out.println(" Tanggal Keberangkatan \t: " + tanggal_keberangkatan);

            if(pilihan_tiket == 2)
            {
                System.out.println(" Tanggal Kembali \t: " + tanggal_kembali);
            }

            System.out.println();
            System.out.println("  DATA PENUMPANG");
            System.out.println(" +------+---------------------------------------+---------------+");
            System.out.println(" | No\t|         Nama Penumpang\t\t|     Tipe\t|");
            System.out.println(" +------+---------------------------------------+---------------+");

            if(jumlah_tiket_dewasa>0)
            {
                for(int x=0 ; x<jumlah_tiket_dewasa ; x++)
                {
                    no = no+1;

                    System.out.print(" | " + no + "\t|");
                    System.out.print(" " + penumpang_dewasa[x] + "\t\t| ");
                    System.out.println("Dewasa" + "\t|");
                }
            }

            if(jumlah_tiket_anak>0)
            {
                for(int x=0 ; x<jumlah_tiket_anak ; x++)
                {
                    no = no+1;

                    System.out.print(" | " + no + "\t|");
                    System.out.print(" " + penumpang_anak[x] + "\t\t\t| ");
                    System.out.println("Anak" + "\t\t|");
                }
            }

            if(jumlah_tiket_bayi>0)
            {
                for(int x=0 ; x<jumlah_tiket_bayi ; x++)
                {
                    no = no+1;

                    System.out.print(" | " + no + "\t|");
                    System.out.print(" " + penumpang_bayi[x] + "\t\t\t| ");
                    System.out.println("Bayi" + "\t\t|");
                }
            }

            System.out.println(" +------+---------------------------------------+---------------+");

            if(pilihan_tiket == 2)
            {
                jumlah_tiket_bayi = 2 * jumlah_tiket_bayi;
                jumlah_tiket_anak = 2 * jumlah_tiket_anak;
                jumlah_tiket_dewasa = 2 * jumlah_tiket_dewasa;
            }

            System.out.println("");
            System.out.println("  JUMLAH PENUMPANG");
            System.out.println(" ---------------------------------------------------------------------------");
            System.out.println(" Dewasa \tx " + jumlah_tiket_dewasa + " \t= Rp." + harga + " \tx " + jumlah_tiket_dewasa + " \t= " + "Rp." + harga*jumlah_tiket_dewasa);

            if(jumlah_tiket_anak>0)
            {
                System.out.println(" Anak-Anak \tx " + jumlah_tiket_anak + " \t= Rp." + (0.5*harga) + " \tx " + jumlah_tiket_anak + " \t= " + "Rp." + (0.5*harga)*jumlah_tiket_anak);
            }
            
            if(jumlah_tiket_bayi>0)
            {
                System.out.println(" Bayi \t\tx " + jumlah_tiket_bayi + " \t= Rp." + (0*harga) + " \t\tx " + jumlah_tiket_bayi + " \t= " + "Rp." + (0*harga)*jumlah_tiket_bayi);
            }

            System.out.println(" ---------------------------------------------------------------------------");
            System.out.println(" TOTAL BIAYA \t\t\t\t\t= Rp." + total_biaya);
            System.out.println(" PAJAK (10%) \t\t\t\t\t= Rp." + pajak);
            System.out.println(" ---------------------------------------------------------------------------");
            System.out.println(" TOTAL YANG HARUS DIBAYAR \t\t\t= Rp." + total_biaya_fix);
                
            System.out.println("");

            do
            {
            	System.out.print(" Diproses lebih lanjut? (y/t) : ");
            	pilihan = input.next().charAt(0);
            }
            while(pilihan != 'y' && pilihan != 't');

            System.out.println("");
        }

        if(pilihan == 'y')
        {
            daftarMetode(); // Menampilkan tampilan daftar metode

            do
            {
            	System.out.print(" Masukkan Metode Pembayaran \t: ");
            	metode = input.nextInt();
            }
            while(metode <= 0 || metode >=3);

            System.out.println("");

            if (metode == 1)
            {
                daftarBank(); // Menampilkan Tampilan Daftar Bank
                
                do
                {
                	System.out.print(" Masukkan Kode Bank \t\t: ");
                	kode_bank = input.nextInt();
                }
                while(kode_bank <=0 || kode_bank >=4);

                System.out.println("");

                metodeTransfer(kode_bank,total_biaya_fix); // Menampilkan cara transfer beserta bank dan rekeningnya
            }
            else
            {
                System.out.print(" Masukkan Nomor Kartu ATM \t: ");
                nomor_kartu = Stringinput.nextLine();

                System.out.println(" Tiket pesanan anda akan dikirimkan ke email " + email + " dalam waktu 1x24jam. Terima kasih,enjoy the flight :)");   
            }
        }
        else if(pilihan == 't')
        {
            System.out.print(" Terima kasih telah berkunjung :) ");
        }
    }
}