import acm.program.*;

//15. კონსოლიდან წაიკითხეთ ორი მთელი რიცხვი და დაბეჭდეთ მათი საშუალო არითმეტიკული.
public class Problem15 extends ConsoleProgram {

	public void run() {
		int a = readInt("Input first number: ");
		int b = readInt("Input second number: ");
		
		int c = (a + b) / 2;
		
		double d = (double)(a + b) / 2;
//		double d = (a + b) / 2.0; // same as prev line
		
		println("Result as int: " + c);
		println("Result as double: " + d);
	}

}
