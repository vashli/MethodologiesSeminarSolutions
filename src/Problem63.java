import java.util.*;
import acm.program.ConsoleProgram;
//63. კონსოლიდან შეგვყავს წყვილ-წყვილად მეგობრების სახელები, მანამ სანამ არ შევიყვანთ
//ცარიელ სტრინგს. დაბეჭდეთ იმ ადამიანის სახელი ვისაც ჰყავს ყველაზე მეტი მეგობარი.
//მეგობრობა შეიძლება იყოს ცალმხრივი. თუკი შევიყვანთ A-ს და B-ს, ეს ნიშნავს, რომ A არის
//B-ს მეგობარი, მაგრამ B შეიძლება არ იყოს A-ს მეგობარი
//64. 63-ე ამოცანის გაგრძელება, დაბეჭდეთ თითოეული შეყვანილი სახელი და მის გასწვრივ
//მძიმით გამოყოფილი მეგობრების სია.
//65. 63-ე ამოცანის გაგრძელება. დაბეჭდეთ ადამიანი რომელსაც ყველაზე მეტი ადამიანი
//ემეგობრება
//66. 63-ე ამოცანის გაგრძელება. დაბეჭდეთ ორი ადამინი რომელთაც არ ჰყავთ საერთო მეგობრები

//mari - > nino, ana, sofo
//gio -> luka, nino
//----
//reversedMap
//nino - > mari, gio
//ana -> mari
//luka - > gio
//sofo - > mari
public class Problem63 extends ConsoleProgram {
	private static final String  SENTINEL = ""; 
	
	public void run(){		
		HashMap<String, ArrayList<String>> map = 
				new HashMap<String, ArrayList<String>>();
		
		while(true){
			String key = readLine("Enter person: ");
			if(key.equals(SENTINEL)){
				break;
			}
			String friend = readLine("Enter their friend: ");
			addStringPairToMap(key, friend, map);
		}
		
		//Problem 63
		println("person with most friends: " + mostPopularKey(map));
		//Problem 64		
		println(map);
		//Problem 65
		HashMap<String, ArrayList<String>> reversedMap = getReversedMap(map);
		println("person who is a friend of most people: " + mostPopularKey(reversedMap));
	}

	private void addStringPairToMap(String key, String oneVal, HashMap<String,ArrayList<String>> map){
		ArrayList<String> valueList;
		if(!map.containsKey(key)){
			valueList = new ArrayList<String>();
			map.put(key, valueList);
		}else{
			valueList = map.get(key);
		}
		
		valueList.add(oneVal);
	}
	
	//mari - > nino, ana
	//gio -> nino, luka
	//----
	//map2 
	//nino - > mari, gio
	//ana -> mari
	//luka - > gio
	private HashMap<String, ArrayList<String>> getReversedMap(HashMap<String, ArrayList<String>> map) {
		HashMap<String, ArrayList<String>> reversedMap = 
				new HashMap<String, ArrayList<String>>();
		
		Set<String> keySet = map.keySet();
		for(String key: keySet){
			ArrayList<String> value = map.get(key);
			for(String currVal: value){ // same as lines: 75, 76
//			for(int i = 0; i < value.size(); i++){
//			String currVal = value.get(i);
				ArrayList<String> reversedList;
				if(!reversedMap.containsKey(currVal)){
					reversedList = new ArrayList<String>();
					reversedMap.put(currVal, reversedList);
				}else{
					reversedList = reversedMap.get(currVal);
				}
				reversedList.add(key);
			}
		}
		
		return reversedMap;
	}

	// returns most popular key - > key, which has arraylist with max length as a value 
	// in this case that is a person who has maxNumberOfFriends
	private String mostPopularKey(HashMap<String, ArrayList<String>> map) {
		int maxCount = 0;
		String popularKey = null;
		for(String key : map.keySet()){
			ArrayList<String> value  = map.get(key);
			int currValCount = value.size();
			if(currValCount > maxCount){
				maxCount = currValCount;
				popularKey = key;
			}
		}
		return popularKey;
	}

}
