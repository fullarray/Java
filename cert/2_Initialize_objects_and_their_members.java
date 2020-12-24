class 2_Initialize_objects_and_their_members{	
	
	String blah = "ABCD";
	
	public 2_Initialize_objects_and_their_members(){
		System.out.println("Public Constructor");
	}
	
	static {
		System.out.println("Static Initializer");
	}
	
	{
		System.out.println("Instance Initializer");
	}
	
	public void static void main(String[] args){
		new 2_Initialize_objects_and_their_members();
		new 2_Initialize_objects_and_their_members();
	}
}
