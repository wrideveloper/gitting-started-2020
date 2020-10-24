import java.util.Scanner;

public class RequestInteger{
    public static void main(String args[]){
        Scanner ipt = new Scanner(System.in);
        
        int a, number;
        double avg;
        
        System.out.println("*****************************************************************");
        System.out.println("*\t\t     Even Number Calculation\t\t\t*");
        System.out.println("*****************************************************************");
        System.out.print("Input limit number : ");
        number = ipt.nextInt();

        int b=0;
        int sum=0;
        for(a=1;a<=number;a++){
            b+=2;
            sum+=b;
            System.out.printf("Even number %d is %d\n",a,b);
        }
        avg=(double)sum/number;
        System.out.println("*****************************************************************");
        System.out.printf("* The sym of the even numbers between 1 and %d is %d\t\t*\n",number,sum);
        System.out.printf("* The average of the even numbers between 1 and %d is %.2f\t*\n",number,avg);
        System.out.println("*****************************************************************");
    }
}