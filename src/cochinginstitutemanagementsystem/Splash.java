package cochinginstitutemanagementsystem;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable{
    
    Thread t;
    
    Splash () {
        
        JLabel lblHeading = new JLabel("<html>Welcome <br> To The <br> Coaching <br> Institute <br> Management <br> System</html>");
        lblHeading.setBounds(40, 20, 300, 420);
        lblHeading.setFont(new Font("Tahoma",Font.BOLD,45));
        lblHeading.setForeground(Color.GREEN);
        add(lblHeading);
        
        
        /* set background image */
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2 = il.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
       
        t = new Thread(this);
        t.start();
                
        setVisible(true);
        
        int x = 1;

        for(int i = 2 ; i<=500 ; i+=4, x+=1 ) /*Splash Animation loop*/{
        setLocation(650-((i+x)/2),350-(i/2));
        setSize(i+200,i);
        
        try{
            Thread.sleep(10);
        }catch(Exception e){
            
        }
        
        }
        
        
    }
    
    public static void main(String[] args){
        new Splash();
    }

    public void run() {
        try{
            
            Thread.sleep(10000);
             setVisible(false);
             new Login();
            
        } catch (Exception e){}
        }
    }

