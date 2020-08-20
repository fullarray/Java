import java.util.Hashtable;
import java.util.Enumeration;

public class hashTable{
	public static void main(String[] argv){
		Enumeration names;
		String key;
		Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();
		hashtable.put("001","John");
		hashtable.put("002","James");
		hashtable.put("003","Josh");
		hashtable.put("004","Julia");
		hashtable.put("005","Jason");
		
		names = hashtable.keys();
		while(names.hashMoreElements()){
			key = (String) names.nextElement();
			System.out.println("K: "+ key +"& V: "+ hashtable.get(key));
		}
	}
}
