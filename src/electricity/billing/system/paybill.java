import java.awt.Choice;
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

public class paybill extends JFrame implements ActionListener{
Choice cmonth;
JButton back,pay;
String meterr;
    paybill(String meterr) {
        setBounds(300, 150, 900, 600);
        

        JLabel heading = new JLabel("Electricity Bill");
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        heading.setBounds(120, 5, 400, 30);
        add(heading);

        JLabel lblmeternumber = new JLabel("Meter Number");
        lblmeternumber.setBounds(35, 80, 200, 20);
        add(lblmeternumber);
        JLabel meternumber = new JLabel("");
        meternumber.setBounds(300, 80, 200, 20);
        add(meternumber);
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(35, 140, 200, 20);
        add(lblname);
        JLabel labelname = new JLabel("");
        labelname.setBounds(300, 140, 200, 20);
        add(labelname);

        JLabel lblmonth = new JLabel("Month");
        lblmonth.setBounds(35, 200, 200, 20);
        add(lblmonth);

        cmonth = new Choice();
        cmonth.setBounds(300, 200, 200, 20);
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
        add(cmonth);

        JLabel lblunit=new JLabel("Units");
        lblunit.setBounds(35,260,200,20);
        add(lblunit);
        JLabel labelunit=new JLabel("");
        labelunit.setBounds(300  ,260,200,20);
        add(labelunit);
        JLabel lbltotalbill=new JLabel("Total Bill");
        lbltotalbill.setBounds(35,320,200,20);
        add(lbltotalbill);
        JLabel labeltotalbill=new JLabel("");
        labeltotalbill.setBounds(300  ,320,200,20);
        // labeltotalbill.setForeground(Color.red);
        add(labeltotalbill);
        JLabel lblstatus=new JLabel("Status ");
        lblstatus.setBounds(35,380,200,20);
        add(lblstatus);
        JLabel labelstatus=new JLabel("");
        labelstatus.setBounds(300  ,380,200,20);
        labelstatus.setForeground(Color.red);
        add(labelstatus);
        try {
         conn c = new conn();
      ResultSet rs = c.s.executeQuery("select* from customer where meter_no='"+meterr+"' ");
      while (rs.next()) {
meternumber.setText(meterr);
        labelname.setText(rs.getString("name"));
        } 

        rs=c.s.executeQuery("select* from bill where meter_no='"+meterr+"' AND month='January' ");
        while (rs.next()) {
               labelunit.setText(rs.getString("unit"));
    labeltotalbill.setText(rs.getString("total_bill"));
         labelstatus.setText(rs.getString("status"));
            
        }
    }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
 pay=new JButton("Pay");
 pay.setBackground(Color.black);
 pay.setForeground(Color.white);
 pay.setBounds(100,460,100,25);
 pay.addActionListener(this);
 add(pay);


 back=new JButton("Back");
 back.setBackground(Color.black);
 back.setForeground(Color.white);
 back.setBounds(230,460,100,25);
 back.addActionListener(this);
 add(back);

 getContentPane().setBackground(Color.white);

 ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("./image/icon/bill.png"));
 Image i2=i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
 ImageIcon i3=new ImageIcon(i2);
 JLabel image=new JLabel(i3);
 image.setBounds(400,120,600,300);
 add(image);

 setLayout(null);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==pay){
            try {
                conn c=new conn();
                c.s.executeUpdate("update the bill set statue='Paid'where meter_no='"+meterr+"' AND month='"+cmonth.getSelectedItem()+"'  ");

            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            setVisible(false);
            new Paytm(meterr);
        }
    }
    public static void main(String[] args) {
        new paybill("");
    }

}
