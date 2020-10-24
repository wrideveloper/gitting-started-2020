import java.util.*;

class Kalkulator {
	public static void main(String[] args) {
			
		Scanner scan = new Scanner(System.in);
		double num1, num2, res;
		char operator;
		
		System.out.print("Masukkan bilangan pertama: ");
		num1 = scan.nextDouble();
		
		System.out.print("Masukkan operator(+, -, *, /): ");
		operator = scan.next().charAt(0);
		
		System.out.print("Masukkan Bilangan ke dua: ");
		num2 = scan.nextDouble();
		
		switch(operator){
			case '+':
				res = num1 + num2;
				System.out.println(num1 +  " + " + num2 + " = " + res);
				break;
			case '-':
				res = num1 - num2;
				System.out.println(num1 + " - " + num2 + " = " + res);
				break;
			case '*':
				res = num1 * num2;
				System.out.println(num1 +  " * " + num2 + " = " + res);
				break;
			case '/':
				res = num1 / num2;
				System.out.println(num1 + " / " + num2 + " = " + res);
				break;
			default:
				System.out.println("Tidak ditemukan operator");
		}
	}
}