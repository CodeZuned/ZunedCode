import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


import javax.swing.*;

import databse.Conn;

public class Deposit extends JFrame implements ActionListener,KeyListener{

    JLabel image,text;
    JTextField amount;
    JButton deposit,back;
    String pinno;
    String cnum;
    boolean A=true;
    public Deposit(String pinno,String cnum)
    {
        this.cnum=cnum;
        this.pinno=pinno;
        setLayout(null);
        ImageIcon i1=new ImageIcon("C:/Users/Zunaid/Documents/Bank/icon/atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,700,600);
        add(image);

        text=new JLabel("Enter the Amount you want to Deposit.");
        text.setBounds(130,125,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway",Font.BOLD,14));
        image.add(text);

        amount=new JTextField();
        amount.setBounds(140,170,240,35);
        amount.setForeground(Color.black);
        amount.setFont(new Font("Raleway",Font.BOLD,14));
        image.add(amount);


       deposit=new JButton("Deposit");
       deposit.setBounds(300,280,100,25);
       deposit.setFont(new Font("Raleway",Font.BOLD,14));
        image.add(deposit);

        
       back=new JButton("Back");
       back.setBounds(300,320,100,25);
       back.setFont(new Font("Raleway",Font.BOLD,14));
       image.add(back);

       deposit.addActionListener(this);
       back.addActionListener(this);
       amount.addKeyListener(this);

        setTitle( "Deposits");
        // setUndecorated(true);
        setSize(700, 630);
        setLocationRelativeTo(null);

        setVisible(true);
    }
    public static void main(String[] args) {
        new Deposit("","");
    }

    public void actionPerformed(ActionEvent e) {
    
        if(e.getSource()==deposit)
        {
            
            String money=amount.getText();
            double balance=getBalance(pinno);
            double m=Double.parseDouble(money);
         
             if(money.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Enter the amount you want to withdraw!");
            }
           
            else
            {
             balance+=m;
             LocalDate currentDate = LocalDate.now();
             LocalTime currentTime = LocalTime.now();

             DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
             String date = currentDate.format(dateFormatter);

             DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
             String Time = currentTime.format(timeFormatter);

                try {
                    Conn ca=new Conn();
                    String query="INSERT INTO bank values('"+cnum+"','"+pinno+"','"+date+"','"+Time+"','Deposit','"+money+"','"+balance+"')";
                    ca.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+money+" Deposit Sucessfully");
                    setVisible(false);
                    new Transactions(pinno,cnum).setVisible(true);
                } catch (Exception ee) {
                   System.out.println(ee);
                }
               
            }
        }
    
        else if(e.getSource()==back)
        {
            setVisible(false);
            new Transactions(pinno,cnum).setVisible(true);
        }
    }
 
    public void keyTyped(KeyEvent e) {

    char c=e.getKeyChar();
    if(!Character.isDigit(c))
    {
      
        e.consume();
    }

    }
  
    public void keyPressed(KeyEvent e) {  }
  
    public void keyReleased(KeyEvent e) {
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
    
}
