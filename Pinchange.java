import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Pinchange extends JFrame implements ActionListener  {
    
     JButton CHANGE,BACK;
        JTextField p,p1;
        String pinnumber;

    Pinchange(String pinnumber){


   JLabel l1 = new JLabel("CHANGE YOUR PIN"); 
      l1.setForeground(Color.white);
      l1.setFont(new Font("System",Font.BOLD,16));
      l1.setBounds(250,280,500,35);

      JLabel l2 = new JLabel("NEW PIN"); 
      l2.setForeground(Color.white);
      l2.setFont(new Font("System",Font.BOLD,16));
      l2.setBounds(165,320,180,25);

      JLabel l3 = new JLabel("CONFIRM NEW PIN"); 
      l3.setForeground(Color.white);
      l3.setFont(new Font("System",Font.BOLD,16));
      l3.setBounds(165,360,180,25);

     p = new JTextField();
      p.setFont(new Font("Railway",Font.BOLD,25));
      p.setBounds(330,320 , 180,25);

      
       p1 = new JTextField();
      p1.setFont(new Font("Railway",Font.BOLD,25));
      p1.setBounds(330,360 , 180,25);

      CHANGE = new JButton("CHANGE");
      CHANGE.setBounds(180, 485, 150, 30);
      CHANGE.addActionListener(this);

        BACK = new JButton("BACk");
      BACK.setBounds(350, 485, 150, 30);
      BACK.addActionListener(this);


      ImageIcon i1 = new ImageIcon("atm.jpg");
      Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel image = new JLabel(i3);
      image.setBounds(0,0,900,900);
      this.add(image);
     image.add(l1);
     image.add(l2);
     image.add(l3); 
     image.add(p);
     image.add(p1);
     image.add(CHANGE);
     image.add(BACK);

     this.pinnumber=  pinnumber;
      this.setLayout(null);
      this.setSize(900,900);
      this.setLocation(300,0);
      this.setVisible(true);

       

    }

     @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==CHANGE) {
              try{
        String npin = p.getText();
        String rpin = p1.getText();

        if (!npin.equals(rpin)) {
            JOptionPane.showMessageDialog(null, "Entered pin dosent match");
        }
        if(npin.equals("")){
              JOptionPane.showMessageDialog(null, "Entered pin");
              return;
        }
        if (rpin.equals("")) {
             JOptionPane.showMessageDialog(null, "REEntered pin");
        }
        conn c = new conn();
        String query1 = "Update bank set pin= '"+rpin+"'where pin='"+pinnumber+"'";
         String query2 = "Update signup3 set pin= '"+rpin+"'where pin='"+pinnumber+"'";

         c.s.executeUpdate(query1);
          c.s.executeUpdate(query2);

           JOptionPane.showMessageDialog(null, "PIN CHANGED SUCCESSFULLY");
           this.setVisible(false);
           new Transaction(pinnumber);

    }catch(Exception ae){
        System.out.println(ae);
    }
        }else if (e.getSource()==BACK){
         this.setVisible(false);
         new Transaction(pinnumber).setVisible(true);
        }
  
    }

    public static void main(String[] args) {
        new Pinchange("");
    }

   
}
