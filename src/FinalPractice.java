import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

//ვიდეოს ლინკი:
//https://www.youtube.com/watch?v=zjpmqXXrq-Y&list=PL6qg6DlVkjd5qcN9fP6DbzqmIugbiepWY&index=2



//Array
//ArrayList
//-create, initial values, get, set, add, remove, size, sort, random sort
//Matrix
//Map
//Set 

//Iterator

//String
//-create, equals, length, indexOf, contains, charAt, substr
//Files
//Tokenizer

//Sorting

//Interactors
//Graphics animations
//Random simulations
public class FinalPractice extends ConsoleProgram {
	public void run() {
		// Array
		// ArrayList

		// int[] arr = new int[5];
		int[] arr = { 1, 2, 3, 4, 5 };
		println(Arrays.toString(arr));

		Integer[] arr1 = new Integer[5];

		println(Arrays.toString(arr1));

		ArrayList<Integer> list = new ArrayList<Integer>();

		list.add(5);
		println(list);

		// list.remove(0);

		// 0, 1, 2
		arr[0] = 7;
		println(arr[0]);

		list.set(0, 7);
		println(list);
		println(list.get(0));

		// arr[7] = 5;

		for (int i = 0; i < arr.length; i++) {
			println(i);
		}

		for (int i = 0; i < list.size(); i++) {
			int val = list.get(i);
			println(list.get(i));
		}

		// for each
		for (int val : list) {
			print(val);
		}

		// -create, initial values, get, set, add, remove, size, sort, random
		// sort
		// Matrix

		// int[][] matrix = new int[2][3];

		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 } };

		for (int i = 0; i < matrix.length; i++) {
			int[] currArr = matrix[i];
			println(Arrays.toString(currArr));
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = i + j;
				println(matrix[i][j]);
			}
		}

		// Map

		HashMap<String, Integer> grades = new HashMap<>();

		grades.put("mberi15", 15);
		grades.put("aberi15", 10);

		println(grades);

		HashMap<String, ArrayList<Integer>> hw = new HashMap<>();

		hw.put("mberi16", new ArrayList<Integer>());

		println(hw);

		ArrayList<Integer> marisGrades = hw.get("mberi16");
		if (marisGrades == null) {
			marisGrades = new ArrayList<Integer>();
			hw.put("mberi16", marisGrades);
		}

		marisGrades.add(5);
		marisGrades.add(7);
		println(hw);

		hw.put("aberi21", new ArrayList<Integer>(Arrays.asList(2, 3)));

		println(hw);

		for (String key : hw.keySet()) {
			println("key: " + key);
			println("val: " + hw.get(key));
			hw.get(key).add(10);
		}

		println(hw);

		HashMap<String, HashMap<String, Integer>> customHw = new HashMap();

		customHw.put("mari", new HashMap<String, Integer>());

		customHw.get("mari").put("breakout", 7);

		println(customHw);

		// Set
		Set<String> keys = hw.keySet();
		println(keys);

		HashSet<String> names = new HashSet<>();

		names.add("mari");
		names.add("mari");
		names.add("mari");
		names.add("ana");
		names.add("ana");

		println(names);

		// Iterator

		Iterator<String> namesIt = names.iterator();

		while (namesIt.hasNext()) {
			String currStr = namesIt.next();
			println(currStr);
		}

		// String
		// -create, equals, length, indexOf, contains, charAt, substr

		String name = "mari";

		String newName = "mari";

		name = name + "aaa";

		String name2 = new String("mari");

		println(newName == name2);
		println(newName.equals(name2));

		// String name3 = readLine();

		println(name);
		for (int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);
			println(ch);
		}

		println(name.indexOf("ar"));

		int index = name.indexOf('r');

		name = name.substring(0, index) + name.substring(index + 1);

		println(name);

		// Interface
		// https://docs.google.com/document/d/1g11BWjcUWXw5E16peFSMZz2_Y7lOls7EeFJlzBoa2bA/
		// https://github.com/vashli/MethodologiesSeminarSolutions/blob/main/src/BonusInterface.java
		// https://github.com/vashli/MethodologiesSeminarSolutions/blob/main/src/MidtermBonus.java
		// https://github.com/vashli/MethodologiesSeminarSolutions/blob/main/src/BonusConsole.java

		// File Read / Write
		// Tokenizer

		ArrayList<String> words = new ArrayList<>();
		words.add("cat");
		words.add("dog");
		words.add("school");

		String fileName = "arrayList.txt";

		try {
			BufferedWriter w = new BufferedWriter(new FileWriter(fileName));
			w.write(words.toString());
			w.close();
			// print("here");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			print("error");
			e.printStackTrace();
		}

		try {

			ArrayList<String> copy = new ArrayList<String>();
			BufferedReader r = new BufferedReader(new FileReader(fileName));

			while (true) {
				String line = r.readLine();
				if (line == null)
					break;

				println(line);
				StringTokenizer tokenizer = new StringTokenizer(line, "[], ");
				while (tokenizer.hasMoreTokens()) {
					copy.add(tokenizer.nextToken());

					// Integer.parseInt("7");
				}

			}
			println(copy);
			r.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Sorting

		int[] array = { 7, 1, 2, 3, 4, 5 };

		println(Arrays.toString(array));

		ArrayList<String> arrList = new ArrayList<String>();

		arrList.add("mari");
		arrList.add("aaaa");
		arrList.add("anastasia");
		println(arrList);

		Arrays.sort(array);
		println(Arrays.toString(array));

		Collections.sort(arrList);
		println(arrList);

		Comparator<String> c = Comparator.comparing(String::length);

		c = c.thenComparing(Comparator.naturalOrder()).reversed();
		arrList.sort(c);
		println(arrList);

	}
}
