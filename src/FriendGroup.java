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
import java.util.HashMap;
import java.util.Map;

public class FriendGroup {
	private Map<String, ArrayList<String>> friendMap;

	public FriendGroup() {
		friendMap = new HashMap<String, ArrayList<String>>();
		System.out.println("constructor called");
	}

	public void addFriendship(String person, String friend) {
		if (!friendMap.containsKey(person)) {
			friendMap.put(person, new ArrayList<String>());
		}

		ArrayList<String> friends = friendMap.get(person);
		if(!friends.contains(friend)) { // to avoid duplicates
			friends.add(friend);
		}
		
		// not needed, friends is the same object we already had as a value for this key
//		friendMap.put(friend, friends); 

		System.out.println(friendMap);// for testing the class TODO remove
	}

	public String getPopularPerson() {
		int maxCount = 0;
		String popularPerson = null;
		for (String person : friendMap.keySet()) {
			int friendCount = friendMap.get(person).size();
			if (friendCount > maxCount) {
				maxCount = friendCount;
				popularPerson = person;
			}
		}
		return popularPerson;
	}

	public String getFriendsAsString(String person) {
		if (!friendMap.containsKey(person)) {
			return "No Friends";
		}
		ArrayList<String> friends = friendMap.get(person);
		// we could have created string by ourselves as well 
		return friends.toString();
	}

	public ArrayList<String> getAllNames() {
		ArrayList<String> names = new ArrayList<String>();
		for (String person : friendMap.keySet()) {
			if (!names.contains(person)) {
				names.add(person);
			}
			ArrayList<String> friends = friendMap.get(person);
			for (String friend : friends) {
				if (!names.contains(friend)) {
					names.add(friend);
				}
			}
		}
		return names;
	}

}
