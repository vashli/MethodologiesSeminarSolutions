import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
//ამოცანა 5. (30 ქულა) ფეხბურთი
//თქვნი მიზანია დაწეროთ Football კლასი, რომლის საშუალებითაც შევძლებთ
//ფეხბურთელებისა და კლუბების შესახებ ინფორმაციის მართვას. კლასი უნდა
//იმპლემენტირებდეს შემდეგ ინტერფეისს:
//public interface Footballer {
//public void addFootballPlayer(String club, String player)
//public Iterator<String> getClubs(String player)
//public Iterator<String> getPlayers(String club, int n)
//}
// თბილისის თავისუფალი უნივერსიტეტი
//addFootballPlayer მეთოდს გადაეცემა კლუბისა და ფეხბურთელი სახელი და
//მისი გამოძახებით კლუბს შეგვიძლია დავამატოთ ფეხბურთელი(ანუ ამ კლუბში ეს
//ფეხბურთელი ოდესღაც თამაშობდა). ჩათვალეთ, რომ კლუბებისა და
//ფეხბურთელების სახელები უნიკალურია, რაც იმას ნიშნავს, რომ თუკი ორი
//ერთიდაიგივე სახელის მქონე კლუბი გადაეცა მეთოდს მაშინ ეს ერთიდაიგივე
//კლუბია, იგივე ფეხბურთელზეც.
//getClubs მეთოდმა უნდა დააბრუნოს player ფეხბურთელის ყველა კლუბზე
//იტერატორი. ანუ მხოლოდ ის კლუბები, რომელშიც ამ ფეხბურთელს ოდესმე
//უთამაშია. თუკი player სახელის ფეხბურთელი არ არსებობს მაშინ მეთოდმა
//უნდა დააბრუნოს null.
//getPlayers მეთოდი აბრუნებს ყველა ისეთ ფეხბურთელზე იტერატორს, რომლებიც
//მხოლოდ ისეთ კლუბებში თამაშობდნენ სადაც არც ერთ გამყიდველ ფეხბურთელს არ
//უთამაშია. გამყიდველია ფეხბურთელი თუკი 3-ზე მეტ კლუბში აქვს ნათამაშები.
//თუკი ასეთი ფეხბურთელები არ არსებობენ მაშინ მეთოდმა უნდა დააბრუნოს
//null.
//კოდი დაწერეთ football.java ფაილში.
public class Final2022Session1Football implements Final2022Session1Footballer {
	private HashMap<String, HashSet<String>> clubPlayers;
	private HashMap<String, HashSet<String>> playerClubs;
	
	public Final2022Session1Football() {
		clubPlayers = new HashMap<>();
		playerClubs = new HashMap<>();
	}

	@Override
	public void addFootballPlayer(String club, String player) {
		clubPlayers.putIfAbsent(club, new HashSet<>());
		clubPlayers.get(club).add(player);
		
		playerClubs.putIfAbsent(player, new HashSet<>());
		playerClubs.get(player).add(club);
	}

	@Override
	public Iterator<String> getClubs(String player) {
		if (!playerClubs.containsKey(player) ) {
			return null;
		}
		return playerClubs.get(player).iterator();
	}

	@Override
	public Iterator<String> getPlayers(String club, int n) {
		HashSet<String> badClubs = badClubs();
		if(badClubs.size() == 0) {
			return null;
		}
		HashSet<String> players = new HashSet<>();
//		for (String player: clubPlayers.get(club)) { // piroba cota gaugebaria
		for (String player: playerClubs.keySet()) {
			boolean good = true;
			for(String cl2: playerClubs.get(player)) {
				if(badClubs.contains(cl2)) {
					good = false;
					break;
				}
			}
			if (good) {
				players.add(player);
			}
		}
		return players.iterator();
	}

	private HashSet<String> badClubs(){
		HashSet<String> badClubs = new HashSet<>();
		
		HashSet<String> badPlayers = badPlayers();
		for(String club: clubPlayers.keySet()) {
			for(String player: clubPlayers.get(club)) {
				if (badPlayers.contains(player)) {
					badClubs.add(club);
					break;
				}
			}
		}
		return badClubs;
	}
	private HashSet<String> badPlayers(){
		HashSet<String> badPlayers = new HashSet<>();
		for(String player: playerClubs.keySet()) {
			if (playerClubs.get(player).size() > 3) {
				badPlayers.add(player);
			}
		}
		return badPlayers;
	}
}