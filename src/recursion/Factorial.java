package recursion;

public class Factorial {
	
	int fact(int n) {
		if ( 0 == n) {
			return 1;
		}else {
			return n * fact(n-1);
		}
	}
	
	void display() {
		
	}
	
	public static void main(String[] args) {
		
		Factorial f = new Factorial();
		int N = 10;
		int m = 1;
		System.out.println("factorial of " + N + " : ");
		for (int i =1; i <= N; i++) {
			m *=i;
		}
		System.out.println(m);
		System.out.println(f.fact(N));
	}
}
