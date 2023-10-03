//2. კარელი დგას 1x1 უჯრაზე. 5x1 უჯრაზე დევს 10 ცალი ბრილიანტი, კარელმა ათივე
//ბრილიანტი უნდა გადაიტანოს 6x1 უჯრაზე.

import stanford.karel.Karel;

public class Problem02 extends Karel{
	public void run(){
		moveToTheBeeperPile();
		pickTenBeepers();
		move();
		putTenBeepers();
	}

	private void putTenBeepers() {
		for (int i = 0; i < 10; i++) {
			putBeeper();
		}
	}

	private void pickTenBeepers() {
		for (int i = 0; i < 10; i++) {
			pickBeeper();
		}
	}

	private void moveToTheBeeperPile() {
		for (int i = 0; i < 4; i++) {
			move();
		}
	}
}
