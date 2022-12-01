import java.util.*;
import acm.program.ConsoleProgram;

//55. კონსოლიდან შეგყვავს n და შემდეგ n ცალი მთელი რიცხვი, გაარკვიეთ შეყვანილი რიცხვები
//არის თუ არა ზრდადობით დალაგებული. თუკი არის დაბეჭდეთ “sorted” თუ არა მაშინ
//დაბეჭდეთ “not sorted”

public class Problem55 extends ConsoleProgram {
	public void run() {
		while(true){
			int n = readInt();
			int[] nums = new int[n];
			for(int i = 0; i < nums.length; i++){
				nums[i] = readInt();
			}
			
			println(isSorted(nums));
			println(isSorted2(nums));
		}
		
	}

	// !! sort the numsCopy , not nums
	// do not modify arguments in methods which are not voids
	private boolean isSorted(int[] nums) {
		int[] numsCopy = Arrays.copyOf(nums, nums.length);
		Arrays.sort(numsCopy);
		return Arrays.equals(numsCopy, nums);
	}
	
	private boolean isSorted2(int[] nums) {
		for(int i = 0; i < nums.length - 1; i++){
			 if(nums[i] > nums[i + 1]){
				 return false;
			 }
		}
		return true;
	}
}
