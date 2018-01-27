public class dolphin{
	//Manipulating strings
	public static void truncateName(String s) {
     s = s.substring(0, 3);
	}

	public static void main(String[] args) {

	   String name = "Dolphins";
	   truncateName(name);

	   System.out.println(name);
	}
}