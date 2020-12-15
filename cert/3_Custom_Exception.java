class 3_Custom_Exception{
	static void validate(int age) throws InvalidAgeException{
		if(age<18)
			throw new InvalidAgeException("Not valid");
		else
			System.out.println("Welcome to vote");
	}
	
	// java 11
	public static void main(String[] args){
		try{
			validate(15);
		}catch(Exception e){
			System.out.println("Exception happened:"+ e);
		}
		
		System.out.println("Other code");
	}
}
