import acm.graphics.GRect;
import acm.program.ConsoleProgram;

//25. მომხმარებელს შეჰყავს ორი რიცხვი თქვენმა პროგრამამ უნდა დაბეჭდოს ამ ორი რიცხვის
//უმცირესი საერთო ჯერადი.
public class Problem25 extends ConsoleProgram{
	public void run(){
		int a = readInt("Enter a: ");
		int b = readInt("Enter b: ");
		for(int i = 1; i <= a * b; i++){
			if(isCommonMultiple(i, a, b)){
				println(i);
				break;
			}
		}
	}
	private boolean isCommonMultiple(int mult, int a, int b){
//		boolean isAsMultiple = (mult % a == 0);
//		boolean isBsMultiple = (mult % b == 0);
		
//		return isAsMultiple && isBsMultiple;
		
		return (mult % a == 0) && (mult % b == 0);
	}

}
