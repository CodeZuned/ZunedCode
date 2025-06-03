import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import databse.Conn;

public class PinChange extends JFrame implements ActionListener{
    String pno;
    String cnum;
    JButton change,back;
    JLabel text,newpin,repin;
    JTextField rtxtpin,ntxtpin;
    public PinChange(String pin,String cnum)
    {
         this.pno=pin;
         this.cnum=cnum;
        setLayout(null);
        ImageIcon i1=new ImageIcon("C:/Users/Zunaid/Documents/Bank/icon/atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(700, 600, Image.SCALE_SMOOTH);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,700,600);
        add(image);

         JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(200,135,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,14));
        image.add(text);

        newpin= new JLabel("NEW PIN:");
        newpin.setBounds(120,200,100,22);
        newpin.setForeground(Color.white);
        image.add(newpin);

        ntxtpin=new JTextField();
        ntxtpin.setBounds(220,200,160,22);
        image.add(ntxtpin);

        repin= new JLabel("RE-ENTER PIN");
        repin.setBounds(120,240,100,22);
        repin.setForeground(Color.white);
        image.add(repin);

        rtxtpin=new JTextField();
        rtxtpin.setBounds(220,240,160,22);
        image.add(rtxtpin);


        change=new JButton("CHANGE");
        change.setBounds(300,300,90,22);
        image.add(change);

        back=new JButton("BACK");
        back.setBounds(300,330,90,22);
        image.add(back);

        change.addActionListener(this);
        back.addActionListener(this);

        setTitle( "PinChange");
        setUndecorated(false);
        setSize(700, 630);
        setLocationRelativeTo(null);

        setVisible(true);

    }
  
    public static void main(String[] args) {
        new PinChange("","");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       String newpinno=ntxtpin.getText();
       String repin=rtxtpin.getText();
       newpinno=newpinno.toLowerCase();
       repin=repin.toLowerCase();
        Conn ce=new Conn();
         String Query="Select * from login where cardnumber='"+cnum+"'and pin='"+pno+"'";
                if(e.getSource()==change)
                {

                try {
                        ResultSet rs=ce.s.executeQuery(Query);
                        if(rs.next()  && newpinno.equalsIgnoreCase(repin))
                        {
                             String Q="UPDATE bank SET pin = '"+newpinno+"' WHERE cardnumber = '"+cnum+"' AND pin = '"+pno+"'";
                            String Q1="UPDATE login SET pin = '"+newpinno+"' WHERE cardnumber = '"+cnum+"' AND pin = '"+pno+"'";
                            ce.s.executeUpdate(Q);
                            ce.s.executeUpdate(Q1);
                            setVisible(false);
                            new Transactions(repin,cnum).setVisible(true);
                            JOptionPane.showMessageDialog(null,"You're successfully logged in..");
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Incorrect pin please enter same pin in both box.");
                        }
                        
                    } catch (Exception ee) {
                        System.out.println(ee);
                    }
                }
                else if(e.getSource()==back)
                {
                    setVisible(false);
                    new Transactions(pno, cnum).setVisible(true);
                }
            }
    }
