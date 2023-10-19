//20. კონსოლიდან წაიკითხეთ n, შემდეგ წაიკითხეთ n ცალი მთელი რიცხვი და დაბეჭდეთ ჯამი

import acm.program.ConsoleProgram;

public class Problem20 extends ConsoleProgram{
	public void run() {
		int n = readInt("Enter n: ");
		int sum = 0;
		for (int i = 0; i < n; i++) {
			int num = readInt("Enter number #" + i + ": ");
			sum += num; // sum = sum + num;
		}
		println("Sum: " + sum);
	}
}
