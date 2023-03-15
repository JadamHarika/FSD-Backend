import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Login extends Frame implements ActionListener
{
     Label l1,l2;
     TextField t1,t2;
     Button b;
      Login()
        {
              setSize(300,300);
              setVisible(true);
              setLayout(new FlowLayout());
              l1=new Label("username");
              l2=new Label("password");
              t1=new TextField(20);
              t2=new TextField(20);
              b=new Button("Login");
              add(l1); 
              add(t1);
              add(l2);
              add(t2);
              add(b);
              b.addActionListener(this);
       }
      public void actionPerformed(ActionEvent e)
         {
            try
             {
                  Class.forName("oracle.jdbc.driver.OracleDriver");
                  System.out.println("Driver Loaded\n");
                  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","scott","tiger");
                   System.out.println("connection established");
                  PreparedStatement stmt=con.prepareStatement("select *from login_21761A4223 where USERNAME=? and PASSWORD=?");
                  String name=t1.getText();
                  String password=t2.getText();
                   stmt.setString(1,name);
                   stmt.setString(2,password);
                     ResultSet rs=stmt.executeQuery(); 
                      int x=0;
                      while(rs.next())
                        {
                             System.out.println(rs.getString(1)+" "+rs.getString(2));
                              x++;
                             System.out.println("login sucessfull");
                        }
                     if(x==0)
                      {
                             System.out.println("login Failed");
                      }
              }
           catch(Exception ex)
             {
                  System.out.println(ex);
             }
       }
    public static void main(String args[])
      {
           new Login();
       }
}             
                
                