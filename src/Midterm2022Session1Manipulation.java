//ვიდეოს ლინკი:
//https://www.youtube.com/watch?v=XC-zYpS7Guo


//ამოცანა 1. (25 ქულა) მანიპულაცია
//სტრინგებზე გვაქვს ასეთი ოპერაციის ჩატარების უფლება:
//შეგვიძლია სტრინგი გავხლიჩოთ ნებისმიერ ადგილას, ისე რომ მივიღოთ 2 ახალი
//არანულოვანი სიგრძის ქვესტრინგი. მიღებულ ორ ქვესტრინგში შეგიძლიათ
//ნებისმიერი სიმბოლო აიღოთ და ყველა ეს სიმბოლო წაშალოთ. საბოლოოდ
//მიღებული სტრინგები კი ისევ შეაწებოთ(იგივე რიგითობით). სიმბოლოს წაშლის
//დროს შესაძლოა პირველ და მეორე ქვესტრინგებში განსხვავებული სიმბოლოები
//წაშალოთ.
//მაგალითად სტრინგი “იყო არაბეთს როსტევან” შეგვიძლია ეს გავყოთ შემდეგ ორ
//ქვესტრინგად: “იყო არა” და “ბეთს როსტევან”
//პირველი ქვესტრინგიდან შეგვიძლია ამოვშალოთ ყველა შემხვედრი ‘ა’ სიმბოლო.
//ხოლო მეორე სტრინგიდან კი ყველა შემხვედრი ‘ბ’ სიმბოლო. მაშინ შეწებებით
//მივიღებდით სტრინგს “იყო რეთს როსტევან”.
//დაწერეთ მეთოდი manipulation რომელსაც გადაეცემა ორი სტრინგი და რომელიც
//აბრუნებს true-ს იმ შემთხვევაში თუ პირველი სტრინგიდან აღწერილი
//ოპერაციებით შეგვიძლია მეორის მიღება. წინააღმდეგ შემთხვევაში მეთოდი
//უნდა აბრუნებდეს false-ს.
//ამოხსნა დაწერეთ manipulation.java ფაილში

import acm.program.ConsoleProgram;

public class Midterm2022Session1Manipulation extends ConsoleProgram {
	public void run() {
		String text1 = "იყო არაბეთს როსტევან";
		String text2 = "იყო რეთს როსტევან";
		println(manipulation(text1, text2));
	}

	private boolean manipulation(String text1, String text2) {
		for (int i = 1; i < text1.length() - 1; i++) {
			String part1 = text1.substring(0, i); // იყო არa
			String part2 = text1.substring(i); // ბეთს როსტევან
			if (canManipulate(part1, part2, text2)) {
				return true;
			}
		}
		return false;
	}

// “იყო არა” და “ბეთს როსტევან”,  იყო რეთს როსტევან

	private boolean canManipulate(String part1, String part2, String text2) {
		for (int i = 0; i < part1.length(); i++) {
			String substracted1 = substractStr(part1, part1.charAt(i)); // იყო არა ა -> იყო რ
			for (int j = 0; j < part2.length(); j++) {
				String substracted2 = substractStr(part2, part2.charAt(j)); // ბეთს როსტევან , ბ ->ეთს როსტევან
				String newText1 = substracted1 + substracted2;
				if (newText1.equals(text2)) {
					return true;
				}
			}
		}
		return false;
	}

	// იყო არა ი -> ყო არა
	private String substractStr(String text, char ch) {
		String newStr = "";
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) != ch) {
				newStr += text.charAt(i);
			}
		}
		return newStr;
	}
}
