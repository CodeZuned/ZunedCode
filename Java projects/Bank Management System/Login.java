import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;

import databse.Conn;

import java.awt.event.*;

public class Login extends JFrame implements ActionListener,FocusListener{

    JLabel lbl1,lbl2,lbl3,text,cardno,pin;

    JButton sign,signup,clear;
    JTextField cardtxt;
    JPasswordField pintxt;
    public static void main(String[] args) {
        new Login();
    }

    public Login() {
        setTitle("AUTOMATIC TELLER MACHINE");
        setLayout(null);

        ImageIcon i1 = new ImageIcon("C:/Users/Zunaid/Documents/Bank/icon/logo.jpg");
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        lbl1 = new JLabel(i3);
        lbl1.setBounds(80, 20, 100, 100);
        add(lbl1);

         text = new JLabel("Welcome to ATM");
        text.setBounds(200, 50, 400, 40);
        text.setFont(new Font("Osward", Font.BOLD, 30));
        add(text);

         cardno = new JLabel("Card No:");
        cardno.setBounds(120, 150, 150, 30);
        cardno.setFont(new Font("Raleway", Font.BOLD, 27));
        add(cardno);

        
        cardtxt=new JTextField();
        cardtxt.setBounds(300,150,240,30);
        cardtxt.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardtxt);

        pin = new JLabel("PIN:");
        pin.setBounds(120, 220, 250, 30);
        pin.setFont(new Font("Raleway", Font.BOLD, 27));
        add(pin);

          
        pintxt=new JPasswordField();
        pintxt.setBounds(300,220,240,30);
        pintxt.setFont(new Font("Arial", Font.BOLD, 14));
        add(pintxt);


        sign=new JButton("SIGN IN");
        sign.setBounds(300,300,100,30);
        sign.setBackground(Color.black);
        sign.setForeground(Color.white);
        add(sign);

        clear=new JButton("CLEAR");
        clear.setBounds(440,300,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        add(clear);

        signup=new JButton("SIGN UP");
        signup.setBounds(300,350,250,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        add(signup);


        sign.addActionListener(this);
        signup.addActionListener(this);
        clear.addActionListener(this);
        pintxt.addFocusListener(this);
        cardtxt.addFocusListener(this);
        setSize(800, 480);
        getContentPane().setBackground(Color.white);
        setLocation(280, 140);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        String card=cardtxt.getText();
            if(e.getSource()==clear)
            {
                cardtxt.setText("");
                pintxt.setText("");
            }
            else if(e.getSource()==sign)
            {
                    Conn ce=new Conn();
                  
                    char[] pin=pintxt.getPassword();
                    String pno=new String(pin);
                    String Query="Select * from login where cardnumber='"+card+"'and pin='"+pno+"'";
                    try {
                        ResultSet rs=ce.s.executeQuery(Query);
                        if(rs.next())
                        {
                            setVisible(false);
                            new Transactions(pno,card).setVisible(true);
                            JOptionPane.showMessageDialog(null,"You're successfully logged in..");
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                        }
                        
                    } catch (Exception ee) {
                        System.out.println(ee);
                    }
            }
            else if(e.getSource()==signup)
            {
                    setVisible(false);
                    new signup().setVisible(true);
            }
    }

    public void focusGained(FocusEvent e)

       { if(e.getSource()==pintxt)
        {
            pintxt.setBackground(Color.white);
        }
        else if(e.getSource()==cardtxt)
        {
            cardtxt.setBackground(Color.white);
        }

      
    }

    public void focusLost(FocusEvent e) {
        if(e.getSource()==pintxt)
        {
            pintxt.setBackground(Color.white);
        }
        else if(e.getSource()==cardtxt)
        {
            cardtxt.setBackground(Color.white);
        }

      
    
    }

   
    
    
}
