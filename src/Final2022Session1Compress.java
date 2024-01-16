//ამოცანა 1. (15 ქულა) სტრინგების კომპრესირება
//დაწერეთ მეთოდი, რომელსაც გადაეცემა სტრინგი და აბრუნებს ამ სტრინგის
//კომპრესირებულ ვერსიას შემდეგი წესით: ნაცვლად ერთმანეთის მიმდევრობით
//გამეორებული სიმბოლოებისა წერს სიმბოლოს და შემდეგ მის რაოდენობას.
//მაგალითად:
//“aabcccccaa” -> “a2b1c5a2”.
//“wwwaaaage” -> “w3a4g1e1”
//იმ შემთხვევაში თუ ამ წესით კომპრესირებული სტრინგი უფრო გრძელია ვიდრე
//საწყისი, მეთოდმა უნდა დააბრუნოს საწყისი სტრინგი უცვლელად. მაგალითად:
//“abc”-ს კომპრესირებული ვერსიაა “a1b1c1”, რომელიც თავდაპირველზე უფრო
//გრძელია, ამიტომ მეთოდი დააბრუნებს “abc”.
//ამოხსნა დაწერეთ compress.java ფაილში
import acm.program.ConsoleProgram;

public class Final2022Session1Compress extends ConsoleProgram{
	public void run() {
		test("aabcccccaa", "a2b1c5a2");
		test("wwwaaaage", "w3a4g1e1");
		test("w", "w1");
		test("", "");

	}
	private void test(String text, String expected) {
		println("Compress: " + text);
		println("Expected: " + expected);
		println("Actual  : " + compress(text));
	}
	
	private String compress(String text) {
		if (text.length() == 0) {
			return "";
		}
		String compressed = "" + text.charAt(0);
		int count = 1;
		for(int i = 1; i < text.length(); i++) {
			if (text.charAt(i) != text.charAt(i - 1)) {
				compressed += count;
				compressed += text.charAt(i);
				count = 1;
			}else {
				count += 1;
			}
		}
		compressed += count;
		
		return compressed;
	}
}


