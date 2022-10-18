import acm.program.*;
import java.math.BigDecimal;

//17. კონსოლიდან წაიკითხეთ ნამდვილი რიცხვი და დაბეჭდეთ მისი მთელი ნაწილი და მისი
//წილადი ნაწილი. მაგალითად მომხმარებელმა თუ შეიყვანა 3.14 თქვენმა პროგრამამ უნდა
//დაბეჭდოს 3 და 0.14
public class Problem17 extends ConsoleProgram {

	public void run() {
		// standard solution
		solveWithDouble();
		// solution for fixing floating point precision
		solveWithBigDecimal();
	}

	private void solveWithDouble() {
		double a = readDouble("Input number: ");

		int exponent = (int) a;
		double fraction = a - exponent;

		println("exponent: " + exponent);
		println("fraction: " + fraction);
	}

	private void solveWithBigDecimal() {
		double a = readDouble("Input number: ");
		
		int exponent = (int) a;
		
		BigDecimal decimal = new BigDecimal("" + a); // argument as String
		BigDecimal fractionDec = decimal.subtract(new BigDecimal("" + exponent));

		println("exponent: " + exponent);
		println("fraction as BigDecimal: " + fractionDec);
	}

}
