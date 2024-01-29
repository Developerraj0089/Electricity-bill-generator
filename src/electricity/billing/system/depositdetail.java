import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.*;

public class depositdetail extends JFrame implements ActionListener{
    Choice meternumber,cmonth;
    JTable table;
    JButton search,print;
    depositdetail() {
        super("Deposit Details");
        setSize(700, 700);
        setLocation(400, 100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);


        JLabel lblmeternumber = new JLabel("Search by meter no.");
        lblmeternumber.setBounds(20, 20, 150, 20);
        add(lblmeternumber);

        meternumber=new Choice();
        meternumber.setBounds(180,20,150,20);
        add(meternumber);


        try {
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select*from customer");
            while (rs.next()) {
                meternumber.add(rs.getString("meter_no"));
                
            }
            
        } catch (Exception e) {
          
            e.printStackTrace();
        }

  JLabel lblmonth = new JLabel("Search by meter no.");
        lblmonth.setBounds(350, 20, 150, 20);
        add(lblmonth);

        cmonth=new Choice();
        cmonth.setBounds(500,20,150,20);
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

        table =new JTable();
        try {
            conn c=new conn();
        ResultSet rs=  c.s.executeQuery("select*from bill");
            table.setModel(DbUtils.resultSetToTableModel(rs));
  
        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane sp= new JScrollPane(table);
        sp.setBounds(0,100,700,600);
        add(sp);

        search =new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        print =new JButton("Print");
        print.setBounds(200,70,80,20);
                print.addActionListener(this);

        add(print);








        setVisible(true);


    }
 public void actionPerformed(ActionEvent ae)
 {
    if (ae.getSource()==search) {
        String query="select*from bill where meter_no='"+meternumber.getSelectedItem()+"'and month='"+cmonth.getSelectedItem()+"'";
try {
    conn c=new conn();
    ResultSet rs=c.s.executeQuery(query);
    table.setModel(DbUtils.resultSetToTableModel(rs));
    
} catch (Exception e) {
    // TODO: handle exception
    e.printStackTrace();
}


    }
    else{
       try {
        table.print();
        
       } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
       }
    }
 }
    public static void main(String[] args) {
        new depositdetail();
    }
}