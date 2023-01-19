import java.util.HashMap;
import java.util.Map;

import acm.program.ConsoleProgram;

public class MyMapTst extends ConsoleProgram{
	public void run(){
		// constructor
		Map<String, String> map = new MyMap<>();
		
		//isEmpty
		println(map.isEmpty());
		//put
        map.put("j", "java");
        map.put("c", "c++");
        map.put("p", "python");
        map.put("n", "node");
        
		//isEmpty
		println(map.isEmpty());

        Map<String, String> expected = new HashMap<>();
        expected.put("n", "node");
        expected.put("c", "c++");
        expected.put("j", "java");
        expected.put("p", "python");

   

        // toString
        println(map);
        
        // entrySey
        println(map.entrySet());
        println(expected);
        
        // size
        println(map.size());
        
        //get
        println(map.get("c"));
        println(map.get("c#"));

        //keySet
        println(map.keySet());
        for(String key: map.keySet()){
        	println(key + ": " + map.get(key));
        }

        //containsKey
        println(map.containsKey("c"));
        println(map.containsKey("c#"));
        
        //containsValue
        println(map.containsValue("java"));
        println(map.containsValue("c#"));
        
        //remove
        println(map.remove("c#"));
        println(map.remove("c"));
        println(map);
        
        //putAll
        map.putAll(expected);
        println(map);
        
        //values
        println(map.values());
        
        //size
        println(map.size());
	}
}
