package gui;
import api.*;

import javax.swing.*;
import java.awt.*;

public class MainMenuFrame {
    private EmployeeManager employeeManager;
    private CustomerManager customerManager;
    private RentingManager rentingManager;
    private CarManager carManager;
    private JFrame frame;






    public MainMenuFrame(EmployeeManager empManager, CustomerManager custManager,
                         RentingManager rentManager, CarManager carManager){

        this.employeeManager = empManager;
        this.customerManager = custManager;
        this.rentingManager = rentManager;
        this.carManager = carManager;





 frame=new JFrame("Main Menu");
frame.setSize(800,400);
JButton carManagementButton, customerManagementButton, carRentalButton, carReturnButton,
                CustomerSearchButton, historyButton,carSearchButton,
                usersManagementButton, logoutButton;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3,3,10,10));
        frame.add( carManagementButton= new JButton("car Management"));
        frame.add(customerManagementButton =new JButton("customers Management"));
        frame.add( carRentalButton =new JButton("car rental "));
        frame.add( carReturnButton =new JButton("Car return"));
        frame.add(carSearchButton= new JButton("Car search"));
        frame.add( CustomerSearchButton =new JButton("customer search "));
        frame.add(historyButton =new JButton("rental history"));
        frame.add(usersManagementButton =new JButton("user management"));
        frame.add(logoutButton=new JButton("logout"));


            customerManagementButton.addActionListener(e->{
                    CustomerManagerGui customerManagerGui1=new CustomerManagerGui(this.customerManager, this.rentingManager);  });

        carManagementButton.addActionListener(e -> {
            new CarManagerGui(this.carManager);
        });

        carRentalButton.addActionListener(e -> {

            Employee currentUser = this.employeeManager.getCurrentUser();
            if (currentUser == null) {
                JOptionPane.showMessageDialog(this.frame, "No user logged in!");
                return;
            }
            new RentingManagerGui(this.carManager, this.customerManager,
                    this.rentingManager, currentUser);});

        carReturnButton.addActionListener(e -> {
            Employee currentUser = this.employeeManager.getCurrentUser();
            if (currentUser == null) {
                JOptionPane.showMessageDialog(this.frame, "No user logged in!");
                return;
            }
            new RentingManagerGui(this.carManager, this.customerManager,
                    this.rentingManager, currentUser);});

        carSearchButton.addActionListener(e -> {
            new CarManagerGui(this.carManager);});

        CustomerSearchButton.addActionListener(e -> {

            new CustomerManagerGui(this.customerManager, this.rentingManager);});

        historyButton.addActionListener(e -> {

            Employee currentUser = this.employeeManager.getCurrentUser();
            if (currentUser == null) {
                JOptionPane.showMessageDialog(this.frame, "No user logged in!");
                return;}
            new RentingManagerGui(this.carManager, this.customerManager,
                    this.rentingManager, currentUser);});

        usersManagementButton.addActionListener(e -> {
            new EmployeeManagerGUI(this.employeeManager);});

        logoutButton.addActionListener(e -> {
            this.employeeManager.logoutUser();
            this.frame.dispose();
        });
        frame.setVisible(true);
    }
}
