import acm.program.ConsoleProgram;
//ამოცანა 2. (10 ქულა) სფეისების დამატება
//დაწერეთ მეთოდი addSpaces რომელსაც გადაეცემა სტრინგი და ინდექსების მასივი და რომელიც აბრუნებს სტინგს სადაც გადაცემული სტრინგის მითითებულ ინდექსებზე სფეისები დაემატება. მაგალითად
//addSpaces(“EnjoyYourExam”, [5,9]) დააბრუნებს “Enjoy Your Exam”
//addSpaces(“Ilovecoding”, [1, 5]) დააბრუნებს “I love coding”
//ჩათვალეთ, რომ ინდექსები ყოველთვის ზრდადობით იქნება დალაგებული.
//ამოხსნა დაწერეთ spaces.java ფაილში

//https://www.youtube.com/playlist?list=PL6qg6DlVkjd6XenORSl6px7Z_NweBs8yf
public class Final2021Session2Spaces extends ConsoleProgram {
	public void run() {
		println(addSpaces("EnjoyYourExam", new int[] { 5, 9 }));
		println(addSpaces("Ilovecoding", new int[] { 1, 5 }));
	}

	private String addSpaces(String text, int[] spaces) {
		for (int i = 0; i < spaces.length; i++) {
			int index = spaces[i] + i;
			text = text.substring(0, index) + " " + text.substring(index);
		}
		return text;
	}
}
