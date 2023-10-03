//7. კარელი დგას 1x1 უჯრაზე, შეავსებინეთ მას მთელი სამყარო თითო ბრილიანტით. ანუ მთელ
//სამყაროში ყველა უჯრაზე უნდა იდოს ზუსტად ერთი ბრილიანტი. ჩათვალეთ რომ საწყისი
//სამყარო ცარიელი არ არის და გარკვეულ(ჩვენთვის უცნობ) უჯრებში თითო(მხოლოდ ერთი)
//ბრილიანტი დევს. ამასთან გაითვალისწინეთ, რომ სამყაროს ზომები თქვენთვის უცნობია და
//თქვენი პროგრამა უნდა მუშაობდეს ნებისმიერი ზომის სამყაროსათვის.

import stanford.karel.Karel;

public class Problem07 extends Karel{
	public void run() {
		fillLine();
		while (leftIsClear()) {
			moveToNextLineStart();
			fillLine();
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
	 * Moves Karel to the first cell of the next row
	 * Pre:  Karel is at the last cell on line n, facing east.
	 * Post: Karel is at the first cell on line n + 1, facing east.
	 */
	private void moveToNextLineStart() {
		turnLeft();
		move();
		turnLeft();
		while(frontIsClear()) {
			move();
		}
		turnAround();
	}
	
	private void turnAround() {
		turnLeft();
		turnLeft();
	}
}
