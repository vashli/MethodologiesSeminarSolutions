import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

//9. მოხმარებელს აქვს საწყისი თანხა 1000, თამაშობს მანამ სანამ არ წააგებს ყველაფერს. 
//ყოველ ჯერზე დებს 10 ლარიან ფსონს 1-იანის ამოსვლაზე. ხდება რულეტკის დატრიალების 
//სიმულაცია(0-დან 36-მდე შემთხვევითი რიცხვი), მოგების შემთხვევაში მოთამაშეს უორმაგედბა 
//დადებული თანხა წაგების შემთხვევაში კი მოთამაშე კარგავს დადებულ თანხას.  
//დათვალეთ საშუალოდ რამდენ სვლაში წააგებს მოთამაშე 1000 ლარს. 
//ამისთვის ჩაატარეთ 2000 ექსპერიმენტი.
//Tags: RandomGenerator, Simulations/Experiments , AverageDuration, Roulette

public class Practice09 extends ConsoleProgram {
	private static final int NUM_EXPERIMENTS = 2000;
	private static final int START_AMOUNT = 1000;
	private static final int BET_AMOUNT = 10;
	private static final int BET_VALUE = 1;
	private static final int MIN_RESULT = 0;
	private static final int MAX_RESULT = 36;
	private RandomGenerator rgen = RandomGenerator.getInstance();

	public void run() {
		double sumResults = 0; // save expected result in doubles for division purposes
		for (int i = 0; i < NUM_EXPERIMENTS; i++) {
			int currResult = experiment();
			sumResults += currResult;

			// just to print some results
			if (i % (NUM_EXPERIMENTS / 100) == 0) println(i + ": " + currResult);
		}
		double averageResult = sumResults / NUM_EXPERIMENTS;
		println("averageResult: " + averageResult );
	}
	
	// returns number of trials before we lose all the money
	private int experiment() {
		int amount = START_AMOUNT;
		int trials = 0;
		while(amount > 0){
			int result = rgen.nextInt(MIN_RESULT, MAX_RESULT);
			boolean won = result == BET_VALUE;
			if(won){
				amount += BET_AMOUNT;
			}else{
				amount -= BET_AMOUNT;
			}
			trials++;
		}
		return trials;
	}
}
