import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
public class Banklogin extends JFrame implements ActionListener {

     JButton login,signup,clear;
     JTextField cardtext;
     JPasswordField pintext;

    Banklogin(){ 
         
          login = new JButton("LOGIN");
         login.setBounds(300,300,100,30);
         login.setBackground(Color.black);
         login.setForeground(Color.white);

         login.addActionListener(this);

           clear = new JButton("CLEAR");
         clear.setBounds(430,300,100,30);
         clear.setBackground(Color.black);
         clear.setForeground(Color.white);
         
         clear.addActionListener(this);

         signup = new JButton("SIGN UP");
         signup.setBounds(300,350,250,30);
       signup.setBackground(Color.black);
      signup.setForeground(Color.white);

         signup.addActionListener(this);

        JLabel l2 = new JLabel("WELCOME TO NITEESH JAGWANI ATM ");
        l2.setBounds(200,40,600,40);
        l2.setFont(new Font("OSWARD",Font.BOLD,30));

        JLabel cardno = new JLabel("CARD NO");
        cardno.setBounds(120,150,230,30);
        cardno.setFont(new Font("OSWARD",Font.BOLD,30));
        
        cardtext = new JTextField();
        cardtext.setBounds(400,150,230,30);

        JLabel pin = new JLabel(" PASSWORD ");
        pin.setBounds(120,220,230,30);
        pin.setFont(new Font("OSWARD",Font.BOLD,30));
  
          
          pintext = new JPasswordField();
        pintext.setBounds(400,220,230,30);
        pintext.setEchoChar('*');


        
        // ADDING BANK IMAGE ON THE TOP LEFT SIDE 
         ImageIcon i1 = new ImageIcon("logo.jpg");
         Image i2 = i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);//cannot add this to the lable
        ImageIcon i3 = new ImageIcon(i2); 
       JLabel l1 = new JLabel();
       l1.setBounds(70,10,100,100);//changes the location of the image
        l1.setIcon(i3);
       
           ImageIcon i = new ImageIcon("image.png");  
 this.setIconImage(i.getImage());
      this.setSize(800,480);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLocation(350,200);
      this.setTitle("AUTOMATED TELLER MACHINE");
     this.setLayout(null); 
     this.setLocationRelativeTo(null);
     this.setBackground(Color.white);
          this.add(l1);
          this.add(l2);
          this.add(cardno);
          this.add(cardtext);
          this.add(pin);
          this.add(pintext);
          this.add(login);
          this.add(signup);
          this.add(clear);
      this.setVisible(true);
    }

      @Override
    public void actionPerformed(ActionEvent e) {
      if (e.getSource()==login) {
        conn C = new conn();
        String Cardnumber=cardtext.getText();
        String Pinnumber = pintext.getText();
      String query = "SELECT * FROM signup3 WHERE cardnumber = '"+ Cardnumber + "' AND pin ='"+Pinnumber+"'";

        try {
         ResultSet rs = C.s.executeQuery(query);
         if (rs.next()) {
        this.setVisible(false); 
         new Transaction(Pinnumber).setVisible(true);
         } else {
          JOptionPane.showMessageDialog(null,"Incorrect cardnumber or pin");
         }
        } catch (Exception ea) {
          System.out.println(ea);
        }
      }else if (e.getSource()==signup){
              Signup1 A = new Signup1();
      }else if (e.getSource()==clear){
     cardtext.setText("");
     pintext.setText("");
      }
    }



    public static void main(String[] args) {
        new Banklogin();
    }

  
}
