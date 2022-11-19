import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

//7.გაქვს 20 ლარი და თამაშობ მონეტის აგდებას, ყოველ ჯერზე დებს გერბზე 2 ლარს, 
//წაგების შემთხვევაში კარგავს ამ 2 ლარს, ხოლო მოგების შემთხვევაში იბრუნებს დადებულ ფსონს 
//და დამატებით 1 ლარს იგებს.  საშუალოდ რა თანხა გექნება 100 აგდების შემდეგ
//(თუ თანხა გაგითავდა, ვთქვთ მე–20 აგდებაზე შენი ექსპერიმენტი რჩება და 21-ედ ვეღარ ააგდებ. 
//ასეთი ექსპერიმენტი შედეგებში ჩვეულებრივ უნდა გაითვალისწინო)  ? საშუალოს გამოსათვლელად 
//ჩაატარეთ 100 ჯერ(ან ნაკლებჯერ, თუ გაკოტრდი) აგდების ექსპერიმენტი 10000 ჯერ. 
//Tags: RandomGenerator, Simulations/Experiments , AverageResult, Coin

public class Practice07 extends ConsoleProgram {
	private static final int START_AMOUNT = 20;
	private static final int BET_AMOUNT = 2;
	private static final int WINNIG_AMOUNT = 1;
	private static final int NUM_EXPERIMENTS = 10000;
	
	private RandomGenerator rgen = RandomGenerator.getInstance();

	public void run() {
		double sumResults = 0; // save expected result in doubles for division purposes
		for (int i = 0; i < NUM_EXPERIMENTS; i++) {
			int currResult = experiment();
			sumResults += currResult;

			// just to print some results
			if (i % (NUM_EXPERIMENTS / 100) == 0)println(i + ": " + currResult);
		}
		double averageResult = sumResults / NUM_EXPERIMENTS;
		println("averageResult: " + averageResult );
	}

	private int experiment() {
		int amount = START_AMOUNT;
		int maxFlips = 100;
		for (int i = 0; i < maxFlips; i++) {
			if (amount < BET_AMOUNT) {
				break;
			}
			boolean won = rgen.nextBoolean();
			if (won) {
				amount += WINNIG_AMOUNT;
			} else {
				amount -= BET_AMOUNT;
			}
		}

		return amount;
	}

}
