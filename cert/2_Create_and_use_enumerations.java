class 2_Create_and_use_enumerations{
	enum Animal {
		DOG,
		CAT,
		COW
	}
	
	public void static void main(String[] args){
		Animal cow1 = Animal.COW;
		Animal cat1 = Animal.CAT;
		Animal dog1 = Animal.DOG;
		
		System.out.println(cow1);
	}
}
