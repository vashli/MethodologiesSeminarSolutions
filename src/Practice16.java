import acm.program.ConsoleProgram;

//16. მოხმარებელს შეყავს მთელი რიცხვი n, a, q, პროგრამამ უნდა დაბეჭდოს 
//გეომეტრიული პროგრესიის პირველი n ცალი წევრი.  
//a არის გეომეტრიული პროგრესიის პირველი წევრი, ხოლო q გეომეტიული მნიშვნელი.
//Tags: Math, Sequence

public class Practice16 extends ConsoleProgram {
	public void run() {
		while (true) {
			int n = readInt("Enter n: ");
			int a = readInt("Enter a: ");
			int q = readInt("Enter q: ");
			printGeomProg(n, a, q);
		}
	}

	private void printGeomProg(int n, int a, int q) {
		int prev = a;
		for(int i = 0; i < n; i++){
			println(prev);
			prev *= q;
		}
	}
}
