import java.util.StringTokenizer;
import acm.program.ConsoleProgram;

//4. დაწერეთ მეთოდი რომელსაც გადაეცემა ინგლისური ტექსტი, და აბრუნებს ტექსტს, რომელიც არის 
//საწყისი ტექსტი შეცვლილი ისე, რომ თითოეული სიყვა არის შებრუნებული.  
//კონსოლიდან შემოიყვანეთ ტექსტი და დაბეჭდეთ ამ მეთოდის მიერ დაბრუნებული შედეგი.
//ტექსტი შედგება მხოლოდ შემდეგი სიმბოლოებისგან: ინგლისური ასოები, მძიმე, წერტილი, space.
//მაგ:  “i have A pEN.” -> “i evah A NEp.”
//Tags: String, Tokenizer, ReverseString

public class Practice04 extends ConsoleProgram {
	public void run() {
		while (true) {
			String s = readLine("Enter text: ");
			println(beautify(s));
		}
	}

	private String beautify(String s) {
		StringTokenizer tokenizer = new StringTokenizer(s, " ,.", true);
		String beautifulS = "";
		while (tokenizer.hasMoreTokens()) {
			String currentWord = tokenizer.nextToken();
			beautifulS += reversed(currentWord);
		}
		return beautifulS;
	}

	private String reversed(String word) {
		String reversed = "";
		for(int i = word.length() -1; i >= 0; i--){
			reversed += word.charAt(i);
		}
		return reversed;
	}
}
