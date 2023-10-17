import acm.program.ConsoleProgram;

//18. კონსოლიდან წაიკითხეთ ორი მთელი რიცხვი და დაბეჭდეთ მათ შორის მაქსიმალური.
public class Problem18 extends ConsoleProgram{
	public void run() {
		int a = readInt("Enter first number: ");
		int b = readInt("Enter second number: ");
		
		
		if (a > b) {
			println("max using if: " + a);
		} else {
			println("max using if: " + b);
		}
		
		println("max using Math.max: " + Math.max(a, b));
	}
}
