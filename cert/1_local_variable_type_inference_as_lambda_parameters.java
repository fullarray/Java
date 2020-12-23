// Wrapper classes
import java.*;
import java.util.*;
public 1_Use_local_variable_type_inference{
	public static main void(String [] args){
		
		// lambda on java 10
		(String s1, String s2) -> s1 + s2;
		
		
		//
		// or, the below did not work in Java 10
		//
		(var s1, var s2) -> s1 + s2;
		
		
		//
		// java 11
		//
		(s1, s2) -> s1 + s2;
		
		
		
		// java annotations can only work with explicit types, 
		// "var" in this case
		//
		(@Nonnull var s1, @Nullable var s2) -> s1 + s2;
		
	}
}
