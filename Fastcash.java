 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener{

    JButton deposit,cashwithdrawl,Fastcash,Ministatment,Bankenquire,exit,pinchange;
    String pinnumber;

    Fastcash(String Pinnumber){
      

        JLabel L = new JLabel("Please Select  Withdrawl amount  ");
       L.setBounds(200,300,700,35);
        L.setFont(new Font("SYSTEM",Font.BOLD,15));
        L.setForeground (Color.WHITE);
      
         deposit = new JButton("RS 100");
         deposit.setBounds(170, 350, 150, 30);
         deposit.addActionListener(this);
     
         cashwithdrawl = new JButton("RS 500");
         cashwithdrawl.setBounds(170,400,150,30);
         cashwithdrawl.addActionListener(this);

         Fastcash = new JButton("RS 1000");
         Fastcash.setBounds(170,450,150,30);
         Fastcash.addActionListener(this);

         Ministatment = new JButton("RS 2000");
         Ministatment.setBounds(350,350,150,30);
         Ministatment.addActionListener(this);

         Bankenquire = new JButton("RS 10000");
         Bankenquire.setBounds(350,400,150,30);
         Bankenquire.addActionListener(this);

         exit = new JButton("BACK");
         exit.setBounds(350,500,150,30);
         exit.addActionListener(this);

         pinchange = new JButton("RS 5000");
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
     image.add(Bankenquire);
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
           this.setVisible(false);
           new Transaction(pinnumber).setVisible(true);
         }else  {
                String amount =((JButton) e.getSource()).getText().substring(3);
                conn c = new conn();
                try {
                    ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                    int balance = 0;
                    while(rs.next()){
                              if(rs.getString("type").equals("Deposit")) {
                                balance +=Integer.parseInt(rs.getString("amount"));
                              }else{
                                balance -= Integer.parseInt(rs.getString("amount"));
                              }

                    }

                    if (e.getSource() != exit && balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null,"Insufficient message");
                        return;
                    }else{
                        Date d = new Date();
                        String query ="insert into bank values('"+pinnumber+"','"+d+"','Withdrawal','"+amount+"')";
                        c.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "RS" + amount + "Debited from your account");
                    }
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                } catch (Exception ae) {
                   System.out.println(ae);
                }
        }
        } 
        public static void main(String[] args) {
        new Fastcash("");
    }
        
  }



