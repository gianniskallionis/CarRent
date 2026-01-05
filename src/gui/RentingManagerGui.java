package gui;

import api.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RentingManagerGui {
    private CarManager carManager;
    private CustomerManager customerManager;
    private RentingManager rentingManager;
    private Employee currentUser;


    public RentingManagerGui(CarManager carManager, CustomerManager customerManager, RentingManager rentingManager,Employee currentUser) {

        JFrame parentFrame = new JFrame("Welcome to Renting Manager");
        parentFrame.setSize(900, 400);
        parentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        parentFrame.setLayout(new FlowLayout());

        this.carManager = carManager;
        this.customerManager = customerManager;
        this.rentingManager = rentingManager;
        this.currentUser = currentUser;

        JPanel panel = new JPanel(new GridLayout(2, 2, 20, 20));
        parentFrame.add(panel);

        // NEW RENTING BUTTON-----------------------------------------------
        JButton newRentingButton = new JButton("New Renting");
        panel.add(newRentingButton);

        newRentingButton.addActionListener(e -> {
            JDialog newRentDialog = new JDialog(parentFrame, "New Renting", true);
            newRentDialog.setLayout(new BorderLayout());
            newRentDialog.setLocationRelativeTo(parentFrame);

            JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));

            JLabel carPlateLabel = new JLabel("Car Plate:");
            JTextField carPlateField = new JTextField(10);
            JLabel customerAfmLabel = new JLabel("Customer AFM:");
            JTextField customerAfmField = new JTextField(10);
            JLabel startDateLabel = new JLabel("Start Date (YYYY-MM-DD):");
            JTextField startDateField = new JTextField(10);
            JLabel endDateLabel = new JLabel("End Date (YYYY-MM-DD):");
            JTextField endDateField = new JTextField(10);

            inputPanel.add(carPlateLabel);
            inputPanel.add(carPlateField);
            inputPanel.add(customerAfmLabel);
            inputPanel.add(customerAfmField);
            inputPanel.add(startDateLabel);
            inputPanel.add(startDateField);
            inputPanel.add(endDateLabel);
            inputPanel.add(endDateField);

            newRentDialog.add(inputPanel, BorderLayout.CENTER);

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JButton rentButton = new JButton("Rent");
            JButton cancelButton = new JButton("Cancel");
            buttonPanel.add(rentButton);
            buttonPanel.add(cancelButton);
            newRentDialog.add(buttonPanel, BorderLayout.SOUTH);

            cancelButton.addActionListener(ev -> newRentDialog.dispose());

            rentButton.addActionListener(ev -> {
                String plate = carPlateField.getText().trim();
                String afm = customerAfmField.getText().trim();
                String startDate = startDateField.getText().trim();
                String endDate = endDateField.getText().trim();

                if (plate.isEmpty() || afm.isEmpty() || startDate.isEmpty() || endDate.isEmpty()) {
                    JOptionPane.showMessageDialog(newRentDialog, "All fields must be filled!");
                    return;
                }

                Car car = carManager.searchByPlate(plate);
                if (car == null) {
                    JOptionPane.showMessageDialog(newRentDialog, "Car not found!");
                    return;
                }
                if (!car.getStatus().equalsIgnoreCase("Available")) {
                    JOptionPane.showMessageDialog(newRentDialog, "Car is not available!");
                    return;
                }

                Customer customer = customerManager.searchByAfm(afm);

                Renting renting = new Renting("R" + System.currentTimeMillis(), car, customer, startDate, endDate, currentUser);
                if (rentingManager.rentCar(renting)) {
                    JOptionPane.showMessageDialog(newRentDialog, "Car rented successfully!");
                    newRentDialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(newRentDialog, "Failed to rent car!");
                }
            });

            newRentDialog.pack();
            newRentDialog.setVisible(true);
        });

        // RETURN CAR BUTTON------------------------------------------------------
        JButton returnCarButton = new JButton("Return Car");
        panel.add(returnCarButton);

        returnCarButton.addActionListener(e -> {
            JDialog returnDialog = new JDialog(parentFrame, "Return Car", true);
            returnDialog.setLayout(new BorderLayout());
            returnDialog.setLocationRelativeTo(parentFrame);

            JPanel inputPanel = new JPanel(new GridLayout(1, 2, 10, 10));
            JLabel rentalCodeLabel = new JLabel("Rental Code:");
            JTextField rentalCodeField = new JTextField(15);
            inputPanel.add(rentalCodeLabel);
            inputPanel.add(rentalCodeField);
            returnDialog.add(inputPanel, BorderLayout.CENTER);

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JButton returnButton = new JButton("Return");
            JButton cancelButton = new JButton("Cancel");
            buttonPanel.add(returnButton);
            buttonPanel.add(cancelButton);
            returnDialog.add(buttonPanel, BorderLayout.SOUTH);

            cancelButton.addActionListener(ev -> returnDialog.dispose());

            returnButton.addActionListener(ev -> {
                String code = rentalCodeField.getText().trim();
                if (code.isEmpty()) {
                    JOptionPane.showMessageDialog(returnDialog, "Rental code cannot be empty!");
                    return;
                }

                Renting foundRenting = null;
                for (Renting r : rentingManager.getAllRentings()) {
                    if (r.getCode().equals(code)) {
                        foundRenting = r;
                        break;
                    }
                }

                if (foundRenting == null) {
                    JOptionPane.showMessageDialog(returnDialog, "Rental with code " + code + " not found!");
                    return;
                }

                if (rentingManager.returnCar(foundRenting)) {
                    JOptionPane.showMessageDialog(returnDialog, "Car returned successfully!");
                    returnDialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(returnDialog, "Car could not be returned!");
                }
            });

            returnDialog.pack();
            returnDialog.setVisible(true);
        });

        // VIEW CUSTOMER RENTALS-----------------------------------------
        JButton viewCustomerRentalsButton = new JButton("View Customer Rentals");
        panel.add(viewCustomerRentalsButton);

        viewCustomerRentalsButton.addActionListener(e -> {
            JDialog dialog = new JDialog(parentFrame, "Customer Rentals", true);
            dialog.setLayout(new BorderLayout());
            dialog.setLocationRelativeTo(parentFrame);

            JPanel inputPanel = new JPanel(new GridLayout(1, 2, 10, 10));
            JLabel afmLabel = new JLabel("Customer AFM:");
            JTextField afmField = new JTextField(10);
            inputPanel.add(afmLabel);
            inputPanel.add(afmField);
            dialog.add(inputPanel, BorderLayout.NORTH);

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JButton viewButton = new JButton("View");
            JButton cancelButton = new JButton("Cancel");
            buttonPanel.add(viewButton);
            buttonPanel.add(cancelButton);
            dialog.add(buttonPanel, BorderLayout.SOUTH);

            cancelButton.addActionListener(ev -> dialog.dispose());

            viewButton.addActionListener(ev -> {
                String afm = afmField.getText().trim();
                if (afm.isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "AFM cannot be empty!");
                    return;
                }

                Customer customer = customerManager.searchByAfm(afm);
                if (customer == null) {
                    JOptionPane.showMessageDialog(dialog, "Customer with AFM " + afm + " not found!");
                    return;
                }
                ArrayList<Renting> rentals = rentingManager.CustomerRentings(customer);

                dialog.dispose();

                JDialog resultsDialog = new JDialog(parentFrame, "Customer Rentals", true);
                resultsDialog.setLayout(new BorderLayout());
                resultsDialog.setSize(900, 500);
                resultsDialog.setLocationRelativeTo(parentFrame);

                if (rentals.isEmpty()) {
                    JPanel panelNoData = new JPanel(new FlowLayout());
                    panelNoData.add(new JLabel("No rentals found for this customer."));
                    resultsDialog.add(panelNoData, BorderLayout.CENTER);
                } else {
                    String[] columnNames = {"Rental ID", "Car Plate", "Start Date", "End Date", "Status"};
                    Object[][] data = new Object[rentals.size()][5];
                    for (int i = 0; i < rentals.size(); i++) {
                        Renting r = rentals.get(i);
                        data[i][0] = r.getCode();
                        data[i][1] = r.getCar().getPlate();
                        data[i][2] = r.getStartDate();
                        data[i][3] = r.getEndDate();
                        data[i][4] = r.getCar().getStatus();
                    }
                    JTable table = new JTable(data, columnNames);
                    resultsDialog.add(new JScrollPane(table), BorderLayout.CENTER);
                }

                JButton okButton = new JButton("Close");
                okButton.addActionListener(ev2 -> resultsDialog.dispose());
                JPanel okPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                okPanel.add(okButton);
                resultsDialog.add(okPanel, BorderLayout.SOUTH);

                resultsDialog.setVisible(true);
            });

            dialog.pack();
            dialog.setVisible(true);
        });

        // VIEW CAR RENTALS--------------------------------------------------------------------
        JButton viewCarRentalsButton = new JButton("View Car Rentals");
        panel.add(viewCarRentalsButton);

        viewCarRentalsButton.addActionListener(e -> {
            JDialog dialog = new JDialog(parentFrame, "Car Rentals", true);
            dialog.setLayout(new BorderLayout());
            dialog.setLocationRelativeTo(parentFrame);

            JPanel inputPanel = new JPanel(new GridLayout(1, 2, 10, 10));
            JLabel plateLabel = new JLabel("Car Plate:");
            JTextField plateField = new JTextField(10);
            inputPanel.add(plateLabel);
            inputPanel.add(plateField);
            dialog.add(inputPanel, BorderLayout.NORTH);

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JButton viewButton = new JButton("View");
            JButton cancelButton = new JButton("Cancel");
            buttonPanel.add(viewButton);
            buttonPanel.add(cancelButton);
            dialog.add(buttonPanel, BorderLayout.SOUTH);

            cancelButton.addActionListener(ev -> dialog.dispose());

            viewButton.addActionListener(ev -> {
                String plate = plateField.getText().trim();
                if (plate.isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "Plate cannot be empty!");
                    return;
                }

                Car car = carManager.searchByPlate(plate);
                if (car == null) {
                    JOptionPane.showMessageDialog(dialog, "Car with plate " + plate + " not found!");
                    return;
                }

                ArrayList<Renting> rentals = rentingManager.CarRentings(car);
                dialog.dispose();

                JDialog resultsDialog = new JDialog(parentFrame, "Car Rentals", true);
                resultsDialog.setLayout(new BorderLayout());
                resultsDialog.setSize(900, 500);
                resultsDialog.setLocationRelativeTo(parentFrame);

                if (rentals.isEmpty()) {
                    JPanel panelNoData = new JPanel(new FlowLayout());
                    panelNoData.add(new JLabel("No rentals found for this car."));
                    resultsDialog.add(panelNoData, BorderLayout.CENTER);
                } else {
                    String[] columnNames = {"Rental ID", "Customer AFM", "Start Date", "End Date", "Status"};
                    Object[][] data = new Object[rentals.size()][5];
                    for (int i = 0; i < rentals.size(); i++) {
                        Renting r = rentals.get(i);
                        data[i][0] = r.getCode();
                        data[i][1] = r.getCustomer().getAfm();
                        data[i][2] = r.getStartDate();
                        data[i][3] = r.getEndDate();
                        data[i][4] = r.getCar().getStatus();
                    }
                    JTable table = new JTable(data, columnNames);
                    resultsDialog.add(new JScrollPane(table), BorderLayout.CENTER);
                }

                JButton okButton = new JButton("Close");
                okButton.addActionListener(ev2 -> resultsDialog.dispose());
                JPanel okPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                okPanel.add(okButton);
                resultsDialog.add(okPanel, BorderLayout.SOUTH);

                resultsDialog.setVisible(true);
            });

            dialog.pack();
            dialog.setVisible(true);
        });

        parentFrame.setVisible(true);
    }}