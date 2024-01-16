//ამოცანა 3. (20 ქულა) გამრავლება
//თქვენი ამოცანაა რაგინდ დიდი მთელი რიცხვები გაამრავლოთ ერთმანეთზე.
//ჩვენთვის ნაცნობ მონაცემთა ტიპებში რაგინდ დიდი რიცხვები არ ჩაეტევა,
//ამიტომ ამისათვის შეგვიძლია ArrayList გამოვიყენოთ. ნემისმიერი რიცხვი
//შეგვიძლია წარმოვიდგინოთ ArrayList-ის სახით, თუ მისი ელემენტები იქნება
//ამ რიცხვში შემავალი ციფრები.
//მაგალითად 451 შეგვიძლია წარმოვიდგინოთ არაილისტის სახით რომელშიც 3
//ელემენტია: ნულოვან ინდექსზე - 4, პირველ ინდექსზე - 5, და მეორე
//ინდექსზე - 1. (ჩავწეროთ როგორც ArrayList{4, 5, 1}).
//დაწერეთ multiply მეთოდი რომელსაც გადაეცემა ორი არაილისტი და რომელიც
//აბრუნებს არაილისტს. გადაცემული არაილისტები მხოლოდ ციფრებს შეიცავენ და
//წარმოადგენენ რაღაც მთელ დადებით რიცხვებს. მეთოდმა ეს რიცხვები უნდა
//გაამრავლოს ერთმანეთზე და დააბრუნოს მიღებული რიცხვის შესაბამისი
//არაილისტი.
//მაგალითად:
//ArrayList{4} * ArrayList{5} = ArrayList{2,0}
//ArrayList{1,2,3,4,5,6,7,8,9} * ArrayList{1,0,0,0,0,0,0,0,0,0,0} =
//ArrayList{1,2,3,4,5,6,7,8,9,0,0,0,0,0,0,0,0,0,0}
//ამოცანის გადასაჭრელად არ გამოიყენოთ BigInteger და მსგავსი ტიპის
//ცვლადები.
//ამოხსნა დაწერეთ multiply.java ფაილში.
//მინიშნება: გამოიყენეთ ქვეშმიწერით გამრავლების ალგორითმი.
import java.util.ArrayList;
import java.util.Arrays;

import acm.program.ConsoleProgram;

public class Final2022Session2Multiply extends ConsoleProgram {
	public void run() {
		ArrayList<Integer> num1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		ArrayList<Integer> num2 = new ArrayList<>(Arrays.asList(1,0,0,0,0,0,0,0,0,0,0));

		println("Expected: ");
		println(Arrays.asList(1,2,3,4,5,6,7,8,9,0,0,0,0,0,0,0,0,0,0));
		println(multiply(num1, num2));
		
		
		ArrayList<Integer> num3 = new ArrayList<>(Arrays.asList(1,2));
		ArrayList<Integer> num4 = new ArrayList<>(Arrays.asList(9,9,8));

		println("Expected: ");
		println(Arrays.asList(1,1,9,7,6));
		println(multiply(num3, num4));
	}

	private ArrayList<Integer> multiply(ArrayList<Integer> a, ArrayList<Integer> b) {
		ArrayList<Integer> res = new ArrayList<>();
		for(int i = 0; i < b.size(); i++) {
			int digit = b.get(b.size() - 1 - i);
			ArrayList<Integer> currRes = multiplyDigit(a, digit);
			for(int j = 0; j < i; j++) {
				currRes.add(0);
			}
			res = add(res, currRes);
		}
		return res;
	}
	
	private ArrayList<Integer> add(ArrayList<Integer> small, ArrayList<Integer> big) {
		ArrayList<Integer> res = new ArrayList<>();
		int rem = 0;
		for(int i = 0; i < big.size(); i++) {
			int sum = big.get(big.size() - 1 - i) + rem;
			if(small.size() - 1 - i >= 0) {
				sum += small.get(small.size() - 1 - i);
			}
			res.add(0, sum % 10);
			rem = sum / 10;
		}
		return res;
	}

	private ArrayList<Integer> multiplyDigit(ArrayList<Integer> a, int digit) {
		ArrayList<Integer> res = new ArrayList<>();
		int rem = 0;
		for (int i = a.size() - 1; i >= 0; i--) {
			int curr = a.get(i);
			int mult = curr * digit + rem;
			res.add(0, mult % 10);
			rem = mult / 10;
		}
		if (rem != 0) {
			res.add(0, rem);
		}
		return res;
	}

}