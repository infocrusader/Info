import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Assignment1 extends JFrame implements ActionListener {
	private JLabel label1, label2, label3, label4;
	private JTextField text; 
	private JButton buttonAdd, buttonOrder;
	private JRadioButton juice, water, tea, coffee;
	private ButtonGroup group;
	String[] boxItems = {"Small", "Medium", "Large"};
	private JComboBox box = new JComboBox(boxItems);
	ArrayList<beverageHelper> beverageList = new ArrayList<>();

	
	public Assignment1() {
		setLayout(null);
		
		label1 = new JLabel();
		label1.setText("Select size:");
		label1.setSize(100,50);
		label1.setLocation(120, 30);
		add(label1);
		
		label2 = new JLabel();
		label2.setText("Select which type of baverage you want to order:");
		label2.setSize(300,50);
		label2.setLocation(120, 80);
		add(label2);
		
		label3 = new JLabel();
		label3.setText("Select how many glasses you want to order:");
		label3.setSize(300,50);
		label3.setLocation(120, 130);
		add(label3);
		
		text = new JTextField();
		text.setSize(300, 20);
		text.setLocation(120, 170);
		add(text);
		
		buttonAdd = new JButton();
		buttonAdd.setText("Add");
		buttonAdd.setSize(80, 30);
		buttonAdd.setLocation(120, 200);
		buttonAdd.addActionListener(this);
		add(buttonAdd);
		
		buttonOrder = new JButton();
		buttonOrder.setText("Order");
		buttonOrder.setSize(80, 30);
		buttonOrder.setLocation(320, 200);
		buttonOrder.addActionListener(this);
		add(buttonOrder);
		
		group = new ButtonGroup();
		
		juice = new JRadioButton();
		juice.setText("Juice");
		juice.setBounds(120, 120, 70, 20);
		add(juice);
		
		water = new JRadioButton();
		water.setText("Water");
		water.setBounds(190, 120, 70, 20);
		add(water);
		
		tea = new JRadioButton();
		tea.setText("Tea");
		tea.setBounds(260, 120, 50, 20);
		add(tea);
		
		coffee = new JRadioButton();
		coffee.setText("Coffee");
		coffee.setBounds(310, 120, 100, 20);
		add(coffee);
		
		group.add(juice);
		group.add(water);
		group.add(tea);
		group.add(coffee);
		

		box.setBounds(120, 70, 85, 20);
		add(box);
		
		label4 = new JLabel();
		label4.setText("");
		label4.setSize(300, 25);
		label4.setLocation(120, 240);
		add(label4);
		
		setSize(600, 400);
		setVisible(true);
		setTitle("Assignment-1");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(buttonAdd)) {
			if((group.isSelected(null)) && (text.getText().equals(""))) {
				JOptionPane.showMessageDialog(this, "Choose a beverage type and enter an amount.");
			}
			else if (group.isSelected(null)) {
				JOptionPane.showMessageDialog(this, "Choose a beverage type.");
			}
			else if (text.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Enter an amount.");
			}
			
			else {
				String x = (String) box.getSelectedItem().toString();
				double boxCode = 0;
				if(x.equals("Small"))
					boxCode = 0.87;
				else if(x.equals("Medium")) {
					boxCode = 1.13;
				}
				else if(x.equals("Large")) {
					boxCode = 1.25;
				}

				if(juice.isSelected()) {
					double ucret;
					int amount = Integer.parseInt(text.getText());
					Object[] fruits = {"Apple","Orange","Pinapple"};
					JComboBox fruitList = new JComboBox(fruits);
					JLabel fruitLabel = new JLabel();
					fruitLabel.setText("Select a fruit!");
					Object[] obje = {fruitLabel, fruitList};
					JOptionPane.showConfirmDialog(this, obje, "Select a fruit", JOptionPane.OK_CANCEL_OPTION);
					ucret = boxCode * (amount * 1.30) * ((fruitList.getSelectedIndex() + 1) * 0.6);
					beverageList.add(new beverageHelper(amount, "Juice", (String) fruitList.getSelectedItem(), false, ucret));
					label4.setText(beverageList.get(beverageList.size() - 1).toString());
					group.clearSelection();
					text.setText("");
					
					
				}
				
				else if(water.isSelected()) {
					int amount = Integer.parseInt(text.getText());
					int i = JOptionPane.showConfirmDialog(this, "Would you like ice?", "Ice", JOptionPane.YES_NO_OPTION);
					//System.out.println(i); -- Yes is 0, No is 1
					double ucret = 0;
					double iceExtra = 1;
					if(i == 0) {
						iceExtra = 1.35;
						ucret = boxCode * (amount * 1.20) * iceExtra;
						beverageList.add(new beverageHelper(amount, "Water", null, true, ucret));
						label4.setText(beverageList.get(beverageList.size() - 1).toString());
					}
					else if(i == 1) {
						ucret = boxCode * (amount * 1.20) * iceExtra;
						beverageList.add(new beverageHelper(amount, "Water", null, false, ucret));
						label4.setText(beverageList.get(beverageList.size() - 1).toString());
					}
					
					group.clearSelection();
					text.setText("");
				}
				
				else if(tea.isSelected()) {
					int amount = Integer.parseInt(text.getText());
					int i = JOptionPane.showConfirmDialog(this, "Would you like sugar?", "Sugar", JOptionPane.YES_NO_OPTION);
					double ucret = 0;
					double sugarExtra = 1;
					
					if(i == 0) {		
						sugarExtra = 1.50;
						ucret = boxCode * (amount * 1.50) * sugarExtra;
						beverageList.add(new beverageHelper(amount, "Tea", null, true, ucret));
						label4.setText(beverageList.get(beverageList.size() - 1).toString());
					}
					else if(i == 1) {
						ucret = boxCode * (amount * 1.50) * sugarExtra;
						beverageList.add(new beverageHelper(amount, "Tea", null, false, ucret));
						label4.setText(beverageList.get(beverageList.size() - 1).toString());
					}
					
					group.clearSelection();
					text.setText("");
				}
				
				else if(coffee.isSelected()) {
					int amount = Integer.parseInt(text.getText());
					int i = JOptionPane.showConfirmDialog(this, "Would you like milk?", "Milk", JOptionPane.YES_NO_OPTION);
					double ucret = 0;
					double milkExtra = 1;
					
					if(i == 0) {
						milkExtra = 1.65;
						ucret = boxCode * (amount * 1.70) * milkExtra;
						beverageList.add(new beverageHelper(amount, "Coffee", null, true, ucret));
						label4.setText(beverageList.get(beverageList.size() - 1).toString());
					}
					else if(i == 1) {
						ucret = boxCode * (amount * 1.70) * milkExtra;
						beverageList.add(new beverageHelper(amount, "Coffee", null, false, ucret));
						label4.setText(beverageList.get(beverageList.size() - 1).toString());
					}
					
					group.clearSelection();
					text.setText("");
				}
			}
				
		}
		
		else if(e.getSource().equals(buttonOrder)) {
			String message = "";
			double total = 0;
			for (beverageHelper beverageHelper : beverageList) {
				if(beverageHelper.getType().equals("Juice")) {
					message += beverageHelper.getFruit() + " juice   -  " + String.valueOf(Math.round(beverageHelper.getUcret() * 100d) / 100d) + "\n" ;
					total += beverageHelper.getUcret();
				}
				else if(beverageHelper.getType().equals("Water")) {
					if(beverageHelper.isExtra()) {
						message += "water with ice  -  " + String.valueOf(Math.round(beverageHelper.getUcret() * 100d) / 100d) + "\n";
						total += beverageHelper.getUcret();
					}		
					else {
						message += "water  -  " + String.valueOf(Math.round(beverageHelper.getUcret() * 100d) / 100d) + "\n";
						total += beverageHelper.getUcret();
					}
				}
				else if(beverageHelper.getType().equals("Tea")) {
					if(beverageHelper.isExtra()) {
						message += "tea with sugar  -   " + String.valueOf(Math.round(beverageHelper.getUcret() * 100d) / 100d) + "\n";
						total += beverageHelper.getUcret();
					}
						
					else {
						message += "tea  -   " + String.valueOf(Math.round(beverageHelper.getUcret() * 100d) / 100d) + "\n";
						total += beverageHelper.getUcret();
					}
				}
				else if(beverageHelper.getType().equals("Coffee")) {
					if(beverageHelper.isExtra()) {
						message += "coffee with milk  -   " + String.valueOf(Math.round(beverageHelper.getUcret() * 100d) / 100d) + "\n";
						total += beverageHelper.getUcret();
					}
						
					else {
						message += "coffee  -  " + String.valueOf(Math.round(beverageHelper.getUcret() * 100d) / 100d) + "\n";
						total += beverageHelper.getUcret();
					}
				}
				
			}
			JOptionPane.showMessageDialog(this, message);
			JOptionPane.showMessageDialog(this, "You should pay " + String.valueOf(Math.round(total * 100d) / 100d));
		}
		
	}
	
	
	public static void main(String[] args) {
		new Assignment1();
	}

}
