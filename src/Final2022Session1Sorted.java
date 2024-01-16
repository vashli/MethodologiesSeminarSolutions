//ამოცანა 3. (20 ქულა) თითქმის დასორტირებული
//მთელი რიცხვების არაილისტს ეწოდება დასორტირებული თუკი მისი ყოველი
//მომდევნო ელემენტი წინაზე მეტია ან ტოლი.
//მთელი რიცხვების არაილისტს ეწოდება თითქმის დასორტირებული თუკი შემდეგი
//ორი ოპერაციით შეგვიძლია მისგან დასორტირებული არაილისტი მივიღოთ:
//1. ორ ელემენტს გაუცვალეთ ადგილი.
//მაგალითად ამ ოპერაციით არაილისტისგან {5,4,3,2,1} შეგვიძლია მივიღოთ
//{1,4,3,2,5} - პირველ და ბოლო ელემენტს გავუცვალეთ ადგილი.
//2. აირჩიეთ ორი რიცხვი 0<=i<j<N სადაც N არაილისტში ელემენტების
//რაოდენობაა. და ელემენტები ინდექსებით, i,i+1, …, j შემოატრიალეთ, ისე,
//რომ იმავე ადგილას იყვნენ ოღონდ შებრუნებული მიმდევრობით: j,j-1, … i.
//მაგალითად ამ ოპერაციით არაილისტისგან {1,4,3,2,5} შეგვიძლია მივიღოთ
//{1,2,3,4,5} ანუ i=1, j=3, შესაბამისად {4,3,2} შემოვატრიალეთ.
//თქვენი ამოცანაა დაწეროთ sorted მეთოდი რომელსაც გადაეცემა არაილისტი და
//რომელიც აბრუნებს true-ს თუკი ეს არაილისტი თითქმის დასწორტირებულია,
//წინააღმდეგ შემთხვევაში კი false-ს.
//გაითვალისწინეთ, რომ ჯერ პირველი ოპერაცია უნდა შეასრულოთ ერთხელ და მერე
//მეორე ასევე ერთხელ.
//მაგალითად:
//sorted({2,3,4,5})->true {2,3,4,5} -> {3,2,4,5} -> {2,3,4,5}
//sorted({4,1,3,2})->true {4,1,3,2} -> {1,4,3,2} -> {1,2,3,4}
//sorted({3,1,5,2,4})->false არ მოიძებნება ასეთი ორი ოპერაცია.
//ამოხსნა დაწერეთ sorted.java ფაილში

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import acm.program.ConsoleProgram;

public class Final2022Session1Sorted extends ConsoleProgram {
	public void run() {
		println("sorted({2,3,4,5}) -> true: " + sorted(new ArrayList<>(Arrays.asList(2, 3, 4, 5))));
		println("sorted({4,1,3,2}) -> true: " + sorted(new ArrayList<>(Arrays.asList(4, 1, 3, 2))));
		println("sorted({3,1,5,2,4}) -> false: " + sorted(new ArrayList<>(Arrays.asList(3, 1, 5, 2, 4))));

	}

	private boolean sorted(ArrayList<Integer> a) {

		for (int i = 0; i < a.size(); i++) {
			for (int j = i + 1; j < a.size(); j++) {
				if (sortedAfterSwap(listWithSwapped(a, i, j))) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean sortedAfterSwap(ArrayList<Integer> a) {
		for (int i = 0; i < a.size(); i++) {
			for (int j = i + 1; j < a.size(); j++) {
				if (isSorted(listWithrotatedSublist(a, i, j))) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isSorted(ArrayList<Integer> list) {
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) < list.get(i - 1)) {
				return false;
			}
		}
		return true;
	}

	private ArrayList<Integer> listWithSwapped(ArrayList<Integer> list, int i, int j) {
		ArrayList<Integer> newList = new ArrayList<>(list.subList(0, i));
		newList.add(list.get(j));
		newList.addAll(list.subList(i + 1, j));
		newList.add(list.get(i));
		newList.addAll(list.subList(j + 1, list.size()));
		return newList;
	}

	private ArrayList<Integer> listWithrotatedSublist(ArrayList<Integer> list, int i, int j) {
		ArrayList<Integer> newList = new ArrayList<>(list.subList(0, i));
		ArrayList<Integer> rotateList = rotated(list.subList(i, j + 1));
		newList.addAll(rotateList);
		newList.addAll(list.subList(j + 1, list.size()));
		return newList;
	}

	private ArrayList<Integer> rotated(List<Integer> list) {
		ArrayList<Integer> newList = new ArrayList<Integer>();
		for (Integer elem : list) {
			newList.add(0, elem);
		}
		return newList;
	}
}
