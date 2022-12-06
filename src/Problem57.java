import java.util.Arrays;

import acm.program.ConsoleProgram;

//57. დაწერეთ მეთოდი, რომელსაც გადაეცემა ორი სტრინგი და აბრუნებს true-ს თუკი ეს ორის
//სტრინგი ერთმანეთის ანაგრამაა, ხოლო წინააღმდე შემთხვევაში აბრუნებს false-ს. ჩათვალეთ,
//რომ ორივე სტრინგი მხოლოდ ლათინური ალფავიტის პატარა ასოებისგან შედგება.
//იმპლემენტაცია გააკეთეთ მასივების გამოყენებით შემდეგი ალგორითმით: თითოეული
//სიტყვისთვის დათვალეთ თითოეული სიმბოლოს რაოდენობა(‘a’-‘z’) და შეინახეთ მასივში.
//შემდეგ შეადარეთ ერთმანეთს მასივები.

public class Problem57 extends ConsoleProgram {
	public void run(){
		String s1 = readLine();
		String s2 = readLine();
		
		println(areAnagrams(s1, s2));
	}

	private boolean areAnagrams(String s1, String s2) {
		int[] arr1 = createCountArr(s1);
		int[] arr2 = createCountArr(s2);
		
		println(Arrays.toString(arr1));
		println(Arrays.toString(arr2));
		
		return(Arrays.equals(arr1, arr2));
	}

	//aabbccc
	private int[] createCountArr(String s) {
		int [] counts = new int [26];
		Arrays.fill(counts, 0); // not needed, default value for int - 0
		
		for(int i = 0; i < s.length(); i++){
//			'a' - 'a' = 0
//			'b' - 'a' = 1
			int countIndex = s.charAt(i) - 'a';
			counts[countIndex] ++;
		}
		
		return counts;
	}

	
}
