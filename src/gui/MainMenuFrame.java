package gui;
import api.CustomerManager;
import api.RentingManager;

import javax.swing.*;
import java.awt.*;

public class MainMenuFrame {


    public MainMenuFrame(){
          CustomerManager  customerManager1=new CustomerManager();
        RentingManager     rentingManager1=new RentingManager();
JFrame frame=new JFrame("Main Menu");
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
        frame.setVisible(true);
        carManagementButton.addActionListener(e -> {});
        // to be continued when all guis are finished
            customerManagementButton.addActionListener(e->{
                    CustomerManagerGui customerManagerGui1=new CustomerManagerGui(customerManager1,rentingManager1);  });























    }


}
