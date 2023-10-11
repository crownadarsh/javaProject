package cochinginstitutemanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UpdateTeacher extends JFrame implements ActionListener{
    
    
    JTextField  tfaddress , tfmno , tfemail , tfqualification , tfdepartment ;
    Choice cempId;
    JLabel labelempId;
    JButton update , cancel;
    
    UpdateTeacher(){
        
        setSize(900,600);
        setLocation(200,50);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        
        JLabel heading = new JLabel("Update Teacher Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("Tahoma",Font.ITALIC,35));
        add(heading);
        
        
        JLabel lblheading = new JLabel("Search by Emp Id");
        lblheading.setBounds(50,70,200,20);
        lblheading.setFont(new Font("serif",Font.PLAIN,20));
        add(lblheading);
        
        cempId = new Choice();
        cempId.setBounds(250, 70, 200, 20);
        add(cempId);
        
          try {
                
              Conn c = new Conn();
              ResultSet rs = c.s.executeQuery("select * from teacher");
              while(rs.next()){
                  
                   cempId.add(rs.getString("empId"));
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
        
        JLabel lblempid = new JLabel("Emp Id");
        lblempid.setBounds(50, 150, 150, 30);
        lblempid.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblempid);
        
        labelempId = new JLabel();
        labelempId.setBounds(225, 150, 170, 30);
        labelempId.setFont(new Font("Tahoma",Font.BOLD,20));
        add(labelempId);
        
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
        
        JLabel lblqualification = new JLabel("Highest Qualification");
        lblqualification.setBounds(50, 300, 220, 30);
        lblqualification.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lblqualification);
        
        tfqualification = new JTextField();
        tfqualification.setBounds(280, 300, 220, 30);
        tfqualification.setBackground(Color.WHITE);
        tfqualification.setForeground(Color.red);
        tfqualification.setFont(new Font("Tahoma",Font.BOLD,20));
        add(tfqualification);
        
        JLabel lbldepartment = new JLabel("Department");
        lbldepartment.setBounds(50, 350, 150, 30);
        lbldepartment.setFont(new Font("Tahoma",Font.BOLD,20));
        add(lbldepartment);
        
        tfdepartment = new JTextField();
        tfdepartment.setBounds(280, 350, 220, 30);
        tfdepartment.setBackground(Color.WHITE);
        tfdepartment.setForeground(Color.BLUE);
        tfdepartment.setFont(new Font("Tahoma",Font.BOLD,20));
        add(tfdepartment);
        
        
        
        
        
        try {
            
            Conn c = new Conn();
            String query = "select * from teacher where empId = '"+cempId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labeldob.setText(rs.getString("dob"));
                labelempId.setText(rs.getString("empId"));
                tfaddress.setText(rs.getString("address"));
                tfmno.setText(rs.getString("mno"));
                tfemail.setText(rs.getString("email"));
                tfqualification.setText(rs.getString("qualification"));
                tfdepartment.setText(rs.getString("department"));
                labeladhar.setText(rs.getString("adhar"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        cempId.addItemListener(new ItemListener(){
            
            public void itemStateChanged(ItemEvent ie){
                try {
            
                    Conn c = new Conn();
                    String query = "select * from teacher where empId = '"+cempId.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()){
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));
                        labeldob.setText(rs.getString("dob"));
                        labelempId.setText(rs.getString("empId"));
                        tfaddress.setText(rs.getString("address"));
                        tfmno.setText(rs.getString("mno"));
                        tfemail.setText(rs.getString("email"));
                        tfqualification.setText(rs.getString("qualification"));
                        tfdepartment.setText(rs.getString("department"));
                        labeladhar.setText(rs.getString("adhar"));
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
            
            String empId = labelempId.getText();
            String address = tfaddress.getText();
            String mno = tfmno.getText();
            String email = tfemail.getText();
            String qualification = (String) tfqualification.getText();
            String department = (String) tfdepartment.getText();
            
            try {
                
                String query = "update teacher set address = '"+address+"',mno = '"+mno+"', email = '"+email+"',qualification = '"+qualification+"', department = '"+department+"' where empId = '"+empId+"' ";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Teacher Details Updated Successfuly");
                setVisible(false);
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if (ae.getSource() == cancel){
            setVisible(false);
        }
        }
    public static void main(String[] args){
        new UpdateTeacher();
    }
}

