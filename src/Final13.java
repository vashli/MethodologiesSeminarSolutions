import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

//დაწერეთ მეთოდი -  private void randomSort(ArrayList<Integer> list)
//რომელსაც გადაეცემა integer-ების arrayList და რომელიც ამ სიის ელემენტებს გადაალაგებს 
//რანდომ თანმიმდევრობით. ანუ შემთხვევითი მიმდევრობის ამოსვლის ალბათობა ყველა სხვა მიმდევრობასთან შედარებით თანაბარ ალბათური უნდა იყოს.
//Tags: ArrayList, Custom Sort, Random

public class Final13 extends ConsoleProgram {
	RandomGenerator rgen = RandomGenerator.getInstance();

	// test
	public void run() {
		ArrayList<Integer> list = new ArrayList<>(
				Arrays.asList(1, 2, 3));
		
		HashMap<ArrayList<Integer>, Integer> statistics = new HashMap<>();

		for(int i = 0; i < 10000; i++){
			randomSort(list);
	
			ArrayList<Integer> listForMap = new ArrayList<>(list);
			if(!statistics.containsKey(listForMap)){
				statistics.put(listForMap, 1);
			}else{
				statistics.put(listForMap, statistics.get(list) + 1);
			}
		}
		
		for(ArrayList<Integer> key: statistics.keySet()){
			println(key.toString() + ": " + statistics.get(key));
		}
		
	}

	private void randomSort(ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			int j = rgen.nextInt(i, list.size() - 1);
			swap(list, i, j);
		}
	}

	private void swap(ArrayList<Integer> list, int i, int j) {
		int tmp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, tmp);
	}
}