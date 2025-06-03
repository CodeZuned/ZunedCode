
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;

public class etc extends JFrame {
    public etc() {
        setTitle("Date Chooser Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("dd-MM-yyyy");

        add(dateChooser);
        setVisible(true);
    }

    public static void main(String[] args) {
        new etc();
    }
}
