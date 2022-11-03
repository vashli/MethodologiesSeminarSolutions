import acm.graphics.*;
import acm.program.GraphicsProgram;

//40. დაწერეთ პროგრამა სადაც იქნება კანვასზე ბურთის მოძრაობა მარცხენა კედლის 
//შუა წერტილიდან მარჯვენა კედლამდე.
//დაამატეთ ვერტიკალური კედლებიდან ასხლეტვა. ანუ ბურთი
//მოძრაობს მარცხენა კედლიდან მარჯვნივ. როგორც კი მარჯვენა კედელს დაეტაკება იმავე
//სიჩქარით უნდა გააგრძელოს მოძრაობა მაჯვენა კედლიდან მარცხნივ. როგორც კი მარცხენა
//კედელს დაეტაკება უნდა გააგრძელოს მარჯვნივ და ა.შ. უსასრულოდ.

public class Problem40 extends GraphicsProgram{
	public void run(){
		int radius = 20;
		GOval circle = new GOval( 2 * radius , 2 * radius);
		circle.setFilled(true);
		add(circle, 0, getHeight() / 2 - radius);
		
		int velocity = 5;
		while(true){
			circle.move(velocity, 0);
			pause(1);
			
			if(circle.getX() >= getWidth() - 2 * radius || circle.getX() <= 0){
				velocity = -velocity;
			}
		}
		
	}
}
