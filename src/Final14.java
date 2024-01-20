import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import acm.program.ConsoleProgram;

//დაწერეთ მეთოდი, რომელსაც გადმოეცემა სტრინგების ლისთი და სორტავს ამ ლისთს სტრინგების სიგრძის მიხედვით კლებადობით
//Tags: Algorithm, Sort, Custom order

public class Final14 extends ConsoleProgram {
	public void run(){
		ArrayList<String> list = new ArrayList<>(
				Arrays.asList("aaa", "z", "bbbb", "zzzz", "111111"));
		
		ArrayList<String> list2 = new ArrayList<>(list);
		
		println(list);
		customSort(list);
		println(list);
		
		customSort2(list2);
		println(list2);
	}
	
	private void customSort(ArrayList<String> list){
		Comparator<String> c = Comparator.comparing(String::length).reversed();
		list.sort(c);
	}
	
	private void customSort2(ArrayList<String> list){
		for(int i = 0; i < list.size(); i++){
			int j = findMinIndex(list, i);
			swap(list, i, j);
		}
	}

	// finds index of min element starting from index i
	// min is longest string in this case
	private int findMinIndex(ArrayList<String> list, int i) {
		int minIndex = i;
		for(int j = i; j < list.size(); j++){
			if(list.get(j).length() > list.get(minIndex).length()){
				minIndex = j;
			}
		}
		return minIndex;
	}
	
	private void swap(ArrayList<String> list, int i, int j) {
		String tmp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, tmp);
	}
}
