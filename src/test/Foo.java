package test;

public class Foo extends Thread{
	
	private int val; 
	
	public Foo(int v){ 
		val = v; 
	} 
	
	public synchronized void printVal(int v){ 
//		while(true) 
		for (int i = 0; i < 10; i++) {
			System.out.println(v); 
		}
	} 
	
	public void run(){
		printVal(val); 
	} 
	
}
