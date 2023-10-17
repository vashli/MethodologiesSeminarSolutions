import java.math.BigDecimal;

import acm.program.ConsoleProgram;

//17. კონსოლიდან წაიკითხეთ ნამდვილი რიცხვი და დაბეჭდეთ მისი მთელი ნაწილი და მისი
//წილადი ნაწილი. მაგალითად მომხმარებელმა თუ შეიყვანა 3.14 თქვენმა პროგრამამ უნდა
//დაბეჭდოს 3 და 0.14

public class Problem17 extends ConsoleProgram{
	public void run() {
		calculateInDouble(); 
		calculateInBigDecimal();
	}
	
	private void calculateInBigDecimal() {
		double a = readDouble("Enter real number: ");
		String aAsString = "" + a;
		BigDecimal decimal = new BigDecimal(aAsString);
		
		int integerPart = decimal.intValue();
		BigDecimal franctionPart = decimal.remainder(BigDecimal.ONE);
		
		println("Integer part: " + integerPart);
		println("Franction part (as BigDecimal): " + franctionPart);
	}

	private void calculateInDouble() {
		double a = readDouble("Enter real number: ");
		int integerPart = (int)a;
		double franctionPart = a - integerPart;
		
		println("Integer part: " + integerPart);
		println("Franction part (as double): " + franctionPart);
	}
}
