import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Paytm extends JFrame implements ActionListener {
    String meterr;
    JButton back;

    Paytm(String meterr) {
        this.meterr = meterr;
        JEditorPane j = new JEditorPane();
        j.setEditable(false);
        try {
            j.setPage("https://paytm.com/online-payments");
        } catch (Exception e) {
            j.setContentType("text/html");
            j.setText("<html>could not load<html>");
        }
        JScrollPane sp = new JScrollPane(j);
        add(sp);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(640, 20, 80, 30);
        back.addActionListener(this);
        j.add(back);
        setSize(800, 600);
        setLocation(400, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new paybill(meterr);
    }

    public static void main(String[] args) {
        new Paytm("");
    }

}
