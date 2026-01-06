package gui;

import api.*;

/**  it initializes the files ,and it  calls loginFrame class to start the app
 *
 */
public class Main {
    public static void main(String[] args) {

        FileManager fileManager = new FileManager();


        fileManager.initializeCustomers();
        fileManager.initializeEmployees();
        fileManager.initializeVehicles();
        fileManager.initializeRentals();


        EmployeeManager employeeManager = fileManager.readEmployees();
        CarManager carManager = fileManager.readVehicles();
        CustomerManager customerManager = fileManager.readCustomers();
        RentalManager rentalManager = fileManager.readRentals(
                carManager, customerManager, employeeManager);


        new LoginFrame(employeeManager);
    }
}