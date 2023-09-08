package bank_management_system;
import java.awt.Color;
import java.util.*;
import java.awt.Font;

import javax.swing.*;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
	JLabel heading,name,fname,address,dob,gender,email,mstatus,city,state,pcode,headingone;
	JTextField nameField,fnameField,aField,eField,cField,sField,pcField,dchooser;
	JRadioButton male,female,married,unmarried,other;
	long random;
	JButton next;
	SignupOne(){
		getContentPane().setBackground(Color.WHITE);
		setSize(800,800);
		setLocation(260,10);
		setVisible(true);
		setTitle("signup1");
		setLayout(null);
		
		Random ran = new Random();
		random = Math.abs((ran.nextLong() % 9000L) + 1000L);
		
		heading = new JLabel("APPLICATION NO." + random );
		heading.setFont(new Font("Osward",Font.BOLD,20));
		heading.setBounds(280,05,250,50);
		add(heading);
		
		headingone = new JLabel("PAGE NO.1 PERSONAL DETAILS");
		headingone.setFont(new Font("Osward",Font.BOLD,15));
		headingone.setBounds(265,40,400,20);
		add(headingone);
		
		name = new JLabel("NAME:");
		name.setFont(new Font("Osward",Font.BOLD,20));
		name.setBounds(40,70,280,50);
		add(name);
		
		nameField = new JTextField();
		nameField.setBounds(220,75,700,40);
		add(nameField);
		
		fname = new JLabel("FATHER'S NAME:");
		fname.setFont(new Font("Osward",Font.BOLD,20));
		fname.setBounds(40,120,250,50);
		add(fname);
		
		fnameField = new JTextField();
		fnameField.setBounds(220,125,700,40);
		add(fnameField);
		
		address = new JLabel("ADDRESS :");
		address.setFont(new Font("Osward",Font.BOLD,20));
		address.setBounds(40,170,250,50);
		add(address);
		
		aField = new JTextField();
		aField.setBounds(220,175,700,40);
		add(aField);
		
		
		 dob = new JLabel("DOB :");
		dob.setFont(new Font("Osward",Font.BOLD,20));
		dob.setBounds(40,220,250,50);
		add(dob);
		
		dchooser = new JTextField();
		dchooser.setBounds(220,225,500,40);
		add(dchooser);
			
		gender = new JLabel("GENDER:");
		gender.setFont(new Font("Osward",Font.BOLD,20));
		gender.setBounds(40,270,250,50);
		add(gender);
		
		male = new JRadioButton("MALE");
		male.setBounds(220,275,100,50);
		male.setBackground(Color.WHITE);
		add(male);
		
		female = new JRadioButton("FEMALE");
		female.setBounds(320,275,100,50);
		female.setBackground(Color.WHITE);
		add(female);
		
		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		
		email = new JLabel("EMAIL:");
		email.setFont(new Font("Osward",Font.BOLD,20));
		email.setBounds(40,320,250,50);
		add(email);
		
		eField = new JTextField();
		eField.setBounds(220,325,700,40);
		add(eField);
		
		
		mstatus = new JLabel("MARTIAL STATUS:");
		mstatus.setFont(new Font("Osward",Font.BOLD,20));
		mstatus.setBounds(40,370,250,50);
		add(mstatus);
		
		married = new JRadioButton("MARRIED");
		married.setBounds(220,375,100,50);
		married.setBackground(Color.WHITE);
		add(married);
		
		unmarried= new JRadioButton("UNMARRIED");
		unmarried.setBounds(320,375,100,50);
		unmarried.setBackground(Color.WHITE);
		add(unmarried);
		
		other = new JRadioButton("OTHER");
		other.setBounds(440,375,100,50);
		other.setBackground(Color.WHITE);
		add(other);
		
		ButtonGroup martialgroup = new ButtonGroup();
		martialgroup.add(married);
		martialgroup.add(unmarried);
		martialgroup.add(other);
		
		city = new JLabel("CITY:");
		city.setFont(new Font("Osward",Font.BOLD,20));
		city.setBounds(40,420,250,50);
		add(city);
		
		cField = new JTextField();
		cField.setBounds(220,425,700,40);
		add(cField);
		
		state = new JLabel("STATE:");
		state.setFont(new Font("Osward",Font.BOLD,20));
		state.setBounds(40,470,250,50);
		add(state);
		
		sField = new JTextField();
		sField.setBounds(220,475,700,40);
		add(sField);
		
		pcode = new JLabel("PIN CODE:");
		pcode.setFont(new Font("Osward",Font.BOLD,20));
		pcode.setBounds(40,520,250,50);
		add(pcode);
		
		pcField = new JTextField();
		pcField.setBounds(220,525,700,40);
		add(pcField);
		
		next = new JButton("NEXT PAGE");
		next.setBounds(600,620,150,30);
		next.addActionListener(this);
		add(next);
		
	}
	public void actionPerformed(ActionEvent ae) {
		String formno = "" + random;
		String name = nameField.getText();
		String fname = fnameField.getText();
		String dob = dchooser.getText();
		String gender = null;
		if(male.isSelected()) {
			gender= "male";
		}else if(female.isSelected()) {
			gender ="female";
		}
		String email = eField.getText();
		String marital = null;
		if(married.isSelected()) {
			marital= "married";
		}else if(unmarried.isSelected()) {
			marital ="unmarried";
		}else if(other.isSelected()) {
			marital = "other";
		}
		String city = cField.getText();
		String state = sField.getText();
		String pincode = pcField.getText();
		String address = aField.getText();
		
		try{
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null, "NAME IS REQUIRED");
			}else {
				Conn c = new Conn();
				String query = "insert into SignUp values('"+formno+"', '"+name+"', '"+fname+"','"+address+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+city+"','"+state+"','"+pincode+"')";
				c.s.executeUpdate(query);
				setVisible(false);
				new SignUpTwo(formno).setVisible(true);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
	}
	public static void main(String[] args) {
		new SignupOne();
	}
}


