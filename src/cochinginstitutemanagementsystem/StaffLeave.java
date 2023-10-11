package cochinginstitutemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class StaffLeave extends JFrame implements ActionListener{
    
    Choice cempid , cduration; 
    JDateChooser dcdate;
    JButton cancel , submit ;
    StaffLeave(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Apply Leave (Staff)");
        heading.setBounds(20, 20, 150, 20);
        add(heading);
        
        JLabel lblempid = new JLabel("Search by Emp ID");
        lblempid.setBounds(60,100,200,20);
        add(lblempid);
        
        cempid = new Choice();
        cempid.setBounds(60, 130, 150, 20);
        add(cempid);
        
          try {
                
              Conn c = new Conn();
              ResultSet rs = c.s.executeQuery("select * from staff");
              while(rs.next()){
                  
                   cempid.add(rs.getString("empid"));
              }
              
            }catch(Exception e){
                e.printStackTrace();
            }
          
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 180, 200, 25);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(60,210,200,20);
        add(dcdate);
        
        JLabel lblduration = new JLabel("Time Duration");
        lblduration.setBounds(60,260,200,20);
        lblduration.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblduration);
        
        cduration = new Choice();
        cduration.setBounds(60, 290, 200, 20);
        cduration.add("Full Day");
        cduration.add("Half Day");
        add(cduration);
        
        submit = new JButton("Submit");
        submit.setBounds(50,350,100,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(200,350,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel);
            
        
        setSize(500,550);
        setLocation(450,50);
        setVisible(true);
        
    }
    
     public void actionPerformed(ActionEvent ae){
        
        
        if (ae.getSource() == submit){
            String rollno = cempid.getSelectedItem();
            String date = ((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
            String duration = cduration.getSelectedItem();
            String query = "insert into staffleave values('"+rollno+"', '"+date+"', '"+duration+"')";
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if (ae.getSource() == cancel){
            setVisible(false);
        }
     }
    public static void main(String[] args){
       new StaffLeave();
    }
}
