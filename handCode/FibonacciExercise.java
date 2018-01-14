//Implementation created by fullarray and John
public class FibonacciExercise{
	public static void main(String[] args){
	 int n = Integer.parseInt(args[0]);
		System.out.print("Fibonacci:");
		for(int i = 1; i <= n; i++ ){
			  if(i != 1){
			  System.out.print(" "+((i-1) + (i-2)));
			}
		}
}