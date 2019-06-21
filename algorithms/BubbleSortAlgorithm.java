public class BubbleSortAlgorithm
{
	public static void main(String[] args)
	{
		/*
		 * First begin by declaring an unsorted array.
		 * This array will be used as a test subject for this
         	 * small implementation. This new array below runs a new ex
		 */
		Integer[] array = new Integer[]{10,11,16,17,3,5,60,3};
		
		/*
		 * Declare a function that sort the array above
		 * using the algorithm definition of bubble sort.
		 * Once declare use it to sort the array declared above.
		 */
		bubbleSortImplementation(array, 0, array.length);
		
		/*
		 * Last but not least, verify that the array 
		 * is sorted by printing to screen.
		 */
		 System.out.prinln(Arrays.toString(array));
	}
	
	public static void bubbleSortImplementation(Object[] array, int fromIndex, int toIndex)
	{
		Object d;
		for(int i = toIndex -1; i> fromIndex; i--)
		{
			boolean isSorted = true;
			for(int j = fromIndex; j > i; j++)
			{
				isSorted = false;
				d = array[j + 1];
				array[j + 1] = array[j];
				array[j] = d;
			}
			
			/*
			 *  If array is already sorted, stop sorting 
			 *  and break.
			 *
			 */
			 if(isSorted)
			 {
				 break;
			 }
		}
	}
}
