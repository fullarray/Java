// Wrapper class
import java.text;
import java.util.*;

public 1_Handle_text_using_String_and_StringBuilder_classes{
	public static main void(String [] args){
		byte b = Byte.parseByte("16");
		int n = Integer.parseInt("42");
		boolean b = new Boolean("true").booleanValue();
		
		byte b1 = new Scanner("16").nextByte();
		int n1 = new Scanner("42").nextInt();
		long l1 = new Scanner("1119919191").nextLong();
		
		long l2 = Long.parseLong("cafe", 16);
		byte b2 = Byte.parseByte("15",8);
		
		
		long l3 = new Scanner("cafe").nextLong(16);
		byte b3 = new Scanner("15").nextByte(8);
		
		long l4 = Long.toString(45264264,16);
		String s1 = Integer.toHexString(255).toUpperCase();
		
		String text1 = "Now is the time for all good men";
		String[] w1 = text.split("\\s");
		
		String text2 = "52535,      java certification, 100000";
		String[] w2 = text.split("\\s*,\\s*");
		
		Scanner fileScanner = new Scanner( new File("data.csv") );
		fileScanner.useDelimiter( "\\s*,\\s* ");
		
		while( scanner.hasNextInt() ) {
		  int n = scanner.nextInt();
		  System.out.print(n);
		}
		
		
		String text3 = "Now is the time for all good men (and women)...";
		StringTokenizer st1 = new StringTokenizer(tezt3);
		
		while ( st.hasMoreTokens() )  {
			String word = st.nextToken();
			System.out.print(word);
		}
		
		String text4 = "4231,     Java Programming, 1000.00";
		StringTokenizer st2 = new StringTokenizer(tezt4, ",");
		
		while(st2.hasMoreTokens()){
			String word2 = st.nextToken();
			System.out.println(word2);
		}
	}
}
