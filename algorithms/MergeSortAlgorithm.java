import java.util.*;

public class MergeSortAlgorithm
{
	public static void main(String[] args)
	{
		//declare an unsorted array
		Integer[] b = {2,4,6,7,9,1};
		
		//Declare MergeSorting algorithm function first.
		MergeSortProcessor(b);
		
		//check the sorted array and output it
		System.out.println(Arrays.toString(b));
	}
	
	public static Comparable[] MergeSortProcessor(Comparable[] list)
	{
		//If list is empty, don't do anything.
		if(list.length <= 1)
		{
			return list;
		}
		
		//Split the array in half in two parts
		Comparable[] first = new Comparable[list.length / 2];
		Comparable[] second = new Comparable[list.length - first.length];
		System.arraycopy(list, 0, first, 0, first.length);
		System.arraycopy(list, first.length, second, 0, second.length);
		
		//Sorting each half recursively
		MergeSortProcessor(first);
		MergeSortProcessor(second);
		
		//Merging both halfs together, overwriting to original array
		merging(first, second, list);
		return list;
	}
	
	private static void merging(Comparable[] first, Comparable[] second, Comparable[] result)
	{
		//indexing position in first array - starting with first element
		int iFirst = 0;
		
		//indexing position in second array - starting with first element
		int iSecond = 0;
		
		//indexing position in merged array - starting with first element
		int iMerged = 0;
		
		/*
		 * compare element at iFirst and iSecond,
		 * and move smaller element at iMerged
		*/
		
		while(iFirst < first.length && iSecond < second.length)
		{
			if(first[iFirst].compareTo(second[iSecond]) < 0)
			{
				result[iMerged] = first[iFirst];
				iFirst++;
			}
			else
			{
				result[iMerged] = second[iSecond];
				iSecond++;
			}
			iMerged++;
		}
		
		/* 
		 * Copy the remaining elements from both halfs - each half will have
		 * already sorted elements.
		 */
		 
		 System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
		 System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
	}
}