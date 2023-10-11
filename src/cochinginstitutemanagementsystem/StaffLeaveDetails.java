package cochinginstitutemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;


public class StaffLeaveDetails extends JFrame implements ActionListener{
  
    Choice cempid ;
    JTable table ;
    JButton search , print , cancel ;
    StaffLeaveDetails(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Search by Emp ID");
        heading.setBounds(20,20,150,20);
        add(heading);
        
        cempid = new Choice();
        cempid.setBounds(180, 20, 150, 20);
        add(cempid);
        
          try {
                
              Conn c = new Conn();
              ResultSet rs = c.s.executeQuery("select * from staffleave");
              while(rs.next()){
                  
                   cempid.add(rs.getString("empId"));
              }
              
            }catch(Exception e){
                e.printStackTrace();
            }
          
        table = new JTable();
        
          try {
                
              Conn c = new Conn();
              ResultSet rs = c.s.executeQuery("select * from staffleave");
              table.setModel(DbUtils.resultSetToTableModel(rs));
              
            }catch(Exception e){
                e.printStackTrace();
            }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 500, 550);
        add(jsp);
        
        
        search = new JButton("Search");
        search.setBounds(20,70,100,20);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        search.setFont(new Font("Tahoma",Font.BOLD,15));
        add(search);
        
        print = new JButton("Print");
        print.setBounds(140,70,100,20);
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        print.addActionListener(this);
        print.setFont(new Font("Tahoma",Font.BOLD,15));
        add(print);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(260,70,100,20);
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
        
        if (ae.getSource()==search){
            
            String query = "select * from staffleave where empId = '"+cempid.getSelectedItem()+"'";
             try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==print){
            
            try{
                table.print();
            } catch (Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==cancel){
            setVisible(false);
        }
        
        
    }
    public static void main(String[] args){
        
        new StaffLeaveDetails();
        
    }
    
}
