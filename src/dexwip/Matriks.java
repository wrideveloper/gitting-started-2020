import java.util.Scanner;

public class Matriks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Masukkan nilai N : ");
        int angka = scan.nextInt();
        int[][] array = new int[angka][angka];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print("Masukkan angka pada [" + i + "] [" + j + "] : ");
                array[i][j] = scan.nextInt();
            }
        }
        System.out.println("Matriks");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] > 1 || array[i][j] < 1) {
                    array[i][j] = 0;
                }
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}