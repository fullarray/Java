import java.io.Console;
class SearchElementInArray
{
	public static void main(String[] args)
	{
		String key = "Smith";
		String[] list = new String[3];
		Console cnsl = System.console();
		for(int i=0; i<3; i++)
		{
			list[i] = cnsl.readLine("Enter a name: ");
		}
		int count = searchTerm (list, key);
		
		String wordNumber;
		
		switch(count)
		{
			case 1:  wordNumber = "once";
					 break;
			case 2:  wordNumber = "twice";
			 		 break;
			default: wordNumber = "all time";
		} 
		
		System.out.println("Your item showed "+ wordNumber +".");
	}
	
	public static int searchTerm(String[] list, String key)
	{
		int i, count = 0;
		
		for(i=0; i<list.length; i++)
		{
			if(list[i].equals(key))
			{
				count = count+1;
			}
		}
		
		return (count);
	}
}
