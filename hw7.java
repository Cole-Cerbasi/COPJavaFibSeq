package cop2805;

class fibRecursive extends Thread{
	
	private int n = 1;
	public fibRecursive(int n) {
		this.n = n;
	}
	
	private int sequence(int n) {
		return n==0||n==1?n:this.sequence(n-1) + this.sequence(n-2);
	}
	
	public void run() {
		//modified to System.nanoTime
		long startTime = System.nanoTime();
		int result = this.sequence(this.n);
		long endTime = System.nanoTime();
		System.out.println(this.n+", Recursive Method: "+result+" in "+(endTime - startTime)+"ns");
	}
}

class fibDynamic extends Thread{
	
	private int n = 1;
	public fibDynamic(int n) {
		this.n = n;
	}
	
	private int sequence(int n) {
		int f = 0; //first
		int s = 1; //second
		int t = 0; //third
		for(int i = 2; i <= n; i++) {
			t = f + s;
			f = s;
			s = t;
		}
		return t;
	}
	
	public void run() {
		//modified to System.nanoTime
		long startTime = System.nanoTime();
		int result = this.sequence(this.n);
		long endTime = System.nanoTime();
		System.out.println(this.n+", Dynamic Method: "+result+" in "+(endTime - startTime)+"ns");
	}
}

public class hw7{
	public static void main(String[] args) {
		
		int[] values = {3, 5, 7, 9, 11};
		
		for(int i = 0; i < values.length; i++) {
			int v = values[i];
			(new fibRecursive(v)).start();
			(new fibDynamic(v)).start();
		}
	}
}
