import java.util.Scanner;

public class FormattingString {
    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("================================");
            for(int i=0;i<3;i++){
                String s1=sc.next();
                int x=sc.nextInt();
                String xs = Integer.toString(x);
                String xpadded="000".substring(xs.length()) + xs;
                //Complete this line
                int diff = 18 - s1.length();
                System.out.println(s1 +""+String.format("%" + diff + "s", xpadded));
            }
            System.out.println("================================");

    }
}



