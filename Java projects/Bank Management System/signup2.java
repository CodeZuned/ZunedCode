


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import databse.Conn;


public class signup2 extends JFrame implements ActionListener {
    JLabel additionalDetail, religion, category, income, qualification,citizen, occupation;
    JLabel  Exaccount,pan,aadhar;
    JButton next,prev;
    JTextField  txtpan,txtaadhar;
    JComboBox religion1,cat,inc,Qual;
    JRadioButton syes,sno,Exyes,Exno;
    String formno;
    public static void main(String args[]) {
        new signup2("");
    }

    public signup2(String fno) 
    {

        this.formno=fno;
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        

        Font labelFont = new Font("Raleway", Font.BOLD, 18);
        Font fieldFont = new Font("Raleway", Font.PLAIN, 16);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
      

        additionalDetail = new JLabel("Page 2: Additional Details");
        additionalDetail.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetail.setBounds(230, 60, 400, 30);
        add(additionalDetail);

        religion = new JLabel("Religion:");
        religion.setFont(labelFont);
        religion.setBounds(80, 110, 150, 25);
        add(religion);

        String valrel[]={"Hindu","Muslim","Sikh","Christian","Other"};

        religion1=new JComboBox(valrel);
        religion1.setBounds(280, 110, 350, 25);
        religion1.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        religion1.setBackground(Color.white);
        add(religion1);

    

        category = new JLabel("Category:");
        category.setFont(labelFont);
        category.setBounds(80, 150, 200, 25);
        add(category);

        
        String valcat[]={"General","OBC","SC","ST"};
        cat=new JComboBox(valcat);
        cat.setFont(fieldFont);
        cat.setBounds(280, 150, 350, 25);
        cat.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        cat.setBackground(Color.white);
        add(cat);

        income = new JLabel("Income:");
        income.setFont(labelFont);
        income.setBounds(80, 190, 200, 25);
        add(income);

        String valinc[]={"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
        inc=new JComboBox(valinc);
        inc.setBounds(280, 190, 350, 25);
        inc.setBackground(Color.white);
        inc.setForeground(new Color(105, 105, 105));
        add(inc);

        

        qualification = new JLabel("Qualification:");
        qualification.setFont(labelFont);
        qualification.setBounds(80, 230, 200, 25);
        add(qualification);

        String valQual[]={"Non Graduation","Graduate","Post Graduation","Doctrate","Other"};
        Qual=new JComboBox(valQual);
        Qual.setBounds(280, 230, 350, 25);
        Qual.setBackground(Color.white);
        Qual.setForeground(new Color(105, 105, 105));
        add(Qual);

        occupation = new JLabel("Occupation:");
        occupation.setFont(labelFont);
        occupation.setBounds(80, 270, 200, 25);
        add(occupation);

        String valOccu[]={"Salaried","Self-Employed","Bussiness","Student","Other"};
        JComboBox  Ocuu=new JComboBox(valOccu);
        Ocuu.setBounds(280, 270, 350, 25);
        Ocuu.setBackground(Color.white);
        add(Ocuu);

    

        pan = new JLabel("PAN Number:");
        pan.setFont(labelFont);
        pan.setBounds(80, 310, 200, 25);
        add(pan);

        txtpan = new JTextField();
        txtpan.setFont(fieldFont);
        txtpan.setBounds(280, 310, 350, 25);
        txtpan.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(txtpan);


        aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(labelFont);
        aadhar.setBounds(80, 350, 200, 25);
        add(aadhar);

        txtaadhar = new JTextField();
        txtaadhar.setFont(fieldFont);
        txtaadhar.setBounds(280, 350, 350, 25);
        txtaadhar.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(txtaadhar);


        citizen = new JLabel("Senior Citizen:");
        citizen.setFont(labelFont);
        citizen.setBounds(80, 390, 200, 25);
        add(citizen);


        syes=new JRadioButton("Yes");
        syes.setBounds(280,390,70,25);
        syes.setBackground(Color.white);
        add(syes);

        sno=new JRadioButton("No");
        sno.setBounds(350,390,290,25);
        sno.setBackground(Color.white);
        add(sno);

        ButtonGroup sgp=new ButtonGroup();
        sgp.add(syes);
        sgp.add(sno);


        Exaccount = new JLabel("Exisiting Account:");
        Exaccount.setFont(labelFont);
        Exaccount.setBounds(80, 430, 200, 25);
        add(Exaccount);

        Exyes=new JRadioButton("Yes");
        Exyes.setBounds(280,430,70,25);
        Exyes.setBackground(Color.white);
        add(Exyes);

        Exno=new JRadioButton("No");
        Exno.setBounds(350,430,290,25);
        Exno.setBackground(Color.white);
        add(Exno);

        ButtonGroup Exgp=new ButtonGroup();
        Exgp.add(Exyes);
        Exgp.add(Exno);


       

        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(550, 520, 80, 30);
        add(next);

        prev=new JButton("Prev");
        prev.setBackground(Color.black);
        prev.setForeground(Color.white);
        prev.setFont(new Font("Raleway",Font.BOLD,14));
        prev.setBounds(450,520,80,30);
        add(prev);

      
        next.addActionListener(this);
        prev.addActionListener(this);
        setSize(700, 650);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String sreligion = (String) religion1.getSelectedItem();
        String scategory=(String)cat.getSelectedItem();
        String sincome=(String)inc.getSelectedItem();

        String squalification=(String)Qual.getSelectedItem();

        String seniorst=null;
        if(syes.isSelected())
        {
            seniorst="Yes";
        }
        else if(sno.isSelected())
        {
            seniorst="No";
        }

        String exacount=null;
        if(Exyes.isSelected())
        {
            exacount="Yes";
        }
        else if(Exno.isSelected())
        {
            exacount="No";
        }

        String stpan=txtpan.getText();
        String staadhar=txtaadhar.getText();

        if(e.getSource()==next)
        {


          try{
            if(staadhar.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Aadhar Number is requred");

            }
            else 
            {
                

                
                Conn ca=new Conn();
               
                String query = "INSERT INTO signuptwo (Formno, Religion, Category, Income, Qualification, PAN, Aadhar, Senior_Citizen, Exisiting_Account) " +
                "VALUES ('" + formno + "', '" + sreligion + "', '" + scategory + "', '" + sincome + "', '" + squalification + "', '" + stpan + "', '" + staadhar + "', '" + seniorst + "', '" + exacount+ "')";
 
                 ca.s.executeUpdate(query);

                 setVisible(false);
                 
                 new signup3(formno).setVisible(true);

            }

        }catch(Exception ee){
            System.out.println(ee);
        }
    }
    else if(e.getSource()==prev)
    {
        setVisible(false);

        try {
            Conn del=new Conn();
            String Q="DELETE FROM signup WHERE  formno = '"+formno+"'";
            del.s.executeUpdate(Q);
                                     

        } catch (Exception ee) {
            System.out.println(ee);
        }
      
        new signup().setVisible(true);
    }
    }
   
} 
