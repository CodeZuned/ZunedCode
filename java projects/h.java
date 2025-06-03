
import java.awt.*;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

public class h extends JFrame {
    JLabel formno, pDetail, name, fname, dob, gender, address, city, email;
    JLabel marital, state, pincode;
    JButton next;
    JTextField txtname, txtfname, txtemail, txtcity, txtstate, txtpin, txtaddress;

    public static void main(String args[]) {
        new h();
    }

    public h() {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        Random rm = new Random();
        long n = Math.abs((rm.nextLong() % 9000L) + 1000L);

        Font labelFont = new Font("Raleway", Font.BOLD, 18);
        Font fieldFont = new Font("Raleway", Font.PLAIN, 16);

        formno = new JLabel("APPLICATION FORM NO. " + n);
        formno.setFont(new Font("Raleway", Font.BOLD, 28));
        formno.setBounds(100, 20, 600, 30);
        add(formno);

        pDetail = new JLabel("Page 1: Personal Details");
        pDetail.setFont(new Font("Raleway", Font.BOLD, 22));
        pDetail.setBounds(230, 60, 400, 30);
        add(pDetail);

        name = new JLabel("Name:");
        name.setFont(labelFont);
        name.setBounds(80, 110, 150, 25);
        add(name);

        txtname = new JTextField();
        txtname.setFont(fieldFont);
        txtname.setBounds(280, 110, 350, 25);
        txtname.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(txtname);

        fname = new JLabel("Father's Name:");
        fname.setFont(labelFont);
        fname.setBounds(80, 150, 200, 25);
        add(fname);

        txtfname = new JTextField();
        txtfname.setFont(fieldFont);
        txtfname.setBounds(280, 150, 350, 25);
        txtfname.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(txtfname);

        dob = new JLabel("Date of Birth:");
        dob.setFont(labelFont);
        dob.setBounds(80, 190, 200, 25);
        add(dob);

        JDateChooser datechooser = new JDateChooser();
        datechooser.setBounds(280, 190, 350, 25);
        datechooser.setForeground(new Color(105, 105, 105));
        add(datechooser);

        gender = new JLabel("Gender:");
        gender.setFont(labelFont);
        gender.setBounds(80, 230, 200, 25);
        add(gender);

        JRadioButton male = new JRadioButton("Male");
        male.setBounds(280, 230, 100, 25);
        male.setBackground(Color.white);
        add(male);

        JRadioButton female = new JRadioButton("Female");
        female.setBounds(400, 230, 100, 25);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup ggroup = new ButtonGroup();
        ggroup.add(male);
        ggroup.add(female);

        email = new JLabel("Email Address:");
        email.setFont(labelFont);
        email.setBounds(80, 270, 200, 25);
        add(email);

        txtemail = new JTextField();
        txtemail.setFont(fieldFont);
        txtemail.setBounds(280, 270, 350, 25);
        txtemail.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(txtemail);

        marital = new JLabel("Marital Status:");
        marital.setFont(labelFont);
        marital.setBounds(80, 310, 200, 25);
        add(marital);

        JRadioButton marid = new JRadioButton("Married");
        marid.setBounds(280, 310, 100, 25);
        marid.setBackground(Color.white);
        add(marid);

        JRadioButton unmarid = new JRadioButton("Unmarried");
        unmarid.setBounds(390, 310, 120, 25);
        unmarid.setBackground(Color.white);
        add(unmarid);

        JRadioButton other = new JRadioButton("Other");
        other.setBounds(520, 310, 100, 25);
        other.setBackground(Color.white);
        add(other);

        ButtonGroup mgroup = new ButtonGroup();
        mgroup.add(marid);
        mgroup.add(unmarid);
        mgroup.add(other);

        address = new JLabel("Address:");
        address.setFont(labelFont);
        address.setBounds(80, 350, 200, 25);
        add(address);

        txtaddress = new JTextField();
        txtaddress.setFont(fieldFont);
        txtaddress.setBounds(280, 350, 350, 25);
        txtaddress.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(txtaddress);

        city = new JLabel("City:");
        city.setFont(labelFont);
        city.setBounds(80, 390, 200, 25);
        add(city);

        txtcity = new JTextField();
        txtcity.setFont(fieldFont);
        txtcity.setBounds(280, 390, 350, 25);
        txtcity.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(txtcity);

        state = new JLabel("State:");
        state.setFont(labelFont);
        state.setBounds(80, 430, 200, 25);
        add(state);

        txtstate = new JTextField();
        txtstate.setFont(fieldFont);
        txtstate.setBounds(280, 430, 350, 25);
        txtstate.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(txtstate);

        pincode = new JLabel("Pin Code:");
        pincode.setFont(labelFont);
        pincode.setBounds(80, 470, 200, 25);
        add(pincode);

        txtpin = new JTextField();
        txtpin.setFont(fieldFont);
        txtpin.setBounds(280, 470, 350, 25);
        txtpin.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(txtpin);

        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(550, 520, 80, 30);
        add(next);

        setSize(700, 650);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
