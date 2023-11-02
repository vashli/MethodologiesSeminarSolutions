
//35. თქვენი ამოცანაა გააკეთოთ მონეტის აგდების სიმულაციები და დათვალოთ საშუალოდ
//რამდენჯერ უნდა ავაგდოთ მონეტა რათა ამოვიდეს ბორჯღალო
import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class Problem35 extends ConsoleProgram {
	private static final int NUM_EXPERIMENTS = 1000000;
	private RandomGenerator rgen = RandomGenerator.getInstance();

	public void run() {
		double sumFlips = 0;
		for (int i = 0; i < NUM_EXPERIMENTS; i++) {
			int currFlips = holdExperiment(); // result of 1 experiment
			sumFlips += currFlips;
		}
		double avgFlips = sumFlips / NUM_EXPERIMENTS;
		println("Avg number of flips is: " + avgFlips);
	}

	private int holdExperiment() {
		int numFlips = 0;
		while (true) {
			numFlips++;
			boolean isHeads = rgen.nextBoolean();
			if (isHeads) {
				break;
			}
		}
		return numFlips;
	}
}
