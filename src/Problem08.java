//8. კარელმა უნდა გამოაკლოს ორი რიცხვი, 2x1 უჯრაზე დევს n ცალი ბრილიანტი, 3x1 უჯრაზე
//m ცალი ბრილიანტი, კარელმა 4x1 უჯრაზე უნდა დადოს n-m ბრილიანტი. ჩათვალეთ, რომ
//კარელს ჩანთაში უსასრულო რაოდენობის ბრილიანტი აქვს და ჩათვალეთ, რომ n>=m.
import stanford.karel.SuperKarel;

public class Problem08 extends SuperKarel{
	/*
	 * Karel moves m beepers both from 2x1 and 3x1 to backup piles(at 2x2, 3x2)
	 * n-m beepers remain at 2x1. We move them to 4x1.  
	 * After that we start restoring. We move backup piles(each with m beepers) to 2x1 and 3x1. 
	 * Then we add n-m beepers which are at 4x1 to the pile at position 2x1 to restore the starting amount. 
	 */
	public void run() {
		move();
		move();
		while(beepersPresent()) {
			substractOneBeeperFromBothPiles();
		}
		turnAround();
		move();
		turnAround();
		moveResultToDestination();
		
		restoreBeepers(); // for the second pile
		move();
		restoreBeepers(); // for the first pile
		move();
		addResultToFirstPile(); // to restore the starting amount
	}

	/*
	 * Karel moves 1 beeper from each pile to backup positions
	 * Pre: Karel at pos: 3x1, facing east, 
	 * k1 beepers at 3x1, k2 beepers at 2x1, p1 beepers at 3x2, p2 beepers at 2x2
	 * Post: Karel at pos: 3x1, facing east, 
	 * k1-1 beepers at 3x1, k2-1 beepers at 2x1, p1+1 beepers at 3x2, p2+1 beepers at 2x2
	 */
	private void substractOneBeeperFromBothPiles() {
		pickBeeper();
		backupBeeper();
		turnAround();
		move();
		turnAround();
		pickBeeper();
		backupBeeper();
		move();
	}

	/*
	 * Karel moves all beepers from first pile position to the destination position to update result
	 * Pre: Karel at pos: 2x1, facing east, k beepers at 2x1, 0 beepers at 4x1
	 * Post: Karel at pos: 2x1, facing east, 0 beepers at 2x1, k beepers at 4x1
	 */
	private void moveResultToDestination() {
		while(beepersPresent()) {
			pickBeeper();
			putBeeperTwoCellsAway();
		}
	}
	
	/*
	 * Karel moves copies of all beepers from destination position to the first pile position 
	 * to restore the starting amount
	 * Pre: Karel at pos: 4x1, facing east, k beepers at 4x1, p beepers at 2x1
	 * Post: Karel at pos: 4x1, facing east, k beepers at 4x1, p+k beepers at 2x1
	 */
	private void addResultToFirstPile() {
		while(beepersPresent()) {
			pickBeeper();
			backupBeeper();
			turnAround();
			putBeeperTwoCellsAway();
			turnAround();
		}
		restoreBeepers();
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
