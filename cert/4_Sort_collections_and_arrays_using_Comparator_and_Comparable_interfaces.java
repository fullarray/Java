import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public 4_Sort_collections_and_arrays_using_Comparator_and_Comparable_interfaces{
	public static main void(String [] args){
		//unknown java. Mayba java 11
		int [] intArr = [4,2,4,5,7,8];
		Arrays.sort(intArr);
		System.out.println(Arrays.toString(intArr));
		
		String[] strArr = {"B","E","Z","C"};
	
		Arrays.sort(strArr);
		
		System.out.println(Arrays.toString(strArr));
		
		List<String> strList = new ArrayList<String>();
		
		strList.add("C");
		strList.add("B");
		strList.add("Z");
		strList.add("E");
		
		Collection.sort(strList);
		for(String str: strList) System.out.print(""+str);
	}
}