import acm.graphics.GRect;
import acm.program.ConsoleProgram;

//23. მომხმარებელს შეყავს მთელი რიცხვი n, 
//პროგრამამ უნდა დაბეჭდოს 1 დან n მდე რიცხვების ჯამი
public class Problem23 extends ConsoleProgram{
	public void run(){
		int n = readInt("enter n: ");
		int sum = getSumN(n);
		println(sum);
	}

	private int getSumN(int num) {
//		int n = 6;
		int sum = 0;
		
		for (int i = 1; i < num + 1; i++){
			sum += i;
		}
		
		return sum;
	}
	
}
