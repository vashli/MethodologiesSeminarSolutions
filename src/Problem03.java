//3. კარელი დგას 1x1 უჯრაზე, გაიყვანეთ იგი პირველი ქუჩის ბოლომდე. გაითვალისწინეთ, რომ
//სამყაროს ზომა არ იცით. თქვენი პროგრამა უნდა მუშაობდეს ნებისმიერი ზომის
//სამყაროსათვის.

import stanford.karel.Karel;

public class Problem03 extends Karel{
	
	public void run() {
		while (frontIsClear()) {
			move();
		}
	}
}
