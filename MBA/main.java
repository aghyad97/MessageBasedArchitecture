package lab11;


import java.io.IOException;

public class main {

	public static void main(String[] args) throws IOException {
		
		// Use the Debug class to see what is going on.
		// Will be saved in the project directory 
		// e.g. /Users/izualkernan/eclipse-workspace/Message-Oriented
		
		Debug.tracefile("debugtrace.txt");
		
		// This code should really be in the a class called
		// Application or Game. 
		
		
		// Create a dispatcher 
		Dispatcher d = new Dispatcher();
		
		// Create one proxy object for each piece of end-node hardware 
		// Each proxy reads from System.in
		// but this could be another shared stream that the game 
		// is writing to.
		
		Proxy p1 = new Proxy(System.in, System.out, d);
		Proxy p2 = new Proxy(System.in, System.out, d);
		
	}

}