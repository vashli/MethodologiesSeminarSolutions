//72. სკოლის გრაფიკა (2018 წლის გამოცდის ამოცანა)
//ჩათვალეთ რომ წინა ამოცანაში აღწერილი School კლასი უკვე არსებობს და შეგიძლიათ
//გამოყენება. დაწერეთ გრაფიკული პროგრამა რომელიც მოგვცემს საშუალებას დავამატოთ
//სკოლის შესახებ მონაცემები და შემდეგ გავფილტროთ. სურათზე ნაჩვენებია თუ როგორ უნდა
//გამოიყურებოდეს გრაფიკული პროგრამა:
//1. Add Teach ღილაკზე დაჭერით სკოლას უნდა დაემატოს Teach ველში
//შეყვანილი სახელის მქონე მასწავლებელი
//2. Add Subj ღიალაკზე დაჭერით Teach ველში შეყვანილი სახელის მქონე
//მასწავლებელს უნდა დაემატოს Subj ველში შეყვანილი სახელის მქონე საგანი
//3. Add Pupil ღილაკზე დაჭერით Subj ველში შეყვანილ საგანს უნდა დაემატოს
//Pupil ველში შეყვანილი სახელის მქონე სტუდენტი
//4. Display Pupils ღილაკზე დაჭერის შემდეგ, პროგრამამ უნდა გაასუფთაოს ეკრანი
//და გამოიტანოს ყველა ისეთი მოსწავლის სახელი, რომელსაც ასწავლის Teach
//ველში შეყვანილი სახელის მქონე მასწავლებელი
//5. Display Teachers ღილაკზე დაჭერით, პროგრამამ უნდა გაასუფთაოს ეკრანი და
//გამოიტანოს ყველა ისეთი მასწავლებლის სახელი, რომლებიც ასწავლიან Pupil
//ველში შეყვანილი სახელის მქონე მოსწავლეს.
//თითოეულ ღილაკზე დაჭერის შემდეგ, ტექსტური ველების მნიშვნელობები უნდა
//გასუფთავდეს. Result სათაური უნდა დაიხატოს, (RESULT_X, LINE_H) წერტილში,
//ხოლო გაფილტრვის შედეგები იგივე ვერტიკალში ერთმანეთისგან LINE_H-ით
//დაშორებით. კოდი დაწერეთ SchoolGraphics.java ფაილში.

import java.awt.event.ActionEvent;
import java.util.Iterator;

import javax.swing.*;

import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

public class Problem72 extends GraphicsProgram{
//	RESULT_X, LINE_H)
	private static final int RESULT_X = 20;
	private static final int LINE_H = 20;
	
	private JTextField teachField;
	private JTextField subjField;
	private JTextField pupField;
	
	private JButton teachButton;
	private JButton subjButton;
	private JButton pupButton;
	private JButton displayPup;
	private JButton displayTeach;
	
	private School school;
	
	
	public void init() {
		this.resize(1000, 500);
		school = new School();
		teachField = new JTextField(10);
		addFieldWithText("Teach: ", teachField);
		
		subjField = new JTextField(10);
		addFieldWithText("Subj:", subjField);
		
		
		pupField = new JTextField(10);
		addFieldWithText("Pup:", pupField);
		

		teachButton = new JButton("Add Teach");
		add(teachButton, SOUTH);

		subjButton = new JButton("Add Subj");
		add(subjButton, SOUTH);

		pupButton = new JButton("Add Pup");
		add(pupButton, SOUTH);

		displayPup = new JButton("Display Pup");
		add(displayPup, SOUTH);

		displayTeach = new JButton("Display Teach");
		add(displayTeach, SOUTH);
		
	
		
		addActionListeners();
	}
	
	private void addFieldWithText(String text, JTextField textField) {
		JLabel label = new JLabel(text);
		add(label, SOUTH);
		add(textField, SOUTH);
		textField.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == teachField || e.getSource() == teachButton) {
			addTeacher(teachField.getText());
		}else if(e.getSource() == subjButton) {
			addSubject(teachField.getText(), subjField.getText());
		}else if(e.getSource() == pupButton) {
			addPupil(subjField.getText(), pupField.getText());
		}else if(e.getSource() == displayTeach) {
			displayTeachers(pupField.getText());
		}else if(e.getSource() == displayPup) {
			displayPupils(teachField.getText());
		}
		
		
		clearFields();
	}

	private void displayPupils(String teacher) {
		if(teacher == null || teacher.equals("")){
			return;
		}
		Iterator<String> pupils =  school.getPupils(teacher);
		displayIteratorElems(pupils);
	}

	private void displayTeachers(String pupil) {
		if(pupil == null || pupil.equals("")){
			return;
		}
		Iterator<String> teachers =  school.getTeachers(pupil);
		displayIteratorElems(teachers);
	}

	private void displayIteratorElems(Iterator<String> it) {
		removeAll();
		int x = RESULT_X;
		int y = LINE_H;
		add(new GLabel("Results: "), x, y);
		if(it == null) {
			return;
		}
		while(it.hasNext()) {
			y += LINE_H;
			String elem = it.next();
			GLabel label = new GLabel(elem);
			add(label, x, y);
		}
	}

	private void addPupil(String subject, String pupil) {
		if(pupil != null && !pupil.equals("") && subject != null && !subject.equals("")) {
			school.addPupil(pupil, subject);
		}
	}

	private void addTeacher(String text) {
		if(text != null && !text.equals("")) {
			school.addTeacher(text);
		}	
	}
	
	private void addSubject(String teacher, String subject) {
		if(teacher != null && !teacher.equals("") && subject != null && !subject.equals("")) {
			school.addSubject(teacher, subject);
		}
	}

	private void clearFields() {
		teachField.setText("");
		subjField.setText("");
		pupField.setText("");
		
	}

	

}
