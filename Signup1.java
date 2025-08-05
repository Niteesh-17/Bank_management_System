

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;


public class Signup1 extends JFrame implements ActionListener {
  long random ;
  JDateChooser date;
  JButton clear,next;
JTextField fnametextf,nametextf,emailtext,addtext,citytext,statetext,pintext;
 JRadioButton maride,unmaride,other,mail,femail;
    Signup1() {

        Random r1 = new Random();
       long Random = Math.abs(r1.nextLong() % 9000L)+ 1000L;
     
        JLabel Formno = new JLabel("APPLICATION FORM NUMBER. " + Random);
        Formno.setFont(new Font("Raleway",Font.BOLD,38));
        Formno.setBounds(140,20,800,40);
                 
        JLabel personaldetails = new JLabel("PAGE 1= Personal Details");
        personaldetails.setFont(new Font("Raleway",Font.BOLD,38));
       personaldetails.setBounds(290,80,600,40);

        JLabel name = new JLabel("NAME:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
      name.setBounds(100,140,100,30);
       
       nametextf = new JTextField();
      nametextf.setFont(new Font("Raleway",Font.BOLD,14));
      nametextf.setBounds(350,140,400,30);
      
        JLabel fname = new JLabel("FATHERS NAME:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
      fname.setBounds(100,190,200,30);

      fnametextf = new JTextField();
      fnametextf.setFont(new Font("Raleway",Font.BOLD,14));
      fnametextf.setBounds(350,190,400,30);

         JLabel DOB = new JLabel("DOB :");
       DOB.setFont(new Font("Raleway",Font.BOLD,20));
      DOB.setBounds(100,240,200,30);

     date = new JDateChooser();
     date.setBounds(350,240,200,30);

          JLabel gender = new JLabel("GENDER:");
      gender.setFont(new Font("Raleway",Font.BOLD,20));
     gender.setBounds(100,290,200,30);

         mail = new JRadioButton("MAIL");
         femail = new JRadioButton("FEMAIL");
       
         mail.setBounds(350,290,60,30);
         femail.setBounds(450,290,100,30);  
       
      ButtonGroup gendeGroup = new ButtonGroup();
      gendeGroup.add(femail);
      gendeGroup.add(mail);

        mail.setBackground(Color.white);
             femail.setBackground(Color.white);

   JLabel email = new JLabel("EMAIL:");
      email.setFont(new Font("Raleway",Font.BOLD,20));
   email.setBounds(100,340,200,30);

    emailtext= new JTextField();
 emailtext.setFont(new Font("Raleway",Font.BOLD,14));
    emailtext.setBounds(350,340,400,30);
 
   JLabel maritals = new JLabel("MARITAL STATUS:");
     maritals .setFont(new Font("Raleway",Font.BOLD,20));
     maritals.setBounds(100,390,200,30);

  maride = new JRadioButton("MARRIED");
       unmaride = new JRadioButton("UNMARRIED");
           other = new JRadioButton("OTHER");
       
         maride.setBounds(350,390,100,30);
        unmaride.setBounds(450,390,100,30);
        other.setBounds(550,390,100,30);  

        maride.setBackground(Color.white);
        unmaride.setBackground(Color.white);
        other.setBackground(Color.white);
       
      ButtonGroup STATE = new ButtonGroup();
      STATE.add(maride);
      STATE.add(unmaride);
      STATE.add(other);

    JLabel add = new JLabel("ADDRESS:");
     add.setFont(new Font("Raleway",Font.BOLD,20));
   add.setBounds(100,440,200,30);

 addtext= new JTextField();
 addtext.setFont(new Font("Raleway",Font.BOLD,14));
    addtext.setBounds(350,440,400,30);
 
    JLabel city = new JLabel("CITY:");
     city.setFont(new Font("Raleway",Font.BOLD,20));
   city.setBounds(100,490,200,30);

    citytext= new JTextField();
 citytext.setFont(new Font("Raleway",Font.BOLD,14));
    citytext.setBounds(350,490,400,30);
 
    JLabel state= new JLabel("STATE:");
     state.setFont(new Font("Raleway",Font.BOLD,20));
  state.setBounds(100,540,200,30);

 statetext = new JTextField();
 statetext.setFont(new Font("Raleway",Font.BOLD,14));
    statetext.setBounds(350,540,400,30);
   
    JLabel pinc= new JLabel("PIN CODE:");
     pinc.setFont(new Font("Raleway",Font.BOLD,20));
  pinc.setBounds(100,590,200,30);

  pintext= new JTextField();
 pintext.setFont(new Font("Raleway",Font.BOLD,14));
    pintext.setBounds(350,590,400,30);

    
           clear = new JButton("CLEAR");
         clear.setBounds(620,660,100,30);
              clear.setFont(new Font("Raleway",Font.BOLD,14));
         clear.setBackground(Color.black);
         clear.setForeground(Color.white);
         clear.addActionListener(this);

        next = new JButton("NEXT");
         next.setBounds(750,660,80,30);
         next.setFont(new Font("Raleway",Font.BOLD,14));
       next.setBackground(Color.black);
      next.setForeground(Color.white);
       next.addActionListener(this);

       ImageIcon i = new ImageIcon("image.png");
       
 this.setIconImage(i.getImage());
   this.setSize(850,800);
   this.setLocation(350,10);
    getContentPane().setBackground(Color.white);
    this.setLayout(null);
     this.add(Formno);
     this.add(personaldetails);
     this.add(name);
       this.add(nametextf);
     this.add(fname);
      this.add(fnametextf);
     this.add(DOB);
     this.add(date);
     this.add(gender);
          this.add(mail);
     this.add(femail);
     this.add(email);
     this.add(emailtext);
     this.add(maritals);
       this.add(maride);
       this.add(unmaride);
       this.add(other);
     this.add(add);
       this.add(addtext);
     this.add(city);
       this.add(citytext);
     this.add(state);
       this.add(statetext);
     this.add(pinc);
       this.add(pintext);
       this.add(next);
       this.add(clear);
   this.setVisible(true);
    }
       @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==next){
             String formno = "" + random; //converting long to string
             String name = nametextf.getText();
             String fname= fnametextf.getText();
             String dob = ((JTextField) date.getDateEditor().getUiComponent()).getText();
            String gender = null;
            if (mail.isSelected()) {
              gender = "Mail";
            }else if (femail.isSelected()){
               gender = "femail";
            }
            String email = emailtext.getText();
            String maritall = null;
            if(maride.isSelected()){
              maritall = "MARRIED";
            }else if (unmaride.isSelected()){
              maritall = "UNMARRIED";
            }else if(other.isSelected()){
                maritall = "OTHER";
            }
         
            String Address = addtext.getText();
            String city = citytext.getText();
            String state = statetext.getText();
            String pin = pintext.getText();
                
               Signup2 C = new Signup2(formno);
            

            try{
             if (name.equals("")){
              JOptionPane.showMessageDialog(null,"NAME is required");
               if(fname.equals("")){
                JOptionPane.showMessageDialog(null,"Father name is required");
               }
             }else{
              conn c = new conn();
              String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+maritall+"','"+Address+"','"+city+"','"+pin+"', '"+state +"')";
              c.s.executeUpdate(query);
                         }
            }catch(Exception ef){
              System.out.println(ef);
            }

       }
       else if (e.getSource()==clear){
        nametextf.setText("");
        pintext.setText("");
       statetext.setText("");
     citytext .setText("");
     addtext.setText("");
     emailtext.setText("");
     fnametextf.setText("");
    
       }
    }
    
    public static void main(String[] args) {
        new Signup1();
    }

}
