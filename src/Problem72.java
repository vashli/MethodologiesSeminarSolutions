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

import javax.swing.JTextField;

import acm.program.GraphicsProgram;

public class Problem72 extends GraphicsProgram{
	
	private JTextField teachField;
	private School school;
	public void init() {
		school = new School();
		teachField = new JTextField(20);
		add(teachField, SOUTH);
		teachField.addActionListener(this);
//		addActionListeners();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == teachField) {
			addTeacher(teachField.getText());
		}
	}

	private void addTeacher(String text) {
		if(text != null && !text.equals("")) {
			school.addTeacher(text);
		}
		
	}

}
