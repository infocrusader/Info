package omg;


import java.io.*;
import java.util.*;
import java.net.*;


public class  Server {
	//Below i will implement functions for handling the number of users and clients
Vector<String> users = new Vector<String>();
Vector<ClientHandler> clients = new Vector<ClientHandler>();

public void process() throws Exception{
	
   ServerSocket server = new ServerSocket(9998,10);
   
   while( true){
		 Socket client = server.accept();
		 ClientHandler f = new ClientHandler(client);
		 clients.add(f);
  }  
}
public static void main(String ... args) throws Exception {
   new Server().process();//invokes new server satisfying the process method
} 

public void broadcast(String user, String message)  {
	    // It will send message to all connected users
	    for ( ClientHandler c : clients )
	       if ( ! c.getUserName().equals(user) )
	          c.sendMessage(user,message);
}

class  ClientHandler extends Thread {
     String name = "";
     
	BufferedReader input;
	
	PrintWriter output;

	public ClientHandler(Socket  client) throws Exception {
      //Here we get input and output streams
	 input = new BufferedReader( new InputStreamReader( client.getInputStream())) ;
	 output = new PrintWriter ( client.getOutputStream(),true);
	 //Here we read name
	 name  = input.readLine();
	 users.add(name); //Here we add to vector
	 start();
     }
//constructor
     public void sendMessage(String ranname,String  msg)  {
	    output.println( ranname + ":" + msg);
	}
		
     public String getUserName() {  
         return name; 
     }
     public void run()  {
 	     String line;
	     try    {
             while(true){
            	 
		 line = input.readLine();
		 if ( line.equals("end") ) {//if line is equal to end remove respective clients and user
		   clients.remove(this);
		   users.remove(name);
		   break;
              }
		 broadcast(name,line); //This method  of the outer class will send messages to all
	       } 
	     } 
	     catch(Exception ex) {
	       System.out.println(ex.getMessage());
	     }
     } 
} 

} 