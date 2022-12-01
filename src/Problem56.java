import acm.program.ConsoleProgram;

//56. კონსოლიდან შეგყვავს n და შემდეგ n ცალი მთელი რიცხვი, დაალაგეთ რიცხვები
//ზრდადობით და დაბეჭდეთ.

public class Problem56 extends ConsoleProgram {
	public void run(){
		int n = readInt();
		int[] arr = new int[n];
		
		sort(arr);
		print(arr);
	}

	private void sort(int[] arr) {
		for(int i = 0 ; i < arr.length; i++){
			int minIndex = findMinIndex(arr, i);
			swap(arr, minIndex, i);
		}
	}

	private void swap(int[] arr, int minIndex, int i) {
		int tmp = arr[minIndex];
		arr[minIndex] = arr[i];
		arr[i] = tmp;
	}

	
	private int findMinIndex(int[] arr, int i) {
		if(i > arr.length - 1) return -1;
		int minIndex = i;
		int minValue = arr[i];
		for(int j = i; j < arr.length; j ++) {
			if(arr[j] < minValue){
				minValue = arr[j];
				minIndex = j;
			}
		}
		return minIndex;
	}
}
