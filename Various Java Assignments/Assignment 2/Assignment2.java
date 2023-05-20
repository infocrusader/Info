package src;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Assignment2 extends JFrame implements ActionListener {
	//Below i will define the functions to be used within the program
	private JTextField seatnumber, agent, wait;
	private JButton createseat, book;
	private ArrayList<JTextField> seatList;
	private JPanel panel;
	private ArrayList<Thread> agents = new ArrayList<Thread>();
	private ReentrantLock k = new ReentrantLock();
	private Random random = new Random();
	public ArrayList<Integer> randomNumbers;
	
	//Constructor
	public Assignment2() {
		//Assigning size and position for the seatnumber textfield
		seatnumber = new JTextField();
		seatnumber.setSize(100, 25);
		seatnumber.setLocation(80, 30);
		seatnumber.setText("Number of seats");
		add(seatnumber);
		//Assigning size and position for the Number of agents textfield
		agent = new JTextField();
		agent.setSize(110, 25);
		agent.setLocation(220, 30);
		agent.setText("Number of agents");
		add(agent);
		//Assigning size and psotion for the waiting time text field
		wait = new JTextField();
		wait.setSize(100, 25);
		wait.setLocation(360, 30);
		wait.setText("Maximum waiting time");
		add(wait);
		//Assigning size and position for the create seats button
		createseat = new JButton();
		createseat.setSize(110,25);
		createseat.setLocation(490, 30);
		createseat.setText("Create seats");
		createseat.addActionListener(this);
		add(createseat);
		//Assigning size and position for the booking button
		book = new JButton();
		book.setSize(80,25);
		book.setLocation(630, 30);
		book.setText("Start Booking");
		book.addActionListener(this);
		add(book);
		//Creating a panel within which all previous textfields and buttons will be entered
		panel = new JPanel();
		panel.setLocation(0, 70);
		panel.setSize(800, 800);
		panel.setLayout(new GridLayout(10,0,10,10));
		
		add(panel);
		//Assigning a range of seat variables which will be built in textfield
		seatList = new ArrayList<JTextField>();
		//Mkaing the broad layout of the system
		setLayout(null);
		setTitle("Booking System");
		setSize(900, 1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Creating a recurssive method the creates allocated seats when createseat button is selected
		if(e.getSource().equals(createseat)) {
			panel.setVisible(false);
			int s = Integer.parseInt(seatnumber.getText().trim());
			for(int i=0; i<s; i++) {
				seatList.add(i, new JTextField());
				
				seatList.get(i).setSize(150, 70);
				
				seatList.get(i).setText("Seat Not booked");
				
				
				
				seatList.get(i).setOpaque(true);
				panel.add(seatList.get(i));
							
			}
			panel.setVisible(true);
			
		}
		
		else if(e.getSource().equals(book)) {
			//Creating a recursive method in the instance that the book button is selected
			int b = Integer.parseInt(agent.getText().trim());//Gets number of agents
			int f = Integer.parseInt(wait.getText().trim());//Gets waiting time
			randomNumbers = new ArrayList<Integer>();
			
			for(int i=0; i<b; i++) {
				//Below we will try to avoid a null case
				randomNumbers.add(random.nextInt(f) + 1);
			}
			
			for(int i=0; i<b; i++) {
				agents.add(new Thread(new Runnable() {
					
					@Override
					public void run() {
						//Invoking a book method which we will see below
						book();
					}
				}));
				agents.get(i).start();
			}	
			
}
			       } 
	
	
	public void book() {
		
		
		String b = Thread.currentThread().getName();
		
		     String[] s = b.split("-");
		int sequence = Integer.parseInt(s[1]) - 1;
	for(int i=0; i<seatList.size(); i++) {
			
		
		if(!(seatList.get(i).getBackground().equals(Color.blue))) {
			//Given that the background colour isnt blue this will run
				k.lock();//Reentrant lovk used to lock 
				seatList.get(i).setBackground(Color.blue);//sets colour blue
				seatList.get(i).setText(String.valueOf("Booked by Agent " + sequence));
				k.unlock();//Thread process unlocked
				try {
					//Making current thread sleep calling a random number as its sleep time variable
					Thread.currentThread().sleep(randomNumbers.get(sequence-1));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		if(Thread.currentThread().equals(agents.get(agents.size() - 1))) {
			//If the current thread corresponds with the size of the hindmost agent, invoke pane method
			createPane();
		}
	}
	
	public void createPane() {
		//creating pane method for message display at end of program
		String message = "";
		ArrayList<Integer> paneList = new ArrayList<Integer>();
		int number = 1;
		//for loop according to number of agents
		for(int i=0; i<Integer.parseInt(agent.getText().trim()); i++) {
			paneList.add(0);
		}
		
		while(number<=agents.size()) {
			//Assigning message contents
			message += "Agent " + number + " booked " + BookCount(number) + " seats.\n";
			number++;
		}

		JOptionPane.showMessageDialog(null, message);
	}
	
	
	
	public int BookCount(int x) {
		//Counting the number of seats booked by particular agents
		int count = 0;
		for(int i=0; i<seatList.size(); i++) {//For loop corresponding to the number of seats in the seatList arraylist
			if(seatList.get(i).getText().equals("Booked by Agent " + x)) {
				count++;
			}
		}
		return count;
	}
	

	public static void main(String[] args) {
		//Alows for the program to run
		Assignment2 ass = new Assignment2();
	}
}
