import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StaticBlockInitialization {

    public static boolean flag = false;
    public static int B;
    public static int H;

static {
    Scanner stdin = new Scanner(System.in);
    B = stdin.nextInt();
    H = stdin.nextInt();
    
    if (B>0 && H>0 ){
        flag = true;
        
    }else{
         System.out.println("java.lang.Exception: Breadth and height must be positive");
    }
    stdin.close();
}

public static void main(String[] args){
		if(flag){
			int area=B*H;
			System.out.print(area);
		}
		
	}//end of main

}//end of class

