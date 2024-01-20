import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

//11. თქვენი ამოცანაა დაწეროთ მეთოდი reverse რომელსაც გადაეცემა 32 ბიტიანი მთელი 
//დადებითი რიცხვი და რომელიც აბრუნებს ამ რიცხვის შებრუნებულს. 
//რიცხვის შებრუნებული გამოითვლება შემდეგნაირად: რიცხვი წარმოადგინეთ 32 ბიტიან ორობით
//ჩანაწერში, ამ ჩანაწერში ყველა 0 გადააკეთეთ 1-ად, ხოლო ყველა 1 გადააკეთეთ 0-ად, 
//მიღებული ორობითი რიცხვი გადააქციეთ ათობითში.
//მაგალითად თუკი გადმოგეცათ 7 მაშინ მისი ორობითი ჩანაწერია:
//00000000000000000000000000000111
//მისი შებრუნებული კი
//11111111111111111111111111111000
//რომელიც არის 1*2^31+1*2^30+ ... + 0*2^1+0*2^0 = 4294967288

public class Practice11 extends ConsoleProgram {
	private static final String ZEROS = "00000000000000000000000000000000";

	public void run() {
		while (true) {
			int num = readInt("Enter number: ");
			println(reverseBinNum(num));
		}
	}

	// we should save result in long to be able to save ints up to 2^32
	private long reverseBinNum(int num) {
		String binaryStr = IntToBinaryStr(num);
		String reveredBinaryStr = reversedBinaryString(binaryStr);
		println(binaryStr);
		println(reveredBinaryStr);
		long result = binaryStrToInt(reveredBinaryStr);
		return result;
	}

	private String IntToBinaryStr(int num) {
		String result = ZEROS; // 32 zeros
		int i = result.length() - 1; // 32 - 1 -- max index
		// we start setting binary digits from the end of the string
		while (num > 0) {
			int currBinaryDigit = (num % 2);
			if (currBinaryDigit == 1) {
				result = result.substring(0, i) + '1' + result.substring(i + 1);
			}
			num /= 2;
			i--;
		}
		return result;
	}

	private String reversedBinaryString(String s) {
		for (int i = 0; i < s.length(); i++) {
			char reveredCh = '0';
			if (s.charAt(i) == '0') {
				reveredCh = '1';
			}
			s = s.substring(0, i) + reveredCh + s.substring(i + 1);
		}
		return s;
	}

	private long binaryStrToInt(String str) {
		long result = 0;
		for (int i = 0; i < str.length(); i++) {
			int currDigit = str.charAt(i) - '0';
			result += currDigit * Math.pow(2, str.length() - 1 - i);
			// println(currDigit + " * 2^" + (str.length() - 1 - i));
		}

		return result;
	}
}
