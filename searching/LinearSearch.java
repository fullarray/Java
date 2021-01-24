class LinearSearch{
	public static int search(int arr[], int x){
		int n = arr.length;
		for(int i = 0; i<n; i++){
			if (arr[i]==x){
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String args[]){
		int arr[] = {4,2,10,1,5};
		
		int x = 10;
		
		int output = search(arr, x);
		
		if(output == -1){
			System.out.print("Not found");
		}else{
			System.out.print("Found at"+ output);
		}
	}
}