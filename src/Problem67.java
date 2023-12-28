import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import acm.graphics.*;
import acm.program.GraphicsProgram;
//67. გააკეთეთ ფოტოების აპლიკაცია. აპლიკაციას უნდა ჰქონდეს ტექსფილდი სადაც შეიძლება
//ფოტოს(ფაილის) მისამართის ჩაწერა. ენტერზე დაჭერის შემდეგ ეს ფოტო უნდა გამოჩნდეს
//ფანჯრის ცენტრში.
public class Problem67 extends GraphicsProgram{
	private JTextField textField;
	
	// სემინარზე რანში გვქონდა თავიდან დამატებული და უცნაურად იმიტომ გაიხსნა.
	public void init() {
		textField = new JTextField(20);
		add(textField, SOUTH);
		
		textField.addActionListener(this);
		addActionListeners();
		
		GImage image = new GImage("bad path");
		double x = getWidth()/ 2 - image.getWidth() / 2;
		double y = getHeight()/ 2 - image.getHeight() / 2;
		add(image, x, y);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == textField) {
			try {
				GImage image = new GImage(textField.getText());
				double x = getWidth()/ 2 - image.getWidth() / 2;
				double y = getHeight()/ 2 - image.getHeight() / 2;
				add(image, x, y);
			} catch(Exception ex) {
				removeAll();
				add(new GLabel("Error occured"), 20, 20);
			}
			textField.setText("");
		}
	}
}
