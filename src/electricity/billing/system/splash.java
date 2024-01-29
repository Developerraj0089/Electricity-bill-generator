
// import javax.swing.JFrame;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
public  class splash extends JFrame implements Runnable {
    Thread t;
splash(){
  
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("./image/dima-panyukov-DwxlhTvC16Q-unsplash.jpg"));
    Image i2=i1.getImage().getScaledInstance(730,550,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel Image =new JLabel(i3);
    add(Image);
    setLocation(400,300);
    setSize(700,400);
    t=new Thread(this);
    t.start();

    setVisible(true);

}
public void run()
{
    try{
        Thread.sleep(3000);
        setVisible(false);
        new login();
    }
    catch(Exception e){
        e.printStackTrace();
    }
}
    public static void main(String[] args){
        new splash();
        
    }
}