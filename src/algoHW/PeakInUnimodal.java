package algoHW;
import java.util.Collections;
import java.util.ArrayList;

public class PeakInUnimodal {
	
	private int[] A;

	PeakInUnimodal(int N){
		// generate unique random numbers 
		// by using collection.
		
		ArrayList<Integer> numbers = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			numbers.add(new Integer(i));
		}
		Collections.shuffle(numbers);
		int i = 0;
		A = new int[N];
		for (Integer n : numbers) {
			A[i++] = n.intValue();
		}
	}
	
	void display() {
		System.out.println();
		for (int n: A) {
			System.out.print(n + " , ");
		}
		System.out.println();
	}
	
	
	static void tester(int N) {
		PeakInUnimodal piu = new PeakInUnimodal(N);
		piu.display();
	}
	public static void main(String[] args) {
		tester(40);
	}
	
}
