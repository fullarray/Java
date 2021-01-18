class 3_Exception_Handling_Try_With_Resource{
	// java 11
	public static void main(String[] args){
		try(BufferedReader reader = new BufferedReader(new FileReader("C://sample.txt"))){
			System.out.println(reader.readLine());
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}


/*
    // all way
	public static void main(String[] args){
		BufferedReader reader = null;
		
		try{
			reader = new BufferedReader(new FileReader("C://sample.txt"));
			System.out.println(reader.readLine());
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(reader != null){
				try{
					reader.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}

*/
