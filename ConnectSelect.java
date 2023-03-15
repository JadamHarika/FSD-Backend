import java.sql.*;
class ConnectSelect
{
    public static void main(String args[])
     {
       try
         {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           System.out.println("Driver Loaded\n");
           Connection con=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","scott","tiger");
           System.out.println("connection established");
           Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
           //st.executeUpdate("create table student1_4223(Rno varchar(15),Name varchar(20),Branch varchar(10)");
          // System.out.println("table created");
            ResultSet rs=st.executeQuery("Select *from student1_4223");
             rs.absolute(3);
            //to fetch records
             //while(rs.next())
              //{
                  //System.out.println(rs.getInt(1));
                  System.out.println(rs.getString(3));
                 //System.out.println(rs.getString(3));
              //}
       }
       catch(Exception e)
        {
          System.out.println(e);
        }
     }
}