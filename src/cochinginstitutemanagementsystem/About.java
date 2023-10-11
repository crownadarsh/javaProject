package cochinginstitutemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class About extends JFrame implements ActionListener{
    
    JButton back;
    
    About(){
        setSize(700,550);
        setLocation(270,50);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        
        JLabel lblHeading = new JLabel("<html>Coaching <br> Institute <br> Management <br> System</html>");
        lblHeading.setBounds(40, 20, 300, 220);
        lblHeading.setFont(new Font("Tahoma",Font.BOLD,45));
        add(lblHeading);
        
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/about.png"));
         Image i2 = il.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 300, 250);
        add(image);
        
        JLabel lblDevloper = new JLabel("Devoloped By : Adarsh Pratap Singh Gautam");
        lblDevloper.setBounds(40, 300, 600, 40);
        lblDevloper.setFont(new Font("Serif",Font.ITALIC,30));
        add(lblDevloper);
        
        JLabel lblRNo = new JLabel("Roll No.         : 03");
        lblRNo.setBounds(40, 340, 550, 40);
        lblRNo.setFont(new Font("Serif",Font.ITALIC,30));
        add(lblRNo);
        
        JLabel lblContact = new JLabel("Contact Us     : crownapsingh@gmail.com");
        lblContact.setBounds(40, 380, 550, 40);
        lblContact.setFont(new Font("Serif",Font.ITALIC,30));
        add(lblContact);
        
        back = new JButton("Close");
        back.setBounds(180,440,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setFont(new Font("Tahoma",Font.BOLD,15));
        add(back);
        
        setVisible(true);
        
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
        
        
        if (ae.getSource() == back){
             setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new About();
    }
}
