package gui;
import api.*;

import javax.swing.*;
import java.awt.*;

public class LoginFrame {
private EmployeeManager employeeManager1;
   public LoginFrame(EmployeeManager employeeManagerParam){
      this.employeeManager1=employeeManagerParam;
      JFrame frame=new JFrame("Login");
      frame.setSize(300,200);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(new FlowLayout());
      JLabel usernameLabel=new JLabel("Username");
      JLabel passwordLabel= new JLabel("Password");
      JTextField usernameField= new JTextField(20);
      JPasswordField passwordField = new JPasswordField(20);
      JButton LoginButton =new JButton("Login");
frame.add(usernameLabel);
frame.add(usernameField);
frame.add(passwordLabel);
frame.add(passwordField);
frame.add(LoginButton);
frame.setVisible(true);
LoginButton.addActionListener(e -> {System.out.println("Login button pressed");
String username=usernameField.getText();   // the input username
String password=new String (passwordField.getPassword()); // the input password
   if (username.isEmpty()){JOptionPane.showMessageDialog(frame,"username must not be  empty");return ;}
   if (password.isEmpty()){JOptionPane.showMessageDialog(frame,"password must not be  empty");return;}
EmployeeManager.loginStatus status= employeeManager1.loginUser(username,password);  // to status kserei to return
if (status== EmployeeManager.loginStatus.wrong_username) {
   JOptionPane.showMessageDialog(frame,"wrong Username");}
  else if(status== EmployeeManager.loginStatus.wrong_password)
      JOptionPane.showMessageDialog(frame,"wrong Password");
 else if (status== EmployeeManager.loginStatus.success)
 {   JOptionPane.showMessageDialog(frame,"login successfull");
     frame.dispose();
     FileManager fileManager = new FileManager();
     CarManager carManager = fileManager.readVehicles();
     CustomerManager customerManager = fileManager.readCustomers();
     RentingManager rentingManager = fileManager.readRentals(carManager, customerManager, employeeManager1);


     new MainMenuFrame(employeeManager1, customerManager, rentingManager, carManager);}

});
   }
}


































