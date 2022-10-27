import acm.program.ConsoleProgram;
//28. მომხმარებელს შეყავს დადებითი რიცხვები, მანამ სანამ არ შეიყვანს -1 ს, დაბეჭდეთ
//რაოდენობა რამდენი ლუწი რიცხვი შეყვანა მომხმარებელმა.
public class Problem28 extends ConsoleProgram{
	public void run(){
		int numberOfEvenNumbers = 0;
		int a = readInt("Enter number: ");
	
		while(a != -1){  // !(a == -1)
			if(a % 2 == 0){ // if a is even
				numberOfEvenNumbers++;
			}
			a = readInt("Enter number: ");
		}
		println(numberOfEvenNumbers);
	}
}
