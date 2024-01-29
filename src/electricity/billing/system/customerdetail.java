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

public class customerdetail extends JFrame implements ActionListener{
    Choice meternumber,cmonth;
    JTable table;
    JButton search,print;
    customerdetail() {
        super("Deposit Details");
        setSize(1200, 650);
        setLocation(200, 150);


    
        table =new JTable();
        try {
            conn c=new conn();
        ResultSet rs=  c.s.executeQuery("select*from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
  
        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane sp= new JScrollPane(table);
        add(sp);

        
        print =new JButton("Print");
                print.addActionListener(this);
        add(print,"South");








        setVisible(true);


    }
 public void actionPerformed(ActionEvent ae)
 {
       try {
        table.print();
        
       } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
       
    }
 }
    public static void main(String[] args) {
        new customerdetail();
    }
}