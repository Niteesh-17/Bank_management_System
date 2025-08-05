import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Balanceenquiry extends JFrame implements ActionListener {

    JButton BACK;
    String pinnumber ;
   
    Balanceenquiry(String pinnumber){
        this.pinnumber=pinnumber;

             BACK = new JButton("BACK");
      BACK.setBounds(350, 485, 150, 30);
      BACK.addActionListener(this);
   
       
 int balance = 0;
       
         conn c = new conn();
                try {
                    ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                   
                    while(rs.next()){
                              if(rs.getString("type").equals("Deposit")) {
                                balance +=Integer.parseInt(rs.getString("amount"));
                              }else{
                                balance -= Integer.parseInt(rs.getString("amount"));
                              }

                    }  }catch (Exception ae){
                        System.out.println(ae);
                    }

                 JLabel l1 = new JLabel("YOUR CURRENT ACCOUNT BALANCE IS RS "+balance);  
                 l1.setBounds(170, 300, 400, 30);
               l1.setForeground(Color.white);

  ImageIcon i1 = new ImageIcon("atm.jpg");
      Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel image = new JLabel(i3);
      image.setBounds(0,0,900,900);
      this.add(image);
      image.add(BACK);
      image.add(l1);

        this.setLayout(null);
        this.setSize(900,900);
        this.setLocation(300,0);
        this.setUndecorated(true);
        this.setVisible(true);
    }

     @Override
    public void actionPerformed(ActionEvent e) {
     if (e.getSource()==BACK) {
        this.setVisible(false);
        new Transaction(pinnumber).setVisible(true);
     }
    }
    public static void main(String[] args) {
        new Balanceenquiry("");
    }
   
}
