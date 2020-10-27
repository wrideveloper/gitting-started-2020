package projek;
import java.util.Scanner;

public class ProjekAkhirRevisi {
    static Scanner sc = new Scanner(System.in);
    static String awal,nomorAnggota,namaAnggota;
    static String akhir;
    static int i,jumlahBuku,denda,totalDenda;
    static String [] judul=new String[10];
    static int totalHarga=0;
    static int [] harga = new int[10];
    static int [] total=new int[10];
    private static String dataString;
    
    public static void main(String[] args) {
        System.out.println("==========================DATA MAHASISWA===========================");
        System.out.println("Nama\t: NADIA LAYRA AZIZA                                       |");
        System.out.println("Kelas\t: TI 1E                                                   |");
        System.out.println("NIM\t: 1941720061                                              |");
        System.out.println("Absn\t: 20                                                      |");
        System.out.println("Tema\t: PEMINJAMAN BUKU PERPUSTAKAAN                            |");
        System.out.println("===================================================================");
        ProjekAkhirRevisi menu= new ProjekAkhirRevisi(); //membuat objek menu utama
        menu.menu(); //memanggil method menu() pada class Perpus
    }
    
    static void menu() {
        String dataString;
        int menu = 0;
        //membuat method menu utama
        System.out.println ("===================================================================");
        System.out.println ("                      MENU UTAMA PERPUSTAKAAN                      ");
        System.out.println ("-------------------------------------------------------------------");
        System.out.println ("1. Daftar Buku");
        System.out.println ("2. Pencarian Buku");
        System.out.println ("3. Peminjaman");
        System.out.println ("4. Pengembalian");
        System.out.println ("5. Exit");
        System.out.println ("===================================================================");
        System.out.print("Masukkan menu pilihan anda: ");
        dataString=sc.nextLine();
        menu = Integer.valueOf(dataString).intValue();
        
        switch(menu) {
            case 1 :
                daftarBuku();// memanggil method Daftar Buku
            break;
            case 2 :
                pencarianBuku();// memanggil method Daftar Buku
            break;
            case 3 :
                peminjaman(awal); //memanggil method Peminjaman
            break;
            case 4 :
                pengembalian(akhir); //memanggil method Pengembalian
            break;
            case 5 :
                System.out.println ("===================================================================");
                System.out.println("                  TERIMA KASIH ATAS KUNJUNGAN ANDA                  ");
                System.out.println ("===================================================================");
            break;
            default :
                System.out.print("Maaf, pilihan yang Anda masukkan salah!");
                pilihMenu();//memanggil method pilihMenu
        }
    }

    static void pilihMenu(){
        int pilihMenu = 0;
        System.out.println("1.Kembali ke Menu Utama \n2.Keluar ");
        System.out.print("Masukkan menu pilihan anda: ");
        pilihMenu =sc.nextInt();
        sc.nextLine();
        
        switch(pilihMenu) {
            case 1 :
                menu();
            break;
            case 2 :
                System.out.println("===================================================================");
                System.out.println("                  TERIMA KASIH ATAS KUNJUNGAN ANDA                  ");
                System.out.println("===================================================================");
            break;
            default :
                System.out.println("Maaf, pilihan yang Anda masukkan salah!");
                pilihMenu();
        }
    }
    
    static void daftarBuku(){
        System.out.println("————————————————————————————————————————");
        System.out.println("|                    DAFTAR BUKU PERPUSTAKAAN                     |");
        System.out.println("————————————————————————————————————————");
        System.out.println("A. KAMUS");
        System.out.println("B. MAJALAH");
        System.out.println("C. TEXT BOOK");
        System.out.println("D. NOVEL");
        System.out.println("E. ENSIKLOPEDIA");
        System.out.println("————————————————————————————————————————");
        String [] jenisBuku = {"A. Kamus","B. Majalah","C. TextBook","D. NOVEL","E. ENSIKLOPEDIA"};
        String [][] buku = {
            {"Inggris – Indonesia","Bahasa Perancis","Bahasa German","Bahasa Arab"},
            {"Tarbawi","Ummi","Sabili","Ar-Risalah"},
            {"Program Berbasis OOP","Java Fundamental","Java Advance","Java Berbasis GUI"},
            {"Teenlit","Chicklit","Songlit","Fantasi"},
            {"Umum/Nasional","Khusus/Subyek","Internasional","Online"}
        };
        for(int i=0; i<5; i++){
            System.out.println(jenisBuku[i]);
            for(int j=0; j<4; j++){
                System.out.println((j+1)+"."+buku[i][j]+" ");
            }
            System.out.println();
            System.out.println("————————————————————————————————————————");
        }
        pilihMenu();
    }
    
    static void pencarianBuku(){
        String cari, key;
        System.out.println("————————————————————————————————————————");
        System.out.println("                    ALTERNATIF PENCARIAN BUKU                    ");
        System.out.println("————————————————————————————————————————");
        String [] jenisBuku = {"A. Kamus","B. Majalah","C. TextBook","D. Novel","E. Ensiklopedia"};
        String buku [][] = {
            {"Inggris – Indonesia","Bahasa Perancis","Bahasa German","Bahasa Arab"},
            {"Tarbawi","Ummi","Sabili","Ar-Risalah"},
            {"Program Berbasis OOP","Java Fundamental","Java Advance","Java Berbasis GUI"},
            {"Teenlit","Chicklit","Songlit","Fantasi"},
            {"Umum/Nasional","Khusus/Subyek","Internasional","Online"}
        };
        System.out.print("Masukkan nama Buku yang ingin anda cari: ");
        cari = sc.nextLine();
        key = cari;
        int urutan=0;
        int baris=0;
        int g = 0;
        
        for(int i=0; i<buku.length; i++){
            for(int j=0; j<4; j++){
                urutan = i+1;
                baris=j+1;
            if (buku[i][j].equalsIgnoreCase(cari)){
                System.out.println("Buku "+key+" terletak di rak nomor "+urutan+" baris ke-"+baris);
                g=1;
                break;
            }
            }
        }
            if(g==0){                
                System.out.println("Maaf buku yang anda cari tidak tersedia");
                System.out.println("————————————————————————————————————————");
            }
            pilihMenu();
    }
    
    static void peminjaman(String awal1){
        System.out.println("————————————————————————————————————————");
        System.out.println("                         PEMINJAMAN BUKU                         ");
        System.out.println("————————————————————————————————————————");
        System.out.println("Tarif Peminjaman Per Minggu: ");
        System.out.println("1. Jenis Buku Kamus        = Rp.3000");
        System.out.println("2. Jenis Buku Majalah      = Rp.1000");
        System.out.println("3. Jenis Buku Text Book    = Rp.2000");
        System.out.println("4. Jenis Buku Novel        = Rp.2000");
        System.out.println("5. Jenis Buku Ensiklopedia = Rp.3000");
        System.out.println("————————————————————————————————————————");
        System.out.print("1. Nomor Anggota              = ");
        int nomorAnggota = sc.nextInt();
        System.out.print("2. Nama Anggota               = ");
        String namaAnggota = sc.next();
        System.out.print("3. Tanggal Pinjam(hr/bln/thn) = ");
        awal = sc.next();
        System.out.println("   Tanggal peminjaman adalah "+ awal);
        System.out.print("4. Jumlah Pinjam Buku         = ");
        jumlahBuku=sc.nextInt();
        
        for (i=1;i<=jumlahBuku;i++){
            System.out.println("——————————————————————————————");
            System.out.println("Pilihan Peminjaman Ke – "+i);
            System.out.print("Pilih Salah Satu Pilihan [1-5] = ");
            int pilihan=sc.nextInt();
            System.out.println("——————————————————————————————");
    
            switch(pilihan){
                case 1:
                    System.out.println("Macam-Macam Kamus : ");
                    System.out.println("1. Inggris – Indonesia");
                    System.out.println("2. Bahasa Perancis");
                    System.out.println("3. Bahasa German");
                    System.out.println("4. Bahasa Arab");
                    System.out.print ("Pilihan Kamus = ");
                    int kamus=sc.nextInt();
                
                    if (kamus==1){
                        judul[i]="Indonesia – Inggris";
                    } else if(kamus==2){
                        judul[i]="Bahasa Perancis";
                    } else if (kamus==3) {
                        judul[i]="Bahasa German";
                    } else {
                        judul[i]="Bahasa Arab";
                    }
                    System.out.println("Judul Kamus yang Dipinjam = "+judul[i]);
                break;
            
                case 2:
                    System.out.println("Macam-Macam Majalah : ");
                    System.out.println("1. Tarbawi");
                    System.out.println("2. Ummi");
                    System.out.println("3. Sabili");
                    System.out.println("4. Ar-Risalah");
                    System.out.print ("Pilih Majalah : ");
                    int majalah=sc.nextInt();

                    if (majalah==1){
                        judul[i]="arbawi";
                    } else if(majalah==2){
                        judul[i]="Ummi";
                    }else if (majalah==3){
                        judul[i]="Sabili";
                    } else {
                        judul[i]="Ar-Risalah";
                    }
                    System.out.println("Judul Majalah yang Dipinjam = "+judul[i]);
                break;

                case 3:
                    System.out.println("Macam-Macam TextBook : ");
                    System.out.println("1. Program Berbasis OOP");
                    System.out.println("2. Java Fundamental");
                    System.out.println("3. Java Advance");
                    System.out.println("4. Java Berbasis GUI");
                    System.out.print("Pilihan Text Book = ");
                    int buku=sc.nextInt();

                    if (buku==1){
                        judul[i]="Program Berbasis OOP";
                    } else if(buku==2){
                        judul[i]="Java Fundamental";
                    } else if(buku==3){
                        judul[i]="Java Advance";
                    } else {
                        judul[i]="Java Berbasis GUI";
                    }
                    System.out.println("Judul Text Book yang Dipinjam = "+judul[i]);
                break;

                case 4:
                    System.out.println("Macam-Macam Novel : ");
                    System.out.println("1. Teenlit");
                    System.out.println("2. Chicklit");
                    System.out.println("3. Songlit");
                    System.out.println("4. Fantasi");
                    System.out.print("Pilihan Novel = ");
                    int novel=sc.nextInt();

                    if (novel==1){
                        judul[i]="Teenlit";
                    } else if(novel==2){
                        judul[i]="Chicklit";
                    } else if(novel==3){
                        judul[i]="Songlit";
                    } else {
                        judul[i]="Fantasi";
                    }
                    System.out.println("Judul Novel yang Dipinjam = "+judul[i]);
                break;

                case 5:
                    System.out.println("Macam-Macam Ensiklopedia : ");
                    System.out.println("1. Umum/Nasional");
                    System.out.println("2. Khusus/Subyek");
                    System.out.println("3. Internasional");
                    System.out.println("4. Online");
                    System.out.print("Pilihan Ensiklopedia = ");
                    int ensiklopedia=sc.nextInt();

                    if (ensiklopedia==1){
                        judul[i]="Umum/Nasional";
                    } else if(ensiklopedia==2){
                        judul[i]="Khusus/Subyek";
                    } else if(ensiklopedia==3){
                        judul[i]="Internasional";
                    } else {
                        judul[i]="Online";
                    }
                    System.out.println("Judul Ensiklopedia yang Dipinjam = "+judul[i]);
                break;
                default:
            }
       
            // Perhitungan Harga
            if (pilihan==1){
                harga[i]=3000;
            } else if (pilihan==2){
                harga[i]=1000;
            } else if(pilihan==3){
                harga[i]=2000;
            } else if(pilihan==4){
                harga[i]=2000;
            } else {
                harga[i]=3000;
            }
        }
        
        for (i=0;i<=jumlahBuku;i++){
            totalHarga = totalHarga + harga[i];
        }
        System.out.println("——————————————————————————————");
        System.out.println("Biaya Peminjaman = Rp " + totalHarga );
        System.out.println("——————————————————————————————");
        System.out.println("Buku-Buku yang dipinjam : ");
        
        for (i=1;i<=jumlahBuku;++i){
        System.out.println(judul[i]);
        }
        System.out.println("————————————————————————————————————————");
        pilihMenu();
    }
    
    static void pengembalian(String akhir1){
        System.out.println ("————————————————————————————————————————");
        System.out.println ("                        PENGEMBALIAN BUKU                        ");
        System.out.println ("             (Denda keterlambatan Rp. 1000 per hari)             ");
        System.out.println ("————————————————————————————————————————");
        System.out.print("1. Nomor Anggota               = ");
        nomorAnggota = sc.next();
        System.out.print("2. Nama Anggota                = ");
        namaAnggota = sc.next();
        System.out.print("3. Tanggal Kembali(hr/bln/thn) = ");
        akhir = sc.next();
        System.out.println("   Nomor Anggota Anda "+nomorAnggota);
        System.out.println("   Nama Angoota "+namaAnggota);
        System.out.println("   Tanggal Pengembalian adalah "+akhir);
        konversiTanggal(awal,akhir);
    }
    
    static void konversiTanggal (String awal, String akhir){
        int tahunK = Integer.parseInt(awal.substring(6, 10));
        int bulanK = Integer.parseInt(awal.substring(3, 5));
        int hariK = Integer.parseInt(awal.substring(0, 2));

        int tahunH = Integer.parseInt(akhir.substring(6, 10));
        int bulanH = Integer.parseInt(akhir.substring(3, 5));
        int hariH = Integer.parseInt(akhir.substring(0, 2));

        int hari = hariH - hariK;
        int bulan = (bulanH - bulanK) * 30;
        int tahun = (tahunH - tahunK) * 365;

        int selisih = hari + bulan + tahun;
       
        System.out.println("4. Lama Peminjaman             = "+selisih+" Hari");
        System.out.println("——————————————————————————————");
        System.out.println ("Denda keterlambatan Rp. 1000 per hari");
         System.out.println("——————————————————————————————");
        if ( selisih > 7){
            denda = selisih - 7;
            totalDenda = denda * 1000;
            System.out.println("Anda terlambat selama "+denda+" hari");
            System.out.println("Total denda anda adalah Rp. "+totalDenda);
        } else {
            System.out.println("Terima Kasih Telah Mengembalikan Tepat Waktu");
        }
        System.out.println ("————————————————————————————————————————");
        cetakNota();
    }
    
    public static void cetakNota(){
        System.out.println("==================================================");
        System.out.println("                NOTA PERPUSTAKAAN                 ");
        System.out.println("==================================================");
        System.out.println("No Anggota             : "+nomorAnggota);
        System.out.println("Nama Anggota           : "+namaAnggota);
        System.out.println("Judul buku yg dipinjam : ");
        for (i=1;i<=jumlahBuku;++i){
        System.out.println(judul[i]);
        }
        System.out.println("Biaya Peminjaman       : Rp " + totalHarga );
        System.out.println("Tanggal Peminjaman     : "+awal);
        System.out.println("Tanggal Pengembalian   : "+akhir);
        System.out.println("Keterlambatan          : "+denda+" Hari");
        System.out.println("Total Denda            : Rp. "+totalDenda);
        System.out.println("==================================================");
        pilihMenu();
    }
}
