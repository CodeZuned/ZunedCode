import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;


import databse.Conn;

public class signup3 extends JFrame implements ActionListener {
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    JLabel l1,type,cardno,number,cardnumber,pin,pinnumber,pass,service;
    String formno;
    public signup3(String formno)
    {
        this.formno=formno;
        setLayout(null);
        l1=new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(200,20,400,40);
        add(l1);

        type=new JLabel("Account Type:");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,90,200,30);
        add(type);

        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBounds(100,140,160,20);
        r1.setBackground(Color.white);
        add(r1);
        
        r2=new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBounds(350,140,200,20);
        r2.setBackground(Color.white);
        add(r2);

             
        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBounds(100,180,180,20);
        r3.setBackground(Color.white);
        add(r3);

             
        r4=new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBounds(350,180,250,20);
        r4.setBackground(Color.white);
        add(r4);

        ButtonGroup r=new ButtonGroup();
        r.add(r1);
        r.add(r2);
        r.add(r3);
        r.add(r4);

        cardno=new JLabel("Card Number:");
        cardno.setFont(new Font("Raleway",Font.BOLD,22));
        cardno.setBounds(100,230,200,30);
        add(cardno);

        
        number=new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,230,260,30);
        add(number);

        
        cardnumber=new JLabel("Your 16 Digit Card Number");
        cardnumber.setFont(new Font("Raleway",Font.BOLD,12));
        cardnumber.setBounds(100,260,270,20);
        add(cardnumber);

        pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,285,200,30);
        add(pin);

        
        pinnumber=new JLabel("XXXX");
        pinnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pinnumber.setBounds(330,285,270,30);
        add(pinnumber);
        
        pass=new JLabel("Your 4 Digit PIN ");
        pass.setFont(new Font("Raleway",Font.BOLD,12));
        pass.setBounds(100,315,270,20);
        add(pass);
        
        service=new JLabel("Services Required:");
        service.setFont(new Font("Raleway",Font.BOLD,22));
        service.setBounds(100,350,200,30);
        add(service);


        c1=new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,400,120,30);
        add(c1);

        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(260,400,160,30);
        add(c2);

        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(460,400,180,30);
        add(c3);

        c4=new JCheckBox("Cheque Book");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(100,450,140,30);
        add(c4);

        c5=new JCheckBox("E-Statement");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(260,450,150,30);
        add(c5);

        
        c6=new JCheckBox("EMAIL & SMS Alerts");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(460,450,200,30);
        add(c6);

        
        c7=new JCheckBox("I Hereby declares that the above entered details are correct to the best of my knowledge ");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,500,550,22);
        add(c7);

        cancel=new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(400,560,100,25);
        add(cancel);

        submit=new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(530,560,100,25);
        add(submit);


        submit.addActionListener(this);
        cancel.addActionListener(this);

        getContentPane().setBackground(Color.white);
        setTitle("Final Page:");


        setSize(700, 650);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==submit)
        {

                String accountType="";
                if(r1.isSelected())
                {
                    accountType="Saving Account";
                }
                else if(r2.isSelected())
                {
                    accountType="Fixed Deposit Account";
                }
                else if(r3.isSelected())
                {
                    accountType="Current Account";
                }
                else if(r4.isSelected())
                {
                    accountType="Reccuring Deposit Account";
                }


                Random rm = new Random();
                long first8 = 50409360L; // Prefix for card
                long last8 = 10000000L + rm.nextInt(90000000); // Ensures exactly 8 digits
                
                String cnumber = first8 + String.valueOf(last8); // Total = 16 digits
                
                int pin = 1000 + rm.nextInt(9000); // Ensures value between 1000–9999
                String pnumber = String.valueOf(pin);

                String facility="";

                if(c1.isSelected())
                {
                    facility+=" ATM Card ";
                }
                else if(c2.isSelected())
                {
                    facility=facility+" Internet Banking";
                }
                else if(c3.isSelected())
                {
                    facility=facility+" Mobile Banking";
                }
                else if(c4.isSelected())
                {
                    facility=facility+" Email & SMS Alerts";
                }
                else if(c5.isSelected())
                {
                    facility=facility+" Cheque Book";
                }
                else if(c6.isSelected())
                {
                    facility=facility+" E-Statement";
                }

                try {
                    if(accountType=="" )
                    {
                        JOptionPane.showMessageDialog(null,"Account Type is Requred ");

                        if(!c7.isSelected())
                          JOptionPane.showMessageDialog(null,"Please checked the balow line");
                    }
                    else 
                    {
                        Conn cnn=new Conn();
                        String query1="INSERT INTO signupthree values('"+formno+"','"+accountType+"','"+cnumber+"','"+pnumber+"','"+facility+"')";
                        String query2="INSERT INTO login values('"+formno+"','"+cnumber+"','"+pnumber+"')";
                        cnn.s.executeUpdate(query1);
                        cnn.s.executeUpdate(query2);

                       JOptionPane.showMessageDialog(null,"Card Number:-"+cnumber+"\n PIN:-"+pnumber);
                       setVisible(false);
                       new Deposit(pnumber,cnumber).setVisible(true);
                       
                    }
                    

                } catch (Exception ee) {
                    System.out.println(ee);
                }
            
        }
        else if(e.getSource()==cancel)
        {

                setVisible(false);
                try {
                    Conn del=new Conn();
                    String Q="DELETE FROM signuptwo WHERE  Formno = '"+formno+"'";
                    del.s.executeUpdate(Q);


                } catch (Exception ee) {
                    System.out.println(ee);
                }
                setVisible(false);
                new signup().setVisible(true);
        }
    }




    public static void main(String args[])
    {
        new signup3("");
    }
}
