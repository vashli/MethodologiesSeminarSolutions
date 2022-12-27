import java.util.Iterator;

//მოსწავლე აკეთებს guess-ს და ირჩევს მთელი რიცხვს 0-
//დან 100-მდე შუალედში(0-ის და 100-ის ჩათვლით). winningNumber არის ყველა მოსწავლის მიერ არჩეული რიცხვების საშუალო
//არითმეტიკული გავამრავლებული 2/3-ზე და აღებული მთელი ნაწილი.
//winners არიან მოსწავლეები, რომელთა guessიც იყო winningNumber-ის ტოლი.

public interface BonusInterface {

	/*
	 * Adds guess for student with freeuni email prefix : studentPrefix
	 */
	public void addGuess(int guess, String studentPrefix);

	/*
	 * returns winning number - CEIL(x * 2 / 3 ) where x is average of all
	 * student guesses
	 */

	public int getWinningNumber();

	/* returns iterator to email prefixes of all winners */
	public Iterator<String> getWinners();

}
