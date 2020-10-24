/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abdul Rohman
 */
import java.util.*;

public class MiniProject {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        String answer;
            do {
            int meet, total, price, discount, discountTot, lastTot;
            String level, age, status, name, pay;
            System.out.println("||======================================||");
            System.out.println("||\tWelcome to English Course\t||");
            System.out.println("||\tPlease fill your data\t\t||");
            System.out.println("||======================================||");
            System.out.print("What is your name : ");
            name = sc.nextLine();
            System.out.print("Status : ");
            status = sc.nextLine();
            System.out.print("Age : ");
            age = sc.nextLine();
            System.out.println("||======================================||");
            System.out.println("||\tChoose your level\t\t|| ");
            System.out.println("||======================================||");
            System.out.println("||\tA. Beginner IDR.10000/meet\t||");
            System.out.println("||\tB. Intermediet IDR.15000/meet\t||");
            System.out.println("||\tC. Professional IDR.20000/meet\t||");
            System.out.println("||======================================||");
            System.out.print("=> ");
            level = sc.nextLine();
            if (level.equalsIgnoreCase("A") || level.equalsIgnoreCase("beginner")) {
                price = 10000;
                System.out.println("||======================================||");
                System.out.println("||\tChoose which paket you need\t||");
                System.out.println("||======================================||");
                System.out.println("||\ta. 1 Month(3 weeks) \t\t||");
                System.out.println("||\tb. 6 Month(18 weeks) \t\t||");
                System.out.println("||\tc. 1 Year(36 weeks) \t\t||");
                System.out.println("||======================================||");
                System.out.print("=> ");
                String paket = sc.nextLine();
                if (paket.equalsIgnoreCase("a")) {
                    System.out.println("||======================================||");
                    System.out.println("||\tYou choosed packet 1\t\t||");
                    System.out.println("||======================================||");
                    System.out.print("How much meeting for every week :");
                    meet = sc1.nextInt();
                    System.out.println("Choose the day :");
                    String[] day = new String[meet];
                    for (int i = 0; i < day.length; i++) {
                        System.out.print("Day ke-" + i + ": ");
                        day[i] = sc.nextLine();
                    }
                    discount = 0;
                    total = meet * (price - discount) * 3;
                    System.out.println("||==============================================||");
                    System.out.println("||\thow you want to pay it\t\t\t||");
                    System.out.println("||==============================================||");
                    System.out.println("|| cash (get 10% Discount from total payment)   ||");
                    System.out.println("|| creadit (didn't get any discount)\t\t||");
                    System.out.println("||==============================================||");
                    System.out.print("=>");
                    pay = sc.nextLine();
                    switch (pay) {
                        case "cash":
                            discountTot = total * 10 / 100;
                            break;
                        default:
                            discountTot = 0;
                    }
                    lastTot = total - discountTot;
                    System.out.println("||=============================================||");
                    System.out.println("|| Your name : " + name);
                    System.out.println("|| Status : " + status);
                    System.out.println("|| Age : " + age);
                    System.out.println("|| The day that you choose :");
                    for (String nameDay : day) {
                        System.out.println("|| day = " + nameDay);
                    }
                    System.out.println("|| Your payment for the Course: IDR." + total);
                    System.out.println("|| Discount you Got : IDR." + discountTot);
                    System.out.println("|| Total that you have to pay : IDR." + lastTot);
                } else if (paket.equalsIgnoreCase("b")) {
                    System.out.println("||======================================||");
                    System.out.println("||\tYou choosed packet 2\t\t||");
                    System.out.println("||======================================||");
                    System.out.print("How much meeting for every week :");
                    meet = sc1.nextInt();
                    String[] day = new String[meet];
                    for (int i = 0; i < day.length; i++) {
                        System.out.print("Day ke-" + i + ": ");
                        day[i] = sc.nextLine();
                    }
                    discount = price * 5 / 100;
                    total = meet * (price - discount) * 18;
                    System.out.println("||==============================================||");
                    System.out.println("||\thow you want to pay it\t\t\t||");
                    System.out.println("||==============================================||");
                    System.out.println("|| cash (get 10% Discount from total payment)   ||");
                    System.out.println("|| creadit (didn't get any discount)\t\t||");
                    System.out.println("||==============================================||");
                    System.out.print("=>");
                    pay = sc.nextLine();
                    switch (pay) {
                        case "cash":
                            discountTot = total * 10 / 100;
                            break;
                        default:
                            discountTot = 0;
                    }
                    lastTot = total - discountTot;
                    System.out.println("||============================================||");
                    System.out.println("|| Your name : " + name);
                    System.out.println("|| Status : " + status);
                    System.out.println("|| Age : " + age);
                    System.out.println("|| The day that you choose :");
                    for (String nameDay : day) {
                        System.out.println("|| day = " + nameDay);
                    }
                    System.out.println("|| Your payment for the Course: IDR." + total);
                    System.out.println("|| Discount you Got : IDR." + discountTot);
                    System.out.println("|| Total that you have to pay : IDR." + lastTot);
                } else if (paket.equalsIgnoreCase("c")) {
                    System.out.println("||======================================||");
                    System.out.println("||\tYou choosed packet 3\t\t||");
                    System.out.println("||======================================||");
                    System.out.print("How much meeting for every week :");
                    meet = sc1.nextInt();
                    String[] day = new String[meet];
                    for (int i = 0; i < day.length; i++) {
                        System.out.print("Day ke-" + i + ": ");
                        day[i] = sc.nextLine();
                    }
                    discount = price * 10 / 100;
                    total = meet * (price - discount) * 36;
                    System.out.println("||==============================================||");
                    System.out.println("||\thow you want to pay it\t\t\t||");
                    System.out.println("||==============================================||");
                    System.out.println("|| cash (get 10% Discount from total payment)   ||");
                    System.out.println("|| creadit (didn't get any discount)\t\t||");
                    System.out.println("||==============================================||");
                    System.out.print("=>");
                    pay = sc.nextLine();
                    switch (pay) {
                        case "cash":
                            discountTot = total * 10 / 100;
                            break;
                        default:
                            discountTot = 0;
                    }
                    lastTot = total - discountTot;
                    System.out.println("||===============================================||");
                    System.out.println("|| Your name : " + name);
                    System.out.println("|| Status : " + status);
                    System.out.println("|| Age : " + age);
                    System.out.println("|| The day that you choose :");
                    for (String nameDay : day) {
                        System.out.println("|| day = " + nameDay);
                    }
                    System.out.println("|| Your payment for the Course: IDR." + total);
                    System.out.println("|| Discount you Got : IDR." + discountTot);
                    System.out.println("|| Total that you have to pay : IDR." + lastTot);
                } else {
                    System.out.println("sorry no packet like that");
                }
            } else if (level.equalsIgnoreCase("B") || level.equalsIgnoreCase("intermediet")) {
                price = 15000;
                System.out.println("||======================================||");
                System.out.println("||\tChoose which paket you need\t||");
                System.out.println("||======================================||");
                System.out.println("||\ta. 1 Month(3 weeks) \t\t||");
                System.out.println("||\tb. 6 Month(18 weeks) \t\t||");
                System.out.println("||\tc. 1 Year(36 weeks) \t\t||");
                System.out.println("||======================================||");
                System.out.print("=> ");
                String paket = sc.nextLine();
                if (paket.equalsIgnoreCase("a")) {
                    System.out.println("||======================================||");
                    System.out.println("||\tYou choosed packet 1\t\t||");
                    System.out.println("||======================================||");
                    System.out.print("How much meeting for every week :");
                    meet = sc1.nextInt();
                    System.out.println("Choose the day :");
                    String[] day = new String[meet];
                    for (int i = 0; i < day.length; i++) {
                        System.out.print("Day ke-" + i + ": ");
                        day[i] = sc.nextLine();
                    }
                    discount = 0;
                    total = meet * (price - discount) * 3;
                    System.out.println("||==============================================||");
                    System.out.println("||\thow you want to pay it\t\t\t||");
                    System.out.println("||==============================================||");
                    System.out.println("|| cash (get 10% Discount from total payment)   ||");
                    System.out.println("|| creadit (didn't get any discount)\t\t||");
                    System.out.println("||==============================================||");
                    System.out.print("=>");
                    pay = sc.nextLine();
                    switch (pay) {
                        case "cash":
                            discountTot = total * 10 / 100;
                            break;
                        default:
                            discountTot = 0;
                    }
                    lastTot = total - discountTot;
                    System.out.println("||=============================================||");
                    System.out.println("|| Your name : " + name);
                    System.out.println("|| Status : " + status);
                    System.out.println("|| Age : " + age);
                    System.out.println("|| The day that you choose :");
                    for (String nameDay : day) {
                        System.out.println("|| day = " + nameDay);
                    }
                    System.out.println("|| Your payment for the Course: IDR." + total);
                    System.out.println("|| Discount you Got : IDR." + discountTot);
                    System.out.println("|| Total that you have to pay : IDR." + lastTot);
                } else if (paket.equalsIgnoreCase("b")) {
                    System.out.println("||======================================||");
                    System.out.println("||\tYou choosed packet 2\t\t||");
                    System.out.println("||======================================||");
                    System.out.print("How much meeting for every week :");
                    meet = sc1.nextInt();
                    String[] day = new String[meet];
                    for (int i = 0; i < day.length; i++) {
                        System.out.print("Day ke-" + i + ": ");
                        day[i] = sc.nextLine();
                    }
                    discount = price * 5 / 100;
                    total = meet * (price - discount) * 18;
                    System.out.println("||==============================================||");
                    System.out.println("||\thow you want to pay it\t\t\t||");
                    System.out.println("||==============================================||");
                    System.out.println("|| cash (get 10% Discount from total payment)   ||");
                    System.out.println("|| creadit (didn't get any discount)\t\t||");
                    System.out.println("||==============================================||");
                    System.out.print("=>");
                    pay = sc.nextLine();
                    switch (pay) {
                        case "cash":
                            discountTot = total * 10 / 100;
                            break;
                        default:
                            discountTot = 0;
                    }
                    lastTot = total - discountTot;
                    System.out.println("||============================================||");
                    System.out.println("|| Your name : " + name);
                    System.out.println("|| Status : " + status);
                    System.out.println("|| Age : " + age);
                    System.out.println("|| The day that you choose :");
                    for (String nameDay : day) {
                        System.out.println("|| day = " + nameDay);
                    }
                    System.out.println("|| Your payment for the Course: IDR." + total);
                    System.out.println("|| Discount you Got : IDR." + discountTot);
                    System.out.println("|| Total that you have to pay : IDR." + lastTot);
                } else if (paket.equalsIgnoreCase("c")) {
                    System.out.println("||======================================||");
                    System.out.println("||\tYou choosed packet 3\t\t||");
                    System.out.println("||======================================||");
                    System.out.print("How much meeting for every week :");
                    meet = sc1.nextInt();
                    String[] day = new String[meet];
                    for (int i = 0; i < day.length; i++) {
                        System.out.print("Day ke-" + i + ": ");
                        day[i] = sc.nextLine();
                    }
                    discount = price * 10 / 100;
                    total = meet * (price - discount) * 36;
                    System.out.println("||==============================================||");
                    System.out.println("||\thow you want to pay it\t\t\t||");
                    System.out.println("||==============================================||");
                    System.out.println("|| cash (get 10% Discount from total payment)   ||");
                    System.out.println("|| creadit (didn't get any discount)\t\t||");
                    System.out.println("||==============================================||");
                    System.out.print("=>");
                    pay = sc.nextLine();
                    switch (pay) {
                        case "cash":
                            discountTot = total * 10 / 100;
                            break;
                        default:
                            discountTot = 0;
                    }
                    lastTot = total - discountTot;
                    System.out.println("||===============================================||");
                    System.out.println("|| Your name : " + name);
                    System.out.println("|| Status : " + status);
                    System.out.println("|| Age : " + age);
                    System.out.println("|| The day that you choose :");
                    for (String nameDay : day) {
                        System.out.println("|| day = " + nameDay);
                    }
                    System.out.println("|| Your payment for the Course: IDR." + total);
                    System.out.println("|| Discount you Got : IDR." + discountTot);
                    System.out.println("|| Total that you have to pay : IDR." + lastTot);
                } else {
                    System.out.println("sorry no packet like that");
                }
            } else if (level.equalsIgnoreCase("C") || level.equalsIgnoreCase("professional")) {
                price = 20000;
                System.out.println("||======================================||");
                System.out.println("||\tChoose which paket you need\t||");
                System.out.println("||======================================||");
                System.out.println("||\ta. 1 Month(3 weeks) \t\t||");
                System.out.println("||\tb. 6 Month(18 weeks) \t\t||");
                System.out.println("||\tc. 1 Year(36 weeks) \t\t||");
                System.out.println("||======================================||");
                System.out.print("=> ");
                String paket = sc.nextLine();
                if (paket.equalsIgnoreCase("a")) {
                    System.out.println("||======================================||");
                    System.out.println("||\tYou choosed packet 1\t\t||");
                    System.out.println("||======================================||");
                    System.out.print("How much meeting for every week :");
                    meet = sc1.nextInt();
                    System.out.println("Choose the day :");
                    String[] day = new String[meet];
                    for (int i = 0; i < day.length; i++) {
                        System.out.print("Day ke-" + i + ": ");
                        day[i] = sc.nextLine();
                    }
                    discount = 0;
                    total = meet * (price - discount) * 3;
                    System.out.println("||==============================================||");
                    System.out.println("||\thow you want to pay it\t\t\t||");
                    System.out.println("||==============================================||");
                    System.out.println("|| cash (get 10% Discount from total payment)   ||");
                    System.out.println("|| creadit (didn't get any discount)\t\t||");
                    System.out.println("||==============================================||");
                    System.out.print("=>");
                    pay = sc.nextLine();
                    switch (pay) {
                        case "cash":
                            discountTot = total * 10 / 100;
                            break;
                        default:
                            discountTot = 0;
                    }
                    lastTot = total - discountTot;
                    System.out.println("||=============================================||");
                    System.out.println("|| Your name : " + name);
                    System.out.println("|| Status : " + status);
                    System.out.println("|| Age : " + age);
                    System.out.println("|| The day that you choose :");
                    for (String nameDay : day) {
                        System.out.println("|| day = " + nameDay);
                    }
                    System.out.println("|| Your payment for the Course: IDR." + total);
                    System.out.println("|| Discount you Got : IDR." + discountTot);
                    System.out.println("|| Total that you have to pay : IDR." + lastTot);
                } else if (paket.equalsIgnoreCase("b")) {
                    System.out.println("||======================================||");
                    System.out.println("||\tYou choosed packet 2\t\t||");
                    System.out.println("||======================================||");
                    System.out.print("How much meeting for every week :");
                    meet = sc1.nextInt();
                    String[] day = new String[meet];
                    for (int i = 0; i < day.length; i++) {
                        System.out.print("Day ke-" + i + ": ");
                        day[i] = sc.nextLine();
                    }
                    discount = price * 5 / 100;
                    total = meet * (price - discount) * 18;
                    System.out.println("||==============================================||");
                    System.out.println("||\thow you want to pay it\t\t\t||");
                    System.out.println("||==============================================||");
                    System.out.println("|| cash (get 10% Discount from total payment)   ||");
                    System.out.println("|| creadit (didn't get any discount)\t\t||");
                    System.out.println("||==============================================||");
                    System.out.print("=>");
                    pay = sc.nextLine();
                    switch (pay) {
                        case "cash":
                            discountTot = total * 10 / 100;
                            break;
                        default:
                            discountTot = 0;
                    }
                    lastTot = total - discountTot;
                    System.out.println("||============================================||");
                    System.out.println("|| Your name : " + name);
                    System.out.println("|| Status : " + status);
                    System.out.println("|| Age : " + age);
                    System.out.println("|| The day that you choose :");
                    for (String nameDay : day) {
                        System.out.println("|| day = " + nameDay);
                    }
                    System.out.println("|| Your payment for the Course: IDR." + total);
                    System.out.println("|| Discount you Got : IDR." + discountTot);
                    System.out.println("|| Total that you have to pay : IDR." +lastTot);
                } else if (paket.equalsIgnoreCase("c")) {
                    System.out.println("||======================================||");
                    System.out.println("||\tYou choosed packet 3\t\t||");
                    System.out.println("||======================================||");
                    System.out.print("How much meeting for every week :");
                    meet = sc1.nextInt();
                    String[] day = new String[meet];
                    for (int i = 0; i < day.length; i++) {
                        System.out.print("Day ke-" + i + ": ");
                        day[i] = sc.nextLine();
                    }
                    discount = price * 10 / 100;
                    total = meet * (price - discount) * 36;
                    System.out.println("||==============================================||");
                    System.out.println("||\thow you want to pay it\t\t\t||");
                    System.out.println("||==============================================||");
                    System.out.println("|| cash (get 10% Discount from total payment)   ||");
                    System.out.println("|| creadit (didn't get any discount)\t\t||");
                    System.out.println("||==============================================||");
                    System.out.print("=>");
                    pay = sc.nextLine();
                    switch (pay) {
                        case "cash":
                            discountTot = total * 10 / 100;
                            break;
                        default:
                            discountTot = 0;
                    }
                    lastTot = total - discountTot;
                    System.out.println("||===============================================||");
                    System.out.println("|| Your name : " + name);
                    System.out.println("|| Status : " + status);
                    System.out.println("|| Age : " + age);
                    System.out.println("|| The day that you choose :");
                    for (String nameDay : day) {
                        System.out.println("|| day = " + nameDay);
                    }
                    System.out.println("|| Your payment for the Course: IDR." + (int)total);
                    System.out.println("|| Discount you Got : IDR." + (int)discountTot);
                    System.out.println("|| Total that you have to pay : IDR." + (int)lastTot);
                } else {
                    System.out.println("sorry no packet like that");
                }
            } else {
                System.out.println("Sorry your input is invalid");
            }
            System.out.println("||===============================================||");
            System.out.println("Do you want to go back to Main Menu (yes/no)?");
            System.out.print("=> ");
            answer = sc.nextLine();
        } while (answer.equalsIgnoreCase("yes"));
    }
}
