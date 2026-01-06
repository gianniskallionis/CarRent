package gui;
import api.*;

import javax.swing.*;
import java.awt.*;

public class MainMenuFrame {
    private EmployeeManager employeeManager;
    private CustomerManager customerManager;
    private RentalManager rentalManager;
    private CarManager carManager;
    private FileManager fileManager;
    private JFrame frame;






    public MainMenuFrame(EmployeeManager empManager, CustomerManager custManager,
                         RentalManager rentManager, CarManager carManager,FileManager fileManager){
        this.fileManager=fileManager;
        this.employeeManager = empManager;
        this.customerManager = custManager;
        this.rentalManager = rentManager;
        this.carManager = carManager;





 frame=new JFrame("Main Menu");
frame.setSize(400,600);
frame.setLocationRelativeTo(null);
JButton carManagementButton, customerManagementButton,
                 rentalManagementButton,
                usersManagementButton, logoutButton;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5,1,15,15));
        frame.add( carManagementButton= new JButton("Cars Management"));
        frame.add(customerManagementButton =new JButton("Customers Management"));
        frame.add(rentalManagementButton =new JButton("Rentals Management"));
        frame.add(usersManagementButton =new JButton("Users Management"));
        frame.add(logoutButton=new JButton("Logout"));


            customerManagementButton.addActionListener(e->{
                    CustomerManagerGui customerManagerGui1=new CustomerManagerGui(this.customerManager, this.rentalManager,this.fileManager);  });

        carManagementButton.addActionListener(e -> {
            Employee currentUser = this.employeeManager.getCurrentUser();
            if (currentUser == null) {
                JOptionPane.showMessageDialog(this.frame, "No user logged in!");
                return;
            }
            new CarManagerGui(this.carManager, this.customerManager,
                    this.rentalManager, currentUser);
        });




        rentalManagementButton.addActionListener(e -> {

            Employee currentUser = this.employeeManager.getCurrentUser();
            if (currentUser == null) {
                JOptionPane.showMessageDialog(this.frame, "No user logged in!");
                return;}
            new RentalManagerGui(this.carManager, this.customerManager,
                    this.rentalManager, currentUser);});

        usersManagementButton.addActionListener(e -> {
            new EmployeeManagerGUI(this.employeeManager,this.fileManager);});

        logoutButton.addActionListener(e -> {
            this.employeeManager.logoutUser();
            this.frame.dispose();
        });
        frame.setVisible(true);
    }
}
