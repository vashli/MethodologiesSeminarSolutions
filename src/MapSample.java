import java.util.HashMap;
import java.util.Map;

import acm.program.ConsoleProgram;

public class MapSample extends ConsoleProgram {
	public void run() {
		Map<String, Double> midtermScores = new HashMap<String, Double>(); 
		
//		Map - interfase
//		Hashmap class, implements Map
		midtermScores.put("mberi15", 10.7);
		midtermScores.put("mberi20", 10.8);
		
		midtermScores.put("mberi21", 10.9);
		
		double score = midtermScores.get("mberi15");
		println(midtermScores.get("mberi15"));
		

		for(String key: midtermScores.keySet()) {
			println(key + ": " + midtermScores.get(key));
		}
		
	}
}










