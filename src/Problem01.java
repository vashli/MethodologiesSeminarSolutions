import stanford.karel.Karel;

public class Problem01 extends Karel{
//	1. კარელი დგას 1x1 უჯრაზე. 3x1 უჯრაზე დევს ბრილიანტი, კარელმა ბრილიანტი უნდა
//	გადაიტანოს 4x1 უჯრაზე და დაამთავროს მუშაობა.

	public void run(){
		move();
		move();
		pickBeeper();
		move();
		putBeeper();
	}

}
