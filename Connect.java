import java.sql.*;
class Connect
{
    public static void main(String args[])
     {
       try
         {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           System.out.println("Driver Loaded\n");
           Connection con=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","scott","tiger");
           System.out.println("connection established");
           Statement st=con.createStatement();
           st.executeUpdate("create table student1_4223(Rno varchar(15),Name varchar(20),Branch varchar(10))");
           System.out.println("table created");
           st.executeUpdate("insert into student1_4223 values(101,'Harika','csm')");
           st.executeUpdate("insert into student1_4223 values(102,'Sirisha','csm')");
           st.executeUpdate("insert into student1_4223 values(103,'Hema','csm')");
           st.executeUpdate("insert into student1_4223 values(104,'Vagdevi','csm')");
           st.executeUpdate("insert into student1_4223 values(105,'Bhargavi','csm')");
           //st.executeUpdate("delete from student1_4223 where (NAME='Harika')");
           //st.executeUpdate("delete from student1_4223 where (NAME='Sirisha')");
            //System.out.println("deleted1");
            //System.out.println("deleted2");
           //System.out.println("first insertion completed");
           //System.out.println("Second insertion completed");
           // System.out.println("third insertion completed");
           // System.out.println("fourth insertion completed");
           // System.out.println("fifth insertion completed");
          // st.executeUpdate("update student1_4223 set NAME='Harika' where (RNO=103)");
          // System.out.println("UPDATE");
         }
       catch(Exception e)
        {
          System.out.println(e);
        }
     }
}