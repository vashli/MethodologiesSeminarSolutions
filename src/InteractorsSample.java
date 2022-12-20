/*
 * File: FindRange.java
 * --------------------
 * This program is a stub for the FindRange problem, which finds the
 * smallest and largest values in a list of integers.
 */

//15. კონსოლიდან წაიკითხეთ ორი მთელი რიცხვი და დაბეჭდეთ მათი საშუალო არითმეტიკული.

import java.awt.event.ActionEvent;
import javax.swing.*;

import acm.graphics.*;
import acm.program.*;

public class InteractorsSample extends GraphicsProgram {
	private JButton redButton;
	private JTextField textField;
	private JRadioButton smallButton;
	private JRadioButton largeButton;
	
	public void init() { 
		JComboBox colorChooser = new JComboBox();
		colorChooser.addItem("White");
		colorChooser.addItem("Red");
		colorChooser.addItem("blue");
		add(colorChooser, SOUTH);

		JCheckBox fillCheckBox = new JCheckBox("Filled");
		// star.setFilled(fillCheckBox.isSelected());
		add(fillCheckBox, NORTH);

		redButton = new JButton("Red");
		add(redButton, SOUTH);
		
		smallButton = new JRadioButton("Small");
		largeButton = new JRadioButton("Large");
		ButtonGroup gr = new  ButtonGroup();
		gr.add(smallButton);
		gr.add(largeButton);
		add(smallButton, WEST);
		add(largeButton, WEST);
		
//		add(gr,WEST); // does not work
		
		JSlider sizeSlider = new JSlider(0, 100, 30);
		add(new JLabel(" Small"), SOUTH);
		add(sizeSlider, SOUTH);
		add(new JLabel("Large"), SOUTH);
		
		
		
		
		textField = new JTextField(20);
		add(textField, SOUTH);
		textField.addActionListener(this);
		addActionListeners();
	}

	public void run() {

	}

	public void actionPerformed(ActionEvent e) {
//		if (e.getActionCommand().equals("Red")) {
//			println("Please do not press this button again.");
//		}
		
		if(e.getSource() == redButton){
			println("Please do not press this button again.");
		}
		
		if (e.getSource() == textField) {
			String txt = textField.getText();
			println(txt);
		}
	}
}
