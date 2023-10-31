//27. მომხმარებელს შეყავს n და m დაბეჭდეთ n^m
import acm.program.ConsoleProgram;

public class Problem27 extends ConsoleProgram{
	public void run() {
		int n = readInt("Enter n: ");
		int m = readPositiveInt("Enter m: "); // we want m to be >= 0
		
		int nPowM = pow(n, m);
		println(n + "^" + m + " = " + nPowM);
	}

	// reads int from console until n is an non negative integer
	private int readPositiveInt(String text) {
		int n = readInt(text);
		while( n < 0) {
			println("Number should non negative");
			n = readInt(text);
		}
		return n;
	}
	private int pow(int n, int m) {
		int res = 1; // res as in result
		for (int i = 0; i < m; i++) {
			res *= n; // res = res * n;
		}
		return res;
	}
}
