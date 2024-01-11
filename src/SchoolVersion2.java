//71. School კლასი(2018 წლის გამოცდის ამოცანა).
//თქვენი მიზანია დაწეროთ School კლასი, რომლის საშუალებითაც შევძლებთ
//უნივერსიტეტის მართვას. კლასს უნდა ჰქონდეს კონსტრუქტორი და 5 public მეთოდი.

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class SchoolVersion2 {
	public HashMap<String, HashSet<String>> teacherSubjects;	
	public HashMap<String, HashSet<String>> subjectPupils;
//	კონსტრუქტორს არაფერი არ გადაეცემა. აქ შეგიძლიათ ინიციალიზაცია გაუკეთოთ
//	თქვენთვის საჭირო ცვლადებს.
	public SchoolVersion2(){
		teacherSubjects = new HashMap<String, HashSet<String>>();
		subjectPupils = new HashMap<String, HashSet<String>>();
	}

//	addTeacher მეთოდის საშუალებით შეგიძლიათ სკოლას დაამატოთ ახალი
//	მასწავლებელი. მეთოდს გადაეცემა მასწავლებლის სახელი. შეგიძლიათ ჩათვალოთ,
//	რომ მასწავლებლის სახელი უნიკალურია.
	public void addTeacher(String teacher){
		if(!teacherSubjects.containsKey(teacher)){
			teacherSubjects.put(teacher, new HashSet<String>());
		}
	}
	
//	addSubject მეთოდის საშუალებით შეგიძლიათ მასწავლებელს დაუმატოთ საგანი.
//	მეთოდს გადაეცემა მასწავლებლის სახელი და საგნის სახელი. ჩათვალეთ, რომ საგნის
//	სახელი უნიკალურია. ერთი და იგივე მასწავლებელი შეიძლება რამდენიმე საგანს
//	კითხულობდეს, ასევე ერთსა და იმავე საგანს შეიძლება რამდენიმე მასწავლებელი
//	კითხულობდეს ერთდროულად.
//	თუკი teacher სახელის მქონე მასწავლებელი არ არის აქამდე დამატებული, მაშინ
//	მეთოდმა არაფერი არ უნდა გააკეთოს.
	public void addSubject(String teacher, String subject){
		if(!teacherSubjects.containsKey(teacher)){
			return;
		}
		
		teacherSubjects.get(teacher).add(subject);
	}
	
//	addPupil მეთოდის საშუალებით შეგიძლიათ საგანზე დაამატოთ მოსწავლე. ერთი და
//	იგივე მოსწავლე შეიძლება ერთ ან რამდენიმე საგანს სწავლობდეს.
	public void addPupil(String pupil, String subject){
		if(!subjectPupils.containsKey(subject)){
			subjectPupils.put(subject, new HashSet<String>());
		}
		subjectPupils.get(subject).add(pupil);
	}
	
//	getTeachers მეთოდს გადაეცემა მოსწავლის სახელი და მან უნდა დააბრუნოს ამ
//	მოსწავლის ყველა მასწავლებელზე იტერატორი. ანუ მხოლოდ იმ მასწავლებლების
//	სახელები, რომლებიც ასწავლიან იმ საგნებს, რომლებზეც მოსწავლეა
//	დამატებული(სწავლობს). თუკი pupil სახელის მოსწავლე არ გვყავს მაშინ მეთოდმა
//	უნდა დააბრუნოს null.
	public Iterator<String> getTeachers(String pupil){
		HashSet<String> teachers = new HashSet<String>();
		for(String subject: getSubjects(pupil)){
			teachers.addAll(getTeachersBySubject(subject));
		}
		return teachers.iterator();
	}
	
	private HashSet<String> getTeachersBySubject(String subject) {
		HashSet<String> teachers = new HashSet<String>();
		for(String teacher: teacherSubjects.keySet()){
			if(teacherSubjects.get(teacher).contains(subject)){
				teachers.add(teacher);
			}
		}
		return teachers;
	}

	private HashSet<String> getSubjects(String pupil){
		HashSet<String> subjects = new HashSet<String>();
		for(String subject: subjectPupils.keySet()){
			if(subjectPupils.get(subject).contains(pupil)){
				subjects.add(subject);
			}
		}
		return subjects;
	}

//	getPupils მეთოდს გადაეცემა მასწავლებლის სახელი და მან უნდა დააბრუნოს ამ
//	მასწავლებლის ყველა სტუდენტზე იტერატორი. ანუ მხოლოდ იმ სტუდენტების
//	სახელები, რომლებიც მის რომელიმე საგანს სწავლობენ. თუკი teacher სახელის მქონე
//	ლექტორი არ გვყავს მაშინ მეთოდმა უნდა დააბრუნოს null.
	public Iterator<String> getPupils(String teacher){
		HashSet<String> subjects = teacherSubjects.get(teacher);
		if(subjects == null) return null;
		HashSet<String> pupils = new HashSet<String>();
		
		for(String subject: subjects){
			HashSet<String> currPupils = subjectPupils.get(subject);
			if(currPupils != null){
				pupils.addAll(currPupils);
			}
			
		}
		
		return pupils.iterator();
	}
	
//	მეთოდმა უნდა წაშალოს მასწავლებლის შესახებ ყველა ინფორმაცია. ამ მეთოდის
//	გამოძახების, შემდეგ getTeachers მეთოდმა არ უნდა დააბრუნოს teacher სახელი არც
//	ერთი სტუდენტისთვის.
	public void removeTeacher(String teacher){
		teacherSubjects.remove(teacher);
	}
	
	// for debug
	public void showAll(){
		System.out.println("teachers and subjects:");
		System.out.println(teacherSubjects);
		System.out.println("subjects and pupils:");
		System.out.println(subjectPupils);	
	}
}