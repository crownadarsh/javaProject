package cochinginstitutemanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class AddStaff extends JFrame implements ActionListener{
    
    
    JTextField tfname , tffname ,tfaddress , tfmno , tfemail , tfadhar  ;
    JLabel labelempId;
    JDateChooser dcdob;
    JComboBox cbqualification , cbdesignation , cbstream;
    JButton submit , cancel;
    
    Random ran = new Random();
    long first4 = (Math.abs(ran.nextLong() % 9000L) + 1000L);
    
    AddStaff(){
        
        setSize(900,600);
        setLocation(200,50);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        
        JLabel heading = new JLabel("Add New Staff");
        heading.setBounds(250, 0, 600, 60);
        heading.setFont(new Font("Tahoma",Font.BOLD,35));
        add(heading);
        
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 100, 60, 30);
        lblname.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(150, 100, 220, 30);
        add(tfname);
        
        
        JLabel lblfname = new JLabel("Father Name");
        lblfname.setBounds(400, 100, 170, 30);
        lblfname.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblfname);
        
        tffname = new JTextField();
        tffname.setBounds(600, 100, 220, 30);
        add(tffname);
        
        JLabel lblempId = new JLabel("Staff Id");
        lblempId.setBounds(50, 150, 150, 30);
        lblempId.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblempId);
        
        labelempId = new JLabel("STF"+first4);
        labelempId.setBounds(225, 150, 170, 30);
        labelempId.setFont(new Font("Tahoma",Font.BOLD,20));
        add(labelempId);
        
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400, 150, 170, 30);
        lbldob.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lbldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(600, 150, 220, 30);
        add(dcdob);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 200, 100, 30);
        lbladdress.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(150, 200, 220, 30);
        add(tfaddress);
        
        
        JLabel lblmno = new JLabel("Contact No.");
        lblmno.setBounds(400, 200, 170, 30);
        lblmno.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblmno);
        
        tfmno = new JTextField();
        tfmno.setBounds(600, 200, 220, 30);
        add(tfmno);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(50, 250, 60, 30);
        lblemail.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(150, 250, 220, 30);
        add(tfemail);
        
        
        JLabel lbladhar = new JLabel("Aadhar No.");
        lbladhar.setBounds(400, 250, 170, 30);
        lbladhar.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lbladhar);
        
        tfadhar = new JTextField();
        tfadhar.setBounds(600, 250, 220, 30);
        add(tfadhar);
        
        JLabel lblqualification = new JLabel("Highest Qualification");
        lblqualification.setBounds(50, 300, 250, 30);
        lblqualification.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblqualification);
        
        String qualification[] = {"HSC","SSC","Gradute","Post Gradute"};
        cbqualification = new JComboBox(qualification);
        cbqualification.setBounds(300, 300, 220, 30);
        cbqualification.setBackground(Color.WHITE);
        cbqualification.setForeground(Color.red);
        cbqualification.setFont(new Font("Tahoma",Font.BOLD,20));
        add(cbqualification);
        
//        JLabel lblstream = new JLabel("Stream");
//        lblstream.setBounds(50, 350, 100, 30);
//        lblstream.setFont(new Font("Tahoma",Font.BOLD,20));
//        add(lblstream);
//        
//        String stream[] = {"Arts","Commerce","Science"};
//        cbstream = new JComboBox(stream);
//        cbstream.setBounds(150, 350, 220, 30);
//        cbstream.setBackground(Color.WHITE);
//        cbstream.setForeground(Color.BLUE);
//        cbstream.setFont(new Font("Tahoma",Font.BOLD,20));
//        add(cbstream);
        
        
        JLabel lblcourse = new JLabel("Select Designation");
        lblcourse.setBounds(50, 350, 250, 30);
        lblcourse.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblcourse);
        
        String designation[] = {"Clerk","Typist","MTS","Receptionist","Manager"};
        cbdesignation = new JComboBox(designation);
        cbdesignation.setBounds(300, 350, 220, 30);
        cbdesignation.setBackground(Color.WHITE);
        cbdesignation.setForeground(Color.GREEN);
        cbdesignation.setFont(new Font("Tahoma",Font.BOLD,20));
        add(cbdesignation);
        
        submit = new JButton("Submit");
        submit.setBounds(150,430,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(300,430,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel);
            
        
        setVisible(true);
    }
   
        public void actionPerformed(ActionEvent ae){
        
        
        if (ae.getSource() == submit){
            
            String name = tfname.getText();
            String fname = tffname.getText();
            String empId = labelempId.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String mno = tfmno.getText();
            String email = tfemail.getText();
            String adhar = tfadhar.getText();
            String qualification = (String) cbqualification.getSelectedItem();
            String designation = (String)  cbdesignation.getSelectedItem();
//            String stream = (String) cbstream.getSelectedItem();
            
            try {
                
                String query = "insert into staff values('"+name+"','"+fname+"','"+empId+"','"+dob+"','"+address+"','"+mno+"','"+email+"','"+adhar+"','"+qualification+"','"+designation+"')";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                //,'"+stream+"'
                
                JOptionPane.showMessageDialog(null, "Staff Details Inserted Successfuly");
                setVisible(false);
                
            }catch(Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"An error occured, please check Console." );

            }
            
        }else if (ae.getSource() == cancel){
            setVisible(false);
        }
        }
    public static void main(String[] args){
        new AddStaff();
    }
}


