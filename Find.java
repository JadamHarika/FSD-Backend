import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Find extends Frame implements ActionListener
{
     Label l1;
     TextField t1;
     Button b;
      Find()
        {
              setSize(300,300);
              setVisible(true);
              setLayout(new FlowLayout());
              l1=new Label("enter roll number");
              t1=new TextField(20);
              b=new Button("Search");
              add(l1);
              add(t1);
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
                  PreparedStatement stmt=con.prepareStatement("select *from student_4223 where RNO=?");
                  String num=t1.getText();
                   stmt.setString(1,num);
                     ResultSet rs=stmt.executeQuery(); 
                      int x=0;
                      while(rs.next())
                        {
                             System.out.println(rs.getString(1)+" "+rs.getString(2)+"  "+rs.getString(3));
                              x++;
                        }
                     if(x==0)
                      {
                             System.out.println("record not found");
                      }
              }
           catch(Exception ex)
             {
                  System.out.println(ex);
             }
       }
    public static void main(String args[])
      {
           new Find();
       }
}             
                
                