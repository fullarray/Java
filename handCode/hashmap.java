import java.util.HashMap;

class Key{
	String key;
	Key(String k){
		this.key = k;
	}
	
	public int hashCode(){
		int hash = (int)key.charAt(0);
		System.out.println("Hash key: "+ key +" = "+ hash);
		return hash;
	}
	
	public boolean equals(Object o){
		return key.equals(((Key)o).key);
	}
}

public class hashmap
{
	public static void main(String[] args){
		HashMap map = new HashMap();
		map.put(new Key("John"), 20);
		map.put(new Key("Mark"), 30);
		map.put(new Key("Bob"), 40);
		System.out.println("\nValue John"+ map.get(new Key("Mark")));
		System.out.println("Value Bob"+ map.get(new Key("Bob")));
		System.out.println("Value John"+ map.get(new Key("John")));
	}
	

}