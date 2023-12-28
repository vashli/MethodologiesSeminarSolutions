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
//1. (დაწერილი უნდა გქონდეთ ამოცანა 68, 69). დაწერეთ კლასი GMessage რომელიც აექსთენდებს GCompound-ს. 
//კონსტრუქტორს არგუმენტად უნდა გადაეცემოდეს ტექსტი. თქვენს კლასში უნდა გქონდეთ მეთოდი, რომელიც ამ ტექსტს 
//ხლეჩს ხაზებად თუ საჭიროა(რაღაც კონსტანტა შეგიძლიათ გქონდეთ, ან სიმბოლოების მაქსიმალური რაოდენობა ხაზში  
//		ან მაქსიმალური width პიქსელებში). თქვენს მესიჯს უნდა ჰქონდეს გაფერადებული ბექგრაუნდი, 
//რომელზეც თქვენი ტექსტი ხაზებად გამოჩნდება. მას შემდეგ, რაც კლასის დაწერას მორჩებით, ამოცანა 69-ში GLabel 
//ობიექტები ჩაანაცვლეთ GMessage ობიექტებით.  (თუ არ იცით როგორ დაწეროთ კლასი, რომელიც GCompound-ს აექსთენდებს, 
//		მაგალითი ნახეთ წიგნში გვ. 330 FIGURE 9-19  - Class GFace)
//
//2. (დაწერილი უნდა გქონდეთ ამოცანა 68, 69) თქვენს ჩათში ტექსტის ჩასაწერად JTextField-ის მაგივრად გამოიყენეთ JTextArea. 
//textArea-ს ზომები არ უნდა იცვლებოდეს ტექსტის ჩაწერისას. თუ დიდ ტექსტს დავწერთ უნდა ჩნდებოდეს სქროლი
//(ხელით არ წერთ სქროლის ფუნქციონალს, დაგუგლეთ როგორ კეთდება)

public class Problem69 extends GraphicsProgram {
	private static final int DISTANCE = 40;
	private JTextField textField;
	private JButton button;
	private double x = DISTANCE;
	private double y = DISTANCE;
	private GCompound messages;
	private double prevY;
	public void init() {
		textField = new JTextField(20);
		add(textField, SOUTH);
		
		textField.addActionListener(this);

		
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
		if(e.getSource() == textField || e.getSource() == button) {
			String text = textField.getText();
			println(text);
			displayMessage(text);
			textField.setText("");
		}
	}
	
	private void displayMessage(String text) {
		if(text == null || text.equals("")) {
			return;
		}
		GLabel message = new GLabel(text);
		messages.add(message, x, y);
		y += DISTANCE;
		
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
