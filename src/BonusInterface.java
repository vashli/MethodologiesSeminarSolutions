import java.util.Iterator;

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
