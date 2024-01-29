import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class calculatebill extends JFrame implements ActionListener {
    JTextField tfname, tfaddress, tfcity, tfstate, tfemail, tfphone;
    JButton next, cancel;
    JLabel lblmeter, lbladdress, lablename, lableaddress;
    Choice meternumber, cmonth;

    calculatebill() {
        setSize(700, 500);
        setLocation(400, 200);
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        add(p);
        JLabel heading = new JLabel("Calculate Electricity Bill");
        heading.setBounds(180, 10, 300, 25);
        heading.setFont(new Font("Tanhoma", Font.PLAIN, 24));
        p.add(heading);

        JLabel lblname = new JLabel("Meter number");
        lblname.setBounds(100, 80, 100, 20);
        p.add(lblname);

        meternumber = new Choice();
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from customer ");
            while (rs.next()) {
                meternumber.add(rs.getString("meter_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        meternumber.setBounds(240, 80, 200, 20);
        p.add(meternumber);

        JLabel lblmeterno = new JLabel("Name ");
        lblmeterno.setBounds(100, 120, 100, 20);
        p.add(lblmeterno);

        lablename = new JLabel();
        lablename.setBounds(240, 120, 100, 20);
        p.add(lablename);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(100, 160, 100, 20);
        p.add(lbladdress);

        lableaddress = new JLabel();
        lableaddress.setBounds(240, 160, 200, 20);
        p.add(lableaddress);

        try {
            conn c = new conn();
            ResultSet rs = c.s
                    .executeQuery("select*from customer where meter_no='" + meternumber.getSelectedItem() + "'");
            while (rs.next()) {
                lablename.setText(rs.getString("name"));
                lableaddress.setText(rs.getString("address"));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        meternumber.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    conn c = new conn();
                    ResultSet rs = c.s.executeQuery(
                            "select*from customer where meter_no='" + meternumber.getSelectedItem() + "'");
                    while (rs.next()) {
                        lablename.setText(rs.getString("name"));
                        lableaddress.setText(rs.getString("address"));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        JLabel lblcity = new JLabel("Unit consumed");
        lblcity.setBounds(100, 200, 100, 20);
        p.add(lblcity);

        tfcity = new JTextField();
        tfcity.setBounds(240, 200, 200, 20);
        p.add(tfcity);

        JLabel lblstate = new JLabel("Month");
        lblstate.setBounds(100, 240, 100, 20);
        p.add(lblstate);

        cmonth = new Choice();
        cmonth.setBounds(240, 240, 200, 20);
        cmonth.add("January");
        cmonth.add("February");
        cmonth.add("March");
        cmonth.add("April");
        cmonth.add("May");
        cmonth.add("June");
        cmonth.add("July");
        cmonth.add("August");
        cmonth.add("September");
        cmonth.add("October");
        cmonth.add("November");
        cmonth.add("December");

        p.add(cmonth);

        next = new JButton("Submit");
        next.setBounds(120, 390, 100, 25);
        next.addActionListener(this);
        p.add(next);

        cancel = new JButton("Cancel");
        cancel.setBounds(300, 390, 100, 25);
        cancel.addActionListener(this);
        p.add(cancel);

        setLayout(new BorderLayout());

        add(p, "Center");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./image/icon/hicon2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image, "West");
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            String meter = meternumber.getSelectedItem();
            String unit = tfcity.getText();
            String month = cmonth.getSelectedItem();

            int totalbill = 0;
            int unit_consumed = Integer.parseInt(unit);
            String query = "select*from tax";

            try {
                conn c = new conn();
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    totalbill += unit_consumed * Integer.parseInt(rs.getString("cost_per_unit"));
                    totalbill += Integer.parseInt(rs.getString("meter_rent"));
                    totalbill += Integer.parseInt(rs.getString("service_charge"));
                    totalbill += Integer.parseInt(rs.getString("service_tax"));
                    totalbill += Integer.parseInt(rs.getString("swachh_bharat_cost"));
                    totalbill += Integer.parseInt(rs.getString("fixed_tax"));

                }
            } catch (Exception e) {
                e.printStackTrace();

            }
            String query2 = "insert into bill values('" + meter + "','" + month + "','" + unit + "','" + totalbill
                    + "','Not paid')";
            try {
                conn c = new conn();
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Customer bill updated successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new calculatebill();
    }
}
