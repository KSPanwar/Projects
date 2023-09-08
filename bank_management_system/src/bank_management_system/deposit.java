package bank_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class deposit extends JFrame implements ActionListener {
	JButton deposit,back;
	JTextField amount;
	String pinnumber;
	deposit(String pinumber){
		this.pinnumber= pinnumber;
		setVisible(true);
		setSize(600,600);
		setLocation(250,10);
		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,600,600);
		add(image);
		
		JLabel heading = new JLabel("Enter the amount you want to deposit");
		heading.setFont(new Font("Raleway",Font.BOLD,10));
		heading.setBounds(130,200,200,20);
		heading.setForeground(Color.WHITE);
		image.add(heading);
		
		amount = new JTextField();
		amount.setBounds(100,240,230,20);
		image.add(amount);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(250,320,100,20);
		deposit.addActionListener(this);
		image.add(deposit);
		
		back = new JButton("Back");
		back.setBounds(250,340,100,20);
		back.addActionListener(this);
		image.add(back);
		
		
	}
	
	public void  actionPerformed(ActionEvent ae) {
		if(ae.getSource()== deposit){
			String pinnumber1 = pinnumber;
			String number = amount.getText();
			Date date = new Date();
			if(number.equals("")){
				JOptionPane.showMessageDialog(null, " PLease fill the amount u want to deposit");
			}
			else {
				try {
				Conn c = new Conn();
				String query ="insert into bank_details values('"+pinnumber1+"','"+date+"','Deposit','"+number+"')";
				c.s.execute(query);
				JOptionPane.showMessageDialog(null, "RS "+number+" Deposited successfully in your account");
				setVisible(false);
				new deposit(pinnumber).setVisible(true);
				
			}catch (Exception e){
				System.out.println(e);
			}
				}
			
		}else if(ae.getSource()==back) {
			setVisible(false);
			new Login_Display(pinnumber).setVisible(true);
			
		}
		
	}

	public static void main(String[] args) {
		new deposit("");

	}

}
