import acm.program.ConsoleProgram;

//ამოცანა 2. მამაშვილობა (20 ქულა)
//SPOILER ALERT! თქვენი ამოცანაა დაადგინოთ არის თუ არა ლუკა ანაკინის შვილი. 
//ამისათვის თქვენ გადმოგეცემათ ლუკას და ანაკინის DNA ნიმუშები (ორი სტრინგი). 
//ეს ნიმუშები ერთმანეთს უნდა შეადაროთ და იპოვოთ მაქსიმალური სიგრძის ზუსტი დამთხვევა 
//რომელიც ორივე DNA-ს ნიმუშში გვხვდება. თუკი მაქსიმალური სიგრძის დამთხვევის სიგრძე
//(სიმბოლოების რაოდენობა) მეტია ანაკინის DNA-ს სიგრძის ნახევარზე მაშინ ლუკა ანაკინის შვილია 
//წინააღმდეგ შემთხვევაში არ არის.
//დაწერეთ მეთოდი amIYourFatherLuke რომელსაც გადაეცემა ორი სტრინგი და აბრუნებს boolean-ს. 
//ანუ თქვენ უნდა იპოვოთ ორ სტრინგში მაქსიმალური სიგრძის ქვესტრინგი, რომელსაც ორივე სტრინგი შეიცავს.
//მაგალითად:
//სტრინგებში "CGAT", "CCTGACT" მაქსიმალური სიგრძის ქვესტინგია "GA"
//სტრინგებში "GATTA", "ATTGATTT" მაქსიმალური სიგრძის ქვესტინგია "GATT"
//სტრინგებში "ATAGGCC", "ATCCGCCAG" მაქსიმალური სიგრძის ქვესტინგია "GCC"
//

public class Midterm2 extends ConsoleProgram{
	public void run(){
		println(amIYourFatherLuke("CGAT", "CCTGACT")); // უნდა დაბეჭდოს false
		println(amIYourFatherLuke("GATTA", "TTGATTT")); // უნდა დაბეჭდოს true		
		println(amIYourFatherLuke("GAT", "TTGAT")); // უნდა დაბეჭდოს true
		println(amIYourFatherLuke("GAT", "TTTGAT")); // უნდა დაბეჭდოს false
	}

	private boolean amIYourFatherLuke(String lukeDNA, String anakinDNA){
		int maxLength = 0;
		for(int i = 0; i < lukeDNA.length(); i++){
			//!! to include substring at the end =>  j < lukeDNA.length() + 1
			for(int j = i + 1; j < lukeDNA.length() + 1; j++){
				String currSubs = lukeDNA.substring(i, j);
				if(anakinDNA.indexOf(currSubs) == -1){
					break;
				}
				maxLength = Math.max(maxLength, currSubs.length());
			}
		}
		return maxLength > anakinDNA.length() / 2.0;
	}
	
	
	// version 2
//	private boolean amIYourFatherLuke(String lukeDNA, String anakinDNA){
//		// if 2 strings have common substring of length substrLength then anakin is father
//		int substrLength = anakinDNA.length() / 2 + 1;
//		for(int i = 0; i < lukeDNA.length() + 1 - substrLength; i++){
//			String currSubs = lukeDNA.substring(i, i + substrLength );
//			if(anakinDNA.indexOf(currSubs) != -1){
//				return true;
//			}
//		}
//		return false;
//	}
}
