import stanford.karel.Karel;
import stanford.karel.SuperKarel;

//9. კარელმა უნდა გაამრავლოს ორი რიცხვი, 2x1 უჯრაზე დევს n ცალი ბრილიანტი, 3x1 უჯრაზე
//m ცალი ბრილიანტი, კარელმა 4x1 უჯრაზე უნდა დადოს n * m ბრილიანტი. ჩათვალეთ, რომ
//კარელს ჩანთაში უსასრულო რაოდენობის ბრილიანტი აქვს.

public class Problem9 extends SuperKarel{
	public void run(){
		multiply();
	}

	private void multiply() {
		move();
		while(beepersPresent()){
			pickBeeper();
			move();
			while(beepersPresent()){
				pickBeeper();
				putOneBeeperToDestination();
				putOneBeeperToBackup();
			}
			returnBackupPile();
			returnToInit();
		}
	}

	private void returnToInit() {
		turnAround();
		move();
		turnAround();
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

	private void putOneBeeperToBackup() {
		turnLeft();
		move();
		putBeeper();
		turnAround();
		move();
		turnLeft();	
	}

	private void putOneBeeperToDestination() {
		move();
		putBeeper();
		turnAround();
		move();
		turnAround();
	}	
}