import java.util.LinkedList;
import java.util.Queue;

public class QueuesImp{
	public static void main(String[] args){
		Queue<Integer> j = new LinkedList<>();
		
		for(int i = 0; i<3; i++){
			j.add(i);
			System.out.println("Queue elements: "+ j);
			
			
			int removedele = j.remove();
			System.out.println("Queue element removed: "+ removedele);
			
			System.out.println(j);
			
			int head = j.peek();
			System.out.println("Queue head:" + head);
			
			int size = j.size();
			System.out.println("Queue size: "+ size);
		}
	}
}