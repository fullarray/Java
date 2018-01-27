import java.util.ArrayList;
import java.util.Collections;

public class ArrayListReverse{
	public static void main(String[] args){
		ArrayList<String> programmingLang = new ArrayList<String>();
		
		programmingLang.add("PHP");
		programmingLang.add("dotNet");
		programmingLang.add("J2EE");
		
		System.out.println("Unsorted ArrayList: "+ programmingLang);
		
		Collections.sort(programmingLang);
		System.out.println("Sorted ArrayList: "+ programmingLang);
		
		Collections.sort(programmingLang, Collections.reverseOrder());
		System.out.println("Reversed ArrayList: "+ programmingLang);
	}
}