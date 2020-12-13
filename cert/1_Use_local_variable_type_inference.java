// Wrapper classes
import java.*;
import java.util.*;
public 1_Use_local_variable_type_inference{
	public static main void(String [] args){
		//
		// before java 10
		Path path = Paths.get("src/web.log");
		try(Stream<String> lines = Files.lines(path)){
			long warningCount = lines
									.filter(line -> line.contains("WARNING"))
									.count();
			System.out.println("Found "+ warningCount + " warnings in the log file");
		}catch(IOException e){
			e.printStackTrace();
		}
		
		//
		// java 10 using local variable type inference
		//
		var path = Paths.get("src/web.log");
		try(var lines = Files.lines(path)){
			var warningCount = lines
									.filter(line -> line.contains("WARNING"))
									.count();
			System.out.println("Found "+ warningCount + " warnings in the log file");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
