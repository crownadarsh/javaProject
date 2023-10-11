package cochinginstitutemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class StudentDetails  extends JFrame implements ActionListener{
    
    Choice crollno ;
    JTable table ;
    JButton search , print , update , add , cancel ;
    StudentDetails() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Search by Roll No.");
        heading.setBounds(20,20,150,20);
        add(heading);
        
        crollno = new Choice();
        crollno.setBounds(180, 20, 150, 20);
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
          
        table = new JTable();
        
          try {
                
              Conn c = new Conn();
              ResultSet rs = c.s.executeQuery("select * from student");
              table.setModel(DbUtils.resultSetToTableModel(rs));
              
            }catch(Exception e){
                e.printStackTrace();
            }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 1100, 600);
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
        
        update = new JButton("Update");
        update.setBounds(260,70,100,20);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        update.setFont(new Font("Tahoma",Font.BOLD,15));
        add(update);
        
        add = new JButton("Add");
        add.setBounds(380,70,100,20);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add.setFont(new Font("Tahoma",Font.BOLD,15));
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(500,70,100,20);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel);
        
        setSize(1100,600);
        setLocation(100,50);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if (ae.getSource()==search){
            
            String query = "select * from student where rollno = '"+crollno.getSelectedItem()+"'";
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
            
        }else if(ae.getSource()==add){
            setVisible(false);
            new AddStudent();
        }else if(ae.getSource()==update){
            setVisible(false);
            new UpdateStudent();
        }else if(ae.getSource()==cancel){
            setVisible(false);
        }
        
        
    }
    
    
    public static void main(String[] args){
        
        new StudentDetails();
        
    }
}
