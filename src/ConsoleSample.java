import acm.program.ConsoleProgram;

public class ConsoleSample extends ConsoleProgram{
	public void run() {
		int kids  = readInt("Enter number of your kids: ");
		println("Number of your kids: " + kids);
		
		boolean isAlive = readBoolean("Is alive? ");
		println(isAlive);

//		number as a String
		String num1 = readLine("Enter number as string: ");
		println(num1);

		String num2 = readLine("Enter  number as string: ");
		println(num2);
		
		println(num1 + num2);
		println(num1 + num2 + 7 + 3 );
		println(num1 + num2 + (7 + 3));


//		average in ints
		int firstNum = readInt("Enter first number: " );
		int secondNum = readInt("Enter second number: " );
		
		int avg = (firstNum + secondNum) / 2;
		println(avg);
	}

}
