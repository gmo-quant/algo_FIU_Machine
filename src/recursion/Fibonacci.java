package recursion;

public class Fibonacci {
	
	int fib(int n) {
		if ( 0 == n || 1 == n) {
			return 1;
		}else {
			return fib(n-1) + fib(n-2);
		}
	}
	
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		int i = 0;
		System.out.println(f.fib(i));
	}
}
