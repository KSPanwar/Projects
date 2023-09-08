package bank_management_system;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class SignUpTwo extends JFrame implements ActionListener{
	JLabel heading,religion,category,income,equalification,occupation,pnumber,anumber,sencitizen,existingacc;
	JTextField panfield,aafield;
	JRadioButton syes,sno,eyes,eno;
	JButton next;
	JComboBox religionbox,categorybox,incomebox,educationbox,occupationbox;
	String formno;
	SignUpTwo(String formno ){
		this.formno = formno;
		getContentPane().setBackground(Color.WHITE);
		setSize(700,700);
		setLocation(260,10);
		setVisible(true);
		setLayout(null);
		
		heading = new JLabel("PAGE 2: Additional Details");
		heading.setFont(new Font("Osward",Font.BOLD,20));
		heading.setBounds(200,30,400,20);
		add(heading);
		
		religion = new JLabel("Religion:");
		religion.setFont(new Font("Osward",Font.BOLD,15));
		religion.setBounds(80,90,400,20);
		add(religion);
		
		String varreligion[] = {"HINDU","MUSLIM","SIKH","CHRISTIAN","OTHER"};
		religionbox = new JComboBox(varreligion);
		religionbox.setBounds(220,92,400,20);
		add(religionbox);
		
		category = new JLabel("Category:");
		category.setFont(new Font("Osward",Font.BOLD,15));
		category.setBounds(80,130,400,20);
		add(category);
		
		String categoryarray[] = {"GENERAL","SC","ST","OBC","OTHER"};
		categorybox = new JComboBox(categoryarray);
		categorybox.setBounds(220,132,400,20);
		add(categorybox);
		
		income = new JLabel("Income:");
		income.setFont(new Font("Osward",Font.BOLD,15));
		income.setBounds(80,170,400,20);
		add(income);
		
		String incomearray[] = {"(0-3) in lakhs","(3-7) in lakhs","(7-10) in lakhs","(10-15) in lakhs","more than 15 in lakhs"};
		incomebox = new JComboBox(incomearray);
		incomebox.setBounds(220,172,400,20);
		add(incomebox);
		
		equalification = new JLabel("Education:");
		equalification.setFont(new Font("Osward",Font.BOLD,15));
		equalification.setBounds(80,210,400,20);
		add(equalification);
		
		String educationarray[] = {"HIGH-SCHOOL","SECONDARY SCHOOL","GRADUATION","POST-GRADUATION","OTHER"};
		educationbox = new JComboBox(educationarray);
		educationbox.setBounds(220,212,400,20);
		add(educationbox);
		
		
		occupation = new JLabel("Occupation:");
		occupation.setFont(new Font("Osward",Font.BOLD,15));
		occupation.setBounds(80,250,400,20);
		add(occupation);
		
		String occupationarray[] = {"SALARIED","NON-SALARIED","BUSINESS"};
		occupationbox = new JComboBox(occupationarray);
		occupationbox.setBounds(220,252,400,20);
		add(occupationbox);
		
		pnumber = new JLabel("PAN Number:");
		pnumber.setFont(new Font("Osward",Font.BOLD,15));
		pnumber.setBounds(80,290,400,20);
		add(pnumber);
		
		panfield = new JTextField();
		panfield.setBounds(220,292,400,20);
		add(panfield);
		
		anumber = new JLabel("Aadhar Number:");
		anumber.setFont(new Font("Osward",Font.BOLD,15));
		anumber.setBounds(80,330,400,20);
		add(anumber);
		
		aafield = new JTextField();
		aafield.setBounds(220,332,400,20);
		add(aafield);
		sencitizen = new JLabel("Senior Citizen:");
		sencitizen.setFont(new Font("Osward",Font.BOLD,15));
		sencitizen.setBounds(80,370,400,20);
		add(sencitizen);
		
		syes = new JRadioButton("Yes");
		syes.setBackground(Color.WHITE);
		syes.setBounds(280,372,100,20);
		add(syes);
		
		sno = new JRadioButton("No");
		sno.setBackground(Color.WHITE);
		sno.setBounds(430,372,100,20);
		add(sno);
		
		ButtonGroup scitizen = new ButtonGroup();
		scitizen.add(syes);
		scitizen.add(sno);
		
		existingacc = new JLabel("Exisitng Account:");
		existingacc.setFont(new Font("Osward",Font.BOLD,15));
		existingacc.setBounds(80,410,400,20);
		add(existingacc);
		
		eyes = new JRadioButton("Yes");
		eyes.setBackground(Color.WHITE);
		eyes.setBounds(280,410,100,20);
		add(eyes);
		
		eno = new JRadioButton("No");
		eno.setBackground(Color.WHITE);
		eno.setBounds(430,410,100,20);
		add(eno);
		
		ButtonGroup existinggroup = new ButtonGroup();
		existinggroup.add(eyes);
		existinggroup.add(eno);
		
		next = new JButton("NEXT");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setBounds(530,450,100,20);
		next.addActionListener(this);
		add(next);	
	}
	
	public void actionPerformed(ActionEvent ae) {
		String sreligion = (String)religionbox.getSelectedItem();
		String scategorybox= (String)categorybox.getSelectedItem();
		String sincomebox= (String)incomebox.getSelectedItem();
		String seducationbox= (String)educationbox.getSelectedItem();
		String soccupationbox= (String)occupationbox.getSelectedItem();
		String spanfield = panfield.getText();
		String saafield = aafield.getText();
		String scitizen = null;
		String sformno = formno;
		if(syes.isSelected()) {
			scitizen = "Yes";
		}else if (sno.isSelected()) {
			scitizen = "No";
		}
		String eaccount = null;
		if(eyes.isSelected()) {
			eaccount = "Yes";
		}else if (eno.isSelected()) {
			eaccount ="No";
		}
		
		try{
			
				Conn c = new Conn();
				String query = "insert into SignUpTwo values('"+sformno+"', '"+sreligion+"', '"+scategorybox+"','"+sincomebox+"','"+seducationbox+"','"+soccupationbox+"','"+spanfield+"','"+saafield+"','"+scitizen+"','"+eaccount+"')";
				c.s.executeUpdate(query);
				setVisible(false);
				new account_details(sformno).setVisible(true);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	}

	public static void main(String[] args) {
		new SignUpTwo("");

	}

}
