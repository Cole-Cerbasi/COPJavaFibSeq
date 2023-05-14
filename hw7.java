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
		long startTime = System.currentTimeMillis();
		int result = this.sequence(this.n);
		long endTime = System.currentTimeMillis();
		System.out.println("Recursive Method: "+result+" in "+(endTime - startTime)+"ms");
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
		long startTime = System.currentTimeMillis();
		int result = this.sequence(this.n);
		long endTime = System.currentTimeMillis();
		System.out.println("Dynamic Method: "+result+" in "+(endTime - startTime)+"ms");
	}
}

public class hw7{
	public static void main(String[] args) {
		(new fibRecursive(40)).start();
		(new fibDynamic(40)).start();
	}
}
