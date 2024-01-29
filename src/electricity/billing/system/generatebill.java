import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Font;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class generatebill extends JFrame implements ActionListener {
    Choice cmonth;
    JTextArea area;
    String meterr;
    JButton bill;

    generatebill(String meterr) {
        this.meterr = meterr;
        setBounds(550, 30, 500, 800);
        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        JLabel heading = new JLabel("Generate Bill");
        JLabel meternumber = new JLabel(meterr);

        cmonth = new Choice();
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
        // add(cmonth);
        area = new JTextArea(50, 15);
        area.setText("\n\n\t---------Click on the-------\n\t Generate Bill Button to get\n\t");
        area.setFont(new Font("Senserif", Font.ITALIC, 18));
        JScrollPane pane = new JScrollPane(area);
        bill = new JButton("Generate Bill");
        bill.addActionListener(this);

        panel.add(heading);
        panel.add(meternumber);
        panel.add(cmonth);
        add(panel, "North");
        add(pane, "Center");
        add(bill, "South");

        // setLayout(null);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {

            conn c = new conn();
            String month = cmonth.getSelectedItem();
            area.setText(
                    "\tReliance power limited\nELECTRICITY BILL GENERATOR FOR THE MONTH\n\t OF " + month + ",2023\n");
            ResultSet rs = c.s.executeQuery("select*from customer where meter_no='"+meterr+"'  ");
            if (rs.next()) {
                area.append("\n    Customer Name:    " + rs.getString("name"));
                area.append("\n    Meter Number:      " + rs.getString("meter_no"));
                area.append("\n    Address:                " + rs.getString("address"));
                area.append("\n    City:                       " + rs.getString("city"));
                area.append("\n    State:                    " + rs.getString("state"));
                area.append("\n    Email:                  " + rs.getString("email"));
                area.append("\n    Phone:                 " + rs.getString("phone"));
                area.append("\n------------------------------------------------------ \n");
            }
             rs = c.s.executeQuery("select*from meter_info where meter_no='"+meterr+"'  ");
            if (rs.next()) {

                area.append("\n    Meter Location:     " + rs.getString("meter_location"));
                area.append("\n    Meter Type:          " + rs.getString("meter_type"));
                area.append("\n    Phase Code:        " + rs.getString("phase_code"));
                area.append("\n    Bill Type:              " + rs.getString("bill_type"));
                area.append("\n    Days:                   " + rs.getString("days"));
                   area.append("\n------------------------------------------------------\n ");
            }
             rs = c.s.executeQuery("select*from bill where meter_no='"+meterr+"' and month='"+month+"'  ");
            if (rs.next()) {

                area.append("\n    Month :              " + rs.getString("month"));
                area.append("\n    Unit :                  " + rs.getString("unit"));
                area.append("\n    Total Bill:            " + rs.getString("total_bill"));
                area.append("\n    Status:              " + rs.getString("status"));
                   area.append("\n------------------------------------------------------\n ");
            }
                         rs = c.s.executeQuery("select*from tax   ");

            if (rs.next()) {

                area.append("\n    Cost Per Unit :             " + rs.getString("cost_per_unit"));
                area.append("\n    Meter Number :          " + rs.getString("meter_rent"));
                area.append("\n    Service Charge:        " + rs.getString("service_charge"));
                area.append("\n    Service Tax:              " + rs.getString("service_tax"));
                area.append("\n    Swachh Bharat Tax:  " + rs.getString("swachh_bharat_cost"));
                area.append("\n    Fixed Tax:                 " + rs.getString("fixed_tax"));
                   area.append("\n------------------------------------------------------\n ");
            }
                         rs = c.s.executeQuery("select*from bill where meter_no='"+meterr+"' and month='"+month+"'   ");

            if (rs.next()) {

                area.append("\n    Current Month:             " + rs.getString("month"));
                area.append("\n    Units Consumed:          " + rs.getString("unit"));
                area.append("\n    Total Charge:        " + rs.getString("total_bill"));

                   area.append("\n------------------------------------------------------");
                       area.append("\n    Total Payable:        " + rs.getString("total_bill"));
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new generatebill("");
    }
}
