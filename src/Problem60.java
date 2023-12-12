//60. კონსოლიდან შეგვყავს რიცხვები მანამ სანამ არ შეიყვანთ -1-ს, დაბეჭდეთ
//შეყვანილი რიცხვები შებრუნებული მიმდევრობით.

import java.util.ArrayList;

import acm.program.ConsoleProgram;

public class Problem60 extends ConsoleProgram{
	private static final int SENTINEL = -1;
	public void run() {
		version2();
	}
	
	private void version1() {
		ArrayList<Integer> myList = new ArrayList<Integer>();
		while(true) {
			int n = readInt("Enter num: ");
			if(n == SENTINEL) {
				break;
			}
			myList.add(n);
		}
		for(int i = myList.size() - 1; i >= 0; i--) {
			println(myList.get(i));
		}
	}
	
	// fill arrayList in reversed order
	private void version2() {
		ArrayList<Integer> myList = new ArrayList<Integer>();
		while(true) {
			int n = readInt("Enter num: ");
			if(n == SENTINEL) {
				break;
			}
			myList.add(0, n);
		}
		println(myList);
	}

}
