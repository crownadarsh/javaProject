package cochinginstitutemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener{
    
    
    JMenuItem miExit , miAbout , notepad , calc , studentInfo ;
  Project(){
      setSize(1920,1080);     
      
      ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
      Image i2 = il.getImage().getScaledInstance(1850, 980, Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel image = new JLabel(i3);
      add(image);
      
      JMenuBar mb = new JMenuBar();
      
//      Add Details

      JMenu newInformation = new JMenu("New Information");
      newInformation.setForeground(Color.BLUE);
      mb.add(newInformation);
      
      studentInfo = new JMenuItem("Add New Student Information");
      studentInfo.setBackground(Color.WHITE);
      studentInfo.addActionListener(this);
      newInformation.add(studentInfo);
      
      JMenuItem facultyInfo = new JMenuItem("Add New Faculty Information");
      facultyInfo.setBackground(Color.WHITE);
      facultyInfo.addActionListener(this);
      newInformation.add(facultyInfo);
      
      JMenuItem staffInfo = new JMenuItem("Add New Staff Information");
      staffInfo.setBackground(Color.WHITE);
      staffInfo.addActionListener(this);
      newInformation.add(staffInfo);
      
//     View Details
      JMenu viewDetails = new JMenu("View Details");
      viewDetails.setForeground(Color.RED);
      mb.add(viewDetails);
      
      JMenuItem facultyDetails = new JMenuItem("View Faculty Information");
      facultyDetails.setBackground(Color.WHITE);
      facultyDetails.addActionListener(this);
      viewDetails.add(facultyDetails);
      
      
      JMenuItem staffDetails = new JMenuItem("View Staff Information");
      staffDetails.setBackground(Color.WHITE);
      staffDetails.addActionListener(this);
      viewDetails.add(staffDetails);
      
      JMenuItem studentDetails = new JMenuItem("View Student Information");
      studentDetails.setBackground(Color.WHITE);
      studentDetails.addActionListener(this);
      viewDetails.add(studentDetails);
      
//     Apply Leave Details
      JMenu applyLeave = new JMenu("Apply Leave");
      applyLeave.setForeground(Color.BLUE);
      mb.add(applyLeave);
      
      JMenuItem applyfacultyLeave = new JMenuItem("Apply Faculty Leave");
      applyfacultyLeave.setBackground(Color.WHITE);
      applyfacultyLeave.addActionListener(this);
      applyLeave.add(applyfacultyLeave);
      
      JMenuItem applyStaffLeave = new JMenuItem("Apply Staff Leave");
      applyStaffLeave.setBackground(Color.WHITE);
      applyStaffLeave.addActionListener(this);
      applyLeave.add(applyStaffLeave);
      
//     Leave Details
      JMenu leave = new JMenu("Leave Details");
      leave.setForeground(Color.RED);
      mb.add(leave);
      
      JMenuItem facultyLeave = new JMenuItem("Faculty Leave");
      facultyLeave.setBackground(Color.WHITE);
      facultyLeave.addActionListener(this);
      leave.add(facultyLeave);
      
      JMenuItem staffLeave = new JMenuItem("Staff Leave");
      staffLeave.setBackground(Color.WHITE);
      staffLeave.addActionListener(this);
      leave.add(staffLeave);
      
//      Update Details

      JMenu updateInformation = new JMenu("Update Information");
      updateInformation.setForeground(Color.BLUE);
      mb.add(updateInformation);
      
      JMenuItem updateFacultyInfo = new JMenuItem("Update Faculty Information");
      updateFacultyInfo.setBackground(Color.WHITE);
      updateFacultyInfo.addActionListener(this);
      updateInformation.add(updateFacultyInfo);
      
      JMenuItem updateStudentInfo = new JMenuItem("Update Student Information");
      updateStudentInfo.setBackground(Color.WHITE);
      updateStudentInfo.addActionListener(this);
      updateInformation.add(updateStudentInfo);
      
      JMenuItem updateStaffInfo = new JMenuItem("Update Staff Information");
      updateStaffInfo.setBackground(Color.WHITE);
      updateStaffInfo.addActionListener(this);
      updateInformation.add(updateStaffInfo);
      
//     Apply Leave Details
      JMenu feeDetails = new JMenu("Fee Details");
      feeDetails.setForeground(Color.RED);
      mb.add(feeDetails);
      
      JMenuItem feeStructure = new JMenuItem("Fee Structure");
      feeStructure.setBackground(Color.WHITE);
      feeStructure.addActionListener(this);
      feeDetails.add(feeStructure);
      
      JMenuItem feeForm = new JMenuItem("Fee Form");
      feeForm.setBackground(Color.WHITE);
      feeForm.addActionListener(this);
      feeDetails.add(feeForm);
      
      
//     Utility 
      JMenu utility = new JMenu("Utility");
      utility.setForeground(Color.BLUE);
      mb.add(utility);
      
      notepad = new JMenuItem("Notepad");
      notepad.setBackground(Color.WHITE);
      notepad.addActionListener(this);
      utility.add(notepad);
      
      calc = new JMenuItem("Calculator");
      calc.setBackground(Color.WHITE);
      calc.addActionListener(this);
      utility.add(calc);
      
//     About 
      JMenu about = new JMenu("About");
      about.setForeground(Color.RED);
      mb.add(about);
      
      miAbout = new JMenuItem("About");
      miAbout.setBackground(Color.WHITE);
      miAbout.addActionListener(this);
      about.add(miAbout);
      
//     Exit 
      JMenu exit = new JMenu("Exit");
      exit.setForeground(Color.BLUE);
      mb.add(exit);
      
      miExit = new JMenuItem("Exit");
      miExit.setBackground(Color.WHITE);
      miExit.addActionListener(this);
      exit.add(miExit);
      
      setJMenuBar(mb);
      
    setVisible(true);
    
  }
  
   public void actionPerformed(ActionEvent ae){
        
       String msg = ae.getActionCommand();
        
        if (msg.equals("Exit")){
           
            setVisible(false);
            
        }else if (msg.equals("About")){
           
            new About();
            
        }else if (msg.equals("Notepad")){
           
            try{
            
            Runtime.getRuntime().exec("notepad.exe");
            
        } catch (Exception e){}
        
            
        }else if (msg.equals("Calculator")){
            try{
            
            Runtime.getRuntime().exec("calc.exe");
            
        } catch (Exception e){}
        
        }else if (msg.equals("Add New Student Information")){
           
            new AddStudent();
            
        }else if (msg.equals("Add New Faculty Information")){
           
            new AddTeacher();
            
        }else if (msg.equals("Add New Staff Information")){
           
            new AddStaff();
            
        }else if (msg.equals("View Student Information")){
           
            new StudentDetails();
            
        } else if (msg.equals("View Faculty Information")){
           
            new TeacherDetails();
            
        } else if (msg.equals("View Staff Information")){
           
            new StaffDetails();
            
        }else if (msg.equals("Apply Faculty Leave")){
           
            new TeacherLeave();
            
        }else if (msg.equals("Apply Staff Leave")){
           
            new StaffLeave();
            
        }else if (msg.equals("Faculty Leave")){
           
            new TeacherLeaveDetails();
            
        }else if (msg.equals("Staff Leave")){
           
            new StaffLeaveDetails();
            
        }else if (msg.equals("Update Faculty Information")){
           
            new UpdateTeacher();
            
        }else if (msg.equals("Update Student Information")){
           
            new UpdateStudent();
            
        }else if (msg.equals("Update Staff Information")){
           
            new UpdateStaff();
            
        }else if (msg.equals("Fee Structure")){
           
            new FeeStructure();
            
        }else if (msg.equals("Fee Form")){
           
            new FeeForm();
            
        }
    }
  
  
    public static void main(String[] args){
        new Project();
    }
}
