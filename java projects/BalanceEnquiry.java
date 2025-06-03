import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


import databse.Conn;

public class BalanceEnquiry extends JFrame implements ActionListener{
   
    JButton exit;
    String pino;
    String cnum;
    public BalanceEnquiry(String pn,String cn)
    {
        pino=pn;
        cnum=cn;
        setLayout(null);
        ImageIcon i1=new ImageIcon("C:/Users/Zunaid/Documents/Bank/icon/atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,700,600);
        add(image);

        exit=new JButton("Back");
        exit.setBounds(270,325,130,22);
        exit.addActionListener(this);
        image.add(exit);

    
         double balance=getBalance(pino);

    

        JLabel text=new JLabel("Your Current Account balance is :");
        text.setForeground(Color.white);
        text.setBounds(130,140,700,35);
        image.add(text);

        String a="Rs "+balance;
         JLabel text1=new JLabel(a);
        text1.setForeground(Color.white);
        text1.setBounds(210,160,700,35);
        image.add(text1);

         setTitle( "BalanceEnquiry");
        setUndecorated(true);
        setSize(700, 630);
        setLocationRelativeTo(null);

        setVisible(true);

    }
    public void actionPerformed(ActionEvent e)
    {
        setVisible(false);
        new Transactions(pino,cnum).setVisible(true);
    }

     public double getBalance(String pinno) 
           {
             try {
                    Conn cr=new Conn();
                    String query = "SELECT balance FROM bank WHERE pin = '" + pinno + "' And cardnumber='"+cnum+"' ORDER BY date DESC, time DESC LIMIT 1";
                   ResultSet rs =cr.s.executeQuery(query);
                       if (rs.next()) {
                    return rs.getDouble("balance");
                          }
                 } catch (Exception ee) {
                         System.out.println(ee);
                       }
      
       
                 return 0.0;
              }
    public static void main(String[] args) {
        new BalanceEnquiry("","");
    }
}
