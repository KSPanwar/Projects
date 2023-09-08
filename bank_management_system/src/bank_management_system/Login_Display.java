package bank_management_system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Login_Display extends JFrame implements ActionListener {
	JButton deposit,fast_cash,pin_change,cash_withdrawal,mini_statement,balance_enquiry,exit;
	String pinnumber;
	Login_Display(String pinnumber){
		this.pinnumber=pinnumber;
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		setSize(600,600);
		setLocation(330,30);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,600,600);
		add(image);
		JLabel heading = new JLabel("Please select your Transaction");
		heading.setBounds(140,200,200,30);
		heading.setForeground(Color.WHITE);
		image.add(heading);
		
		deposit = new JButton("Deposit");
		deposit.setBackground(Color.GRAY);
		deposit.setForeground(Color.BLACK);
		deposit.setBounds(100,280,110,15);
		deposit.addActionListener(this);
		image.add(deposit);
		
		cash_withdrawal = new JButton("Cash Withdrawal");
		cash_withdrawal.setBackground(Color.GRAY);
		cash_withdrawal.setForeground(Color.BLACK);
		cash_withdrawal.setBounds(205,280,140,15);
		cash_withdrawal.addActionListener(this);
		image.add(cash_withdrawal);
		
		fast_cash= new JButton("Fast Cash");
		fast_cash.setBackground(Color.GRAY);
		fast_cash.setForeground(Color.BLACK);
		fast_cash.setBounds(100,300,110,15);
		fast_cash.addActionListener(this);
		image.add(fast_cash);
		
		mini_statement = new JButton("Mini Statement");
		mini_statement.setBackground(Color.GRAY);
		mini_statement.setForeground(Color.BLACK);
		mini_statement.setBounds(205,300,140,15);
		mini_statement.addActionListener(this);
		image.add(mini_statement);
		
		pin_change= new JButton("Pin Change");
		pin_change.setBackground(Color.GRAY);
		pin_change.setForeground(Color.BLACK);
		pin_change.setBounds(100,320,110,15);
		pin_change.addActionListener(this);
		image.add(pin_change);
		
		balance_enquiry= new JButton("Balance Enquiry");
		balance_enquiry.setBackground(Color.GRAY);
		balance_enquiry.setForeground(Color.BLACK);
		balance_enquiry.setBounds(205,320,140,15);
		balance_enquiry.addActionListener(this);
		image.add(balance_enquiry);
		
		exit= new JButton("Exit");
		exit.setBackground(Color.GRAY);
		exit.setForeground(Color.BLACK);
		exit.setBounds(205,340,140,15);
		exit.addActionListener(this);
		image.add(exit);
		
		ButtonGroup trans = new ButtonGroup();
		trans.add(balance_enquiry);
		trans.add(cash_withdrawal);
		trans.add(deposit);
		trans.add(fast_cash);
		trans.add(mini_statement);
		trans.add(pin_change);
		trans.add(exit);
		
	}
	public void actionPerformed(ActionEvent ae) {
		String pinnumber2= pinnumber;
		if(ae.getSource()== exit) {
			System.exit(0);
		}else if(ae.getSource()==deposit){
			setVisible(false);
			new deposit(pinnumber2).setVisible(true); 
		}
		
	}
	
	public static void main(String[] args) {
		
		new Login_Display("");

	}

}
