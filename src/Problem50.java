//50. შეყვანილ ტექსტში დათვალეთ სიტვყების რაოდენობა, ტოკენაიზერის საშუალებით

import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

public class Problem50 extends ConsoleProgram{
	public void run() {
		String text = readLine("Enter text: ");
//		StringTokenizer tokenizer = new StringTokenizer(text); // default delims = " \t\n"
		StringTokenizer tokenizer = new StringTokenizer(text, " ,.!?\t");
		
		int count = 0;
		while(tokenizer.hasMoreTokens()) {
//			String currToken = tokenizer.nextToken(); // we don't use it so we can skip creating a variable
			tokenizer.nextToken();
			count++;
		}
		println("Count: " + count);
	}

}
