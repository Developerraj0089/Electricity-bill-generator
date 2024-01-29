import java.awt.Choice;
import java.awt.Color;
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

import com.mysql.cj.protocol.Resultset;

public class login extends JFrame implements ActionListener {
    JButton Login, signup, cancel;
    JTextField username, password;
    Choice loginin;

    login() {
        super("Login Page");
        getContentPane().setBackground(Color.white);
        setLayout(null);
        JLabel uname = new JLabel("username");
        uname.setBounds(300, 20, 100, 20);
        add(uname);
        username = new JTextField();
        username.setBounds(400, 20, 150, 20);
        add(username);

        JLabel upassword = new JLabel("Password");
        upassword.setBounds(300, 60, 100, 20);
        add(upassword);
        password = new JTextField();
        password.setBounds(400, 60, 150, 20);
        add(password);

        JLabel loginas = new JLabel("Login as");
        loginas.setBounds(300, 100, 100, 20);
        add(loginas);
        loginin = new Choice();
        loginin.add("Admin");
        loginin.add("User");
        loginin.setBounds(400, 100, 150, 20);
        add(loginin);

        Login = new JButton("Login");
        Login.setBounds(330, 160, 100, 20);
        Login.addActionListener(this);
        add(Login);
        signup = new JButton("Signup");
        signup.setBounds(450, 160, 100, 20);
        signup.addActionListener(this);
        add(signup);
        cancel = new JButton("Cancel");
        cancel.setBounds(380, 200, 100, 20);
        cancel.addActionListener(this);
        add(cancel);
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("./image/icon/second.jpg"));
        Image i8 = i7.getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel image = new JLabel(i9);
        image.setBounds(0, 0, 250, 250);
        add(image);
        setSize(600, 500);
        setLocation(700, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Login) {
            String susername = username.getText();
            String spassword = password.getText();
            String user = loginin.getSelectedItem();
            try {
                conn c = new conn();
                String query = "select* from login where username='" + susername + "' and password='" + spassword
                        + "' and accounttype='" + user + "' ";
                // c.s.executeQuery(query);
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    String meterr = rs.getString("meter_no");
                    setVisible(false);
                    new project(user, meterr);
                } else {
                    JOptionPane.showMessageDialog(null, "invalid login");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new signup();
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new login();
    }
}
