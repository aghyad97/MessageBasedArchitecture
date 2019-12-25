package lab11;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Proxy implements Runnable {
	
	InputStream in;
	OutputStream out;
	Dispatcher d;

	Proxy(InputStream in, OutputStream out, Dispatcher d) throws IOException{
		
		// setup input and output streams
		this.in = new BufferedInputStream(in);
		this.out = new BufferedOutputStream(out);
		this.d = d;
		
		//register yourself as a proxy with the dispatcher
		d.register(this);
		
		//start your thread
		new Thread(this).start();
	}
	void send_msg(msg m) throws IOException {
	   // tell the dispatcher to send your message
       d.send_msg(this, m);
	}
	
	msg get_msg() {
		
		// does this really make sense?
		// do you need this message?
		
		return d.get_msg(this);
	}
	
	public void run() {		
		byte b; 
		while(true) {
		
		// logic of proxy here
		// this on is implementing simple 
		// forwarding of message to the dispacher
			
		try {
			if(in.available()>0) {
				
				// read a byte from the input stream
				// this will come from the Application or the Game class.
				
				b = (byte) in.read();
				
				Debug.trace(this+" sending "+b+" to the dispatcher");
				
				// just send to out the dispatcher
				d.send_msg(this,new msg(b));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
			
			
		}
		
	}
	public void process_message(msg msg) throws IOException {
		
        // call-back function -- will be called by dispatcher 
		// then decide to do what with the incoming message
		
	    Debug.trace("Message "+msg.value+" received by "+this+" from dispacher");
		
	}

}