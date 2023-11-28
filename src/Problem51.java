//51. დაწერეთ მეთოდი რომელიც გადაცემული ტექსტიდან შლის 
//დუბლირებულ სიმბოლოებს,
//ანუ თუ ტექსტიში რომელიმე სიმბოლო მეორდება, უნდა დარჩეს მხოლოდ 
//ყველაზე მარცხენა.

import acm.program.ConsoleProgram;

public class Problem51 extends ConsoleProgram{
	public void run() {
		while(true) {
			String text = readLine("Enter text: ");
			String editedText = removeDuplicates(text);
			println(editedText);
		}
	}
	
	private String removeDuplicates(String text) {
		String result = "";
		for(int i = 0; i < text.length(); i++) {
			char ch  = text.charAt(i);
//			check if it's the first occurrence of a character(lines 22,23,24)
//			if(text.indexOf(ch) == i ) { 
//			if(!result.contains("" + ch)) {
			if(result.indexOf(ch) == -1) {
				result += ch;
			}
		}
		return result;
	}
}
