import acm.program.ConsoleProgram;

//51. დაწერეთ მეთოდი რომელიც გადაცემული ტექსტიდან შლის დუბლირებულ სიმბოლოებს,
//ანუ თუ ტექსტიში რომელიმე სიმბოლო მეორდება, უნდა დარჩეს მხოლოდ ყველაზე მარცხენა.

public class Problem51 extends ConsoleProgram {
	public void run() {
		while (true) {
			String s = readLine("Enter txt:");
			println(removeDublicates(s));
			println(removeDublicates2(s));
		}
	}

	//mariami
	private String removeDublicates(String s) {
		for(int i = 0; i < s.length(); i++){
			if(!isFirstOccurence(s, i)){
//				println("i: " + i + " length: " + s.length());
//				println(s);
				s = s.substring(0, i) + s.substring(i + 1 , s.length());
				i--;
//				i = 4 (before i--) line 22
//				s.substring(0, i)  mar
//				s.substring(i + 1 , s.length() ami
//				s = "marami"
			}
		}
		return s;
	}
	//mariami
	private String removeDublicates2(String s) {
		String result = "";
		for(int i = 0; i < s.length(); i++){
			if(result.indexOf(s.charAt(i)) == -1) {
				result += s.charAt(i);
			}
//			we can use this instead of lines 35-37
//			if(isFirstOccurence(s, i)){
//				result += s.charAt(i);
//			}
		}
		return result;
	}

	private boolean isFirstOccurence(String s, int i) {
		for(int j = 0; j < i; j++){
			if(s.charAt(j) == s.charAt(i)){
				return false;
			}
		}
		return true;
	}
}
