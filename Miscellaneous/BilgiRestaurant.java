package SimpleGUI;

import javax.swing.JOptionPane;

public class BilgiRestaurant extends javax.swing.JFrame {
//Creating new form BilgiRestaurant
public BilgiRestaurant() {
contents();
}


@SuppressWarnings("unchecked")
// <editor-fold defaultstate="collapsed" desc="Generated Code">
public void contents() {
//Declaring combobox, jtextfield and buttons
	jButton1 = new javax.swing.JButton();

	jButton2 = new javax.swing.JButton();	
	
	
jComboBox2 = new javax.swing.JComboBox<>();

jTextField1 = new javax.swing.JTextField();



setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//Adding label info and contents
jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cost", "Food cost", "Dessert cost", "Beverage cost" }));
jComboBox2.addActionListener(new java.awt.event.ActionListener() {
	
public void actionPerformed(java.awt.event.ActionEvent evt) {
jComboBox2ActionPerformed(evt);
}});
//Details for button shape and font, also what happens upon pressing
jButton1.setFont(new java.awt.Font("Tahoma", 4, 12)); // NOI18N
jButton1.setText("Order");
jButton1.addActionListener(new java.awt.event.ActionListener() {
	
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton1ActionPerformed(evt);
}
});

jButton2.setText("Finalize");
jButton2.addActionListener(new java.awt.event.ActionListener() {
	
public void actionPerformed(java.awt.event.ActionEvent evt) {
jButton2ActionPerformed(evt);
}
});
//Code concerning panel look,inserting contents, button spacing etc
javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
getContentPane().setLayout(layout);
layout.setHorizontalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(141, 141, 141).addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE).addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(26, 26, 26))
.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
.addComponent(jButton1)
.addComponent(jButton2))
.addGap(101, 101, 101)));
layout.setVerticalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup().addGap(114, 114, 114).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
.addGap(70, 70, 70)
.addComponent(jButton1)
.addGap(18, 18, 18)
.addComponent(jButton2)
.addContainerGap(36, Short.MAX_VALUE)));

pack();
}

// </editor-fold>

private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt){  
	
}

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {   
// TODO add your handling code here:
	dispose();
	Order order = new Order();
	order.setVisible(true);
}
//What happens upon selecting "finalize"
private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {   
// TODO add your handling code here:
dispose();
Order order = new Order();
order.setVisible(true);
String s = (String) jComboBox2.getSelectedItem();
//get the selected item
double price;

switch (s) {//check for a match
    case "Cost":
        price = 1.1;
        JOptionPane.showMessageDialog(null,"Cost selected, price:" + price);
        break;
    case "Food cost":
        price = 2.2;
        JOptionPane.showMessageDialog(null,"Food Cost selected, price:" + price);
        break;
    case "Dessert cost":
        price = 3.3;
        JOptionPane.showMessageDialog(null,"Dessert Cost selected, price:" + price);
        break;
    case "Beverage cost":
        price = 3.3;
        JOptionPane.showMessageDialog(null,"Beverage Cost selected, price:" + price);
        break;
    default:
        price = 0.0;
        JOptionPane.showMessageDialog(null,"Thanks for nothing, price:" + price);
        break;   
}}
// Catching null exceptions for UI manager
public static void main(String args[]) {
	
 try{
	 
   for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()){
	   
if ("Nimbus".equals(info.getName())){
	
javax.swing.UIManager.setLookAndFeel(info.getClassName());
break;}}
} catch (ClassNotFoundException ex) {
java.util.logging.Logger.getLogger(BilgiRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (InstantiationException ex) {
java.util.logging.Logger.getLogger(BilgiRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (IllegalAccessException ex) {
java.util.logging.Logger.getLogger(BilgiRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (javax.swing.UnsupportedLookAndFeelException ex) {
java.util.logging.Logger.getLogger(BilgiRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
}
//</editor-fold>

// creating and displaying the field
java.awt.EventQueue.invokeLater(new Runnable() {
//Executable	
public void run() {
new BilgiRestaurant().setVisible(true);}});}

// Here i will declare all variables  
private javax.swing.JButton jButton1;
private javax.swing.JButton jButton2;
private javax.swing.JComboBox<String> jComboBox2;
private javax.swing.JTextField jTextField1;
  
}