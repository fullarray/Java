import java.util.ArrayList;

public class ArrayListIndex{
	public static void main(String[] argv){
		ArrayList<String> l = new ArrayList<String>();
		l.add("John");
		l.add("Nate");
		l.add("Herman");
		l.add("Omar");
		System.out.println("Index of 'John': "+ l.indexOf("Herman"));
		System.out.println("Index of 'John': "+ l.indexOf("Nate"));
		System.out.println("Index of 'John': "+ l.indexOf("John"));
	}
}