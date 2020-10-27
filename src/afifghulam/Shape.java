import java.util.*;

class Shapes {
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    int num, row, col, selection;
	
	//Menus
    System.out.println("==============================");
    System.out.println("\tCreate your own shape");
    System.out.println("==============================");
    System.out.println("1. Square");
    System.out.println("2. Triangle");
    System.out.print("Your option: ");
    selection = scan.nextInt();
    System.out.println("------------------------------");

    switch(selection) {

      case 1:
        System.out.print("Input Row: ");
        row = scan.nextInt();

        System.out.print("Input Column: ");
        col = scan.nextInt();

        for(int i=0; i < row; i++) {
          for(int j=0; j < col; j++) {
            System.out.print("* ");
          }
          System.out.print("\n");
        }
        break;

      case 2:
        System.out.print("input your number: ");
        num = scan.nextInt();

        for(int i=0; i<num; i++) {
          for(int j=0; j<num; j++) {
            System.out.print("* ");
            if(i==j) break;
          }
          System.out.print("\n");
        }
        break;

      default: 
        System.out.println("Input option mismatch !");
        
    }

  }
}