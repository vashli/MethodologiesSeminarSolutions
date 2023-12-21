//63. კონსოლიდან შეგვყავს წყვილ-წყვილად მეგობრების სახელები, მანამ სანამ არ შევიყვანთ
//ცარიელ სტრინგს. დაბეჭდეთ იმ ადამიანის სახელი ვისაც ჰყავს ყველაზე მეტი მეგობარი.
//მეგობრობა შეიძლება იყოს ცალმხრივი. თუკი შევიყვანთ A-ს და B-ს, ეს ნიშნავს, რომ A არის
//B-ს მეგობარი, მაგრამ B შეიძლება არ იყოს A-ს მეგობარი.
//64. 63-ე ამოცანის გაგრძელება, დაბეჭდეთ თითოეული შეყვანილი სახელი და მის გასწვრივ
//მძიმით გამოყოფილი მეგობრების სია.
//65. 63-ე ამოცანის გაგრძელება. დაბეჭდეთ ადამიანი რომელსაც ყველაზე მეტი ადამიანი
//ემეგობრება
//66. 63-ე ამოცანის გაგრძელება. დაბეჭდეთ ორი ადამინი რომელთაც არ ჰყავთ საერთო მეგობრები

import java.util.ArrayList;
import acm.program.ConsoleProgram;
public class FriendGroupConsole extends ConsoleProgram{
	private static final String SENTINEL = "";
	public void run() {
		FriendGroup myFriendGroup = new FriendGroup();
		while(true) {
			String friend = readLine("Enter friend: ");
			if(friend.equals(SENTINEL)) {
				break;
			}
			String person = readLine("Enter person: ");
			myFriendGroup.addFriendship(person, friend);
		}
		
//		63
		println("Person with most friends: " + myFriendGroup.getPopularPerson());
//		64
		println("Everyone with their friends: ");
		ArrayList<String> names = myFriendGroup.getAllNames();
		for(String name: names) {
			println(name + "'s friends: " + myFriendGroup.getFriendsAsString(name));
		}
//		65
		println("Friends of most people: " + myFriendGroup.getPopularFriend());
//		66
		ArrayList<String> twoPeople = myFriendGroup.getTwoPeopleWithoutCommonFriends();
		println("People with no common friends: " + twoPeople);
	}
}
