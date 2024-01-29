import java.awt.Color;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.mysql.cj.protocol.Resultset;

import net.proteanit.sql.DbUtils;

public class billdetail extends JFrame{
    billdetail(String meterr){
      setBounds(400,150,700,650);
      getContentPane().setBackground(Color.WHITE);
      setLayout(null);
JTable table=new JTable();
try {
    conn c=new conn();
    String query="select*from bill where meter_no='"+meterr+"' ";
    ResultSet rs=c.s.executeQuery(query);
     table.setModel(DbUtils.resultSetToTableModel(rs));
    
} catch (Exception e) {
    e.printStackTrace();
}
JScrollPane sp=new JScrollPane(table);
sp.setBounds(0,0,700,650);
add(sp);
      setVisible(true);
    }
    public static void main(String[] args) {
        new billdetail("");
    }
}
