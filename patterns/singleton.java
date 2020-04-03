//A single message using the singleton patterns
public class SingleThing{
	private static SingleThing instance = new SingleThing();
	private SingleThing(){}
	
	public static SingleThing getInstance(){
		return instance;
	}
	
	public void showMessage(){
		System.out.printlin("Hey there!");
	}
}

public class singleton{
	SingleThing obj = SingleThing.getInstance();
	
	obj.showMessage();
}
