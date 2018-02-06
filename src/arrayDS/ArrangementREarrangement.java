package arrayDS;

import java.util.*;

public class ArrangementREarrangement {
	/*
	 * questions from geeksforgeeks.com
	 * 
	 * rearrange positive and negative numbers in O(n) time and O(1) extra space
	 * 
	 * An array 
	 * contains both positive and negative numbers 
	 * in random order.
	 * 
	 * Rearrange the array elements 
	 * so that positive and negative numbers 
	 * are placed alternatively.
	 * 
	 * If there are more positive numbers they appear at the end of the array. 
	 * If there are more negative numbers, they too appear in the end of the array.
	 * 
	 * ex. input:
	 * 	 	[-1, 2, -3, 4, 5, 6, -7, 8, 9]
	 * ex. output:
	 * 		[9, -7, 8, -3, 5, -1, 2, 4, 6]
	 * 
	 */
	
	/*
	 * 
	 * two solutions are alike in general, both are trying classify positive and negative first
	 * and use the even/odd index as auxiliary .
	 * 
	 * the difference is 
	 * solution1 sort the array and get the position of the divider.
	 * solution2 use a partition function similar to the one in quick sort, to approach the classification. 
	 */
	
	
	private int[] A;
	private Random rand;
	
	ArrangementREarrangement(int N){
		A = new int[N];
		rand = new Random();
		for (int i = 0; i < N; i++) {
			A[i] = rand.nextInt(20) - 10;
		}
	}
	
	/*
	 * solution 1
	 * 
	 * analysis:
	 * 		think of positive and negative as two category
	 * 
	 *  	so first classify them apart.
	 *  	here elements are integer
	 * 			we can sort the array to classify.  
	 *
	 *   		so that negative numbers will be in the left
	 *   		and positive numbers will be in the right
	 *   	
	 *   	think of a special number 0, it divide positive and negative
	 *   	
	 *   	start from both end of the sorted array, i = 0; n = length of array, 
	 *   		
	 *   
	 *
	 */
	void solution1() {
		display("original");
		classify();
		display("sorted");
		arrange();
		display("rearrange");
	}
	
	void solution2() {
		display("original");
		rearrange();
		display("rearranged");
		
	}

	void arrange(){
		int index = positiveLoc();
		if (index != -1) {
			for (int i = 1, j = index;i < A.length && j < A.length; i= i+2 , j++) {
				swap(i, j);
			}
		}
	}
	
	int positiveLoc() {
		int flag = -1;
		for( int i = 0; i < A.length; i++) {
			if (A[i] >= 0) {
				return i;
			}
		}
		return flag ;
	}
	
	void classify() {
//		classify for solution 1
		Arrays.sort(A);
	}
	

	
	void hoarePartition() {

		
	}
	
	
	void swap(int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
	
	
	/*
	 * solution 2
	 * 
	 * tips from geeksforgeeks.com
	 * 
	 * put positive numbers at even index
	 * and negative numbers at odd index
	 * 
	 * use a partition function to classify positive and negative numbers
	 * this partition function is alike the one used in quicksort
	 * 
	 */
	
	int partition() {		
		// classify for solution 2
		int i = -1;
		for (int j = 0; j < A.length; j++) {
			if (A[j] < 0) {
				i++;
				swap(i, j);
			}
		}
		return i;
	}
	
	void rearrange() {
		int pos = partition();
		pos +=1;
		int neg = 0;
		// increment the negative index by 2 and positive index by 1, 
		//swap every alternate negative number with next positive number
		
		while(pos< A.length && neg < pos && A[neg] < 0) {
			swap(pos, neg);
			pos++;
			neg+=2;
		}
	}
	
	void display(String s) {
		System.out.println(s);
		for (int n : A) {
			System.out.print(n + ", ");
		}
		System.out.println("\n");
	}
	
	public static void main(String[] args) {
		int N = 17;
		ArrangementREarrangement a = new ArrangementREarrangement(N);
		a.solution2();
		
	}
}
