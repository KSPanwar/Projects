package bank_management_system;
import java.sql.*;
public class Conn {
	Connection c;
	Statement s;
	public Conn(){
		try {
			c=DriverManager.getConnection("jdbc:mysql:///bankamanagementsystem","root","P@nwar1234");  //connection String
			s= c.createStatement();
	}catch(Exception e) {
		System.out.println(e);
	}

}
}
