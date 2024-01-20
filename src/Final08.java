import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;
import acm.program.ConsoleProgram;

//შექმენით HashMap<String, Integer> ობიექტი, შეავსეთ. 
//ჩაწერეთ ფაილში. შემდეგ წაიკითხეთ ეგ ფაილი და წაკითხული მონაცემები შეინახეთ ახალ HashMap-ში.
//ფაილში როგორი სტრუქტურითაც გინდათ ისე შეინახეთ, მთავარია წაკითხვის მერე ანალოგიური map-ის შევსება მოახერხოთ სწორად. 
//Tags: File read/write, Map

public class Final08 extends ConsoleProgram {
	private static final String FILE_NAME = "map.txt";

	public void run() {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("mari", 112);
		map.put("ana", 222222);
		map.put("gio", 12323);
		writeMap(map, FILE_NAME);

		HashMap<String, Integer> map2 = readMap(FILE_NAME);
		print(map2);
	}

	private void writeMap(HashMap<String, Integer> map, String fileName) {
		try {
			BufferedWriter w = new BufferedWriter(new FileWriter(fileName));
			w.write(map.toString());
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private HashMap<String, Integer> readMap(String fileName) {
		HashMap<String, Integer> map = new HashMap<>();
		try {
			BufferedReader r = new BufferedReader(new FileReader(fileName));

			while (true) {
				String line = r.readLine();
				if (line == null)
					break;

				StringTokenizer tokenizer = new StringTokenizer(line, "{}, ");
				while (tokenizer.hasMoreTokens()) {
					String pair = tokenizer.nextToken();
					// instead of this, we can use tokenizer here as well
					int index = pair.indexOf("=");
					String key = pair.substring(0, index);
					Integer value = Integer.parseInt(pair.substring(index + 1));
					map.put(key, value);
				}
			}
			r.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return map;
	}
}