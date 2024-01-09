import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// same as ProgrammingMethodologiesClass from seminar group 2
public class SchoolSubject {
	private Map<String, Double> studentGrades;

	public SchoolSubject() {
		System.out.println("constructor 1"); // for test
		studentGrades = new HashMap<>();
	}

	public SchoolSubject(ArrayList<String> students) {
		System.out.println("constructor 2"); // for test
		studentGrades = new HashMap<>();
		for (String student : students) {
			addStudent(student);
		}

//		for (int i = 0; i < students.size(); i++) {
//			String student = students.get(i);
//			addStudent(student);
//		}
	}

	public void addStudent(String student) {
		if (!studentGrades.containsKey(student)) {
			studentGrades.put(student, null);
		}
		System.out.println(studentGrades); // for test
	}

	public Iterator<String> getStudents() {
		return studentGrades.keySet().iterator();
	}

	public void setGrade(String student, Double grade) {
		if (studentGrades.containsKey(student)) {
			studentGrades.put(student, grade);
		}
		System.out.println(studentGrades); // for test
	}

	public Double getGrade(String student) {
		if (!studentGrades.containsKey(student)) {
			System.out.println("No such student: " + student); // for test
		}
		return studentGrades.get(student);
	}
}
