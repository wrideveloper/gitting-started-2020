package tugasprogjar1;

import java.util.Scanner;

public class checkIP
{
    public static void main(String[] args) 
    {
        int a,b,c,d;

        String ip;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Masukkan IP : ");
        ip = sc.nextLine();
        
        for(a=0;a<=255;a++)
        {
            for(b=0;b<=255;b++)
            {
                for(c=0;c<=255;c++)
                {
                    for(d=0;d<=255;d++)
                    {
                        if(ip.equals(a + "." + b + "." + c + "." + d))
                        {
                            System.out.println("IP Valid");
                            System.exit(0);
                        }
                        else
                        {
                            break;
                        }
                    }
                }
            }
        }
        
        System.out.println("IP Tidak Valid");
    }
}
