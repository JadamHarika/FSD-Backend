import java.sql.*;
class CallFun
{
    public static void main(String args[])
     {
       try
         {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","scott","tiger");
           CallableStatement cst=con.prepareCall("{?=call square023(?)}");
           cst.setInt(2,5);
           cst.registerOutParameter(1,Types.INTEGER);
           cst.execute();
           int res=cst.getInt(1);
           System.out.println("Square is"+res);
       }
       catch(Exception e)
        {
          System.out.println(e);
        }
     }
}