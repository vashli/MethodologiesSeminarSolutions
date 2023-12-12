//57. დაწერეთ მეთოდი, რომელსაც გადაეცემა ორი სტრინგი და აბრუნებს true-ს თუკი 
//ეს ორი სტრინგი ერთმანეთის ანაგრამაა, ხოლო წინააღმდე შემთხვევაში აბრუნებს false-ს. ჩათვალეთ,
//რომ ორივე სტრინგი მხოლოდ ლათინური ალფავიტის პატარა ასოებისგან შედგება.
//იმპლემენტაცია გააკეთეთ მასივების გამოყენებით შემდეგი ალგორითმით: თითოეული
//სიტყვისთვის დათვალეთ თითოეული სიმბოლოს რაოდენობა(‘a’-‘z’) და შეინახეთ მასივში.
//შემდეგ შეადარეთ ერთმანეთს მასივები.

import java.util.Arrays;

import acm.program.ConsoleProgram;

public class Problem57 extends ConsoleProgram {
	public void run() {
		String str1 = "mariam";
		String str2 = "maaiam";
		println(areAnagrams(str1, str2));
	}

	private boolean areAnagrams(String str1, String str2) {
		if(str1.equals(str2)) {
			return false;
		}
		int[] counts1 = getCountArray(str1);
		int[] counts2 = getCountArray(str2);
		
		println("counts for debug");
		println(Arrays.toString(counts1));
		println(Arrays.toString(counts2));
		
		return Arrays.equals(counts1, counts2);
	}
	
	private int[] getCountArray(String s) {
		int[] counts = new int[26];
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			int index = ch - 'a';
			counts[index]++;
		}
		return counts;
	}
}
