import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.util.*;
 import java.sql.ResultSet;
 
public class Withdrawal extends JFrame implements ActionListener{
     JButton back,wit;
       JTextField amounttext;
      String Pinnumber;
    Withdrawal(String Pinnumber){
          
    JLabel l2 = new JLabel("Enter the amount you want to Withdraw "); 
    l2.setFont(new Font("SYSTEM",Font.BOLD,15));
    l2.setForeground(Color.white);
    l2.setBounds(170,300,400,20);

     amounttext = new JTextField();
    amounttext.setFont(new Font("Railway",Font.BOLD,22));
    amounttext.setBounds(170, 350, 320, 25);

    wit = new JButton("Withdraw");
      wit.setBounds(355,485,150,30);
    wit.addActionListener(this);

     back = new JButton("Back");
    back.setBounds(355,520,150,30);
    back.addActionListener(this);
    
      ImageIcon i1 = new ImageIcon("atm.jpg");
    Image I = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(I);

      JLabel l1 = new JLabel(i3);   
    l1.setBounds(0,0,900,900);
    l1.add(back);
     l1.add(l2);
     l1.add(amounttext);
     l1.add(wit);
     this.Pinnumber=Pinnumber;
    this.setLayout(null);
    this.add(l1);
     this.setSize(900,900);
       this.setLocation(300,0);
       this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==back){
        this.setVisible(false);
      Transaction t1 = new Transaction(Pinnumber);
      }else if (e.getSource()==wit){
        String number = amounttext.getText();
        Date d = new Date();
        if(number.equals("")){
         JOptionPane.showMessageDialog(null, "Enter the amount");
        }else{
            try{
            conn C1 = new conn();
           String query = "INSERT INTO bank VALUES('" + Pinnumber + "', '" + d + "', 'withdrawl', '" + number + "')";

            C1.s.executeUpdate(query);
          JOptionPane.showMessageDialog(null,"Rs " + number + " Withdrawn Successfully");
            this.setVisible(false);
            new Transaction(Pinnumber).setVisible(true);
            }
            catch (Exception ea){
               System.out.println(ea);
            }
        }
      }
    }

     public static void main(String[] args) {
        new Withdrawal("");
     }
    
}