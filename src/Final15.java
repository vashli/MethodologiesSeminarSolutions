import java.util.HashMap;

import acm.program.ConsoleProgram;

//გაქვთ HashMap<String, String>  studentTeachers, სადაც ვინახავთ მოსწავლე -> მასწავლებლის წყვილებს. 
//ყველა მოსწავლეს ერთი მასწავლებელი ჰყავს, ბევრ მოსწავლეს შეიძლება იგივე მასწავლებელი ჰყავდეს.
//დაწერეთ boolean მეთოდი  validateTeachers, რომელსაც გადაეცემა ეს მეპი და ამოწმებს რომ 
//არც ერთი მოსწავლის წინაპარი მასწავლებელი(მასწავლებლის მასწავლების… მასწავლებელი) არ გამოდის საკუთარი თავი.
//Tags: Algorithm, Maps 

public class Final15 extends ConsoleProgram {
	public void run() {
		HashMap<String, String>  map = new HashMap<>();
		
		map.put("1", "2");
		map.put("2", "4");
		map.put("3", "4");
		map.put("4", "7");
		map.put("5", "7");
		map.put("6", "7");
		
		println(validateTeachers(map));
		
		map.put("7", "1");
		println(validateTeachers(map));
	}

	private boolean validateTeachers(HashMap<String, String> studentTeachers) {
		for(String student: studentTeachers.keySet()){
			boolean currValid = validateCurrStudent(studentTeachers, student);
			if(!currValid){
				return false;
			}
		}
		return true;
	}

	private boolean validateCurrStudent(HashMap<String, String> studentTeachers, String student) {
		String currStudent = studentTeachers.get(student);
		
		while(studentTeachers.containsKey(currStudent)){
			if(currStudent.equals(student)){
				return false;
			}
			currStudent = studentTeachers.get(currStudent);
		}
		
		return true;
	}
}