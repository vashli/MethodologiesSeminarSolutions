import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

//38. მოხმარებელს აქვს საწყისი თანხა 1000, თამაშობს მანამ სანამ არ წააგებს ყველაფერს. ყოველ
//ჯერზე შეყავს ფსონის თანხა და რიცხვი რომელზეც დებს. ხდება რულეტკის დატრიალების
//სიმულაცია(0-დან 36-მდე შემთხვევითი რიცხვი), მოგების შემთხვევაში მოთამაშეს
//უორმაგედბა დადებული თანხა წაგების შემთხვევაში კი მოთამაშე კარგავს დადებულ თანხას.
//მოთამაშე მოგებულია მაშინ თუ რულეტკაზე ამოსული რიცხვი ემთხვევა მის მიერ დადებულ
//რიცხვს. პროგრამა ყოველ მოქმედებაზე უნდა ბეჭდავდეს შესაბამის შეტყობინებას, ადვილად
//რომ გაერკვეს მოთამაშე, რა რიცხვი ამოვიდა, რამდენი წააგო, რამდენი მოიგო, რამდენი აქვს
//ბალანსი.

public class Problem38 extends ConsoleProgram{
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
	public void run(){
		int wholeAmount = 1000;
		while(wholeAmount > 0){
			wholeAmount =  playTurn(wholeAmount);
			println("Available amount: " + wholeAmount);
		}
		println("GAME OVER, you lost");
	}

	private int playTurn(int wholeAmount) {
		int betNumber = enterBetNumber();
		int betAmount = enterBetAmount(wholeAmount);
		
		int rouletteResult = rgen.nextInt(36); // simulation
		println("Roulette result is " + rouletteResult);
		
		if(betNumber == rouletteResult){
			wholeAmount += betAmount;
			println("You win this turn!");
		}else{
			wholeAmount -= betAmount;
			println("You lose this turn");
		}
		return wholeAmount;
	}
	
	private int enterBetNumber(){
		int betNumber = readInt("Enter number to bet on: ");
		while (betNumber < 0 || betNumber > 36 ){
			println("Number should be between 0 and 36");
			betNumber = readInt("Enter number to bet on: ");
		}
		return betNumber;
	}
	
	private int enterBetAmount(int wholeAmount){
		int betAmount = readInt("Enter amount of money you want to bet: ");
		while (betAmount > wholeAmount){
			println("You don't have enough money, available amount: " + wholeAmount);
			betAmount = readInt("Enter amount of money you want to bet: ");
		}
		return betAmount;
	}
}
