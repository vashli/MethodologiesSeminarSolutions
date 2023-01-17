import acm.program.ConsoleProgram;

//https://www.youtube.com/playlist?list=PL6qg6DlVkjd6XenORSl6px7Z_NweBs8yf
public class Spaces extends ConsoleProgram {
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
