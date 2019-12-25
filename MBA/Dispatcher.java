package lab11;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Dispatcher implements Runnable {

	// need to keep track of proxies 
	
	ArrayList<Proxy> proxies;
	Random r = new Random();
	
	
	Dispatcher(){
		
		//create an array list to remember proxies 
		
		proxies = new ArrayList<Proxy>();
		
		//start the thread
		new Thread(this).start();
	}
	
	
	public void send_msg(Proxy proxy, msg m) throws IOException {
		
        // this message should be sent out to the appropriate hardware 
		// resource 
		Debug.trace("Dispatcher: Message m="+m.value+" received from "+proxy);
		
		// decode the message and send to the right person.
		// should look like a switch statement
		/*
		switch(msg.get_id()) {
		  case 0:
		    // send msg.get_payload() to hardware edge node 0
		    break;
		  case 1:
		    // send send msg.get_payload() to hardware edge node 1
		    break;
		  default:
		    // code block
		}
		*/
	}

	public msg get_msg(Proxy proxy) {
		return null;
	    // receive a message 
		// do you really need this?
		
	}

	@Override
	public void run() {
		// look for messages from the hardware
		// when message arrives figure out who is the message
		// intended for and send them the message
		
		// we will use a call_back to send the message back. 
		// hard-coded to the first element of the proxies list
		// change this to decode the message to figure out 
		// who should get the message. 
		
		while(true) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//should read and decode the message and figure out
			//the index of the proxy the message is intended for 
			//the index has been hard-coded to 0 here. 
			
			try {
				
				// call the process_message call back on the appropriate
				// proxy object with a random message 
				
				if (proxies.size()>0)
				proxies.get(0).process_message(new msg((byte)r.nextInt()));
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
			
		}
		

	public void register(Proxy proxy) throws IOException {
		
		// add a new proxy to your list of known proxies
		Debug.trace("Adding "+proxy+" to list of proxies known to "+this);
	    
		proxies.add(proxy);
	}

}