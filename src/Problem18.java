import acm.program.*;
import java.math.BigDecimal;
// 18. კონსოლიდან წაიკითხეთ ორი მთელი რიცხვი და დაბეჭდეთ მათ შორის მაქსიმალური.
public class Problem18 extends ConsoleProgram {

	public void run() {
		int a = readInt("Input first number: ");
		int b = readInt("Input second number: ");
		
		standardSolution(a, b);
		solutionWithoutUsingIf(a, b);
	}

	private void standardSolution(int a, int b) {
		if (a > b){
			println(a);
		}else{
			println(b);
		}
	}

	private void solutionWithoutUsingIf(int a, int b) {
//		count absolute difference between a and b
		int absoluteDiff = Math.abs(a - b);
		
//		if a > b => a == max(a, b) && b + absoluteDiff == a ==  max(a, b)
//		if a < b => b == max(a, b) && a + absoluteDiff == b ==  max(a, b)
		int maxNum = (a + b + absoluteDiff) / 2;
		
		println(maxNum);
	}


	
}
