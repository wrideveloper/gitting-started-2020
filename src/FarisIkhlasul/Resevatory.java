package fungsi2;

/**
 *
 * @author Faris Ikhlasul H
 */
import java.util.Scanner;

public class Resevatory {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan Bilangan : ");
        int bil = input.nextInt();

        if (cekBilanganPrima(bil)) {
            System.out.println("Bilangan Prima");
        } else {
            System.out.println("Bukan Bilangan Prima");
        }
    }

    private static int PrimaRekursif(int b, int c) {
        if (c == 1) {
            return 1;
        } else if (b % c == 0) {
            return 1 + PrimaRekursif(b, c--);
        } else {
            return 0 + PrimaRekursif(b, --c);
        }
    }

    public static boolean cekBilanganPrima(int a) {
        if (a > 1) {
            return (PrimaRekursif(a, a) == 2);
        } else {
            return false;
        }
    }

}
