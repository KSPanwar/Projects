package bank_management_system;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class account_details extends JFrame implements ActionListener {
	JLabel acctype,heading,cardnum,pin,servicer,ctext,ptext,cardsample,pinsample;
	JCheckBox atm,mobile,internet,email,cheque,estatement,declaration;
	JRadioButton saccount,fdaccount,caccount,rdaccount;
	JButton submit,cancel;
	String sformno;
	account_details(String sformno){
		this.sformno = sformno;
		setSize(700,700);
		setVisible(true);
		setLocation(250,20);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		heading = new JLabel("PAGE 3 : ACCOUNT DETAILS");
		heading.setFont(new Font("Osward",Font.BOLD,20));
		heading.setBounds(230,20,300,40);
		add(heading);
		
		acctype = new JLabel("Account Type :");
		acctype.setFont(new Font("Osward",Font.BOLD,15));
		acctype.setBounds(40,90,150,20);
		add(acctype);
		
		saccount = new JRadioButton("Saving Account");
		saccount.setFont(new Font("Osward",Font.BOLD,10));
		saccount.setBackground(Color.WHITE);
		saccount.setBounds(40,130,150,12);
		add(saccount);
		
		fdaccount = new JRadioButton("Fixed Deposit Account");
		fdaccount.setFont(new Font("Osward",Font.BOLD,10));
		fdaccount.setBackground(Color.WHITE);
		fdaccount.setBounds(240,130,150,12);
		add(fdaccount);
		
		caccount = new JRadioButton("Current Account");
		caccount.setFont(new Font("Osward",Font.BOLD,10));
		caccount.setBackground(Color.WHITE);
		caccount.setBounds(40,170,150,12);
		add(caccount);
		
		rdaccount = new JRadioButton("Recurring Deposit Account");
		rdaccount.setFont(new Font("Osward",Font.BOLD,10));
		rdaccount.setBackground(Color.WHITE);
		rdaccount.setBounds(240,170,250,12);
		add(rdaccount);
		
		ButtonGroup account = new ButtonGroup();
		account.add(saccount);
		account.add(fdaccount);
		account.add(caccount);
		account.add(rdaccount);
		
		cardnum = new JLabel("Card Number:");
		cardnum.setFont(new Font("Osward",Font.BOLD,15));
		cardnum.setBounds(40,220,150,20);
		add(cardnum);
		
		cardsample = new JLabel("XXXX-XXXX-XXXX-2456");
		cardsample.setFont(new Font("Osward",Font.BOLD,15));
		cardsample.setBounds(180,220,200,20);
		add(cardsample);
		
		ctext= new JLabel("Your 14 Digit Card Number");
		ctext.setFont(new Font("Osward",Font.PLAIN,10));
		ctext.setBounds(40,235,150,20);
		add(ctext);
		
		pin = new JLabel("PIN :");
		pin.setFont(new Font("Osward",Font.BOLD,15));
		pin.setBounds(40,265,150,20);
		add(pin);
		
		pinsample = new JLabel("XXXX");
		pinsample.setFont(new Font("Osward",Font.BOLD,15));
		pinsample.setBounds(180,265,150,20);
		add(pinsample);
		
		ptext= new JLabel("Your 4 Digit Password");
		ptext.setFont(new Font("Osward",Font.PLAIN,10));
		ptext.setBounds(40,280,150,20);
		add(ptext);
		
		servicer = new JLabel("Servcies Required :");
		servicer.setFont(new Font("Osward",Font.BOLD,15));
		servicer.setBounds(40,320,150,20);
		add(servicer);
		
		atm = new JCheckBox("ATM CARD");
		atm.setFont(new Font("Osward",Font.PLAIN,10));
		atm.setBackground(Color.WHITE);
		atm.setBounds(40,360,150,12);
		add(atm);
		
		internet = new JCheckBox("Internet Banking");
		internet.setFont(new Font("Osward",Font.PLAIN,10));
		internet.setBackground(Color.WHITE);
		internet.setBounds(240,360,150,12);
		add(internet);
		
		mobile = new JCheckBox("Mobile Banking");
		mobile.setFont(new Font("Osward",Font.PLAIN,10));
		mobile.setBackground(Color.WHITE);
		mobile.setBounds(40,400,150,12);
		add(mobile);
		
		email = new JCheckBox("EMAIL & SMS Alerts");
		email.setFont(new Font("Osward",Font.PLAIN,10));
		email.setBackground(Color.WHITE);
		email.setBounds(240,400,150,12);
		add(email);
		
		cheque = new JCheckBox("Cheque Book");
		cheque.setFont(new Font("Osward",Font.PLAIN,10));
		cheque.setBackground(Color.WHITE);
		cheque.setBounds(40,440,150,12);
		add(cheque);
		
		estatement = new JCheckBox("E-Statment");
		estatement.setFont(new Font("Osward",Font.PLAIN,10));
		estatement.setBackground(Color.WHITE);
		estatement.setBounds(240,440,150,12);
		add(estatement);
		
		declaration = new JCheckBox("I hereby declares that the above entered details are correct by the best of my knowledge");
		declaration.setFont(new Font("Osward",Font.PLAIN,10));
		declaration.setBackground(Color.WHITE);
		declaration.setBounds(40,500,550,12);
		add(declaration);
		
		submit = new JButton("Submit");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setBounds(100,530,100,20);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.setBounds(250,530,100,20);
		add(cancel);
		
	}
	public void actionPerformed(ActionEvent ae) {
		
		if (ae.getSource()==submit) { 
			String formno = sformno;
			 String acselected = null;
			 if(saccount.isSelected()) {
				 acselected = "Saving Account";
			 }else if(fdaccount.isSelected()) {
				 acselected = "Fixed Deposit Account";
			 }else if(caccount.isSelected()) {
				 acselected = "Current Account";
			 }else if(rdaccount.isSelected()) {
				 acselected = "Recurring Deposit Account";
			 }
			 
			 Random ran = new Random();
			 
			 String cardnumber = "" + Math.abs((ran.nextLong()% 90000000L) + 1234567800000000L);
			 String pinnumber = "" + Math.abs((ran.nextLong() % 9000L) + 1000L);
			 
			 String facility = "";
			 if(atm.isSelected()) {
				 facility = facility + "ATM Card";
			 }else if(internet.isSelected()) {
				facility = facility + " Internet Banking";
			 }else if(mobile.isSelected()) {
				 facility = facility + "Mobile Banking";
			 }else if(email.isSelected()) {
				 facility = facility + "Email & SMS Alerts";
			 }else if(cheque.isSelected()) {
				 facility = facility + "Cheque Book";
			 }else if(estatement.isSelected()) {
				 facility = facility + "E-Statement";
			 }
			 
			 String edeclaration=" ";
			 if(declaration.isSelected()) {
				 edeclaration = "Checked";
			 }
			 
			 try {
				 if(edeclaration.equals(" ")){
				 JOptionPane.showMessageDialog(null, "PLEASE TICK THE DELCARATION");
				 }
				 else {
				 Conn c = new Conn();
				 String query = "insert into account_details values('"+formno+"', '"+acselected+"', '"+cardnumber+"','"+pinnumber+"','"+facility+"')";
				 String querya = "insert into cardandpin values('"+formno+"', '"+cardnumber+"','"+pinnumber+"')";
				 c.s.executeUpdate(query);
				 c.s.executeUpdate(querya);
				 JOptionPane.showMessageDialog(null, "CARD NUMBER : " + cardnumber +"\n PIN : " + pinnumber);	 
			 }
				 
			 }catch(Exception e) {
				 System.out.println(e);
			 }
		}else if (ae.getSource()==cancel) {
			
		}
		
	}

	public static void main(String[] args) {
		new account_details("");

	}

}
