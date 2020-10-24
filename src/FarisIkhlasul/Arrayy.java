package array2d;

/**
 *
 * @author Faris Ikhlasul H
 */
import java.util.Scanner;

public class Arrayy {

    public static void main(String[] Args) {
        Scanner faris = new Scanner(System.in);
        int penilaian[][][] = new int[5][10][3];
        int mahasiswa[];
        int mhs;
        int simpan[] = new int[5];
        double average;
        for (int i = 0; i < penilaian.length; i++) {
            System.out.print("Masukkan Jumlah Mahasiswa Kelas Ke-" + (i + 1) + " : ");
            mhs = faris.nextInt();
            simpan[i] = mhs;
            System.out.println("------------------------------------------------");
            mahasiswa = new int[mhs];
            for (int j = 0; j < mahasiswa.length; j++) {
                System.out.print("Masukkan Nilai UTS Mahasiswa Kelas-" + (i + 1) + " Ke -" + (j + 1) + " :");
                penilaian[i][j][0] = faris.nextInt();
                System.out.print("Masukkan Nilai UAS Mahasiswa Kelas-" + (i + 1) + " Ke -" + (j + 1) + " :");
                penilaian[i][j][1] = faris.nextInt();
                System.out.print("Masukkan Nilai PROJECT Mahasiswa Kelas-" + (i + 1) + " Ke -" + (j + 1) + " :");
                penilaian[i][j][2] = faris.nextInt();
                System.out.println();
            }
            System.out.println("=======================================================================");

        }

        for (int i = 0; i < penilaian.length; i++) {
            for (int j = 0; j < simpan[i]; j++) {
                int total = 0;
                for (int k = 0; k < penilaian[0][1].length; k++) {
                    total += penilaian[i][j][k];
                }
                average = (double) total/3;
                System.out.println("Rata-rata Anak Kelas " + (i+1) + " Ke - " + (j+1) + " :" + average);

            }
            System.out.println();
        }

    }
}