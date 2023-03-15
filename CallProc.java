import java.sql.*;
class CallProc
{
    public static void main(String args[])
     {
       try
         {
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","scott","tiger");
           CallableStatement cst=con.prepareCall("{call cube023(?,?)}");
           cst.setInt(1,6);
           cst.registerOutParameter(2,Types.INTEGER);
           cst.execute();
           int res=cst.getInt(2);
           System.out.println("cube is"+res);
       }
       catch(Exception e)
        {
          System.out.println(e);
        }
     }
}