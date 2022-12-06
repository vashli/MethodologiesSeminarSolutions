import java.util.ArrayList;
import java.util.Arrays;

import acm.program.ConsoleProgram;

//61. კონსოლიდან შეგვყავს რიცხვი m და n, შემდეგ n ცალი რიცხვი. პროგრამამ უნდა იპოვოს
//შეყვანილი რიცხვებიდან წყვილი რომელთა ჯამი არის m.

// 1 2 3 // 6
public class Problem61 extends ConsoleProgram {
	public void run() {
		int m = readInt("enter m: ");
		int n = readInt("enter n: ");
		println("enter n numbers");

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = readInt();
		}

		int[] twoNums = getNumsSumM(arr, m);
		if (twoNums[0] == 1 && twoNums[1] == m) {
			println("not found");
		} else {
			println(Arrays.toString(twoNums));
			// println(twoNums); // does not work
		}

		// second version
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			arrList.add(arr[i]);
		}

	}

	// returns a, b values from arr, so that a + b = m
	// if a, b pair does not exist, returns 1, m
	private int[] getNumsSumM(int[] arr, int m) {
		int[] result = { 1, m };

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == m) {
					result[0] = arr[i];
					result[1] = arr[j];
					return result;
				}
			}
		}

		return result;
	}

	// second version
	// returns a, b values from arr, so that a + b = m
	// if a, b pair does not exist, returns 1, m
	private int[] getNumsSumM1(ArrayList<Integer> arrList, int m) {
		int[] result = { 1, m };

		for (int i = 0; i < arrList.size(); i++) {
			int numToFind = m - arrList.get(i);
			// numToFind exists in our list starting from index (i + 1_
			if (arrList.subList(i + 1, arrList.size()).indexOf(numToFind) > 0) {
				result[0] = arrList.get(i);
				result[1] = numToFind;
				return result;
			}
		}

		return result;
	}

}
