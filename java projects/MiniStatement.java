import java.awt.Color;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;



import databse.Conn;

public class MiniStatement extends JFrame {

    String pno,cnum;
    public MiniStatement(String pno,String cnum)
    {
        this.pno=pno;
        this.cnum=cnum;


        setLayout(null);

        JLabel text=new JLabel();
        add(text);

        JLabel bank=new JLabel("Indian Bank ");
        bank.setBounds(130,100,100,20);
        add(bank);

        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);


         try {
            Conn cn = new Conn();
             ResultSet rs = cn.s.executeQuery("SELECT * FROM bank WHERE pin='" + pno + "'ORDER BY date DESC, time DESC LIMIT 5");
             while(rs.next())
             {
                
                card.setText("Card Number :"+cnum.substring(0,4)+"xxxxxxxx"+cnum.substring(12));
               }
         }
         catch(Exception e)
         {
            System.out.println(e);
         }

        try {
    Conn cn = new Conn();

    ResultSet rs = cn.s.executeQuery("SELECT * FROM bank WHERE pin='" + pno + "'");


StringBuilder htmlContent = new StringBuilder("<html>");
while (rs.next()) {
    String date = rs.getString("date");
    String type = rs.getString("type");
    String amount = rs.getString("amount");

    date = date.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    type = type.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    amount = amount.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");

 
    htmlContent.append("<br><br>").append(date)
               .append("&nbsp;&nbsp;&nbsp;&nbsp;")
               .append(type)
               .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
               .append(amount)
               .append("<br><br>");
}
htmlContent.append("</html>");


text.setText(htmlContent.toString());

}
catch(Exception e)
{
    System.out.println(e);
}
    

       
       
        text.setBounds(20,140,400,200);

        setTitle("Mini Statement");
    
        setSize(350, 460);
       getContentPane().setBackground(Color.white);
        setLocation(20,20);
        setVisible(true);
        
    }
    public static void main(String[] args) {
        new MiniStatement(""," ");
    }
}
