import java.util.StringTokenizer;
import acm.program.ConsoleProgram;

//3. დაწერეთ მეთოდი რომელსაც გადაეცემა ინგლისური ტექსტი, და აბრუნებს ტექსტს, 
//რომელიც არის საწყისი ტექსტი შეცვლილი ისე, რომ ყველა სიყვა დიდი ასოთი იწყებოდეს და სიტყვაში 
//ყოველი შემდგომი ასო იყოს პატარა.  კონსოლიდან შემოიყვანეთ ტექსტი და დაბეჭდეთ ამ მეთოდის მიერ 
//დაბრუნებული შედეგი. მაგ: “i have A pEN.” -> “I Have A Pen”
//Tags: String, Tokenizer, toLowerCase, toUpperCase

public class Practice03 extends ConsoleProgram {
	public void run() {
		while (true) {
			String s = readLine("Enter text: ");
			println(beautify(s));
		}
	}

	private String beautify(String s) {
		StringTokenizer tokenizer = new StringTokenizer(s);
		String beautifulS = "";
		while (tokenizer.hasMoreTokens()) {
			String currentWord = tokenizer.nextToken();
			if(beautifulS.length() != 0){
				beautifulS += ' ';
			}
			
			if (currentWord.length() == 1) {
				currentWord = currentWord.substring(0, 1).toUpperCase();
			} else {
				currentWord = currentWord.substring(0, 1).toUpperCase() 
						+ currentWord.substring(1).toLowerCase();
			}
			
			beautifulS += currentWord;
		}
		return beautifulS;
	}
}
