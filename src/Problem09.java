//9. კარელმა უნდა გაამრავლოს ორი რიცხვი, 2x1 უჯრაზე დევს n ცალი ბრილიანტი, 3x1 უჯრაზე
//m ცალი ბრილიანტი, კარელმა 4x1 უჯრაზე უნდა დადოს n * m ბრილიანტი. ჩათვალეთ, რომ
//კარელს ჩანთაში უსასრულო რაოდენობის ბრილიანტი აქვს.

//ალგორითმი
//გვინდა რომ m ბიფერი 3x1 4x1 -ზე გადავიტანოთ n-ჯერ:
//
//სანამ 2x1ზე დევს ბიფერები გავაკეთოთ შემდეგი მოქმედებები:
//	ავიღოთ ერთი ბიფერი, 
//	დავაბექაფოთ მომავლისთვის(2x2ზე). 
//	გადავიდეთ 3x1-ზე 
//	სანამ ბიფერები გვიდევს 3x1-ზე:	
//		ავიღოთ ბიფერი
//		დავაბექაფოთ მომავლისთვის (3x2ზე). 
//		დავდოთ ბიფერი 4x1-ზე
//	დავაბრუნოთ ბიფერები 3x2 დან 3x1ზე
//დავაბრუნოთ ბიფერები 2x2 დან 2x1ზე

import stanford.karel.SuperKarel;

public class Problem09 extends SuperKarel{
	public void run() {
		move();
		while(beepersPresent()) {
			pickBeeper();
			backupBeeper();
			move();
			addSecondPileToDestination();
			moveBack();
		}
		restoreBeepers();
	}

	/*
	 * Karel adds  beepers from second pile to destination position 
	 * Pre: Karel at pos: 2x1, facing east, m beepers at 3x1, k beepers at 4x1
	 * Post: Karel at pos: 2x1, facing east, m beepers at 3x1, k+m beepers at 4x1
	 */
	private void addSecondPileToDestination() {
		while(beepersPresent()) {
			pickBeeper();
			backupBeeper();
			putBeeperOneCellAway();
		}
		restoreBeepers();
	}
	
	/*
	 * Karel moves 1 move backwards
	 * Pre: Karel at pos: ix1, facing east
	 * Post: Karel at pos: i-1x1, facing east
	 */
	private void moveBack() {
		turnAround();
		move();
		turnAround();
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
		moveBack();
		moveBack();
	}

	/*
	 * Karel puts 1 beeper at the next cell in the direction he's facing
	 * Pre: Karel at pos: ixj, facing direction x, k beepers at next cell(e.g. i+1xj)
	 * Post: Karel at pos: ixj, facing direction x, k+1 beepers at next cell(depending on direction Karel was facing)
	 */
	private void putBeeperOneCellAway() {
		move();
		putBeeper();
		moveBack();
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
