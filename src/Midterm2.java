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
	}

	private boolean amIYourFatherLuke(String lukeDNA, String anakinDNA){
		// TODO
		return false;
	}
}
