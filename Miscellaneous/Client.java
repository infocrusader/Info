package omg;

import java.io.*;
import java.util.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static java.lang.System.out;

public class  Client extends JFrame implements ActionListener {
	//Declaring the variables to be used
	PrintWriter printwriter;
     String ranname;
    JTextArea  textingspace;
    Socket client;
    BufferedReader reader;
     JTextField textfield;
    JButton btnSend,btnExit;
   
    
    public Client(String ranname,String servername) throws Exception {
        super(ranname);  //This will set title for frame
        this.ranname = ranname;
        client  = new Socket(servername,9998);
        reader = new BufferedReader( new InputStreamReader( client.getInputStream()) ) ;
        printwriter = new PrintWriter(client.getOutputStream(),true);
        printwriter.println(ranname);  //This will send name to server
        buildInterface();
        new MessagesThread().start();  //This will create thread for listening for messages
    }
    
    public void buildInterface() {
    	//Setting up buttons,Jtextfield and general frame
        btnSend = new JButton("Send");
        
        btnExit = new JButton("Exit");
        
        textingspace = new JTextArea();
        
        textingspace.setRows(10);
        
        textingspace.setColumns(50);
        
        textingspace.setEditable(false);
        
        textfield  = new JTextField(50);
        
        JScrollPane sp = new JScrollPane(textingspace, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        add(sp,"Center");
        JPanel bp = new JPanel( new FlowLayout());
        bp.add(textfield);
        bp.add(btnSend);
        bp.add(btnExit);
        add(bp,"South");
        btnSend.addActionListener(this);
        btnExit.addActionListener(this);
        setSize(500,300);
        setVisible(true);
        pack();
    }
    
    public void actionPerformed(ActionEvent evt) {
        if ( evt.getSource() == btnExit ) {
            printwriter.println("end");  //This will send end to server so that the server will know about the termination
            System.exit(0);
        } else {
            //This will send message to server
            printwriter.println(textfield.getText());
        }
    }
    
    public static void main(String ... args) {
    
        // This takes username from the user
        String name = JOptionPane.showInputDialog(null,"Console name? :", "Username",
             JOptionPane.PLAIN_MESSAGE);
        String servername = "localhost"; 
        //Try Catch when all needed are fulfilled and incase of error
        try {
            new Client( name ,servername);
        } catch(Exception ex) {
            out.println( "Error --> " + ex.getMessage());
        }
        
    } 
    
    // This is the inner class for Messages Thread
    class  MessagesThread extends Thread {
        public void run() {
            String line;
            try {
                while(true) {
                    line = reader.readLine();
                    textingspace.append(line + "\n");
                } 
            } catch(Exception ex) {}
        }
    }
}