import java.util.*;
import java.io.*;
import java.lang.Math;

class LoopingII{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int product=0, sum =a, count=0;
            
            //if(a==0){
            //    a = 1;
            //}
            
            //if(b==0){
            //    b = 1;
            //}
            
            for(int j=0; j<=n;j++){
                // product = a + 2^j * b
                product = ((int) Math.pow(2, j) * b);
                sum += product;
                
                /*
                when a = 3, b = 5:
                  
                p = 3^0 * 5 = 5
                s = 3 + 5 = 8
                
                p = 3^1 * 5 = 15
                3 += 14
                
                
                */
                
                
                if(count<n){
                    System.out.print( sum + " ");
                }
                count++;          
            } System.out.println(" ");
                   
        }
        in.close();
    }
}
