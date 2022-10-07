import stanford.karel.Karel;
import stanford.karel.SuperKarel;

//10. კარელმა უნდა გაყოს ორი რიცხვი, 2x1 უჯრაზე დევს n ცალი ბრილიანტი, 3x1 უჯრაზე m
//ცალი ბრილიანტი, კარელმა 4x1 უჯრაზე უნდა დადოს n / m ბრილიანტი. ჩათვალეთ, რომ n
//ზუსტად იყოფა m-ზე და კარელს ჩანთაში უსასრულო რაოდენობის ბრილიანტი აქვს.

public class Problem10 extends SuperKarel{
	public void run(){
		divide();
	}

	private void divide() {
		move();
		while(beepersPresent()){
			doSubstraction();
			addOneToResult();
		}
	}

	private void addOneToResult() {
		move();
		putBeeper();
		turnAround();
		move();
		move();
		turnAround();
	}

	private void doSubstraction() {
		move();
		while(beepersPresent()){
			pickBeeper();
			substractOneFromNPile();
			backupOneBeeper();
		}
		returnBackupPile();
	}

	private void returnBackupPile() {
		turnLeft();
		move();
		while(beepersPresent()){
			pickBeeper();
			turnAround();
			move();
			putBeeper();
			turnAround();
			move();
		}
		turnAround();
		move();
		turnLeft();
	}

	private void backupOneBeeper() {
		turnLeft();
		move();
		putBeeper();
		turnAround();
		move();
		turnLeft();
	}

	private void substractOneFromNPile() {
		turnAround();
		move();
		pickBeeper();
		turnAround();
		move();
	}
}
