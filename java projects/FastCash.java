import java.awt.Color;
import java.awt.Font;

import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import databse.Conn;

public class FastCash extends JFrame implements ActionListener{
    JLabel image,text;
    JButton r1,r2,r3,r4,r5,r6,exit;
    String pinnum,cnum;
    public FastCash(String pno,String cnum) 
    {
        pinnum=pno;
        this.cnum=cnum;
        setLayout(null);



        ImageIcon i1=new ImageIcon("C:/Users/Zunaid/Documents/Bank/icon/atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH);
        ImageIcon i3=new ImageIcon(i2);
         image=new JLabel(i3);
        image.setBounds(0,0,700,600);
        add(image);

        text=new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(160,125,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway",Font.BOLD,14));
        image.add(text);


        r1=new JButton("Rs 100");
        r1.setBounds(120,238,130,22);
        image.add(r1);

        
        r2=new JButton("Rs 500");
        r2.setBounds(270,238,130,22);
        image.add(r2);

        
        r3=new JButton("Rs 1000");
        r3.setBounds(120,268,130,22);
        image.add(r3);

             
        

        r4=new JButton("Rs 2000");
        r4.setBounds(270,268,130,22);
        image.add(r4);

        r5=new JButton("Rs 5000");
        r5.setBounds(120,298,130,22);
        image.add(r5);
        
        r6=new JButton("Rs 10000");
        r6.setBounds(270,298,130,22);
        image.add(r6);

        exit=new JButton("Back");
        exit.setBounds(270,325,130,22);
        image.add(exit);


        r1.addActionListener(this);
        r2.addActionListener(this);
        r3.addActionListener(this);
        r4.addActionListener(this);
        r5.addActionListener(this);
        r6.addActionListener(this);
    exit.addActionListener(this);
    

        setTitle( "FastCash");
        setUndecorated(true);
        setSize(700, 630);
        setLocationRelativeTo(null);

        setVisible(true);

    }


    public static void main(String[] args) {
        new FastCash("","");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit)
        {
          setVisible(false);
          new Transactions(pinnum,cnum).setVisible( true);
        }
        else 
        {
            String money=((JButton)e.getSource()).getText().substring(3);
            double balance=getBalance(pinnum);
            double m=Double.parseDouble(money);
              LocalDate currentDate = LocalDate.now();
             LocalTime currentTime = LocalTime.now();

             DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
             String date = currentDate.format(dateFormatter);

             DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
             String Time = currentTime.format(timeFormatter);
            if(m>balance)
            {
                    JOptionPane.showMessageDialog(null,"Balance is insufficient for withdraw" );
            }
            else{
                balance=balance-m;
                try {
                    Conn ca=new Conn();
                    
                    String Q1 ="INSERT INTO bank values('"+cnum+"','"+pinnum+"','"+date+"','"+Time+"','Deposit','"+money+"','"+balance+"')";
            
                    ca.s.executeUpdate(Q1);
                
                    JOptionPane.showMessageDialog(null,"Rs "+money+" withdraw Sucessfully");
                    setVisible(false);
                    new Transactions(pinnum,cnum).setVisible(true);
                } catch (Exception ee) {
                   System.out.println(ee);
                }
               
            }
             
        }
    
    }

     public double getBalance(String pinno) 
           {
             try {
                    Conn cr=new Conn();
                    String query = "SELECT balance FROM bank WHERE pin = '" + pinno + "' ORDER BY date DESC, time DESC LIMIT 1";
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

