import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

//მოსწავლე აკეთებს guess-ს და ირჩევს მთელი რიცხვს 0-დან 100-მდე შუალედში(0-ის და 100-ის ჩათვლით).
//winningNumber არის ყველა მოსწავლის მიერ არჩეული რიცხვების საშუალო
//არითმეტიკული გავამრავლებული 2/3-ზე და აღებული მთელი ნაწილი.
//winners არიან მოსწავლეები, რომელთა guess-იც იყო winningNumber-ის ტოლი.

public class MidtermBonus implements BonusInterface{
	private HashMap<String, Integer> guesses;
	
	public MidtermBonus(){
		System.out.println("constructor called");
		guesses = new HashMap<String, Integer>();
	}

	@Override
	public void addGuess(int guess, String studentPrefix) {
		guesses.put(studentPrefix, guess);
	}
	

	@Override
	public int getWinningNumber() {
		int result = 0;
		for(String prefix: guesses.keySet()){
			int guess = guesses.get(prefix);
			result += guess;
		}
		result = (int)((double)result / guesses.size() * 2 / 3 );
		return result;
	}

	@Override
	public Iterator<String> getWinners() {
		ArrayList<String> winners = new ArrayList<String>();
		int result = getWinningNumber();
		for(String prefix: guesses.keySet()){
			int guess = guesses.get(prefix);
			if(result == guess){
				winners.add(prefix);
			}
		}
		return winners.iterator();
	}

}
