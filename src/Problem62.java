import java.util.HashMap;
import acm.program.ConsoleProgram;
//
//62. კონსოლიდან შეგვყავს სახელები, მანამ სანამ არ შევიყვანთ ცარიელ სტრინგს. დაბეჭდეთ
//სახელი და მის გასწვრივ რაოდენობა რამდენჯერ შევიყვანეთ ეს სახელი.

public class Problem62 extends ConsoleProgram {
	public void run() {
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		while (true) {
			String name = readLine("Enter name: ");
			if (name.equals("")) {
				break;
			}

			int value = 1;
			if (map.containsKey(name)) {
				value = map.get(name) + 1;
			}
			map.put(name, value);
		}

		println(map);
	}
}