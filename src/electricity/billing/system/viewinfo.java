import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class viewinfo extends JFrame implements ActionListener {

  JButton cancel;
  String meterr;

  viewinfo(String meterr) {
    this.meterr = meterr;
    setBounds(350, 150, 850, 650);
    getContentPane().setBackground(Color.WHITE);
    // setLayout(null);
    JLabel heading = new JLabel("VIEW CUSTOMER INFORMATION");
    heading.setBounds(250, 0, 500, 40);
    heading.setFont(new Font("Tanhoma", Font.PLAIN, 24));
    add(heading);

    JLabel lblname = new JLabel("Name");
    lblname.setBounds(70, 80, 100, 20);
    add(lblname);
    JLabel name = new JLabel("");
    name.setBounds(250, 80, 100, 20);
    add(name);
    JLabel lblmeternumber = new JLabel("Meter Number");
    lblmeternumber.setBounds(70, 140, 100, 20);
    add(lblmeternumber);
    JLabel meternumber = new JLabel("");
    meternumber.setBounds(250, 140, 100, 20);
    add(meternumber);

    JLabel lbladdress = new JLabel("Address");
    lbladdress.setBounds(70, 200, 100, 20);
    add(lbladdress);
    JLabel address = new JLabel("");
    address.setBounds(250, 200, 100, 20);
    add(address);
    JLabel lblcity = new JLabel("City");
    lblcity.setBounds(70, 260, 100, 20);
    add(lblcity);
    JLabel city = new JLabel("");
    city.setBounds(250, 260, 100, 20);
    add(city);
    JLabel lblstate=new JLabel("State");
    lblstate.setBounds(500,80,100,20);
    add(lblstate);
    JLabel state=new JLabel("");
    state.setBounds(650,80,100,20);
    add(state);
    JLabel lblemail=new JLabel("Email");
    lblemail.setBounds(500,140,100,20);
    add(lblemail);
    JLabel email=new JLabel("");
    email.setBounds(650,140,100,20);
    add(email);
    JLabel lblphone=new JLabel("Phone");
    lblphone.setBounds(500,200,100,20);
    add(lblphone);
    JLabel phone=new JLabel("");
    phone.setBounds(650,200,100,20);
    add(phone);

    try {
      conn c = new conn();
      ResultSet rs = c.s.executeQuery("select* from customer where meter_no='"+meterr+"' ");
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
    cancel = new JButton("Cancel");
    cancel.setBackground(Color.black);
    cancel.setForeground(Color.white);
    cancel.setBounds(350, 340, 100, 25);
    cancel.addActionListener(this);
    add(cancel);
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./image/icon/viewcustomer.jpg"));
    Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(20, 350, 600, 300);
    add(image);

    setVisible(true);
  }

  public void actionPerformed(ActionEvent ae){
    setVisible(true);

  }
  public static void main(String[] args) {
    new viewinfo("");
  }
}
