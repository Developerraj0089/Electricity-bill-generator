import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class project extends JFrame implements ActionListener {
  String atype,meterr;
  project(String atype, String meterr) {
    this.atype=atype;
    this.meterr=meterr;

    setExtendedState(JFrame.MAXIMIZED_BOTH);
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./image/icon/elect1.jpg"));
    Image i2 = i1.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    add(image);

    JMenuBar mb = new JMenuBar();
    setJMenuBar(mb);
    JMenu master = new JMenu("Master");

    JMenuItem newcustomer = new JMenuItem("New Customer");
    newcustomer.setBackground(Color.white);
    ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("./image/icon/icon1.png"));
    Image image1 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
    newcustomer.setIcon(new ImageIcon(image1));
    newcustomer.setMnemonic('D');
    newcustomer.addActionListener(this);
    newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
    master.add(newcustomer);

    JMenuItem customerdetail = new JMenuItem("Customer Details");
    customerdetail.setBackground(Color.white);
    ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("./image/icon/icon2.png"));
    Image image2 = icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
    customerdetail.setIcon(new ImageIcon(image2));
    customerdetail.setMnemonic('M');
    customerdetail.addActionListener(this);
    customerdetail.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
    master.add(customerdetail);

    JMenuItem depositdetails = new JMenuItem("Deposit Details");
    depositdetails.setBackground(Color.white);
    ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("./image/icon/icon3.png"));
    Image image3 = icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
    depositdetails.setMnemonic('N');
    depositdetails.addActionListener(this);
    depositdetails.setIcon(new ImageIcon(image3));
    depositdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
    master.add(depositdetails);

    JMenuItem calculatebill = new JMenuItem("Calculate bill");
    calculatebill.setBackground(Color.white);
    ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("./image/icon/icon4.png"));
    Image image4 = icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
    calculatebill.setMnemonic('B');
    calculatebill.addActionListener(this);
    calculatebill.setIcon(new ImageIcon(image4));
    calculatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
    master.add(calculatebill);

    JMenu info = new JMenu("Information");
    info.setForeground(Color.red);

    JMenuItem updateinfo = new JMenuItem("Update Information");
    updateinfo.setBackground(Color.white);
    ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("./image/icon/icon5.png"));
    Image image5 = icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
    updateinfo.setMnemonic('B');
     updateinfo.addActionListener(this);
    updateinfo.setIcon(new ImageIcon(image5));
    updateinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
    info.add(updateinfo);

    JMenuItem viewinfo = new JMenuItem("View Information");
    viewinfo.setBackground(Color.white);
    ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("./image/icon/icon6.png"));
    Image image6 = icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
    viewinfo.setMnemonic('B');
    viewinfo.addActionListener(this);
    viewinfo.setIcon(new ImageIcon(image6));
     viewinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
    info.add(viewinfo);

    JMenu user = new JMenu("User");
    user.setForeground(Color.blue);

    JMenuItem paybill = new JMenuItem("Pay Bills");
    paybill.setBackground(Color.white);
    ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("./image/icon/icon5.png"));
    Image image7 = icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
    paybill.setMnemonic('B');
    paybill.setIcon(new ImageIcon(image7));
    paybill.addActionListener(this);
    paybill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
    user.add(paybill);

    JMenuItem billdetail = new JMenuItem("Bill Details");
    billdetail.setBackground(Color.white);
    ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("./image/icon/icon6.png"));
    Image image8 = icon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
    billdetail.setMnemonic('B');
    billdetail.setIcon(new ImageIcon(image8));
    billdetail.addActionListener(this);
    billdetail.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
    user.add(billdetail);

    JMenu report = new JMenu("Report");
    report.setForeground(Color.red);

    JMenuItem generatebill = new JMenuItem("Generate Bills");
    generatebill.setBackground(Color.white);
    ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("./image/icon/icon5.png"));
    Image image9 = icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
    generatebill.setMnemonic('B');
    generatebill.setIcon(new ImageIcon(image9));
    generatebill.addActionListener(this);
    generatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
    report.add(generatebill);

    JMenu utility = new JMenu("Utility");
    utility.setForeground(Color.blue);

    JMenuItem notepad = new JMenuItem("Notepad");
    notepad.setBackground(Color.white);
    ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("./image/icon/icon5.png"));
    Image image10 = icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
    notepad.setMnemonic('B');
    notepad.setIcon(new ImageIcon(image10));
    notepad.addActionListener(this);
    notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
    utility.add(notepad);

    JMenuItem calculator = new JMenuItem("Calculator");
    calculator.setBackground(Color.white);
    ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("./image/icon/icon9.png"));
    Image image11 = icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
    calculator.setMnemonic('C');
    calculator.setIcon(new ImageIcon(image11));
    calculator.addActionListener(this);
    calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
    utility.add(calculator);

    JMenu exit = new JMenu("Exit");
    exit.setForeground(Color.red);

    if(atype.equals("Admin"))
    {
      mb.add(master);
    }
    else{ mb.add(info);
mb.add(report);
   
    mb.add(user);
    }
    // mb.add(master);
    mb.add(utility);
        mb.add(exit);
    

    JMenuItem exitt = new JMenuItem("Exit");
    exitt.setBackground(Color.white);
    ImageIcon icon12 = new ImageIcon(ClassLoader.getSystemResource("./image/icon/icon11.png"));
    Image image12 = icon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
    exitt.setMnemonic('W');
    exitt.setIcon(new ImageIcon(image12));
    exitt.addActionListener(this);
    exitt.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
    exit.add(exitt);

    setVisible(true);

  }

  public void actionPerformed(ActionEvent ae) {
    String msg = ae.getActionCommand();
    if (msg.equals("New Customer")) {
      new newcustomer();
    } else if (msg.equals("Customer Details")) {
      new customerdetail();

    } else if (msg.equals("Deposit Details")) {
      new depositdetail();

    } else if (msg.equals("Calculate bill")) {

      new calculatebill();

    }
    else if(msg.equals("View Information")){
      new viewinfo(meterr);
    }
    else if(msg.equals("Update Information")){
  new updateinfo(meterr);
    }
    else if(msg.equals("Bill Details")){
      new billdetail(meterr);
    }
    else if(msg.equals("Notepad")){
     
      try {
         Runtime.getRuntime().exec("notepad.exe");
      } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
      }
    }
    else if(msg.equals("Calculator")){
     
      try {
         Runtime.getRuntime().exec("calc.exe");
      } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
      }
    }
    else if(msg.equals("Exit")){
      setVisible(false);
      new login();
    }
    else if(msg.equals("Pay Bills")){
      new paybill(meterr);
    }
    else if(msg.equals("Generate Bills")){
      new generatebill(meterr);
    }

    } 
   


  

  public static void main(String[] args) {
    new project("","");
  }
}
