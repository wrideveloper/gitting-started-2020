import java.util.Scanner;

/**
 * @author Sultan GaussEliminasiDyn
 */

public class GaussEliminasiDyn {
    public static Scanner scanInt = new Scanner(System.in);
    public static Scanner scanChar = new Scanner(System.in);
    public static double[][] matriksArr;
    public static double[] value;
    public static double a, b, p;
    public static char ulangi;

    public static void main(String[] args) {
        do {
            inputMatriks();
            prosesMenjadi0();
            prosesDapatHasil();
        } while (ulangi());
    }

    public static void inputMatriks() {
        System.out.println("Gauss Eliminasi Ordo Dinamis\n");
        ordoMatriks();
        System.out.println("*untuk pemisah nilai matriks dan hasil gunakan spasi*");
        System.out.println("*misal 1 2 7*");
        System.out.println("Masukkan nilai matriks : ");
        for (int i = 0; i < matriksArr.length; i++) {
            for (int j = 0; j < matriksArr[i].length; j++) {
                matriksArr[i][j] = scanInt.nextDouble();
            }
            value[i] = scanInt.nextDouble();
        }
        System.out.println("\nNilai Matriks yang sudah di input :");
        printMatriks();
    }

    public static void ordoMatriks() {
        System.out.print("Masukkan ordo yang diinginkan : ");
        int a1 = scanInt.nextInt();
        matriksArr = new double[a1][a1];
        value = new double[a1];
    }

    public static void printMatriks() {
        for (int i = 0; i < matriksArr.length; i++) {
            for (int j = 0; j < matriksArr[i].length; j++) {
                System.out.printf("%.3f ", matriksArr[i][j], " ");
            }
            System.out.print("| ");
            System.out.printf("%.3f\n", value[i]);
        }
    }

    public static void prosesMenjadi0() {
        for (int i = 0; i < matriksArr.length - 1; i++) {
            for (int j = i + 1; j < matriksArr.length; j++) {
                double factor = matriksArr[j][i] / matriksArr[i][i];
                value[j] -= factor * value[i];
                for (int k = i; k < matriksArr.length; k++)
                    matriksArr[j][k] -= factor * matriksArr[i][k];
            }
        }
        System.out.println("\n*Menjadikan matriks 0 dibawah diagonal");
        printMatriks();
    }

    public static void prosesDapatHasil() {
        double[] solution = new double[matriksArr.length];
        for (int i = matriksArr.length - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < matriksArr.length; j++)
                sum += matriksArr[i][j] * solution[j];
            solution[i] = (value[i] - sum) / matriksArr[i][i];
        }
        System.out.println("\nHasilnya : ");
        char A = 65;
        for (int i = 0; i < solution.length; i++) {
            System.out.print(A);
            System.out.printf(" = %.3f\n", solution[i]);
            A++;
        }
    }

    public static boolean ulangi() {
        System.out.print("\nUlang lagi(Y/N) ? ");
        ulangi = scanChar.next().charAt(0);
        if (ulangi == 'N' || ulangi == 'n') {
            System.out.println("\nTerima Kasih");
        } else if (ulangi == 'Y' || ulangi == 'y') {
            return ulangi == 'Y' || ulangi == 'y';
        } else {
            System.out.println("\nInputan tidak Valid\nSilahkan Coba Lagi");
            ulangi();
        }
        return ulangi == 'Y' || ulangi == 'y';
    }

}