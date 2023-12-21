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
import java.util.Iterator;
import java.util.Map;

public class FriendGroup {
	private Map<String, ArrayList<String>> friendMap;

	public FriendGroup() {
		friendMap = new HashMap<String, ArrayList<String>>();
		System.out.println("constructor called");
	}
	
	public void addFriendship(String person, String friend) {
		friendMap.putIfAbsent(person, new ArrayList<String>());

		ArrayList<String> friends = friendMap.get(person);
		if(!friends.contains(friend)) { // to avoid duplicates
			friends.add(friend);
		}
		
//		friendMap.put(friend, friends); // not needed, friends is the same object we already had as a value for this key
		System.out.println(friendMap);// for testing the class TODO remove
	}

	public String getPopularPerson() {
		return getPopularKey(friendMap);
	}
	
	private String getPopularKey(Map<String, ArrayList<String>> map) {
		int maxCount = 0;
		String popularKey = null;
		for (String key : map.keySet()) {
			int friendCount = map.get(key).size();
			if (friendCount > maxCount) {
				maxCount = friendCount;
				popularKey = key;
			}
		}
		return popularKey;		
	}

	public String getFriendsAsString(String person) {
		if (!friendMap.containsKey(person)) {
			return "No Friends";
		}
		ArrayList<String> friends = friendMap.get(person);
		// we could have created string by ourselves as well 
		return friends.toString();
		
	}
	
	public Iterator<String> getFriendsIterator(String person) {
		ArrayList<String> friends = friendMap.get(person);
		return friends.iterator();
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
	
//	mari -> gio, ele
//	nino -> gio

//	gio -> mari, nino
//	ele -> mari
	private HashMap<String, ArrayList<String>> reverseMap(Map<String, ArrayList<String>> map){
		HashMap<String, ArrayList<String>> reversed = new HashMap<String, ArrayList<String>>();
		for(String key: map.keySet()) {
			ArrayList<String> friends = map.get(key);
			for(String friend: friends) {
				reversed.putIfAbsent(friend, new ArrayList<String>());
				reversed.get(friend).add(key);
			}
		}
		
		return reversed;
	}
	
	public String getPopularFriend() {
		HashMap<String, ArrayList<String>> reversed = reverseMap(friendMap);
		return getPopularKey(reversed);
	}
	
	public ArrayList<String> getTwoPeopleWithoutCommonFriends(){
		for (String person1: friendMap.keySet()) {
			for (String person2: friendMap.keySet()) {
				if(person1.equals(person2)) {
					continue;
				}
				ArrayList<String> friends1 = friendMap.get(person1);
				ArrayList<String> friends2 = friendMap.get(person2);
				if(!haveCommonMember(friends1, friends2)) {
					  ArrayList<String>res = new ArrayList<String>();
					  res.add(person1);
					  res.add(person2);
					  return res;
				}
			}
		}
		return null;
	}

	private boolean haveCommonMember(ArrayList<String> friends1, ArrayList<String> friends2) {
		for(String friend: friends1) {
			if(friends2.contains(friend)) {
				return true;
			}
		}
		return false;	
	}

}
