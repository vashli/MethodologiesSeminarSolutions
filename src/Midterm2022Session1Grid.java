//ვიდეოს ლინკი:
//https://www.youtube.com/watch?v=XC-zYpS7Guo


//ამოცანა 2. (25 ქულა) ცხრილი
//გრაფიკულ პროგრამაში კანვასი დაანაწევრეთ უჯრებად ისე რომ ერთგვარი 8x8-
//ზე ცხრილი შეიქმნას.(როგორც სურათზეა მოცემული)
//თავიდან ყველა უჯრა თეთრია. თითოეულ უჯრაზე მაუსით დაკლიკებისას
//1) თუკი თეთრ უჯრაზე დაეკლიკა მაშინ ეს უჯრა უნდა გაფერადდეს შავად.
//2) თუკი შავ უჯრაზე დაეკლიკა მაშინ ეს უჯრა უნდა გაფერადდეს თეთრად.
//ოღონდ ორზე მეტი შავი უჯრა ერთდოულად არ შეიძლება რომ იყოს. შესაბამისად
//თუკი უკვე 2 უჯრაა გაშავებული და მომხმარებელმა თეთრ უჯრაზე დააკლიკა, ამ
//შემთხვევაში, იმ ორი შავი უჯრიდან რომელიც უფრო ადრე გაშავდა ის უნდა
//გათეთრდეს, ხოლო თეთრი უჯრა რომელზეც მომხმარებელმა დააკლიკა უნდა
//გაშავდეს(შედეგად ისევ 2 შავი უჯრა გვექნება).
//ამოხსნა დაწერეთ grid.java ფაილში
import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Midterm2022Session1Grid extends GraphicsProgram {
	private static final double ROWS = 8;
	private static final double COLUMNS = 8;

	private GRect firstBlack = null;
	private GRect secondBlack = null;

	public void run() {
		drawGrid();
		addMouseListeners();
	}

	private void drawGrid() {
		double length = Math.min(getHeight(), getWidth()) / ROWS;

		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				GRect cell = new GRect(length, length);
				cell.setFilled(true);
				cell.setFillColor(Color.WHITE);
				add(cell, i * length, j * length);
			}
		}
	}

	public void mouseClicked(MouseEvent e) {
		GRect obj = (GRect) getElementAt(e.getX(), e.getY());
		if (obj == null) {
			return;
		}

		if (obj.getFillColor() == Color.WHITE) {
			obj.setFillColor(Color.BLACK);
			if (firstBlack == null) {
				firstBlack = obj;
			} else if (secondBlack == null) {
				secondBlack = obj;
			} else {
				firstBlack.setFillColor(Color.WHITE);
				firstBlack = secondBlack;
				secondBlack = obj;
			}
		} else {
			obj.setFillColor(Color.WHITE);
			if (obj == firstBlack) {
				firstBlack = secondBlack;
			}
			secondBlack = null;
		}
	}
}
