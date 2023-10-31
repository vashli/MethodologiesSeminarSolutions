//35. თქვენი ამოცანაა გააკეთოთ მონეტის აგდების სიმულაციები და დათვალოთ საშუალოდ
//რამდენჯერ უნდა ავაგდოთ მონეტა რათა ამოვიდეს ბორჯღალო

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class Problem35 extends ConsoleProgram{
	private static final int MAX_SIMULATIONS  = 10000;
	private RandomGenerator rgen  = RandomGenerator.getInstance();
	public void run() {
		double sumFlips = 0;
		for(int i = 0; i < MAX_SIMULATIONS; i++) {
			int currNumFlips = simulation();
			sumFlips += currNumFlips;
		}
		
		double avgFlips = sumFlips / MAX_SIMULATIONS;
		
		println("average number of flips: " + avgFlips);
	}
	
	private int simulation() {
		int numFlips = 0;
		while(true) {
			boolean isHeads = rgen.nextBoolean();
			numFlips += 1;
			if(isHeads) {
				break;
			}
		}
		return numFlips;
	}
}
