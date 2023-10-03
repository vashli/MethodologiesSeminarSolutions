//5. კარელი დგას 1x1 უჯრაზე, შეავსებინეთ მას პირველი ქუჩა ბრილიანტებით. ანუ პირველი
//ქუჩის ყველა უჯრაზე უნდა იდოს ზუსტად ერთი ბრილიანტი. ჩათვალეთ რომ საწყისი
//სამყარო ცარიელი არ არის და გარკვეულ(ჩვენთვის უცნობ) უჯრებში თითო(მხოლოდ ერთი)
//ბრილიანტი დევს.

import stanford.karel.Karel;

public class Problem05 extends Karel{
	
	public void run() {
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
}
