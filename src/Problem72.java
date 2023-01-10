import java.awt.event.ActionEvent;
import java.util.Iterator;
import javax.swing.*;
import acm.graphics.GLabel;
import acm.program.GraphicsProgram;


public class Problem72 extends GraphicsProgram{
	private JTextField teachField;
	private JTextField pupField;
	private JTextField subjField;
	
	private School school;
	private static final String ADD_TEACH = "Add teach";
	private static final String ADD_SUBJ = "Add subj";
	private static final String ADD_PUPIL = "Add pup";
	private static final String DISPLAY_TEACH = "Display teach";
	private static final String DISPLAY_PUPILS = "Display pupils";
	private static final double RESULT_X = 20;
	private static final double START_Y = 20;
	private static final double LINE_H = 20;
	public void init(){
		this.resize(1200, 500);
		
		teachField = new JTextField(10);
		pupField = new JTextField(10);
		subjField = new JTextField(10);
		
		addField("Teach:", teachField);
		addField("Subj:", subjField);
		addField("Pupil:", pupField);
		
		add(new JButton(ADD_TEACH), SOUTH);
		add(new JButton(ADD_SUBJ), SOUTH);
		add(new JButton(ADD_PUPIL), SOUTH);
		add(new JButton(DISPLAY_TEACH), SOUTH);
		add(new JButton(DISPLAY_PUPILS), SOUTH);
		
		school = new School();
		addActionListeners();
	}

	private void addField(String name, JTextField field) {
		add(new JLabel(name), SOUTH);
		add(field, SOUTH);
	}
	
	public void actionPerformed(ActionEvent e){

		if(e.getActionCommand().equals(ADD_TEACH)){
			addTeacher();
		}else if(e.getActionCommand().equals(ADD_SUBJ)){
			addSubject();
		}else if(e.getActionCommand().equals(ADD_PUPIL)){
			addPupil();
		}else if(e.getActionCommand().equals(DISPLAY_TEACH)){
			displayTeachers();
		}else if(e.getActionCommand().equals(DISPLAY_PUPILS)){
			displayPupils();
		}
		
		clearFields();
		// for debugging
		println(e.getActionCommand() + "---------------");
		school.showAll();
	}

	private void clearFields() {
		teachField.setText("");
		pupField.setText("");
		subjField.setText("");
	}

	private void displayPupils() {
		String teacher = teachField.getText();
		if(teacher.equals("")) return;
		Iterator<String> pupils = school.getPupils(teacher);
		displayList(pupils);
	}

	private void displayList(Iterator<String> pupils) {
		removeAll();
		double y = START_Y;
		while(pupils.hasNext()){
			String pupil = pupils.next();
			add(new GLabel(pupil),RESULT_X, y);
			y += LINE_H;
		}
	}

	private void displayTeachers() {
		String pupil = pupField.getText();
		if(pupil.equals("")) return;
		Iterator<String> teachers = school.getTeachers(pupil);
		displayList(teachers);
	}

	private void addPupil() {
		String subject = subjField.getText();
		String pupil = pupField.getText();
		if(subject.equals("") || pupil.equals("")){
			return;
		}
		school.addPupil(pupil, subject);
	}

	private void addSubject() {
		String subject = subjField.getText();
		String teacher = teachField.getText();
		if(subject.equals("") || teacher.equals("")){
			return;
		}
		school.addSubject(teacher, subject);
	}

	private void addTeacher() {
		String teacher = teachField.getText();
		if(teacher.equals("")) return;
		school.addTeacher(teacher);
	}
}
