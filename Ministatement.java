import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Ministatement extends JFrame implements ActionListener {

    Ministatement(String pinnumber) {

        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);

        JLabel l1 = new JLabel();
        l1.setBounds(20, 140, 400, 200);

        JLabel l2 = new JLabel("NJ BANK");
        l2.setBounds(150, 20, 100, 20);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM signup3 WHERE pin = '" + pinnumber + "'");
            while (rs.next()) {
                card.setText("Card Number: " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        } catch (Exception e) {
            System.out.println("Error fetching card details: " + e);
        }

        try {
            conn c = new conn();
            int bal = 0;
            ResultSet r = c.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinnumber + "'");
            while (r.next()) {
                l1.setText(l1.getText() + "<html>" + r.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                   + r.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        + r.getString("amount") + "<br><br></html>");

                if (r.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(r.getString("amount"));
                } else {
                    bal -= Integer.parseInt(r.getString("amount"));
                }
            }
            balance.setText("Your current balance is Rs " + bal);

        } catch (Exception ae) {
            System.out.println("Error fetching transaction history: " + ae);
        }

        
        this.add(balance);
        this.add(card);
        this.add(l2);
        this.add(l1);
        this.setTitle("Mini Statement");
        this.setLayout(null);
        this.setSize(400, 600);
        this.getContentPane().setBackground(Color.white);
        this.setLocation(20, 20);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
    }

    public static void main(String[] args) {
        new Ministatement("");  
    }
}
