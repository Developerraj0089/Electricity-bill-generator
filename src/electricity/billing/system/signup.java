import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class signup extends JFrame implements ActionListener {
    JButton back,create;
    Choice accounttype;
    JTextField meterno,name,nametext,password;
    
    signup() {
        setBounds(450, 150, 700, 400);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        JPanel panel = new JPanel();
        panel.setBounds(30, 30, 650, 300);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 3), "Create Account",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(172,216,230)));
        panel.setBackground(Color.white);
        panel.setLayout(null);
        panel.setForeground(new Color(34,139,34));
        add(panel);

        JLabel heading=new JLabel("Create Account");
        heading.setBounds(100,50,140,20);
        panel.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(heading);

         accounttype=new Choice();
        accounttype.add("Admin");
        accounttype.add("User");
        panel.add(accounttype);

        accounttype.setBounds(250,50,140,20);



          JLabel meter=new JLabel("Meter Number");
        meter.setBounds(100,90,140,20);
        panel.setFont(new Font("Tahoma",Font.BOLD,14));
        meter.setVisible(false);
        panel.add(meter);
         meterno=new JTextField();
        meterno.setBounds(250,90,150,20);
                meterno.setVisible(false);

        panel.add(meterno);
        
        meterno.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe){}
            @Override
            public void focusLost(FocusEvent fe){
                try {
                    conn c=new conn();
                    ResultSet rs=c.s.executeQuery("select*from login where meter_no='"+meterno.getText()+"'");
                    while (rs.next()) {
                        nametext.setText(rs.getString("name"));
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
          

        });

        JLabel uname=new JLabel("Username");
        uname.setBounds(100,130,140,20);
        uname.setForeground(Color.gray);
        uname.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(uname);
         name=new JTextField();
        name.setBounds(250,130,150,20);
        panel.add(name);

        JLabel namee=new JLabel("Name");
        namee.setBounds(100,170,140,20);
        namee.setForeground(Color.gray);
        namee.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(namee);
         nametext=new JTextField();
        nametext.setBounds(250,170,150,20);
        panel.add(nametext);

        JLabel upass=new JLabel("Password");
        upass.setBounds(100,210,140,20);
        upass.setForeground(Color.gray);
        upass.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(upass);
         password=new JTextField();
        password.setBounds(250,210,150,20);
        panel.add(password);
        accounttype.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ae){
                String user=accounttype.getSelectedItem();
                if(user.equals("User")){
                    meter.setVisible(true);
                    meterno.setVisible(true);
                    nametext.setEditable(false);

                }
                else{
                        meter.setVisible(false);
                    meterno.setVisible(false);
                             nametext.setEditable(true);

                }
            }
        });


        create=new JButton("Create");
        create.setBackground(Color.black);
        create.setForeground(Color.white);
        create.setBounds(140,260,120,25);
        create.addActionListener(this);
        panel.add(create);

         back=new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(290,260,120,25);
        back.addActionListener(this);
        panel.add(back);

    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("./image/icon/signupImage.png"));
    Image i2=i1.getImage().getScaledInstance(250,250, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(410,30,250,250);
    panel.add(image);

    setVisible(true); 


    } 
public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==create){
       String atype=accounttype.getSelectedItem();
       String surname=name.getText();
       String sname=nametext.getText();
       String spassword=password.getText();
       String smeter=meterno.getText();
       try {
        conn c=new conn();
        String query=null;
        if (atype.equals("Admin")) {
            query=        "insert into login values('"+smeter+"','"+surname+"','"+sname+"','"+spassword+"','"+atype+"')";
            
        } else {
            query="update login set username='"+surname+"', password='"+spassword+"',accounttype='"+atype+"' where meter_no='"+smeter+"' ";
           
        }

       c.s.executeUpdate(query);
       JOptionPane.showMessageDialog(null,"account created successfully");
setVisible(false);
new login();
      
      } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
       }
    }
    else if(ae.getSource()==back){
          setVisible(false);
          new login();

    }
}
    public static void main(String[] args) {
        new signup();
    }
}
