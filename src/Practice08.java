import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

//8. რა არის ალბათობა იმისა, რომ  6 გვერდიანი კამათლის 4-ჯერ გაგორების შედეგად ზედიზედ ამოვა 
//2 ცალი 2-იანი. ამისათვის გააკეთეთ კამათლისა და გაგორებების სიმულაცია. ჩაატარეთ 10000 ცალი 
//ექსპერიმენტი და დათვალეთ ხდომილების ალბათობა. ერთი ექსპერიმენტი არის კამათლის 4-ჯერ გაგორება.
//Tags: RandomGenerator, Simulations/Experiments , Probability, Dice

public class Practice08 extends ConsoleProgram {
	private static final int NUM_EXPERIMENTS = 100000;
	private static final int NUM_ROLLS = 4;
	private static final int NUM_SIDES = 6;
	private static final int RESULT_VALUE = 2;
	private static final int RESULT_QUANTITY = 2;
	private RandomGenerator rgen = RandomGenerator.getInstance();

	public void run() {
		double sumResults = 0; // save expected result in doubles for division purposes
		for (int i = 0; i < NUM_EXPERIMENTS; i++) {
			boolean currResult = experiment();
			if(currResult) {
				sumResults ++;
			}

			// just to print some results
			if (i % (NUM_EXPERIMENTS / 100) == 0)println(i + ": " + currResult);
		}
		double averageResult = sumResults / NUM_EXPERIMENTS;
		println("averageResult: " + averageResult );
	}

	// returns true if we had 2 2s in a row
	private boolean experiment() {
		int resultInARow = 0;
		for(int i = 0; i < NUM_ROLLS; i++){
			int currRoll = rgen.nextInt(1, 6);
			if (currRoll == RESULT_VALUE){
				resultInARow++;
			}else{
				resultInARow = 0;
			}
		}
		return resultInARow >= 2;
	}

}
