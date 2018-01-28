import java.util.*;

interface Person{
	Person clone();
}

class Josh implements Person{
	private final String NAME = "Josh";
	
	public Person clone(){
		return new Josh();
	}
	
	public String toString(){
		return NAME;
	}
}

class Maria implements Person{
	private final String NAME = "Maria";
	
	
	public Person clone(){
		return new Maria();
	}
	
	
	public String toString(){
		return NAME;
	}
}

class Harold implements Person{
	private final String NAME = "Harold";
	
	
	public Person clone(){
		return new Harold();
	}
	
	
	public String toString(){
		return NAME;
	}
}

class Factory{
	private static final Map<String, Person> proto = new HashMap<>();
	
	static{
		proto.put("maria", new Maria());
		proto.put("josh", new Josh());
		proto.put("harold", new Harold());
	}
	
	public static Person getPrototype(String type){
		try{
			return proto.get(type).clone();
		}catch(NullPointerException e){
			System.out.println("Prototype "+ type +", doesn't exist.");
			return null;
		}
	}
}
	
	public class prototype{
		public static void main(String[] args){
			if(args.length > 0){
				for(String type: args){
					Person proto = Factory.getPrototype(type);
					if(proto != null){
						System.out.println(proto);
					}
				}
			}else{
				System.out.println("No input was detected.");
			}
		}
	}



