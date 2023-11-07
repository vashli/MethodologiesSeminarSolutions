//39. დაწერეთ პროგრამა სადაც იქნება კანვასზე ბურთის მოძრაობა მარცხენა კედლის შუა
//წერტილიდან მარჯვენა კედლამდე.
//40. წინა ამოცანის გაგრძელება, დაამატეთ ვერტიკალური კედლებიდან ასხლეტვა. ანუ ბურთი
//მოძრაობს მარცხენა კედლიდან მარჯვნივ. როგორც კი მარჯვენა კედელს დაეტაკება იმავე
//სიჩქარით უნდა გააგრძელოს მოძრაობა მაჯვენა კედლიდან მარცხნივ. როგორც კი მარცხენა
//კედელს დაეტაკება უნდა გააგრძელოს მარჯვნივ და ა.შ. უსასრულოდ.
import acm.graphics.*;
import acm.program.GraphicsProgram;

public class Problem39_40 extends GraphicsProgram {
	private static final int PAUSE_MS = 5;
	private static final int VEL_X = 3;
	private static final int RADIUS = 20;

	public void run() {
		GOval circle = createInitialCircle();
		int vx = VEL_X;
		int vy = 0;

		while (true) {
			if ((circle.getX() + 2 * RADIUS >= getWidth()) || (circle.getX() < 0)) {
				vx = -vx;
			}
			circle.move(vx, vy);
			pause(PAUSE_MS);
		}
		
////		for problem 39
//		while (circle.getX() + 2 * RADIUS < getWidth()) {
//			circle.move(vx, vy);
//			pause(PAUSE_MS);
//		}
	}

	private GOval createInitialCircle() {
		GOval circle = new GOval(2 * RADIUS, 2 * RADIUS);
		circle.setFilled(true);
		double x = 0;
		double y = getHeight() / 2 - RADIUS;
		add(circle, x, y);
		return circle;
	}

}
