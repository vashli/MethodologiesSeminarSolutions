import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

//37. რულეტკა, მომხმარებელს შეყავს 0 დან 36 მდე რიცხვი, შემდეგ ხდება 
//რულეტკის დატრიალების სიმულაცია, კონსოლში უნდა დაიბეჭდოს ამოსული 
//რიცხვი და მოიგო თუ არა დადებულმა რიცხვმა

public class Problem37 extends ConsoleProgram{
	private RandomGenerator rgen = RandomGenerator.getInstance();
	public void run(){
		int bet = readInt("Enter number to bet on: ");
		int rouletteResult = rgen.nextInt(36); // simulation
		
		println("Roulette result is " + rouletteResult);
		if(bet == rouletteResult){
			println("You win!");
		}else{
			println("You lose");
		}
		
	}
}
