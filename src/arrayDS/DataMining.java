package arrayDS;


import java.util.*;



public class DataMining {
	private double[] A; 
	DataMining(double[] a){
		 A = a ; 
	}
	
	// for solving the 
	void getBasicStatisticalMeasure() {
		sortData();
		display("sorted:");
		double median = getMedian();
		double mean = getMean();
		System.out.println("the median is : " + median);
		System.out.printf("the mean is:  %.2f " , mean);
		
	}
	


	void sortData() {
		Arrays.sort(A);
	}
	
	double getMedian() {
		int mid = A.length/2;
		// if the amount of numbers is even
		if (A.length % 2 == 0) {
			return (A[mid-1] + A[mid]) / 2;
		}else{
			return A[mid];
		}
	}
	
	double getMean() {
		double sum = 0;
		for (double n : A) {
			sum += n;
		}
		double ave = sum / A.length;
		return ave;
	}
	
//	double getQuartile(int i) {
//		
//		double quar;
//		double midian ;
//		
//		return quar;
//	}
	
	void findMode() {

		for (int i = 0; i < A.length; i++) {
			int count = 0;
			for (int j = 0; j < A.length; j++) {
				if (A[j] == A[i]) {
					count++;
				}
			}
			System.out.println("count of " + A[i] +" is : " + count );
		}
	}
		

	void display(String s) {
		System.out.println(s);
		for (double n : A) {
			System.out.print(n + ", ");
		}
		System.out.println("\n");
	}
	
	void display() {
		
		double sum = 0;
		for (int i = 0; i < A.length; i = i+ 3) {
			sum = 0;
			System.out.println();
			for (int j = i; j< i+ 3; j++) {
				sum += A[j];
				System.out.print(A[j] + ", ");
			}
			System.out.print("mean: " + sum/3 );
			System.out.println();
		}
	}
	
	void minMaxNormalization() {
		
		double min = A[0];
		double max = A[A.length-1];
		double nmin = 0;
		double nmax = 1;
		double vt = 0;
		double ni = nmax - nmin;
		double m = max - min;
		for (double v : A) {
			vt = ((v - min) * ni)  / m;
			System.out.printf(" %.3f , ", vt);
		}
		
	}
	
	void getZscore() {
		double mean = getMean();
		double vt = 0;
		for (double v : A) {
			vt = (v - mean)/12.94;
			System.out.printf(" %.3f ,", vt);
		}
	}

	
	void getDecimal() {
		double d = 100;
		double vt = 0;
		for (double v : A) {
			vt = v / d;
			System.out.printf(" %.3f , ",vt);
		}
	}
	public static void main(String[] args) {
		double[] A = new double[] {13, 15, 16, 16, 19, 20, 20, 21, 22, 22, 25, 25, 25, 25, 30, 33, 33, 35, 35, 35, 35, 36, 40, 45, 46, 52, 70};
		int N = 5;
		double[] B = new double[N];
		
		Random rand = new Random();
		for (int i = 0; i < N ; i++) {
			B[i] = rand.nextInt(30);
		}
		DataMining dm = new DataMining(A);
		dm.display("original");
//		dm.getBasicStatisticalMeasure();
//		dm.sortData();
//		dm.getZscore();
//		dm.minMaxNormalization();
		dm.getDecimal();
		
		
//		Arrays.sort(A);
//		int mid = A.length/2;
//		System.out.println();
//		for (int i = 0 ; i < mid; i ++) {
//			System.out.print(A[i] + " , ");
//		}
//		System.out.println();
//		System.out.print(A[mid]);
//		System.out.println();
//		for (int i = mid+1 ; i < A.length; i ++) {
//			System.out.print(A[i] + " , ");
//		}
//		

	}
	
}
