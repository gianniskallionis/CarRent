CarRent

A desktop app for managing a small car rental business, written in Java with Swing. I built it as a university project to practice object-oriented design, working with files, and building a GUI.

An employee logs in and can manage the cars, the customers, the rentals and the other staff accounts. Everything is saved in CSV files, so the data is still there the next time you open the app.


What it does
Log in as an employee
Add, edit, remove and search cars
Add, edit, remove and search customers
Rent a car, return it, and look at the rental history of a customer or a car
Manage employee accounts
How it's built

The code is split in two packages: api holds the logic and the data classes (Car, Customer, Employee, Rental and their managers), and gui holds the Swing windows. Employees and customers both extend an abstract Person class, and the GUI only talks to the manager classes, never to the files directly.

Running it

You need a JDK. I developed it in IntelliJ IDEA, so the easiest way is to open the folder and run src/gui/Main.java.


On the first run the app creates its CSV files with some sample data. You can log in with jsmith / password1.

Author

Giannis Kallionis, Computer Science student
