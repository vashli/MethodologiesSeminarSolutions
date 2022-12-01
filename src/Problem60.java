import acm.program.ConsoleProgram;
import java.util.*;

//60. კონსოლიდან შეგვყავს რიცხვები მანამ სანამ არ შეიყვანთ -1-ს, დაბეჭდეთ შეყვანილი
//რიცხვები შებრუნებული მიმდევრობით

public class Problem60 extends ConsoleProgram {
	private static final int SENTINEL = -1;
	public void run() {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		while(true){
			int n = readInt();
			if(n == SENTINEL){
				break;
			}
			nums.add(n);
		}
		printReversed(nums);
	}

	private void printReversed(ArrayList<Integer> nums) {
		for(int i = nums.size() - 1; i >= 0; i--){
			println(nums.get(i));
		}
		
//		როცა ინდექსი არ გვაინტერესებს და მარტო ელემენტებზე გადაყოლა გვინდა, ეს სინტაქსი შეგვიძლია გამოვიყენოთ
//		for(Integer el  : nums){
//			println(el);
//		}
	}
}
