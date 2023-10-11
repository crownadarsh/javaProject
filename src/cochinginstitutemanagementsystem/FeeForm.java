package cochinginstitutemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;

public class FeeForm extends JFrame implements ActionListener{
    
    
    Choice crollno ;
    JComboBox cbcourse, cbstream , cbclass;
    JButton pay , update , back;
    JLabel lbltotal;
FeeForm(){
    
    setSize(900,500);
    setLocation(250,100);
    getContentPane().setBackground(Color.white);
    setLayout(null);
    
    
    ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
         Image i2 = il.getImage().getScaledInstance(450, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 40, 450, 300);
        add(image);
        
     JLabel lblheading = new JLabel("Select Roll No.");
        lblheading.setBounds(40,60,150,20);
        lblheading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblheading);
        
        crollno = new Choice();
        crollno.setBounds(200, 60, 150, 20);
        add(crollno);
        
          try {
                
              Conn c = new Conn();
              ResultSet rs = c.s.executeQuery("select * from student");
              while(rs.next()){
                  
                   crollno.add(rs.getString("rollno"));
              }
              
            }catch(Exception e){
                e.printStackTrace();
            }
        
          
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40, 100, 150, 20);
        lblname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblname);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(200, 100, 150, 20);
        labelname.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(labelname);
        
        JLabel lblfname = new JLabel("Father Name");
        lblfname.setBounds(40, 140, 150, 20);
        lblfname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblfname);
        
        JLabel labelfname = new JLabel();
        labelfname.setBounds(200, 140, 180, 20);
        labelfname.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(labelfname);
        
         try {
            
            Conn c = new Conn();
            String query = "select * from student where rollno = '"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        crollno.addItemListener(new ItemListener(){
            
            public void itemStateChanged(ItemEvent ie){
                try {
            
                    Conn c = new Conn();
                    String query = "select * from student where rollno = '"+crollno.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));
                    }
        }catch(Exception e){
            e.printStackTrace();
        }
            }
            
        });
        
        JLabel lblclass = new JLabel("Class");
        lblclass.setBounds(40, 170, 150, 20);
        lblclass.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblclass);
        
        String sclass[] = {"9","10","11","12"};
        cbclass = new JComboBox(sclass);
        cbclass.setBounds(200, 170, 150, 20);
        cbclass.setBackground(Color.WHITE);
        cbclass.setForeground(Color.red);
        cbclass.setFont(new Font("Tahoma",Font.BOLD,16));
        add(cbclass);
        
        JLabel lblstream = new JLabel("Stream");
        lblstream.setBounds(40, 210, 150, 20);
        lblstream.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblstream);
        
        String stream[] = {"Arts","Commerce","Science"};
        cbstream = new JComboBox(stream);
        cbstream.setBounds(200, 210, 150, 20);
        cbstream.setBackground(Color.WHITE);
        cbstream.setForeground(Color.BLUE);
        cbstream.setFont(new Font("Tahoma",Font.BOLD,16));
        add(cbstream);
        
        
        JLabel lblcourse = new JLabel("Select Course");
        lblcourse.setBounds(40, 250, 150, 20);
        lblcourse.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblcourse);
        
        String course[] = {"Foundation","CrashCourse","Practice","TestSeries"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200, 250, 150, 20);
        cbcourse.setBackground(Color.WHITE);
        cbcourse.setForeground(Color.GREEN);
        cbcourse.setFont(new Font("Tahoma",Font.BOLD,16));
        add(cbcourse);
        
         JLabel lblpayable = new JLabel("Payable");
        lblpayable.setBounds(40, 290, 150, 20);
        lblpayable.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblpayable);
        
        lbltotal = new JLabel();
        lbltotal.setBounds(200, 290, 150, 20);
        lbltotal.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(lbltotal);
        
        
        
        update = new JButton("Update");
        update.setBounds(60,340,120,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        update.setFont(new Font("Tahoma",Font.BOLD,15));
        add(update);
        
        pay = new JButton("Pay");
        pay.setBounds(190,340,120,30);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        pay.setFont(new Font("Tahoma",Font.BOLD,15));
        add(pay);
        
        back = new JButton("Back");
        back.setBounds(330,340,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFont(new Font("Tahoma",Font.BOLD,15));
        add(back);
        
       
        
    setVisible(true);
    
    
}    
  
public void actionPerformed(ActionEvent ae){
    if (ae.getSource() == update){

        String course = (String)cbcourse.getSelectedItem();
        String sclass = (String)cbclass.getSelectedItem();
        String stream = (String)cbstream.getSelectedItem();
        String query = "select * from feestructure where class ='"+sclass+"'";
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                        lbltotal.setText(rs.getString(course));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
   
    }else if(ae.getSource()== pay){
       
        String rollno = crollno.getSelectedItem();
        String course = (String)cbcourse.getSelectedItem();
        String sclass = (String)cbclass.getSelectedItem();
        String stream = (String)cbstream.getSelectedItem();
        String total = lbltotal.getText();
        
         try{
            Conn c = new Conn();
            String query ="insert into coachingfee values('"+rollno+"','"+sclass+"','"+course+"','"+stream+"','"+total+"')";
            c.s.executeUpdate(query);
           
            JOptionPane.showMessageDialog(null, "College fee submitted successfully");
            setVisible(false);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }else {
        setVisible(false);
    }
}
    
    public static void main(String[] args){
        
      new FeeForm();
        
    }
}
