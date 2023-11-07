//38. მოხმარებელს აქვს საწყისი თანხა 1000, თამაშობს მანამ სანამ არ წააგებს ყველაფერს. ყოველ
//ჯერზე შეყავს ფსონის თანხა და რიცხვი რომელზეც დებს. ხდება რულეტკის დატრიალების
//სიმულაცია(0-დან 36-მდე შემთხვევითი რიცხვი), მოგების შემთხვევაში მოთამაშეს
//უორმაგედბა დადებული თანხა წაგების შემთხვევაში კი მოთამაშე კარგავს დადებულ თანხას.
//მოთამაშე მოგებულია მაშინ თუ რულეტკაზე ამოსული რიცხვი ემთხვევა მის მიერ დადებულ
//რიცხვს. პროგრამა ყოველ მოქმედებაზე უნდა ბეჭდავდეს შესაბამის შეტყობინებას, ადვილად
//რომ გაერკვეს მოთამაშე, რა რიცხვი ამოვიდა, რამდენი წააგო, რამდენი მოიგო, რამდენი აქვს
//ბალანსი.
import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class Problem38 extends ConsoleProgram{
	private static final int MIN_VALUE = 0;
	private static final int MAX_VALUE = 36;
	private static final int INITIAL_AMOUNT = 1000;
	private RandomGenerator rgen = RandomGenerator.getInstance();
	public void run() {
		int remainingAmount = INITIAL_AMOUNT;
		
		while(remainingAmount > 0) {
			int betNumber = readBetNumber();
			int betAmount = readBetAmount(remainingAmount);
			int rouletteResult = spinRoulette();
			if(betNumber == rouletteResult) {
				remainingAmount += betAmount;
				println("You won this turn!");
			}else {
				remainingAmount -= betAmount;
				println("You lost this turn!");
			}
			println("Remaining amount: " + remainingAmount);
		}
		println("GAME OVER, you lost.");
		
	}

	private int readBetAmount(int remainingAmount) {
		while(true) {
			int betAmount = readInt("Enter bet Amount(should be <= " + remainingAmount + "): ");
			if(betAmount <= remainingAmount) {
				return betAmount;
			}
		}
	}

	private int readBetNumber() {
		while(true) {
			int betNum = readInt("Enter bet number from " + MIN_VALUE + " to " + MAX_VALUE + ": ");
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
