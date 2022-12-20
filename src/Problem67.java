import java.awt.event.ActionEvent;
import javax.swing.*;

import acm.graphics.GImage;
import acm.program.*;

//67. გააკეთეთ ფოტოების აპლიკაცია. აპლიკაციას უნდა ჰქონდეს ტექსფილდი სადაც შეიძლება
//ფოტოს(ფაილის) მისამართის ჩაწერა. ენტერზე დაჭერის შემდეგ ეს ფოტო უნდა გამოჩნდეს
//ფანჯრის ცენტრში.
public class Problem67 extends GraphicsProgram {
	private JTextField urlField;

	public void init() {
		urlField = new JTextField(12);
		add(urlField, SOUTH);
		urlField.addActionListener(this);
	}

	public void run() {

	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == urlField){
			String url = urlField.getText();
			println(url);
			GImage image = new GImage(url);
			add(image, getWidth()/ 2 - image.getWidth() / 2 ,
					getHeight() / 2 - image.getHeight() / 2);
		}
	}
}
