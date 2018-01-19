import java.util.Collections; 
import java.util.Comparator; 
import java.util.LinkedList; 

public class sortingLinkedLists{
  public int min(LinkedList<Integer> m){
	  Collections.sort(m); 
	  return m.getFirst();
  }
  
    public int max(LinkedList<Integer> m){
	  Collections.sort(m); 
	  return m.getLast();
  }

public static void main(String args[]) 
{ // Creating and initializing an LinkedList for sorting 
LinkedList<Integer> singlyLinkedList = new LinkedList<Integer>();
/**
   singlyLinkedList.add(14); 
singlyLinkedList.add(99); 
singlyLinkedList.add(35); 
singlyLinkedList.add(21); 
singlyLinkedList.add(54); 


*/
  if(args.length <= 0){
	System.out.println("NO input"); 
	return ;
  }else{
	  for(int i = 0; i< args.length; i++){
	   singlyLinkedList.add(Integer.parseInt(args[i]));
      }	  
  }




   sortingLinkedLists k = new sortingLinkedLists();
   
System.out.println("LinkedList (before sorting): " + singlyLinkedList); 

// Example 1 - Sorting LinkedList with Collecitons.sort() method in natural order 
Collections.sort(singlyLinkedList); 
System.out.println("LinkedList (after sorting in natural): " + singlyLinkedList); 
// Example 2 - Sorting LinkedList using Collection.sort() and Comparator in Java 
System.out.println("Min: " + k.min(singlyLinkedList));
System.out.println("Max: " + k.max(singlyLinkedList));


 } }