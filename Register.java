import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Register extends Frame implements ActionListener
{
     Label l1,l2,l3;
     TextField t1,t2,t3;
     Button b;
      Register()
        {
              setSize(300,300);
              setVisible(true);
              setLayout(new FlowLayout());
              l1=new Label("enter roll number");
              l2=new Label("enter name");
              l3=new Label("enter the branch");
              t1=new TextField(20);
              t2=new TextField(20);
              t3=new TextField(20);
              b=new Button("Register");
              add(l1);
              add(t1);
              add(l2);
              add(t2);
              add(l3);
              add(t3);
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
                  PreparedStatement stmt=con.prepareStatement("insert into student_4223 values(?,?,?)");
                  String num=t1.getText();
                  String name=t2.getText();
                  String branch=t3.getText();
                   stmt.setString(1,num);
                    stmt.setString(2,name);
                     stmt.setString(3,branch);
                     stmt.executeUpdate();
                   System.out.println("inserted");
              }
           catch(Exception ex)
             {
                  System.out.println(ex);
             }
       }
    public static void main(String args[])
      {
           new Register();
       }
}             
                
                