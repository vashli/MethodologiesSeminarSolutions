import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.*;
import acm.graphics.GLabel;
import acm.program.*;

//68. თქვენი ამოცანაა გრაფიკული პროგრამის საშუალებით გააკეთოთ ჩატი. ფანჯარაზე, SOUTH
//რეგიონზე უნდა გქონდეთ ერთი ტექსტფილდი და ერთი ღილაკი ტექტით Enter.
//ტექსტფილდში ტექსტის შეყვანის მერე Enter ჭილაკზე დაჭერით ტექსტი უნდა
//იწერებოდეს(იხატებოდეს) კანვასზე ხოლო ტექსტფილდში კი ტექსტი იშლებოდეს. ხელახლა
//ტექსტის შეყვანისას ახალი ტექსტი წინა ტექსტის ქვემოთ უნდა გამოცნდეს(როგორც ჩატში
//ხდება ხოლმე. თუკი ტექსტი ჩაცდება ეკრანს არაუშავს.

//69. 68 ამოცანის გაგრძელება. დაამატეთ სქროლი. თუკი ტექსტი ჩაცდება ეკრანს მაშინ ახალი
//ტექსტი მაინც უნდა გამოჩნდეს ეკრანის ბოლოში, შესაბამისად სულ პირველად შეყვანილი
//ტექსტი გაქრება ეკრანიდან. 

public class Problem68 extends GraphicsProgram {
	private JTextField msgField;
	private JButton enterButton;
	private double y = 20;
	private ArrayList<GLabel> msgList;
	private static final int DISTANCE = 50;

	public void init() {
		msgField = new JTextField(12);
		add(msgField, SOUTH);

		enterButton = new JButton("ENTER");
		add(enterButton, SOUTH);
		msgField.addActionListener(this);
		
		// enterButton.addActionListener(this);
		addActionListeners();

		msgList = new ArrayList<GLabel>();
	}


	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == enterButton ||
				e.getSource() == msgField) {
			addMessage();
		}
	}

	private void addMessage() {
		String msgText = msgField.getText();
		msgField.setText(null);
		if(msgText.equals("")){
			return;
		}
		
		GLabel label = new GLabel(msgText);
		if (y + label.getAscent() > getHeight()) {
			shiftMsgs();
			y -= DISTANCE;
		}

		add(label, 20, y);
		msgList.add(label);
		y += DISTANCE;
	}

	private void shiftMsgs() {
		for (GLabel msgLabel : msgList) {
			msgLabel.setLocation(msgLabel.getX(), msgLabel.getY() - DISTANCE);
		}
	}
}
