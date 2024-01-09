import java.util.ArrayList;
import java.util.Iterator;

import acm.program.ConsoleProgram;

public class SchoolSubjectConsole extends ConsoleProgram{
	public void run() {
//		SchoolSubject methodologies = new SchoolSubject();
		ArrayList<String> students = new ArrayList<String>();
		students.add("mberi15");
		students.add("aberi10");
		SchoolSubject methodologies = new SchoolSubject(students);
		printIterator(methodologies.getStudents());
		methodologies.addStudent("mberi20");
		
		printIterator(methodologies.getStudents());
		
		methodologies.setGrade("mberi15", 20.0);
		
		methodologies.setGrade("newStudent20", 40.0);
		
		println(methodologies.getGrade("mberi15"));
		println(methodologies.getGrade("newStudent20"));
	}
	
	private void printIterator(Iterator<String> it) {
		if(it == null) {
			println("null");
		}else {
			if(!it.hasNext()) {
				println("empty");
				return;
			}
			while(it.hasNext()) {
				print(it.next() + ", ");
			}
			println();
		}
	}
}
