//16. კონსოლიდან წაიკითხეთ სამი მთელი რიცხვი და დაბეჭდეთ მათი საშუალო ჰარმონიული.
// შეგახსენებთ, რომ სამი რიცხვის საშუალო ჰარმონიულის გამოთვლის ფორმულა არის 
// 1 / (1/a + 1/b + 1/c)

import acm.program.*;

public class Problem16 extends ConsoleProgram {

	public void run() {
		// version with doubles
		countHarmDouble();
		// version with ints
		countHarmInt();
	}

	private void countHarmDouble() {
		// three different options for saving ints into doubles
		double a = readDouble("Input first number: ");
		double b = (double)readInt("Input second number: ");
		double c = readInt("Input third number: ");

		double d = 1 / (1 / a + 1 / b + 1 / c);
		println("Result: " + d);
		
		////	!! useful note
		//	int x = 4;
		//	double a1 = x; // works even without cast
		//	int a2 = (int)a1; // does not work without cast
	}

//	test on input 2 2 2
	private void countHarmInt() {
		int a = readInt("Input first number: ");
		int b = readInt("Input second number: ");
		int c = readInt("Input third number: ");
		
////		!! uncomment to see error
////		1 / 0 (int / int) ---> error
//		double d1 = 1 / (1 / a + 1 / b + 1 / c);
//		println("Result: " + d1);

		
//		1.0 / 0 (double / int)	 -> double.Infinity
		double d2 = (double)1 / (1 / a + 1 / b + 1 / c);
		println("Result infinity: " + d2);
		
//		(int / (1 / double + 1 / int + 1 / int) -> incorrect answer
		double d3 = 1 / (1 / (double) a + 1 / b + 1 / c);
		println("Result incorrect: " + d3);
		
//		(int / (1 / double + 1 / double + 1 / double) -> correct answer
		double d4 = 1 / (1 / (double) a + 1 / (double) b + 1 / (double) c);
		println("Result: " + d4);
	}

}