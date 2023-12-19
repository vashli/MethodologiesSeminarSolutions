import java.util.HashMap;
import java.util.Map;

import acm.program.ConsoleProgram;

public class MapSample extends ConsoleProgram {
	public void run() {
		// array []  // Arrays
		// ArrayList
		// key -> value
		// map, dictionary 
	
		Map<String, Integer> strudentScores = new HashMap<String, Integer>();
		
		strudentScores.put("mberi15", 7);
		println(strudentScores.get("mberi15"));
		
		strudentScores.put("mberi21", 10);
		
		for(String key: strudentScores.keySet()) {
			println(key + ": " + strudentScores.get(key));
		}
		
//		Map - interface
//		HashMap - class (implements Map)
//		strudentScores - object , instance of HashMap
			
	}

}
