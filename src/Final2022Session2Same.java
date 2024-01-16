//ამოცანა 1. (20 ქულა) მსგავსი სტრინგები
//მოცემული გაქვთ ორი თანაბარი სიგრძის სტრინგი S და T, რომლებშიც მხოლოდ
//პატარა ლათინური ასოები შედის. აღვნიშნოთ სიგრძე n-ით. შეგიძლიათ შემდეგი
//3 ოპერაცია გააკეთოთ რამდენჯერაც გინდათ იმდენჯერ და რა მიმდევრობითაც
//გინდათ იმ მიმდევრობით:
//* აირჩიეთ i (0 <= i < n) და ადგილები გაუცვალეთ S[i] და T[i] სიმბოლოებს
//* აირჩიეთ i (0 <= i < n) და ადგილები გაუცვალეთ S[i] და S[n-i-1]
//სიმბოლოებს
//* აირჩიეთ i (0 <= i < n) და ადგილები გაუცვალეთ T[i] და T[n-i-1]
//სიმბოლოებს
//S[i]-ით აღნიშნულია S სტრინგის i-ურ ინდექსზე მდგომი სიმბოლო.
//თუკი ამ ოპერაციებით შეგიძლიათ მიიღოთ ორი ერთნაირი სტრინგი, მაშინ ასეთ
//სტრინგებს უწოდებენ მსგავსებს. თქვენი ამოცანაა დაწეროთ same მეთოდი
//რომელსაც გადაეცემა ორი სტრინგი და რომელიც აბრუნებს true-ს, თუკი ეს
//სტრინგები მსგავსებია, ხოლო false-ს თუკი ისინი მსგავსები არ არიან.
//მაგალითად:
//same(“bla”, “blu”) -> false
//same(“abca”, “dbcd”) -> true
//same(“pcabb”, “bbacp”) -> true
//ამოხსნა დაწერეთ same.java ფაილში


import acm.program.ConsoleProgram;

public class Final2022Session2Same extends ConsoleProgram {
	public void run() {
		test("bla", "blu", false);
		test("abca", "dbcd", true);
		test("pcabb", "pcabb", true);
		test("", "", true);
		test("aa", "aa", true);

	}

	private void test(String text1, String text2, boolean expected) {
		print("same: " + text1 + ", " + text2);
		print(" Expected: " + expected);
		println("  -> " + same(text1, text2));
	}

	//algorithm: for each index i S[i], S[n-i-1], T[i] , T[n-i-1] should be x,x,y,y or x,x,x,x
	private boolean same(String s, String t) {
		int n = s.length();
		for(int i = 0; i < n ; i++) {
			char[] letters = {s.charAt(i), t.charAt(i), s.charAt(n - i - 1), t.charAt(n - i - 1)};
			if(!checkLetters(letters)) {
				return false;
			}
		}
		return true;
	}

	private boolean checkLetters(char[] letters) {
		for (int i = 0; i < letters.length; i++) {
			int cnt = count(letters, letters[i]);
			if (cnt != 2 && cnt != 4) {
				return false;
			}
		}
		return true;
	}


	private int count(char[] letters, char c) {
		int cnt = 0;
		for (int i = 0; i < letters.length; i++) {
			if(letters[i] == c) {
				cnt ++;
			}
		}
		return cnt;
	}

}