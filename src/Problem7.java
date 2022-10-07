import stanford.karel.SuperKarel;

//7. კარელი დგას 1x1 უჯრაზე, შეავსებინეთ მას მთელი სამყარო თითო ბრილიანტით. ანუ მთელ
//სამყაროში ყველა უჯრაზე უნდა იდოს ზუსტად ერთი ბრილიანტი. ჩათვალეთ რომ საწყისი
//სამყარო ცარიელი არ არის და გარკვეულ(ჩვენთვის უცნობ) უჯრებში თითო(მხოლოდ ერთი)
//ბრილიანტი დევს. ამასთან გაითვალისწინეთ, რომ სამყაროს ზომები თქვენთვის უცნობია და
//თქვენი პროგრამა უნდა მუშაობდეს ნებისმიერი ზომის სამყაროსათვის.

public class Problem7 extends SuperKarel {
	
	
	public void run() {
		turnLeft();
		while(facingNorth()){
			fixStartPosition();
			fillRow();
			moveToNextRowIfPossible();
		}	
	}

	/*
	 * pre: karel is at one of the ends of a street, pos:(x,y)
	 * facing east or west
	 * post: if there was another street to move to
	 * karel is at pos:(x,y+1), facing north 
	 * if not, karel is at pos:(x,y) facing south
	 */
	private void moveToNextRowIfPossible() {
		if(facingEast()){
			turnLeft();
		}else{
			turnRight();
		}
		if(frontIsClear()){
			move();
		}else{
			turnAround();
		}
	}

	/*
	 * pre: karel is at one of the ends of a street, 
	 * facing towards the row east or west. 
	 * There are beepers at random places on the street.
	 * post: karel is at the opposite end of the street,
	 * facing towards the wall east or west.
	 * There are beepers at every cell on the street.
	 */
	private void fillRow() {
		while(frontIsClear()){
			if(noBeepersPresent()){
				putBeeper();
			}
			move();	
		}
		//for the last cell
		if(noBeepersPresent()){
			putBeeper();
		}
	}

	/*
	 * pre: karel facing north
	 * post: facing towards the row, 
	 * east or west depending on karel's starting position
	 */
	private void fixStartPosition() {
		turnLeft();
		if(frontIsBlocked()){
			turnAround();
		}
	}
	
}