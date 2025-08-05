import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener {
 JRadioButton r1,r2,r3,r4,b1,b2,b3,b4,b5,b6,b7;
 JButton submit,cancle;
 String formno;
Signup3(String formno){

    JLabel pg3 = new JLabel("PAGE 3 : ACCOUNT DETAILS  ");
     pg3.setFont(new Font("Raleway",Font.BOLD,38));
        pg3.setBounds(140,20,800,40);

   JLabel type = new JLabel("Account Type");
     type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,400,30);

        r1= new JRadioButton("Savings Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.white);
        r1.setBounds(100,180,200,20);

          r2= new JRadioButton("Fixed Deposit Account ");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.white);
        r2.setBounds(400,180,300,20);

          r3= new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.white);
        r3.setBounds(100,240,200,20);

          r4= new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.white);
        r4.setBounds(400,240,300,20);
  
        ButtonGroup c1 = new ButtonGroup();
        c1.add(r1);
        c1.add(r2);
        c1.add(r3);
        c1.add(r4);

        JLabel cardno = new JLabel("CARD NO ");
     cardno.setFont(new Font("Raleway",Font.BOLD,22));
        cardno.setBounds(100,300,200,30);

         JLabel numb = new JLabel("XXXX-XXXX-2355");
     numb.setFont(new Font("Raleway",Font.BOLD,22));
        numb.setBounds(330,300,200,30);

          JLabel carddno = new JLabel("THIS IS YOUR 16 DIGIT CARD NUMBER");
     carddno.setFont(new Font("Raleway",Font.BOLD,12));
        carddno.setBounds(100,330,300,30);

 JLabel pin = new JLabel("PIN NO ");
     pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,200,30);

         JLabel pinnumb = new JLabel("XXXX");
     pinnumb.setFont(new Font("Raleway",Font.BOLD,22));
        pinnumb.setBounds(330,370,300,30);

        
 JLabel pind = new JLabel("This is your password ");
     pind.setFont(new Font("Raleway",Font.BOLD,12));
        pind.setBounds(100,400,200,30);

           JLabel servis = new JLabel("SERVISIS REQUIRED");
     servis.setFont(new Font("Raleway",Font.BOLD,22));
        servis.setBounds(100,450,300,30);

        b1=new JRadioButton("ATM card");
        b1.setBackground(Color.white);
        b1.setFont(new Font("Railway",Font.BOLD,16));
        b1.setBounds(100,500,200,30);

        b2=new JRadioButton("Internet banking");
          b2.setBackground(Color.white);
        b2.setFont(new Font("Railway",Font.BOLD,16));
        b2.setBounds(300,500,200,30);

        b3=new JRadioButton("Mobile banking");
          b3.setBackground(Color.white);
        b3.setFont(new Font("Railway",Font.BOLD,16));
        b3.setBounds(100,550,200,30);

        b4=new JRadioButton("Email and SMS alart");
          b4.setBackground(Color.white);
        b4.setFont(new Font("Railway",Font.BOLD,16));
        b4.setBounds(300,550,200,30);

        b5=new JRadioButton("Check book");
          b5.setBackground(Color.white);
        b5.setFont(new Font("Railway",Font.BOLD,16));
        b5.setBounds(100,600,200,30);

        b6=new JRadioButton("Pass book");
          b6.setBackground(Color.white);
        b6.setFont(new Font("Railway",Font.BOLD,16));
        b6.setBounds(300,600,200,30);

        b7=new JRadioButton("I HEAR BY DECLAIR THAT THE ABOVE ENTERED INFORMATION IS CCORRECT TO THE BEST I KNOW ");
        b7.setBackground(Color.white);
        b7.setFont(new Font("Railway",Font.BOLD,16));
        b7.setBounds(100,650,500,30);

        submit = new JButton("SUBMIT");
         submit.setBackground(Color.black);
         submit.setForeground(Color.white);
         submit.setFont(new Font("Railway",Font.BOLD,16));
         submit.setBounds(220,700,100,30);
         submit.addActionListener(this);

         cancle = new JButton("CANCEL");
         cancle.setBackground(Color.black);
         cancle.setForeground(Color.white);
         cancle.setFont(new Font("Railway",Font.BOLD,16));
         cancle.setBounds(400,700,100,30);
         cancle.addActionListener(this);

        ImageIcon i = new ImageIcon("image.png");
  
this.formno = formno;        
this.add(submit);
this.add(cancle);        
this.add(b7);        
this.add(b1);
this.add(b2);
this.add(b3);
this.add(b4);
this.add(b5);
this.add(b6);
this.add(servis);        
this.add(carddno);  
this.add(pind);      
this.add(pinnumb);
this.add(pin);  
this.add(numb);
this.add(cardno);       
this.add(r1);
this.add(r2);
this.add(r3);
this.add(r4);       
this.setIconImage(i.getImage());
this.add(type);      
this.add(pg3);
this.setSize(850,850);
this.setLocation(350,10);
getContentPane().setBackground(Color.white);
this.setLayout(null);
this.setVisible(true);
}

@Override
    public void actionPerformed(ActionEvent e){
      if(e.getSource()==submit){
        String accounttype = null;
        if (r1.isSelected()) {
          accounttype="Savings Account";
        } else if (r2.isSelected()){
          accounttype= "Fixed Deposit Account";
        }else if(r3.isSelected()){
        accounttype="Current Account";
        }else if(r4.isSelected()){
         accounttype="Recurring Deposit Account";
        }
        Random r1 = new Random();
      String cardnumber =""+65659595L+Math.abs((r1.nextLong()%900000L));
      String pinnumber =""+Math.abs((r1.nextLong()% 9000L) + 1000L);
      
      String facility = "";
       if (b1.isSelected()) {
        facility = facility +"ATM Card";
       }else if (b2.isSelected()){
        facility = facility + "Internet Banking";
       }else if (b3.isSelected()){
         facility = facility + "Mobile banking";
       }else if (b4.isSelected()){
        facility = facility + "Email and SMS alart";
       }else if (b5.isSelected()){
         facility = facility +"Check book";
       }else if (b6.isSelected()){
         facility = facility + "Pass book";
       }

       try {
        if(b7.equals("")){
          JOptionPane.showMessageDialog(null,"Please fill the concent");
        }else {
          conn c = new conn();
          String queryl = "insert into Signup3 values ('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
          c.s.executeUpdate(queryl);
        }
       this.setVisible(false);
       new Deposit(pinnumber); 
       } catch (Exception ae) {
          System.out.println(ae);
       }

      }else if (e.getSource()==cancle){

      }
    }

    public static void main(String[] args) {
        new Signup3("");
    }
    
}
