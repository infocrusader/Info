

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class upDwn {

	private JFrame frame;
	private JTextField origt;
	private JTextField chant;
	private JTextField sizet;
	public String or="heeey",ch,temp;
	public int si;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					upDwn window = new upDwn();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public upDwn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		origt = new JTextField();
		origt.setBounds(153, 43, 96, 20);
		frame.getContentPane().add(origt);
		origt.setColumns(10);
		
		chant = new JTextField();
		chant.setBounds(153, 102, 96, 20);
		frame.getContentPane().add(chant);
		chant.setColumns(10);
		
		sizet = new JTextField();
		sizet.setBounds(153, 179, 96, 20);
		frame.getContentPane().add(sizet);
		sizet.setColumns(10);
		
		JButton btnNewButton = new JButton("Upper Case");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				or=origt.getText();
				chant.setText(or.toUpperCase());
			}
		});
		btnNewButton.setBounds(295, 42, 110, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Lower Case");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				or=origt.getText();
				chant.setText(or.toLowerCase());
			}
		});
		btnNewButton_1.setBounds(295, 101, 110, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Find Size");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				or=origt.getText();
				sizet.setText(String.valueOf(or.length()));
			}
		});
		btnNewButton_2.setBounds(295, 178, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Original Text");
		lblNewLabel.setBounds(10, 46, 96, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Changed");
		lblNewLabel_1.setBounds(10, 105, 117, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Size");
		lblNewLabel_2.setBounds(10, 182, 96, 14);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
