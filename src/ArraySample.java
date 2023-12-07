import java.util.Arrays;

import acm.program.ConsoleProgram;

public class ArraySample extends ConsoleProgram{
	public void run() {
		int[] myArr = new int[10];
		
		int[] myArr2 = {0, 5, 6, 7, 8, 9};
		int[] myArr3 = {0, 5, 100, 7, 8, 9};
		
		println(myArr[2]);
		println(myArr2[2]);
		
		myArr2[2] = 100;
		println(myArr2[2]);
		
		println("print with for loop: i, arr[i]");
		for(int i = 0; i < myArr2.length; i++) {
			println("index: " + i + ",value: " + myArr2[i]);
		}
		
		println("print with foreach loop: each element, no index)");
		for(int value: myArr2) {
			println("value: " + value);
		}
		
//		array -> wrapper class Arrays
		println("println(myArr2); // does not work");
		println(myArr2); // does not work
		println("println(Arrays.toString(myArr2)); // works");
		println(Arrays.toString(myArr2)); // works
		
		
		println("== does not work for arrays Arrays.equal does");
		if(myArr2 == myArr3) {
			println("==");
		}
		
		if(Arrays.equals(myArr2, myArr3)) {
			println("Equals");
		}
		
		
		Arrays.fill(myArr3, 7);
		println(Arrays.toString(myArr3));
		
		int[] toSort = {10, 5, 61, 7, 10, -2, 8, 9};
		
		Arrays.sort(toSort);
		println(Arrays.toString(toSort));
		
		
	}
}
