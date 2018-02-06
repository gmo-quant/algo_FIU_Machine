package arrayDS;

import java.util.*;

public class Reverse {

	/*
	 * questions from geeksforgeeks.com
	 * 
	 * reverse the given array or string
	 * 
	 * analysis:
	 * 
	 */
	
	private int[] A;
	private Random rand;
	
	Reverse(int N){
		A = new int[N];
		rand = new Random();
		for (int i = 0; i < N; i++) {
			A[i] = rand.nextInt(20) - 10;
		}
	}
	
	/*
	 * solution 1.
	 * 
	 * iterative manner.
	 * 
	 * to reverse an array, swap the elements of the array symmetrically respect to the middle of the array
	 */
	void solution1() {
		int mid = A.length/2;
		for (int i = 0; i < mid; i++) {
			swap(i, A.length-1-i);
		}
	}
	
	void swap(int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
	/*
	 * solution 2
	 * 
	 * recurrence manner
	 * 
	 * 
	 * 
	 */
	void solution2() {
		recursion(0, A.length-1);
	}
	void recursion(int start, int end) {
		if (start >= end) {
			return;
		}
		swap(start, end);
		recursion(start+1, end-1);
	}
	
	
	void display(String s) {
		System.out.println(s);
		for (int n : A) {
			System.out.print(n + ", ");
		}
		System.out.println("\n");
	}
	
	

	
	public static void main(String[] args) {
		int N = 11;
		Reverse r = new Reverse(N);
		r.display("original");
		r.solution2();
		r.display("revesed");
	}
}
