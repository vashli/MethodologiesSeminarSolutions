//7. კარელი დგას 1x1 უჯრაზე, შეავსებინეთ მას მთელი სამყარო თითო ბრილიანტით. ანუ მთელ
//სამყაროში ყველა უჯრაზე უნდა იდოს ზუსტად ერთი ბრილიანტი. ჩათვალეთ რომ საწყისი
//სამყარო ცარიელი არ არის და გარკვეულ(ჩვენთვის უცნობ) უჯრებში თითო(მხოლოდ ერთი)
//ბრილიანტი დევს. ამასთან გაითვალისწინეთ, რომ სამყაროს ზომები თქვენთვის უცნობია და
//თქვენი პროგრამა უნდა მუშაობდეს ნებისმიერი ზომის სამყაროსათვის.

import stanford.karel.Karel;

public class Problem07ZigZag extends Karel{
	public void run() {
		while (notFacingNorth()) { // moveToNextLineIfPossible sets Karel facing north if it can not move
			fillLine();
			moveToNextLineIfPossible();
		}
	}
	
	/*
	 * Karel fills row with beepers
	 * Pre:  Karel is at the first cell of the row, facing east.
	 * Some cells have one beeper on them, some - none
	 * Post: Karel is at the last cell of the row, facing east.
	 * Every cell has one beeper.
	 */
	private void fillLine() {
		while (frontIsClear()) {
			if (noBeepersPresent()) {
				putBeeper();	
			} 
			move();
		}
		if (noBeepersPresent()) {
			putBeeper();
		}
	}

	/*
	 * Moves Karel to the upper cell if next row exists
	 * If not turns Karel towards the north
	 * Pre:  Karel is at the last cell on line n, facing east 
	 * or at the first cell on line n facing west
	 * Post: If next Row does not exist Karel stays on the same cell facing north.
	 * If next row exists,  Karel is at the last cell on line n + 1, facing west 
	 * or at the first cell on line n + 1 facing east
	 */
	private void moveToNextLineIfPossible() {
		// && is logical and operator
		if (facingEast() && leftIsClear()) { // at the end of the row, next row exists   
				turnLeft();
				move();
				turnLeft();
		} else if(facingWest() && rightIsClear()) { // at the beginning of the row, next row exists
			turnRight();
			move();
			turnRight();
		} else { // next row does not exist
			while (notFacingNorth()) {
				turnLeft();
			}
		}
	}
	
	private void turnRight() {
		for (int i = 0; i < 3; i++) {
			turnLeft();
		}
	}
}
