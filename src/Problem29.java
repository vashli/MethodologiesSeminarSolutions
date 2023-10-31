//29. მოხმარებელს შეყავს მთელი რიცხვი n, პროგრამამ უნდა დაბეჭდოს ფიბონაჩის მიმდევრობის
//მე n წევრი.

import acm.program.ConsoleProgram;

public class Problem29 extends ConsoleProgram {

	public void run() {
		while(true) {
			int n = readInt("enter n: ");
			
			int fibN = fib(n);
			println(fibN);
		}
	}

	
//	indices: 0 1 2 3 4 5 6
//	values:  0 1 1 2 3 5 8
	private int fib(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		
		int prev2 = 0;
		int prev1 = 1;
		
//		loop
		int curr = -1;
		for (int i = 2; i <= n; i++) {
			curr = prev2 + prev1;
			prev2 = prev1;
			prev1 = curr;
		}
		
		return curr;
	}
}