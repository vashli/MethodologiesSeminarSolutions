import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import acm.program.ConsoleProgram;
//ამოცანა 4. (30 ქულა) სამზარეულო
//თქვენი ამოცანაა გაიგოთ რა კერძების გაკეთება შეიძლება სამზარეულოში. ამისათვის მოცემული გაქვთ რეცეპტების სია ჰეშმეფის სახით. ჰეშმეფის key არის კერძის სახელი(String), ხოლო value ინგრედიენტების სახელების სია(ArrayList<String>). ზოგიერთი კერძის ინგრედიენტი შეიძლება სხვა კერძიც იყოს, მაგალითად:
//პური - [ფქვილი, მარილი]
//ხაჭაპური - [ფქვილი, ყველი , მარილი]
//ბურგერი - [პური, ყველი, სალათის ფოთოლი]
//ასევე მოცემული გაქვთ მაცივარში არსებული ინგრედიენტების სახელების სია(ArrayList<String>). ჩათვალეთ, რომ უსასრულო რაოდენობის ინგრედიენტები გაქვთ.
//დაწერეთ kitchen მეთოდი რომელსაც გადაეცემა რეცეპტების ჰეშმეფი და ინგრედიენტების არაილისტი და რომელიც აბრუნებს შესაძლებელი კერძების არაილისტს.
//ამოხსნა დაწერეთ kitchen.java კლასში
//TODO არასწორადაა პირობა გაგებული და უფრო მარტივი ვარიანტის ამოხსნა წერია.
//https://www.youtube.com/playlist?list=PL6qg6DlVkjd6XenORSl6px7Z_NweBs8yf
public class Final2021Session2Kitchen extends ConsoleProgram {

	public void run() {
		Map<String, ArrayList<String>> receipts = new HashMap<>();
		ArrayList<String> ingredients = new ArrayList<>(Arrays.asList("1", "2", "3"));

		ArrayList<String> i1 = new ArrayList<>(Arrays.asList("1", "2"));

		ArrayList<String> i2 = new ArrayList<>(Arrays.asList("4", "2"));

		ArrayList<String> i3 = new ArrayList<>(Arrays.asList("1", "3"));

		receipts.put("k1", i1);
		receipts.put("k2", i2);
		receipts.put("k3", i3);

		println(kitchen(receipts, ingredients));

	}

	private ArrayList<String> kitchen(Map<String, ArrayList<String>> receipts, ArrayList<String> ingredients) {

		ArrayList<String> res = new ArrayList<>();
		for (String key : receipts.keySet()) {
			if (canBeMade(receipts.get(key), ingredients)) {
				res.add(key);
			}
		}
		return res;
	}

	private boolean canBeMade(ArrayList<String> currIngredients, ArrayList<String> ingredients) {
		for (String ing : currIngredients) {
			if (!ingredients.contains(ing)) {
				return false;
			}
		}
		return true;
	}

}