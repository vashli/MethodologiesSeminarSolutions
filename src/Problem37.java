//37. რულეტკა, მომხმარებელს შეყავს 0 დან 36 მდე რიცხვი, შემდეგ ხდება რულეტკის
//დატრიალების სიმულაცია, კონსოლში უნდა დაიბეჭდოს ამოსული რიცხვი და მოიგო თუ არა
//დადებულმა რიცხვმა

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class Problem37 extends ConsoleProgram{
	private static final int MIN_VALUE = 0;
	private static final int MAX_VALUE = 36;
	private RandomGenerator rgen = RandomGenerator.getInstance();
	public void run() {
		int betNumber = readBetNumber();
		int rouletteResult = spinRoulette();
		if(betNumber == rouletteResult) {
			println("You won!");
		}else {
			println("You lost!");
		}
	}

	private int readBetNumber() {
		while(true) {
			int betNum = readInt("Enter number from " + MIN_VALUE + " to " + MAX_VALUE + ": ");
			if(betNum >= MIN_VALUE && betNum <= MAX_VALUE) {
				return betNum;
			}
		}
	}
	
	private int spinRoulette() {
		int rouletteResult = rgen.nextInt(MIN_VALUE, MAX_VALUE);
		println("Roulette result is: " + rouletteResult);
		return rouletteResult;
	}
}
