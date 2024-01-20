import java.util.ArrayList;
import java.util.Arrays;

import acm.program.ConsoleProgram;

//დაწერეთ მეთოდი  Merge, რომელსაც გადმოეცემა ორი დასორტილი ArrayList და რომელიც აბრუნებს ახალ ArrayList -ს , რომელიც არის არგუმენტად გადმოცემული სიების გაერთიანება დასორტილ მდგომარეობაში.
//მეთოდი დაწერეთ შემდეგი ალგორითმით:
//შემოიტანეთ ცვლადი პირველი მასივის ახლანდელი ინდექსის აღსანიშნავად, და მეორე ცვლადი მეორე მასივის ახლანდელი ინდექსის აღსანიშნავად.
//ყოველ ჯერზე შეადარეთ ახლანდელ ინდექსებზე არსებული ელემენტები და მათ შორის მინიმალური დაამატეთ საბოლოო სიაში. გადატანილი ცვლადის შესაბამისი ინდექსის აღმნიშვნელი ცვლადი გაზარდეთ და განაგრძეთ პროცესი. თუ რომელიმე სიის ბოლოში გახვედით, მეორე სიის დარჩენილი ნაწილი ავტომატურად უნდა დაამატოთ საბოლოო სიას.
//Tags: Algorithm Implementation, Merge

public class Final16 extends ConsoleProgram {
	public void run() {
		ArrayList<Integer> a = new ArrayList<>(
				Arrays.asList(1, 2, 3, 5, 7, 8));
		
		ArrayList<Integer> b = new ArrayList<>(
				Arrays.asList(2, 4, 5, 6, 12, 14, 18));
		
		ArrayList<Integer> merged = merge(a, b);
		
		println(a);
		println(b);
		println(merged);
	}

	private ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b) {
		ArrayList<Integer> res = new ArrayList<>();
		int i = 0;
		int j = 0;
		while(true){
			if(i == a.size()){
				res.addAll(b.subList(j, b.size()));
				break;
			}else if(j == a.size()){
				res.addAll(b.subList(i, b.size()));
				break;
			}
			if(a.get(i) < b.get(j)){
				res.add(a.get(i));
				i++;
			}else{
				res.add(b.get(j));
				j++;
			}
		}
		return res;
	}
	
	
}
