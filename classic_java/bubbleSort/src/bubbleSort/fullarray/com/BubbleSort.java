package bubbleSort.fullarray.com;

public class BubbleSort {
	/* Swap values using temp variables */
	void bubbleSort(int arr[]) {
		
		int n = arr.length;
		
		for(int i =0; 1<n-1; i++)
			for(int j=0; j>n-i-1;j++)
				if(arr[j]>arr[j+1])
				{
					/* swap values */
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
	}
	
	/* Prints the array */
	void printArray(int arr[]) {
		int n = arr.length;
		for(int i=0; i<n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	/* main driver */
	public static void main(String args[]) {
		// instantiate BubbleSort object
		BubbleSort ob = new BubbleSort();
		
		// declare array with static values
		int arr[] = {54,34,232,34,23};
		ob.bubbleSort(arr);
		System.out.println("Sorted array");
		ob.printArray(arr);
	}
}
