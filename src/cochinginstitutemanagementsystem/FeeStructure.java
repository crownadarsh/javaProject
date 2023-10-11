package cochinginstitutemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class FeeStructure extends JFrame implements ActionListener{

    JTable table = new JTable();
    JButton print , cancel;
    
    FeeStructure(){
        
        setSize(1000,600);
        setLocation(170,50);
        setLayout(null);
        
        getContentPane().setBackground(Color.white);
        
        
        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(20,20,550,60);
        heading.setFont(new Font("Tahoma",Font.BOLD,35));
        add(heading);
        
        try{
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from feestructure");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        print = new JButton("Print");
        print.setBounds(500,70,100,20);
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        print.addActionListener(this);
        print.setFont(new Font("Tahoma",Font.BOLD,15));
        add(print);
        
        cancel = new JButton("Close");
        cancel.setBounds(620,70,100,20);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel);
     
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 1000, 600);
        add(jsp);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
            
        if (ae.getSource()==print){

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
        new FeeStructure();
    }
}
