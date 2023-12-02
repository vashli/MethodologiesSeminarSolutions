//გრაფიკულ პროგრამაში გაკეთეთ volume slider-ის იმპლემენტაცია.
//slider შედგება 3 ნაწილისგან: bar, handle, text. სადაც bar BAR_SIZE სიგრძის მქონე
//მონაკვეთია, handle HANDLE_RADIUS რადიუსის მქონე შავი წრე, ხოლო text ამ
//სლაიდერის მნიშვნელობის აღმნიშვნელი ტექსტი.
//bar განთავსებული უნდა იყოს კანვასის ცენტრში. handle საწყის მდგომარეობაში
//უნდა იყოს განთავსებული ბარზე როგორც პირველ სურათზეა მოცემული(წრის
//ცენტრი უნდა ემთხვეოდეს მონაკვეთის მარცხენა წერტილს). თავზე უნდა იყოს
//text - წარწერა Volume: და ხმის სიმაღლის ამჟამიდელი მნიშვნელობა
//(თავდაპირველი მნიშვნელობა არის 0 და იზრდება მაქსიმუმ 100-მდე). text უნდა
//იყოს მონაკვეთის მარცხენა წერილისგან TEXT_MARGIN პიქსელით
//ჩრდილოეთით.
//როდესაც handle-ს მაუსით ხელს მოვკიდებთ და გავამოძრავებთ(drag), მან
//მოძრაობა უნდა დაიწყოს x ღერძის გასწვრივ, იმის მიხედვით თუ რომელი
//მიმართულებით ვამოძრავებთ მაუსს. წრის ცენტრი ყოველთვის მონაკვეთზე
//უნდა მდებარეობდეს. handle არ შეიძლება, რომ bar-ს გადაცდეს იმაზე მეტად
//ვიდრე საწყის და საბოლოო სურათებშია მოცემული. handle-ის მოძრაობის
//პარალელურად უნდა იცვლებოდეს ხმის სიმაღლის მნიშვნელობა წარწერაზე
//handle-ის მდებარეობის მიხედვით handle-ის საწყისი მდებარეობიდან
//დაშორების პროპორციულად. ამოხსნა დაწერეთ slider.java კლასში

import java.awt.event.MouseEvent;
import acm.graphics.*;
import acm.program.GraphicsProgram;

public class Midterm2023Session2Slider extends GraphicsProgram {
	private static final double BAR_SIZE = 100;
	private static final double HANDLE_RADIUS = 5;
	private static final double TEXT_MARGIN = 50;

	private GLine bar = null;
	private GOval handle = null;
	private GLabel volumeLabel = null;

	private boolean handleIsActive = false;
	private int prevX = 0;

	public void run() {
		addMouseListeners();
		addSlider();
	}

	private void addSlider() {
		double barX1 = getWidth() / 2 - BAR_SIZE / 2;
		double barX2 = getWidth() / 2 + BAR_SIZE / 2;
		double barY = getHeight() / 2;
		bar = new GLine(barX1, barY, barX2, barY);
		add(bar);

		double handleX = barX1 - HANDLE_RADIUS;
		double handleY = barY - HANDLE_RADIUS;
		handle = new GOval(2 * HANDLE_RADIUS, 2 * HANDLE_RADIUS);
		handle.setFilled(true);
		add(handle, handleX, handleY);

		volumeLabel = new GLabel("Volume: " + 0);
		add(volumeLabel, barX1, barY - TEXT_MARGIN);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject o = getElementAt(e.getX(), e.getY());
		if (o == handle) {
			prevX = e.getX();
			handleIsActive = true;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (handleIsActive) {
			int delta = e.getX() - prevX;
			double newX = handle.getX() + delta;
			double handleMinX = bar.getX() - HANDLE_RADIUS;
			double handleMaxX = bar.getX() + bar.getWidth() - HANDLE_RADIUS;
			if (newX >= handleMinX && newX <= handleMaxX) {
				handle.move(delta, 0);
				prevX = e.getX();
				
				int volume = (int) (100 * (newX - handleMinX) / BAR_SIZE);
				volumeLabel.setLabel("Volume: " + volume);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		handleIsActive = false;
	}
}
