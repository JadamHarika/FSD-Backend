import java.util.Scanner;
import java.sql.*;
import java.sql.Date;  
class preaparedelete
{
 public static void main(String args[])
{
 try
 {
   String Name;
Scanner sc=new Scanner(System.in);
System.out.println("Enter Name");
Name=sc.next();
  Class.forName("oracle.jdbc.driver.OracleDriver");
  System.out.println("Driver Loaded\n");
  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","scott","tiger");
  System.out.println("Connection Established");
 String sql1="delete from Student4208 where Name=?";
 //Create object for PreparedStatement by callin
 //connection.preparedStatement
  PreparedStatement stm=con.prepareStatement(sql1);
stm.setString(1,Name); 
stm.executeUpdate();
System.out.println("Records Deleted");
con.close();
}
 catch(Exception e)
 {
 System.out.println(e);
 }
}
}
