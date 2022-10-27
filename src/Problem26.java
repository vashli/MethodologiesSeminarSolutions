import acm.program.ConsoleProgram;
//26. მომხმარებელს შეჰყავს ორი რიცხვი თქვენმა პროგრამამ უნდა დაბეჭდოს ამ ორი რიცხვის
//უდიდესი საერთო გამყოფი
public class Problem26 extends ConsoleProgram{
	
	public void run(){
		int a = readInt("Enter first number: ");
		int b = readInt("Enter second number: ");

		// its better to start with i = Math.min(a,b), but this works as well
		for(int i = a; i >= 1; i--){
			if(isCommonDivisor(a, b, i)){
				println(i);
				break;
			}
		}
	}

	private boolean isCommonDivisor(int num1, int b, int i) {
		boolean isDivisorOfA = num1 % i == 0;
		boolean isDivisorOfB = b % i == 0;
		
		return isDivisorOfA && isDivisorOfB;
	}
}
