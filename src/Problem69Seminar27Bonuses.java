import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.*;

import acm.graphics.*;
import acm.program.GraphicsProgram;
//68. თქვენი ამოცანაა გრაფიკული პროგრამის საშუალებით გააკეთოთ ჩატი. ფანჯარაზე, SOUTH
//რეგიონზე უნდა გქონდეთ ერთი ტექსტფილდი და ერთი ღილაკი ტექტით Enter.
//ტექსტფილდში ტექსტის შეყვანის მერე Enter ჭილაკზე დაჭერით ტექსტი უნდა
//იწერებოდეს(იხატებოდეს) კანვასზე ხოლო ტექსტფილდში კი ტექსტი იშლებოდეს. ხელახლა
//ტექსტის შეყვანისას ახალი ტექსტი წინა ტექსტის ქვემოთ უნდა გამოცნდეს(როგორც ჩატში
//ხდება ხოლმე. თუკი ტექსტი ჩაცდება ეკრანს არაუშავს.
//69. 68 ამოცანის გაგრძელება. დაამატეთ სქროლი. თუკი ტექსტი ჩაცდება ეკრანს მაშინ ახალი
//ტექსტი მაინც უნდა გამოჩნდეს ეკრანის ბოლოში, შესაბამისად სულ პირველად შეყვანილი
//ტექსტი გაქრება ეკრანიდან. 
public class Problem69Seminar27Bonuses extends GraphicsProgram {
	private static final int DISTANCE = 40;
	private JTextArea textArea;
	private JButton button;
	private double x = DISTANCE;
	private double y = DISTANCE;
	private GCompound messages;
	private double prevY;
	public void init() {
		textArea = new JTextArea(5, 20);
		textArea.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane( textArea );
		add(scrollPane, SOUTH);
		
		button = new JButton("Enter");
		add(button, SOUTH);
		
		
		messages = new GCompound();
		add(messages);
		addActionListeners();
		addMouseListeners();
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		println("here");
		if(e.getSource() == textArea || e.getSource() == button) {
			String text = textArea.getText();
			println(text);
			displayMessage(text);
			textArea.setText("");
		}
	}
	
	private void displayMessage(String text) {
		if(text == null || text.equals("")) {
			return;
		}
		GMessage message = new GMessage(text);
		messages.add(message, x, y);
		y += message.getHeight() + DISTANCE;
		
		fixPositionAtLastMessage();
	}



	private void fixPositionAtLastMessage() {
		if(messages.getHeight() + DISTANCE > getHeight()) {
			double newY = getMinY(); //getHeight() - messages.getHeight() - DISTANCE;
			messages.setLocation(messages.getX(), newY);
		}
		
	}
	
	private double getMinY() {
		return getHeight() - messages.getHeight() - DISTANCE;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		prevY = e.getY();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(messages.getHeight() + DISTANCE <= getHeight()) {
			return;
		}
		messages.move(0, e.getY() - prevY);
		prevY = e.getY();
		
		double minY = getMinY();
		double maxY = 0;
		if (messages.getY() < minY) {
			messages.setLocation(messages.getX(), minY);
		}else if(messages.getY() > maxY) {
			messages.setLocation(messages.getX(), maxY);
		}
	}
	
}
