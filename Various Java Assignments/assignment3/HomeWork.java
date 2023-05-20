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

//Below i declare variable type and Assign their names
public class HomeWork extends JFrame implements ActionListener {
	private JLabel FirstLabel, SecondLabel, ThirdLabel, FourthLabel;
	
	private JTextField Type;
	
	private JButton buttonAdd, buttonOrder;
	
	private JRadioButton juice, water, tea, coffee;
	
	private ButtonGroup collection;
	
	String[] SizeSelection = {"Small", "Medium", "Large"};
	
	ArrayList<AidClass> beverageList = new ArrayList<>()
			;
	private JComboBox box = new JComboBox(SizeSelection);
	

	
	public HomeWork() {
		
		//Below i set the size,text and location of the first label
		setLayout(null);
		FirstLabel = new JLabel();
		FirstLabel.setText("Select size:");
		FirstLabel.setSize(100,50);
		FirstLabel.setLocation(120, 30);
		add(FirstLabel);
		//Below i set the size,text and location of the second label
		SecondLabel = new JLabel();
		SecondLabel.setText("Please Select What You Would Like To Drink");
		SecondLabel.setSize(300,50);
		SecondLabel.setLocation(120, 80);
		add(SecondLabel);
		//Below i set the size, text and location of the third label
		ThirdLabel = new JLabel();
		ThirdLabel.setText("Select how many glasses you want to order:");
		ThirdLabel.setSize(300,50);
		ThirdLabel.setLocation(120, 130);
		add(ThirdLabel);
		//Below i set the textfield where user writes what he/she wants
		Type = new JTextField();
		Type.setSize(300, 20);
		Type.setLocation(120, 170);
		add(Type);
		//Below i set the size location and text of both the add and order buttons
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
		//Below i will create the water,juice,coffee and tea buttons and afterwards add
		collection = new ButtonGroup();
		
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
		
		collection.add(coffee);
		collection.add(water);
		collection.add(juice);
		collection.add(tea);
		
		//Below i exact the box cordinates. the size text and location of foruth label and the peculariaties of the panel that will contain everything

		box.setBounds(120, 70, 85, 20);
		add(box);
		
		FourthLabel = new JLabel();
		FourthLabel.setText("");
		FourthLabel.setSize(300, 25);
		FourthLabel.setLocation(120, 240);
		add(FourthLabel);
		
		
		
		setSize(600, 400);
		setVisible(true);
		setTitle("Beverage System");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
//Below i exact the path the program will take when collection button is selected
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource().equals(buttonAdd)){
			
			if((collection.isSelected(null)) && (Type.getText().equals(""))) {
				JOptionPane.showMessageDialog(this, "Select Your Beverage Of Choice And Respective Price");
			}
			else if (collection.isSelected(null)) {
				JOptionPane.showMessageDialog(this, "Select Your Beverage Of Choice");
			}
			else if (Type.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Enter The Amount.");
			}
			//Below will pop up after user has selected his drink 
			else {
				String x = (String) box.getSelectedItem().toString();
				double IncAmount = 0;
				
				if(x.equals("Small"))
					IncAmount = 0.87;
				
				else if(x.equals("Medium")) {
					IncAmount = 1.20;
				}
				else if(x.equals("Large")) {
					IncAmount = 1.25;
				}
//below i code the information panel that will pop up and require the user to select a fruit,
				if(juice.isSelected()) {
					double collect;
					
					int sum = Integer.parseInt(Type.getText());
					
					Object[] fruits = {"Guava","Orange","Mango"};
					
					JComboBox fruitList = new JComboBox(fruits);
					
					JLabel fruitLabel = new JLabel();
					
					fruitLabel.setText("Select a fruit!");
					
					Object[] obje = {fruitLabel, fruitList};
					
					JOptionPane.showConfirmDialog(this, obje, "Select a fruit", JOptionPane.OK_CANCEL_OPTION);
					
					collect = IncAmount * (sum * 1.30) * ((fruitList.getSelectedIndex() + 1) * 0.6);
					beverageList.add(new AidClass(sum, "Juice", (String) fruitList.getSelectedItem(), collect , false));
					FourthLabel.setText(beverageList.get(beverageList.size() - 1).toString());
					collection.clearSelection();
					Type.setText("");
					
					
				}
				//below i write the path the code will take whem=n water button is selected,couple with the information panel asking for ice and the calculation for price depending on size
				else if(water.isSelected()) {
					int sum = Integer.parseInt(Type.getText());
					double collect = 0;
					double more = 1;
					int i = JOptionPane.showConfirmDialog(this, "Do You Want Ice With That?", "Ice", JOptionPane.YES_NO_OPTION);
					
					if(i == 0) {
						more = 1.45;
						collect = IncAmount * (sum * 1.20) * more;
						beverageList.add(new AidClass(sum, "Water", null, collect, true));
						FourthLabel.setText(beverageList.get(beverageList.size() - 1).toString());
					}
					else if(i == 1) {
						collect = IncAmount * (sum * 1.20) * more;
						beverageList.add(new AidClass(sum, "Water", null, collect, false));
						FourthLabel.setText(beverageList.get(beverageList.size() - 1).toString());
					}
					
					collection.clearSelection();
					Type.setText("");
				}
				//below i write the path the code will take when the tea button coupled with information pannel and neccessary calcs  on price 
				else if(tea.isSelected()) {
					int sum = Integer.parseInt(Type.getText());
					int i = JOptionPane.showConfirmDialog(this, "Do You Want Sugar With That?", "Sugar", JOptionPane.YES_NO_OPTION);
					double collect = 0;
					double more = 1;
					
					if(i == 0) {		
						more = 1.45;
						collect = IncAmount * (sum * 1.60) * more;
						beverageList.add(new AidClass(sum, "Tea", null, collect , true));
						FourthLabel.setText(beverageList.get(beverageList.size() - 1).toString());
					}
					else if(i == 1) {
						collect = IncAmount * (sum * 1.60) * more;
						beverageList.add(new AidClass(sum, "Tea", null, collect , false));
						FourthLabel.setText(beverageList.get(beverageList.size() - 1).toString());
					}
					
					collection.clearSelection();
					Type.setText("");
				}
				//I do fro coffee what i did for previous buttons
				else if(coffee.isSelected()) {
					int sum = Integer.parseInt(Type.getText());
					int i = JOptionPane.showConfirmDialog(this, "Do You Want Milk With That?", "Milk", JOptionPane.YES_NO_OPTION);
					double more = 1;
					double collect = 0;
					
					
					if(i == 0) {
						more = 1.65;
						collect = IncAmount * (sum * 1.79) * more;
						beverageList.add(new AidClass(sum, "Coffee", null, collect , true));
						FourthLabel.setText(beverageList.get(beverageList.size() - 1).toString());
					}
					else if(i == 1) {
						collect = IncAmount * (sum * 1.76) * more;
						beverageList.add(new AidClass(sum, "Coffee", null, collect , false));
						FourthLabel.setText(beverageList.get(beverageList.size() - 1).toString());
					}
					
					collection.clearSelection();
					Type.setText("");
				}
			}
				
		}
		//Below i write the code for compiling the various orders and obtaining a receipt
		else if(e.getSource().equals(buttonOrder)){
			double Summation = 0;
			String relay = "";
		
			for (AidClass Aidclass : beverageList) {
				if(AidClass.getType().equals("Juice")) {
					relay += AidClass.getFruit() + " juice   -  " + String.valueOf(Math.round(AidClass.getcollect() * 100d) / 100d) + "\n" ;
					Summation += AidClass.getcollect();
				}
				else if(AidClass.getType().equals("Water")) {
					if(AidClass.Extra()) {
						relay += "Water with added ice  -  " + String.valueOf(Math.round(AidClass.getcollect() * 100d) / 100d) + "\n";
						Summation += AidClass.getcollect();
					}		
					else {
						relay += "water  -  " + String.valueOf(Math.round(AidClass.getcollect() * 100d) / 100d) + "\n";
						Summation += AidClass.getcollect();
					}
				}
				else if(AidClass.getType().equals("Tea")) {
					if(AidClass.Extra()) {
						relay += "tea with added sugar  -   " + String.valueOf(Math.round(AidClass.getcollect() * 100d) / 100d) + "\n";
						Summation += AidClass.getcollect();
					}
						
					else {
						relay += "tea  -   " + String.valueOf(Math.round(AidClass.getcollect() * 100d) / 100d) + "\n";
						Summation += AidClass.getcollect();
					}
				}
				else if(AidClass.getType().equals("Coffee")) {
					if(AidClass.Extra()) {
						relay += "coffee with added milk  -   " + String.valueOf(Math.round(AidClass.getcollect() * 100d) / 100d) + "\n";
						Summation += AidClass.getcollect();
					}
						
					else {
						relay += "coffee  -  " + String.valueOf(Math.round(AidClass.getcollect() * 100d) / 100d) + "\n";
						Summation += AidClass.getcollect();
					}
				}
				
			}
			// This will be the receipt relayed to the user and the message shown with price
			JOptionPane.showMessageDialog(this, relay);
			
			JOptionPane.showMessageDialog(this, "You should pay " + String.valueOf(Math.round(Summation * 100d) / 100d));
		}
		
	}
	
	
	public static void main(String[] args) {
		new HomeWork();
	}

}
