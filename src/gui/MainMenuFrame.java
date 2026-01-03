package gui;
import javax.swing.*;
import java.awt.*;

public class MainMenuFrame {


    public MainMenuFrame(){
JFrame frame=new JFrame("Main Menu");
frame.setSize(800,400);
JButton carManagementButton, customerManagementButton, carRentalButton, carReturnButton,
                 searchCustomerButton, historyButton,carSearchButton,
                usersManagementButton, logoutButton;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3,3,10,10));
        frame.add( carManagementButton= new JButton("car Management"));
        frame.add(customerManagementButton =new JButton("customers Management"));
        frame.add( carRentalButton =new JButton("car rental "));
        frame.add( carReturnButton =new JButton("Car return"));
        frame.add(carSearchButton= new JButton("Car search"));
        frame.add( searchCustomerButton =new JButton("customer search "));
        frame.add(historyButton =new JButton("rental history"));
        frame.add(usersManagementButton =new JButton("user management"));
        frame.add(logoutButton=new JButton("logout"));
        frame.setVisible(true);
        carManagementButton.addActionListener(e -> {});
        // to be continued when all guis are finished


















    }


}
