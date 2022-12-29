import java.util.Iterator;

import acm.program.ConsoleProgram;

public class SchoolTst extends ConsoleProgram{
	public void run(){
		School school = new School();
		school.addTeacher("mari");
		school.addTeacher("nino");
		
		school.addSubject("mari", "cs");
		school.addSubject("mari", "math");
		school.addSubject("nino", "physics");
		
		school.addPupil("ana", "cs");
		school.addPupil("ana", "physics");
		school.addPupil("salo", "cs");
		school.addPupil("sofo", "pe");
		
		println(school.teacherSubjects);
		println(school.subjectPupils);
		
		
		Iterator<String> pup = school.getPupils("mari");
		println("pupils mari");
		if(pup == null){
			println("null");
		}else{
			while(pup.hasNext()){
				println(pup.next());
			}
		}
		
		
		println("teachers ana");
		Iterator<String> t = school.getTeachers("ana");
		if(t == null){
			println("null");
		}else{
			while(t.hasNext()){
				println(t.next());
			}
		}
		
		
		println("removing mari");
		school.removeTeacher("mari");
		println("teachers ana");
		t = school.getTeachers("ana");
		if(t == null){
			println("null");
		}else{
			while(t.hasNext()){
				println(t.next());
			}
		}
		
		
	}
}
