import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup2 extends JFrame implements ActionListener {
JComboBox religionbox, catbox,edubox, ocubox; 
JTextField incfi, pantext,Adhartext;
 JRadioButton yes,no,yes1,no2;
 JButton next;
 String formno;
    Signup2(String formno){
       
        JLabel Adddetail = new JLabel("Page 2: ADDITIONAL DETAILS");
        Adddetail.setFont(new Font("Raleway",Font.BOLD,38));
         Adddetail.setBounds(150,20,800,40);

         JLabel religion = new JLabel("Religion : ");
         religion.setFont(new Font("Raleway",Font.BOLD,20));
         religion.setBounds(100,140,100,30);
         
         String Varreligion[] = {"Hindu","Muslim","Sikh","Cristian","Other"};
          religionbox = new JComboBox(Varreligion);
         religionbox.setBounds(350,140,200,30);
         religionbox.setBackground(Color.white);

        JLabel cat = new JLabel("Category : ");
         cat.setFont(new Font("Raleway",Font.BOLD,20));
         cat.setBounds(100,190,200,30);

         String Varcat[] = {"General","SC","ST","OBC","Other"};
          catbox = new JComboBox(Varcat);
         catbox.setBounds(350,190,200,30);
        catbox.setBackground(Color.white);

          JLabel inc = new JLabel("Income Up to : ");
         inc.setFont(new Font("Raleway",Font.BOLD,20));
         inc.setBounds(100,240,400,30);
 
       incfi = new JTextField();
       incfi.setFont(new Font("Raleway",Font.BOLD,20));
       incfi.setBounds(350,240,200,30);

      JLabel edu = new JLabel("QUALIFICATION : ");
      edu.setFont(new Font("Raleway",Font.BOLD,20));
      edu.setBounds(100,290,200,30);

         String Varedu[] = {"Non-Graduated","Graduated","Other"};
          edubox = new JComboBox(Varedu);
         edubox.setBounds(350,290,200,30);
        edubox.setBackground(Color.white);

JLabel ouc = new JLabel("Occupation : ");
      ouc.setFont(new Font("Raleway",Font.BOLD,20));
      ouc.setBounds(100,340,200,30);

       
         String Varocu[] = {"Salaried","Self-Salaried","Other"};
        ocubox = new JComboBox(Varocu);
         ocubox.setBounds(350,340,200,30);
        ocubox.setBackground(Color.white);

        JLabel pan = new JLabel("PAN NUMBER :");
         pan.setFont(new Font("Raleway",Font.BOLD,20));
      pan.setBounds(100,390,200,30);

     pantext = new JTextField();
       pantext.setFont(new Font("Raleway",Font.BOLD,20));
       pantext.setBounds(350,390,200,30);

  JLabel Adhar = new JLabel("ADHAR NUMBER :");
         Adhar.setFont(new Font("Raleway",Font.BOLD,20));
      Adhar.setBounds(100,440,200,30);

       Adhartext = new JTextField();
       Adhartext.setFont(new Font("Raleway",Font.BOLD,20));
       Adhartext.setBounds(350,440,200,30);

        JLabel Senior = new JLabel("Senior Citizen :");
         Senior.setFont(new Font("Raleway",Font.BOLD,20));
      Senior.setBounds(100,490,200,30);

      
       yes = new JRadioButton("YES");
      no  = new JRadioButton("NO");

      ButtonGroup SeniorC = new ButtonGroup();
      SeniorC.add(yes);
      SeniorC.add(no);

      yes.setBounds(350,490,100,30);
      no.setBounds(450,490,100,30);

       JLabel EXTACC = new JLabel("Exisiting ACC  :");
         EXTACC.setFont(new Font("Raleway",Font.BOLD,20));
      EXTACC.setBounds(100,540,200,30);

       yes1 = new JRadioButton("YES");
      no2 = new JRadioButton("NO");

      yes1.setBounds(350,540,100,30);
      no2.setBounds(450,540,100,30);

      ButtonGroup EXTACCg = new ButtonGroup();
      EXTACCg.add(yes1);
      EXTACCg.add(no2);

      next = new JButton("NEXT");
         next.setBounds(750,660,80,30);
         next.setFont(new Font("Raleway",Font.BOLD,14));
       next.setBackground(Color.black);
      next.setForeground(Color.white);
       next.addActionListener(this);
        
   ImageIcon i = new ImageIcon("image.png");
       
 this.setIconImage(i.getImage());
   this.formno=formno;
        this.add(EXTACC);
       this.add(yes1);
       this.add(no2);
       this.add(next);
        this.add(no);
        this.add(yes);
        this.add(Senior);
        this.add(Adhartext);
        this.add(Adhar);
        this.add(pantext);
        this.add(pan);
        this.setLocation(350,10);
        this.add(edu);
        this.add(edubox);
        this.add(ocubox);
        this.add(ouc);
        this.add(inc);
        this.add(incfi);
        this.add(cat);
        this.add(catbox);
        this.add(religion);
        this.add(religionbox);
        this.setLayout(null);
        this.add(Adddetail);
        this.setSize(850,800);
        this.setBackground(Color.white);
        this.setVisible(true);
    }

      @Override
    public void actionPerformed(ActionEvent e) {
  
       String religion = (String)religionbox.getSelectedItem();
       String Category = (String)catbox.getSelectedItem();
       String income = incfi.getText();
       String education = (String)edubox.getSelectedItem();
       String occupation = (String)ocubox.getSelectedItem();
       String seniorcitizen = null;
       if (yes.isSelected()) {
         seniorcitizen = "YES";
       }else if (no.isSelected()){
         seniorcitizen = "NO";
       }
       String existingacc = null;
       if (yes1.isSelected()) {
         existingacc= "YES";
       }else if (no2.isSelected()){
         existingacc= "NO";
       }
       String pannumber = pantext.getText();
       String Adharnumber = Adhartext.getText();

     
       try{
              conn c = new conn();
              String query = "insert into signup2 values('"+formno+"','"+religion+"','"+Category+"','"+income+"','"+education+"','"+occupation+"','"+pannumber+"','"+Adharnumber+"','"+existingacc+"','"+seniorcitizen+"')";
              c.s.executeUpdate(query);

                Signup3 S3 = new Signup3(formno); 
             }
            catch(Exception ef){
              System.out.println(ef);
            }

    }

    public static void main(String[] args) {
     new Signup2("");
    }
  
}
