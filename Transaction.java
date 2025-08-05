 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener{

    JButton deposit,cashwithdrawl,Fastcash,Ministatment,Balanceenquiry,exit,pinchange;
    String pinnumber;

    Transaction(String Pinnumber){
      

        JLabel L = new JLabel("Please select your transaction type ");
       L.setBounds(200,300,700,35);
        L.setFont(new Font("SYSTEM",Font.BOLD,15));
        L.setForeground (Color.WHITE);
      
         deposit = new JButton("Deposit");
         deposit.setBounds(170, 350, 150, 30);
         deposit.addActionListener(this);
     
         cashwithdrawl = new JButton("Cash-Withdrawl");
         cashwithdrawl.setBounds(170,400,150,30);
         cashwithdrawl.addActionListener(this);

         Fastcash = new JButton("Fast Cash");
         Fastcash.setBounds(170,450,150,30);
         Fastcash.addActionListener(this);

         Ministatment = new JButton("Mini Statemengt");
         Ministatment.setBounds(350,350,150,30);
         Ministatment.addActionListener(this);

     Balanceenquiry = new JButton("Balance Enquire");
       Balanceenquiry.setBounds(350,400,150,30);
       Balanceenquiry.addActionListener(this);

         exit = new JButton("EXIT");
         exit.setBounds(350,500,150,30);
         exit.addActionListener(this);

         pinchange = new JButton("Pinchange");
         pinchange.setBounds(350,450,150,30);
         pinchange.addActionListener(this);

     ImageIcon atm = new ImageIcon("atm.jpg");
     Image i1 = atm.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
     ImageIcon i2 = new ImageIcon(i1);
     
     JLabel image = new JLabel(i2);
     image.setBounds(0,0,900,900);
     image.add(cashwithdrawl);
     image.add(Fastcash);
     image.add(Ministatment);
     image.add(Balanceenquiry);
     image.add(exit); 
     image.add(pinchange);
         image.add(deposit);
      image.add(L);
      this.pinnumber=Pinnumber;
     this.setLayout(null);
     this.add(image);
     this.setSize(900,900);
     this.setLocation(300,0);
     this.setUndecorated(true);
     this.setVisible(true);
    }
      @Override
        public void actionPerformed(ActionEvent e) {
         if (e.getSource() == exit){
       System.exit(0);
         }else if (e.getSource()==deposit){
           setVisible(false);
           new Deposit(pinnumber).setVisible(true);
        }else if (e.getSource()==cashwithdrawl){
          new Withdrawal(pinnumber).setVisible(true);
        }else if (e.getSource()==Fastcash){
          new Fastcash(pinnumber).setVisible(true);
        }else if (e.getSource()==pinchange){
          new Pinchange(pinnumber).setVisible(true);
        }else if (e.getSource()==Balanceenquiry){
          new Balanceenquiry(pinnumber).setVisible(true);
        }else if (e.getSource()==Ministatment) {
          new Ministatement(pinnumber).setVisible(true);
        }
        } 
        public static void main(String[] args) {
        new Transaction("");
    }
        
  }



