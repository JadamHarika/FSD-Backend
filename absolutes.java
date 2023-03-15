import java.sql.*;
class absolutes
{
 public static void main(String args[])
{
 try
 {
  Class.forName("oracle.jdbc.driver.OracleDriver");
  System.out.println("Driver Loaded\n");
  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","scott","tiger");
  System.out.println("Connection Established");
  Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
String sql1="select * from Student4208";
ResultSet rs=st.executeQuery(sql1);
//getting the record of thirst row
rs.absolute(3);
System.out.println(rs.getString(1)+""+rs.getString(2));

}
 catch(Exception e)
 {
 System.out.println(e);
 }
}
}