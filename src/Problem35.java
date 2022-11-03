import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

//35. თქვენი ამოცანაა გააკეთოთ მონეტის აგდების სიმულაციები და დათვალოთ საშუალოდ
//რამდენჯერ უნდა ავაგდოთ მონეტა რათა ამოვიდეს ბორჯღალო
public class Problem35 extends ConsoleProgram{
	private RandomGenerator rgen = RandomGenerator.getInstance();
	public void run(){
		int maxTrials = 1000000;
		
		int sumOfSimulations = 0;
		for(int i = 0; i < maxTrials; i++){
			int currNumSimulations = numberOfSimulationsForHeads();
			sumOfSimulations += currNumSimulations; // sumOfSimulations = sumOfSimulations + currNumSimulations;
		}
		
		double avgSimulations = (double)sumOfSimulations / maxTrials;
		println(avgSimulations);
		
	}
	
	private int numberOfSimulationsForHeads(){
		boolean isHeads = false;
		int numberOfSimulations = 0;
		
		while(!isHeads){ // isHeads != true // isHeads == false
			isHeads = rgen.nextBoolean();
			numberOfSimulations++;
		}
		return numberOfSimulations;
	}
}
