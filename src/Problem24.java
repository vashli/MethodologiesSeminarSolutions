import acm.graphics.GRect;
import acm.program.ConsoleProgram;

public class Problem24 extends ConsoleProgram {
	public void run() {
		int n = readInt("Enter n: ");
		println("number of divisors is " + getNumberOfDivisors(n));
		println("Second version:");
		println("number of divisors is  " + getNumberOfDivisorsOpt(n));
	}


	private boolean isDivisible(int n, int i) {
		return n % i == 0;
	}

	private int getNumberOfDivisors(int n) {
		int numberOfDivisors = 0;

		for (int i = 1; i < n + 1; i++) {
			if (isDivisible(n, i)) {
				numberOfDivisors += 1;
			}
		}
		return numberOfDivisors;
	}
	

	private int getNumberOfDivisorsOpt(int n) {
		int numberOfDivisors = 0;

		int sqrt = (int)Math.sqrt(n);
		
		for (int i = 1; i <= sqrt; i++) {
			if (isDivisible(n, i)) {
				if (i == sqrt && i*i == n){
					numberOfDivisors += 1;
				}else{
					numberOfDivisors += 2;
				}
			}
		}
		return numberOfDivisors;
	}
}
