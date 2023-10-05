//6. კარელმა უნდა შეკრიბოს ორი რიცხვი, 2x1 უჯრაზე დევს n ცალი ბრილიანტი, 3x1 უჯრაზე m
//ცალი ბრილიანტი, კარელმა 4x1 უჯრაზე უნდა დადოს n+m ბრილიანტი. ჩათვალეთ, რომ
//კარელს ჩანთაში უსასრულო რაოდენობის ბრილიანტი აქვს.
import stanford.karel.SuperKarel;

public class Problem06 extends SuperKarel{
	
	/*
	 * Karel moves n beepers from 2x1 to 4x1 and makes backup 
	 * pile of n beepers at 2x2, same for m beepers.
	 * After that karel moves n beepers back from 2x2 to 2x1
	 * and m beepers from 3x2 to 3x1
	 */
	public void run() {
		move();
		moveFirstPileToDestinationAndBackup();
		move();
		moveSecondPileToDestinationAndBackup();
		restoreBeepers(); // for the second pile
		turnAround();
		move();
		turnAround();
		restoreBeepers(); // for the first pile
	}

	/*
	 * Karel moves all beepers from first pile to destination position and backup position
	 * Pre: Karel at pos: 2x1, facing east, n beepers at 2x1, 0 beepers at 2x2, 0 beepers at 4x1
	 * Post: Karel at pos: 2x1, facing east,  0 beepers at 2x1, n beepers at 2x2, n beepers at 4x1
	 */
	private void moveFirstPileToDestinationAndBackup() {
		while(beepersPresent()) {
			pickBeeper();
			putBeeperTwoCellsAway();
			backupBeeper();
		}
	}
 
	/*
	 * Karel moves all beepers from second pile to destination position and backup position
	 * Pre: Karel at pos: 2x1, facing east, m beepers at 3x1, 0 beepers at 3x2, n beepers at 4x1
	 * Post: Karel at pos: 2x1, facing east, 0 beepers at 3x1, m beepers at 3x2, n+m beepers at 4x1
	 */
	private void moveSecondPileToDestinationAndBackup() {
		while(beepersPresent()) {
			pickBeeper();
			putBeeperOneCellAway();
			backupBeeper();
		}
	}
	
	/*
	 * Karel moves 1 beeper from main position to the backup position
	 * Pre: Karel at pos: ix1, facing east, k beepers at ix1, p beepers at ix2
	 * Post: Karel at pos: ix1, facing east, k-1 beepers at ix1, p+1 beepers at ix2
	 */
	private void backupBeeper() {
		turnLeft();
		move();
		putBeeper();
		turnAround();
		move();
		turnLeft();
	}
	
	/*
	 * Karel puts 1 beeper at the cell which is two cells away in the direction he's facing
	 * Pre: Karel at pos: ixj, facing direction x, k beepers at cell which is two cells away (e.g. i+2xj)
	 * Post: Karel at pos: ixj, facing direction x, k+1 beepers at next cell(depending on direction Karel was facing)
	 */
	private void putBeeperTwoCellsAway() {
		move();
		move();
		putBeeper();
		turnAround();
		move();
		move();
		turnAround();
	}

	/*
	 * Karel puts 1 beeper at the next cell in the direction he's facing
	 * Pre: Karel at pos: ixj, facing direction x, k beepers at next cell(e.g. i+1xj)
	 * Post: Karel at pos: ixj, facing direction x, k+1 beepers at next cell(depending on direction Karel was facing)
	 */
	private void putBeeperOneCellAway() {
		move();
		putBeeper();
		turnAround();
		move();
		turnAround();
	}

	/*
	 * Karel moves all beepers from backup position to the main position
	 * Pre: Karel at pos: ix1, facing east, 0 beepers at ix1, k beepers at ix2
	 * Post: Karel at pos: ix1, facing east, k beepers at ix1, 0 beepers at ix2
	 */
	private void restoreBeepers() {
		turnLeft();
		move();
		turnAround();
		while(beepersPresent()) {
			pickBeeper();
			putBeeperOneCellAway();
		}
		move();
		turnLeft();
	}
}
