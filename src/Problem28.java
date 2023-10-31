//28. მომხმარებელს შეყავს დადებითი რიცხვები, მანამ სანამ არ შეიყვანს -1 ს, დაბეჭდეთ
//რაოდენობა რამდენი ლუწი რიცხვი შეყვანა მომხმარებელმა.

import acm.program.ConsoleProgram;

public class Problem28 extends ConsoleProgram{
	private static final int SENTINEL = -1;
	public void run() {
//		int n = readInt("Enter n: ");
		int numEvens = 0;
		while (true) { 
			int n = readInt("Enter n: ");
			if (n == SENTINEL) {
				break;
			}
			
			while(n < 0) {
				println("n must be positive");
				n = readInt("Enter n: ");
			}
			
			if(n % 2 == 0) {
				numEvens  += 1;
			}
		}
		println("number of evens is: " + numEvens);
	}
}
