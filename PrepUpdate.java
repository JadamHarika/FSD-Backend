import java.sql.*;
import java.util.Scanner;
class PrepUpdate
{
    public static void main(String args[])
     {
       try
         {   
             
           Class.forName("oracle.jdbc.driver.OracleDriver");
           System.out.println("Driver Loaded\n");
           Connection con=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","scott","tiger");
           System.out.println("connection established");
            PreparedStatement stmt=con.prepareStatement("update student_4223 set NAME=? where RNO=?");
            Scanner sc=new Scanner(System.in);
            System.out.println("enter roll number");
            String num=sc.next();
            System.out.println("enter a name");
            String name=sc.next();
            stmt.setString(1,name);
            stmt.setString(2,num);
            stmt.executeUpdate();
            
       }
       catch(Exception e)
        {
          System.out.println(e);
        }
     }
}