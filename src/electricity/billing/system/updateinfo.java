import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class updateinfo extends JFrame implements ActionListener {
  TextField phone, address, city, state, email;
  JButton update, cancel;
  String meterr;

  updateinfo(String meterr) {
    this.meterr = meterr;
    setBounds(300, 150, 1050, 450);
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    JLabel heading = new JLabel("UPDATE CUSTOMER INFORMATION");
    heading.setBounds(110, 0, 400, 30);
    heading.setFont(new Font("Tanhoma", Font.PLAIN, 24));
    add(heading);

    JLabel lblname = new JLabel("Name");
    lblname.setBounds(30, 70, 100, 20);
    add(lblname);
    JLabel name = new JLabel("");
    name.setBounds(230, 70, 200, 20);
    add(name);
    JLabel lblmeternumber = new JLabel("Meter Number");
    lblmeternumber.setBounds(30, 110, 100, 20);
    add(lblmeternumber);
    JLabel meternumber = new JLabel("");
    meternumber.setBounds(230, 110, 200, 20);
    add(meternumber);

    JLabel lbladdress = new JLabel("Address");
    lbladdress.setBounds(30, 150, 100, 20);
    add(lbladdress);
    address = new TextField("");
    address.setBounds(230, 150, 200, 20);
    add(address);
    JLabel lblcity = new JLabel("City");
    lblcity.setBounds(30, 190, 100, 20);
    add(lblcity);
    city = new TextField("");
    city.setBounds(230, 190, 200, 20);
    add(city);
    JLabel lblstate = new JLabel("State");
    lblstate.setBounds(30, 230, 100, 20);
    add(lblstate);
    state = new TextField("");
    state.setBounds(230, 230, 200, 20);
    add(state);
    JLabel lblemail = new JLabel("Email");
    lblemail.setBounds(30, 270, 100, 20);
    add(lblemail);
    email = new TextField("");
    email.setBounds(230, 270, 200, 20);
    add(email);
    JLabel lblphone = new JLabel("Phone");
    lblphone.setBounds(30, 310, 100, 20);
    add(lblphone);
    phone = new TextField("");
    phone.setBounds(230, 310, 200, 20);
    add(phone);

    try {
      conn c = new conn();
      ResultSet rs = c.s.executeQuery("select* from customer where meter_no='" + meterr + "' ");
      while (rs.next()) {
        name.setText(rs.getString("name"));
        address.setText(rs.getString("address"));
        city.setText(rs.getString("city"));
        state.setText(rs.getString("state"));
        email.setText(rs.getString("email"));
        phone.setText(rs.getString("phone"));
        meternumber.setText(rs.getString("meter_no"));

      }

    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
    update = new JButton("Update");
    update.setBackground(Color.black);
    update.setForeground(Color.white);
    update.setBounds(70, 360, 100, 25);
    update.addActionListener(this);
    add(update);

    cancel = new JButton("Cancel");
    cancel.setBackground(Color.black);
    cancel.setForeground(Color.white);
    cancel.setBounds(230, 360, 100, 25);
    cancel.addActionListener(this);
    add(cancel);
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./image/icon/update.jpg"));
    Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(550, 50, 400, 300);
    add(image);

    setVisible(true);

  }

  public void actionPerformed(ActionEvent ae) {
    // setVisible(false);
    if (ae.getSource() == update) {
      String tfaddress = address.getText();
      String tfcity = city.getText();
      String tfstate = state.getText();
      String tfphone = phone.getText();
      String tfemail = email.getText();

      try {
        conn c = new conn();
        c.s.executeUpdate("Update customer set address='" + tfaddress + "', city='" + tfcity + "', state='" + tfstate
            + "', phone='" + tfphone + "',email='" + tfemail + "' where meter_no='" + meterr + "'");
        JOptionPane.showMessageDialog(null, "Update successfully");
      } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
      }

    }
  }

  public static void main(String[] args) {
    new updateinfo("");
  }

}
