import java.util.Comparator;
public class Selection
{
	private Selection()
	{}
	public static void sort(Comparable[] array)
	{
		if(array == null)
		{
			throw new NullPointerException();
		}
		int size = array.length;
		int min;
			
		for(int i = 0; i < size; i++)
		{
			min=i;
			
			for(int j = i+1; j < size; j++)
			{
				if(less(array[j]), array[min])
				{
					min = j;
				}
			}
			exchange(array, i, min);
		}
		
	}
	
	private static boolean less(Comparable v, Comparable w)
	{
		return v.compareTo(w) < 0;
	}
	
	private static void exchange(Object[] a, int i, int j)
	{
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	
	public static void show(Comparable[] array)
	{
		int n = array.length;
		for(int i = 0; i < n; i++)
		{
			System.out.print(array[i] + ",");
		}
	}
}
