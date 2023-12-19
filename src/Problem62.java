//62. კონსოლიდან შეგვყავს სახელები, მანამ სანამ არ შევიყვანთ ცარიელ სტრინგს. 
//დაბეჭდეთ სახელი და მის გასწვრივ რაოდენობა რამდენჯერ შევიყვანეთ ეს სახელი.

import java.util.HashMap;
import java.util.Map;

import acm.program.ConsoleProgram;

public class Problem62 extends ConsoleProgram{
	private static final String SENTINEL = "";
	public void run() {
		Map<String, Integer> nameCounts = 
				new HashMap<String, Integer>();
		
		while(true) {
			String name = readLine("Enter name: ");
			if(name.equals(SENTINEL)) {
				break;
			}
			
			if(!nameCounts.containsKey(name)) {
				nameCounts.put(name, 0);
			}
			
			int newCount = nameCounts.get(name) + 1;
			nameCounts.put(name, newCount);
		}
		
		println(nameCounts);
		
	}

}
