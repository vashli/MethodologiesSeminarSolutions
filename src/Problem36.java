import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

//36. თქვენი ამოცანაა გააკეთოთ მონეტის აგდების სიმულაციები და 
//დათვალოთ საშუალოდ რამდენჯერ უნდა ავაგდოთ მონეტა რათა 3-ჯერ ზედიზედ ამოვიდეს ბორჯღალო.

public class Problem36 extends ConsoleProgram{
	private RandomGenerator rgen = RandomGenerator.getInstance();
	public void run(){
		int maxTrials = 1000000;
		
		int sumOfSimulations = 0;
		for(int i = 0; i < maxTrials; i++){
			int currNumSimulations = numberOfSimulationsForTheeHeads();
			sumOfSimulations += currNumSimulations; // sumOfSimulations = sumOfSimulations + currNumSimulations;
		}
		
		double avgSimulations = (double)sumOfSimulations / maxTrials;
		println(avgSimulations);
		
	}
	
	private int numberOfSimulationsForTheeHeads(){
		boolean isHeads = false;
		int numberOfSimulations = 0;
		int numberOfHeads = 0;
				
		while(numberOfHeads != 3){ 
			isHeads = rgen.nextBoolean();
			numberOfSimulations++;
			
			if(isHeads){
				numberOfHeads++;
			}else{
				numberOfHeads = 0;
			}
		}
		return numberOfSimulations;
	}
}
