import java.awt.Color;
import java.awt.Font;

import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transactions extends JFrame implements ActionListener{
    JLabel image,text;
    JButton deposit,withdraw,fastcash,ministatement,pinchange,balanceenquiry,exit;
    String pinnum;
    String cnum;
    public Transactions(String pno,String cnum) 
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

        text=new JLabel("Please select your Transaction");
        text.setBounds(160,125,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway",Font.BOLD,14));
        image.add(text);


        deposit=new JButton("Deposit");
        deposit.setBounds(120,238,130,22);
        image.add(deposit);

        
        withdraw=new JButton("Cash Withdraw");
        withdraw.setBounds(270,238,130,22);
        image.add(withdraw);

        
        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(120,268,130,22);
        image.add(fastcash);

             
        

        ministatement=new JButton("Mini Statement");
        ministatement.setBounds(270,268,130,22);
        image.add(ministatement);

        pinchange=new JButton("Pin Change");
        pinchange.setBounds(120,298,130,22);
        image.add(pinchange);
        
        balanceenquiry=new JButton("Balance Enquiry");
        balanceenquiry.setBounds(270,298,130,22);
        image.add(balanceenquiry);

        exit=new JButton("Exit");
        exit.setBounds(270,325,130,22);
        image.add(exit);


        deposit.addActionListener(this);
        withdraw.addActionListener(this);
        fastcash.addActionListener(this);
        ministatement.addActionListener(this);
        pinchange.addActionListener(this);
        balanceenquiry.addActionListener(this);
        exit.addActionListener(this);
    

        setTitle( "Transactions");
        setUndecorated(true);
        setSize(700, 630);
        setLocationRelativeTo(null);

        setVisible(true);

    }


    public static void main(String[] args) {
        new Transactions("","");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit)
        {
            System.exit(0);
        }
        else if(e.getSource()==deposit)
        {
            setVisible(false);
            new Deposit(pinnum,cnum).setVisible(true);

        }
        else if(e.getSource()==withdraw)
        {
            setVisible(false);
            new Withdraw(pinnum,cnum).setVisible(true);
        }
        else if(e.getSource()==fastcash)
        {
            setVisible(false);
            new FastCash(pinnum,cnum).setVisible(true);
        }
        else if(e.getSource()==pinchange)
        {
            setVisible(false);
            new PinChange(pinnum,cnum).setVisible(true);
        }else if(e.getSource()==balanceenquiry)
        {
            setVisible(false);
            new BalanceEnquiry(pinnum,cnum).setVisible(true);
        }
        else if(e.getSource()==ministatement)
        {
            new MiniStatement(pinnum, cnum).setVisible(true);
        }
    
    }
}
