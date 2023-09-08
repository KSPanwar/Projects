package bank_management_system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{
	JButton login,clear,signUp;
	JTextField cardTextField,pinTextField;
	Login(){
		setTitle("AUTOMATED TELLER MACHINE");
		setLayout(null);	//to remove the default layout
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));  // getting image from system
		Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);		// to scale the image we cannot do on ImageIcon we need to shift to Image
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);   //putting image in label to put in JLabel
		label.setBounds(70,30,70,70);
		add(label);
		
		JLabel text = new JLabel("Welcome to ATM");
		text.setFont(new Font("Osward",Font.BOLD,45));
		text.setBounds(170,30,400,80);
		add(text);
		
		JLabel cardNo = new JLabel("Card No. :");
		cardNo.setFont(new Font("Osward",Font.BOLD,30));
		cardNo.setBounds(100,140,400,50);
		add(cardNo);
		
		cardTextField = new JTextField();
		cardTextField.setBounds(270,150,300,40);
		add(cardTextField);
		
		JLabel pin = new JLabel("Pin :");
		pin.setFont(new Font("Osward",Font.BOLD,30));
		pin.setBounds(100,220,400,50);
		add(pin);
		
		pinTextField = new JTextField();
		pinTextField.setBounds(270,220,300,40);
		add(pinTextField);
		
		login = new JButton("SIGN IN");
		login.setBounds(100,300,200,30);
		login.addActionListener(this);
		add(login);
		
		
		clear = new JButton("CLEAR");
		clear.setBounds(370,300,200,30);
		clear.addActionListener(this);
		add(clear);
		
		signUp = new JButton("SIGN UP");
		signUp.setBounds(100,350,470,30);
		signUp.addActionListener(this);
		add(signUp);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(800,480); //frame length and width
		setVisible(true); //making it visible to user
		setLocation(300,100);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == clear) {
			cardTextField.setText("");
			pinTextField.setText("");
			
		} else if(ae.getSource() == login) {
			Conn conn = new Conn();
			String cardnumber = cardTextField.getText();
			String pinnumber = pinTextField.getText();
			String query = "Select * from cardandpin where Account_type ='"+cardnumber+"' and Card_Number = '"+pinnumber+"'";
			try {
				ResultSet rs = conn.s.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new Login_Display(pinnumber).setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null,"Incorrect Details");
				}
			}catch(Exception e) {
				System.out.println(e);
			}
			
			
		} else if(ae.getSource() == signUp) {
			setVisible(false);
			new SignupOne().setVisible(true);
		}
		
	}

	public static void main(String[] args) {
		new Login();

	}

}
