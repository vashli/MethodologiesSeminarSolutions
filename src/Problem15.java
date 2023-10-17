import acm.program.ConsoleProgram;

//15. კონსოლიდან წაიკითხეთ ორი მთელი რიცხვი და დაბეჭდეთ მათი საშუალო არითმეტიკული.
public class Problem15 extends ConsoleProgram{
	public void run() {
		
		double d1 = readInt("Enter first number: ");
		double d2 = readInt("Enter second number: ");
		double avgInDoubles = (d1 + d2) / 2;
		println("Average in doubles: " + avgInDoubles);
		
		

		println("see different versions");
		int num1 = readInt("Enter first number: ");
		int num2 = readInt("Enter second number: ");
		
		int avg = (num1 + num2) / 2;
		
		println("Average in ints: " + avg);
		
		double avgInDoubles0 = (num1 + num2) / 2; // does not work
		println("Average in doubles0: " + avgInDoubles0);
		
		double avgInDoubles1 = (num1 + num2) / 2.0;
		println("Average in doubles1: " + avgInDoubles1);
		
		double avgInDoubles2 = (double)(num1 + num2) / 2;
		println("Average in doubles2: " + avgInDoubles2);	
		
	}
}
