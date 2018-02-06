package arrayDS;

import java.util.Arrays;
import java.util.Random;

public class SortArrayInWaveForm {

	
	/*
	 * questions from geeksforgeeks.com
	 * 
	 * given an unsorted array
	 * sort the array into a wave like array
	 * Examples:

// Input:  arr[] = {10, 5, 6, 3, 2, 20, 100, 80}
// Output: arr[] = {10, 5, 6, 2, 20, 3, 100, 80} OR
//                 {20, 5, 10, 2, 80, 6, 100, 3} OR
//                 any other array that is in wave form
//
// Input:  arr[] = {20, 10, 8, 6, 4, 2}
// Output: arr[] = {20, 8, 10, 4, 6, 2} OR
//                 {10, 8, 20, 2, 6, 4} OR
//                 any other array that is in wave form
//
// Input:  arr[] = {2, 4, 6, 8, 10, 20}
// Output: arr[] = {4, 2, 8, 6, 20, 10} OR
//                 any other array that is in wave form
//
// Input:  arr[] = {3, 6, 5, 10, 7, 20}
// Output: arr[] = {6, 3, 10, 5, 20, 7} OR
//                 any other array that is in wave form
	 */
	
	private int[] A;
	private Random rand;
	
	SortArrayInWaveForm(int N){
		A = new int[N];
		rand = new Random();
		for (int i = 0; i < N; i++) {
			A[i] = rand.nextInt(20) ;
		}
	}
	
	void doesnotwork_solution1() {
		// in some cases, there will be " 15, 2, [ 4, 4 ], 13, 3, 15, 4, 16,"
		int i, j, k;
		for ( i = 0; i+ 2 < A.length; i+=2) {
			if (A[i] <= A[i+1]) {
				swap(i, i+1);
			}
			if (A[i+1] >= A[i+2]) {
				swap(i+1, i+2);
			}
		}
	}
	
	void doesnotwork_solution2() {
		// same problem as solution1
		Arrays.sort(A);
		for (int i = 0; i < A.length -1; i+=2) {
			swap(i, i+1);
		}
		
	}
	
	void swap(int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
	
	void display(String s) {
		System.out.println(s);
		for (int n : A) {
			System.out.print(n + ", ");
		}
		System.out.println("\n");
	}
	
	public static void main(String[] args) {
		SortArrayInWaveForm s = new SortArrayInWaveForm(30);
		s.display("original");
//		s.solution2();
		s.display("wave sorted");
	}
}
