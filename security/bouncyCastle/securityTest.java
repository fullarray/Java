import java.security.Security;

public class securityTest{
    public static void main(String[] args) {
        //Tell java to check if BouncyCastl is installed.
        if (Security.getProvider("BC") == null){
            System.out.println("Bouncy Castle is NOT installed");
        }
        else{
            System.out.println("Bouncy Castle is install");
        }
    }
}
