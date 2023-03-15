import java.sql.*;
import java.util.Scanner;
class Prepared
{
    public static void main(String args[])
     {
       try
         {   
             Scanner s=new Scanner(System.in);
             System.out.println("enter the rows");
               int rows=s.nextInt();
           Class.forName("oracle.jdbc.driver.OracleDriver");
           System.out.println("Driver Loaded\n");
           Connection con=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","scott","tiger");
           System.out.println("connection established");
           String sql="insert into student1_14223 values(?,?,?)";
            //create object for PreparedStatement by calling
            //connection.preparestatement
            PreparedStatement stmt=con.prepareStatement(sql);
          for(int i=0;i<rows;i++)
             {
                
               System.out.println("enter the id");
                 int id=s.nextInt();
               stmt.setInt(1,id);
                System.out.println("enter the name");
               String Name=s.next();
                 stmt.setString(2,Name);
              System.out.println("enter the branch");
                String Branch=s.next();
            stmt.setString(3,Branch);
               stmt.executeUpdate();
           }
              //int i=stmt.executeUpdate();
              //System.out.println(i+"records inserted");
           Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("Select *from student1_14223");
            // rs.absolute(3);
              //rs.first();
            //to fetch records
             while(rs.next())
              {
                  System.out.println(rs.getInt(1));
                  System.out.println(rs.getString("Name"));
                 System.out.println(rs.getString("Branch"));
              }
           con.close();
       }
       catch(Exception e)
        {
          System.out.println(e);
        }
     }
}