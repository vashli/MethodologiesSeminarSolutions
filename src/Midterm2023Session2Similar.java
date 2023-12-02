//ორ სტრინგის ეწოდება მსგავსი თუკი პირველი სტრინგის სიმბოლოების წრეზე
//დალაგების შედეგად არსებობს წრის მოტრიალება ისეთი, რომ მეორე სტრინგი
//მივიღოთ. მაგალითად “abcd” და “cdab” მსგავსი სტრინგებია, ასევეა “aba” და
//“aab”, მაგრამ სტრინგები “abab” და “baab” მსგავსები არ არიან.
//დაწერეთ მეთოდი similar რომელსაც გადაეცემა მხოლოდ პატარა ლათინური
//სიმბოლოებისგან შემდგარი ორი სტრინგი first და second. მეთოდი აბრუნებს trueს 
//მხოლოდ იმ შემთხვევაში თუკი first სტრინგში მხოლოდ ერთი სიმბოლოს სხვა
//რომელიმე სიმბოლოთი შეცვლის შედეგად მივიღებთ ისეთ სტრინგს რომელის
//მსგავსი იქნება second-ის.
//მაგალითად
//similar(“bla”, “lam”) უნდა დააბრუნოს true
//similar(“bla”, “alm”) უნდა დააბრუნოს false
//ამოხსნა დაწერეთ similar.java ფაილში
import acm.program.ConsoleProgram;

public class Midterm2023Session2Similar extends ConsoleProgram{
	public void run() {
		println(similar("bla", "lam"));
		println(similar("bla", "alm"));
	}

	private boolean similar(String first, String second) {
		// we change character at index i with ch and check if its a rotation of second text
		for(int i = 0; i < first.length(); i++) {
			for(char ch = 'a'; ch <= 'z'; ch++) {
				if(ch == first.charAt(i)) continue; // we need 1 char to be different
				String firstChanged = first.substring(0, i)+ ch + first.substring(i + 1) ;
				if(sameRotated(firstChanged, second)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean sameRotated(String first, String second) {
		for(int i = 0; i < first.length(); i++) {
			String st1 = first.substring(i) + first.substring(0, i);
			if (st1.equals(second)) {
				return true;
			}
		}
		return false;
	}
}
