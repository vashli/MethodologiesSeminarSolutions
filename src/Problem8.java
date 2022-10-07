import stanford.karel.Karel;
import stanford.karel.SuperKarel;

//8. კარელმა უნდა გამოაკლოს ორი რიცხვი, 2x1 უჯრაზე დევს n ცალი ბრილიანტი, 3x1 უჯრაზე
//m ცალი ბრილიანტი, კარელმა 4x1 უჯრაზე უნდა დადოს n-m ბრილიანტი. ჩათვალეთ, რომ
//კარელს ჩანთაში უსასრულო რაოდენობის ბრილიანტი აქვს და ჩათვალეთ, რომ n>=m.

public class Problem8 extends SuperKarel{
	public void run(){
		substract();
	}

	private void substract(){
		for(int i=0; i<2; i++){
			move();
		}
		substractBothPiles();
		moveResultToDestination();
	}
	private void substractBothPiles() {
		while(beepersPresent()){
			pickBeeper();
			turnAround();
			move();
			pickBeeper();
			turnAround();
			move();
		}
	}

	private void moveResultToDestination() {
		turnAround();
		move();
		while(beepersPresent()){
			pickBeeper();
			turnAround();
			move();
			move();
			putBeeper();
			turnAround();
			move();
			move();	
		}
	}
}