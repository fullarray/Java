
public class 2_Declare_and_instantiate_Java_objects_including_nested_class_objects{
	
	String model;
	
	public Car(String model){
		this.model = model;
	}
	
	public static main void(String [] args){
		Car lambo = new Car("New lamborgini");
		lambo = null; // garbage collection. Part of object life
	}
}
