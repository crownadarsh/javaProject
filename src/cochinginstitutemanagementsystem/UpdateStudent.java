package cochinginstitutemanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UpdateStudent extends JFrame implements ActionListener{
    
    
    JTextField  tfaddress , tfmno , tfemail , tfclass , tfcourse , tfstream ;
    Choice crollno;
    JLabel labelrollno;
    JButton update , cancel;
    
    UpdateStudent(){
        
        setSize(900,600);
        setLocation(200,50);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        
        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("Tahoma",Font.ITALIC,35));
        add(heading);
        
        
        JLabel lblheading = new JLabel("Search by Roll No.");
        lblheading.setBounds(50,70,200,20);
        lblheading.setFont(new Font("serif",Font.PLAIN,20));
        add(lblheading);
        
        crollno = new Choice();
        crollno.setBounds(250, 70, 200, 20);
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
        lblname.setBounds(50, 100, 60, 30);
        lblname.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblname);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(150, 100, 220, 30);
        labelname.setFont(new Font("Tahoma",Font.BOLD,18));
        add(labelname);
        
        JLabel lblfname = new JLabel("Father Name");
        lblfname.setBounds(400, 100, 170, 30);
        lblfname.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblfname);
        
        JLabel labelfname = new JLabel();
        labelfname.setBounds(600, 100, 220, 30);
        labelfname.setFont(new Font("Tahoma",Font.BOLD,18));
        add(labelfname);
        
        JLabel lblrollno = new JLabel("Student Id");
        lblrollno.setBounds(50, 150, 150, 30);
        lblrollno.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblrollno);
        
        labelrollno = new JLabel();
        labelrollno.setBounds(225, 150, 170, 30);
        labelrollno.setFont(new Font("Tahoma",Font.BOLD,20));
        add(labelrollno);
        
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400, 150, 170, 30);
        lbldob.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lbldob);
        
        JLabel labeldob = new JLabel();
        labeldob.setBounds(600, 150, 220, 30);
        labeldob.setFont(new Font("Tahoma",Font.BOLD,18));
        add(labeldob);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 200, 100, 30);
        lbladdress.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(150, 200, 220, 30);
        tfaddress.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(tfaddress);
        
        
        JLabel lblmno = new JLabel("Contact No.");
        lblmno.setBounds(400, 200, 170, 30);
        lblmno.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblmno);
        
        tfmno = new JTextField();
        tfmno.setBounds(600, 200, 220, 30);
        tfmno.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(tfmno);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(50, 250, 60, 30);
        lblemail.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(150, 250, 220, 30);
        tfemail.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(tfemail);
        
        
        JLabel lbladhar = new JLabel("Aadhar No.");
        lbladhar.setBounds(400, 250, 170, 30);
        lbladhar.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lbladhar);
        
        JLabel labeladhar = new JLabel();
        labeladhar.setBounds(600, 250, 220, 30);
        labeladhar.setFont(new Font("Tahoma",Font.BOLD,18));
        add(labeladhar);
        
        JLabel lblclass = new JLabel("Class");
        lblclass.setBounds(50, 300, 60, 30);
        lblclass.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblclass);
        
        tfclass = new JTextField();
        tfclass.setBounds(150, 300, 220, 30);
        tfclass.setBackground(Color.WHITE);
        tfclass.setForeground(Color.red);
        tfclass.setFont(new Font("Tahoma",Font.BOLD,20));
        add(tfclass);
        
        JLabel lblstream = new JLabel("Stream");
        lblstream.setBounds(50, 350, 100, 30);
        lblstream.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblstream);
        
        tfstream = new JTextField();
        tfstream.setBounds(150, 350, 220, 30);
        tfstream.setBackground(Color.WHITE);
        tfstream.setForeground(Color.BLUE);
        tfstream.setFont(new Font("Tahoma",Font.BOLD,20));
        add(tfstream);
        
        
        JLabel lblcourse = new JLabel("Select Course");
        lblcourse.setBounds(400, 300, 150, 30);
        lblcourse.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblcourse);
        
        tfcourse = new JTextField();
        tfcourse.setBounds(600, 300, 220, 30);
        tfcourse.setBackground(Color.WHITE);
        tfcourse.setForeground(Color.GREEN);
        tfcourse.setFont(new Font("Tahoma",Font.BOLD,20));
        add(tfcourse);
        
        
        try {
            
            Conn c = new Conn();
            String query = "select * from student where rollno = '"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labeldob.setText(rs.getString("dob"));
                labelrollno.setText(rs.getString("rollno"));
                tfaddress.setText(rs.getString("address"));
                tfmno.setText(rs.getString("mno"));
                tfemail.setText(rs.getString("email"));
                tfcourse.setText(rs.getString("course"));
                tfstream.setText(rs.getString("stream"));
                tfclass.setText(rs.getString("sclass"));
                labeladhar.setText(rs.getString("aadhar"));
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
                        labeldob.setText(rs.getString("dob"));
                        labelrollno.setText(rs.getString("rollno"));
                        tfaddress.setText(rs.getString("address"));
                        tfmno.setText(rs.getString("mno"));
                        tfemail.setText(rs.getString("email"));
                        tfcourse.setText(rs.getString("course"));
                        tfstream.setText(rs.getString("stream"));
                        tfclass.setText(rs.getString("sclass"));
                        labeladhar.setText(rs.getString("aadhar"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
            }
            
        });
        
        
        update = new JButton("Update");
        update.setBounds(150,400,120,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        update.setFont(new Font("Tahoma",Font.BOLD,15));
        add(update);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(300,400,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel);
            
        
        setVisible(true);
    }
   
        public void actionPerformed(ActionEvent ae){
        
        
        if (ae.getSource() == update){
            
            String rollno = labelrollno.getText();
            String address = tfaddress.getText();
            String mno = tfmno.getText();
            String email = tfemail.getText();
            String sclass = (String) tfclass.getText();
            String course = (String) tfcourse.getText();
            String stream = (String) tfstream.getText();
            
            try {
                
                String query = "update student set address = '"+address+"',mno = '"+mno+"', email = '"+email+"',sclass = '"+sclass+"', course = '"+course+"', stream = '"+stream+"' where rollno = '"+rollno+"' ";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Student Details Updated Successfuly");
                setVisible(false);
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if (ae.getSource() == cancel){
            setVisible(false);
        }
        }
    public static void main(String[] args){
        new UpdateStudent();
    }
}

