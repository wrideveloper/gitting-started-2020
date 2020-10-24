package bruteforce_dnc;

import java.util.Scanner;

public class BruteForce_dnc {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("============================");
        System.out.println("Input the number elements that you want to count : ");
        int elemen = sc.nextInt();
        int option;
        back png[] = new back[elemen];
        for (int i = 0; i < elemen; i++) {
            System.out.println("input the value of number to be squared to-" + (i + 1) + " : ");
            int num = sc.nextInt();
            System.out.println("input the squared value to-" + (i + 1) + " : ");
            int squared = sc.nextInt();
            png[i] = new back(num, squared);
        }
        System.out.println("What method do you want to use ? ");
        System.out.println("1. Brute force");
        System.out.println("2. Divide and onquer");
        option = sc.nextInt();
        if (option == 1) {
            System.out.println("Resutl with brute force : ");
            for (int i = 0; i < elemen; i++) {
                System.out.println("value " + png[i].num + "squared " + png[i].squared + " is :" + png[i].squareBF(png[i].num, png[i].squared));
            }
        } else if (option == 2) {
            System.out.println("Resutl with divide n conquer : ");
            for (int i = 0; i < elemen; i++) {
                System.out.println("value " + png[i].num + "squared " + png[i].squared + " is :" + png[i].squareDC(png[i].num, png[i].squared));
            }
        }
    }
}
