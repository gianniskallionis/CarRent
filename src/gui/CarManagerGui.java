package gui;

import api.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CarManagerGui {
    private CustomerManager customerManager;
    private RentalManager rentalManager;
    private Employee currentUser;
    private CarManager carManager;
    private FileManager fileManager;
    public CarManagerGui(CarManager carManager,CustomerManager customerManager,
                         RentalManager rentalManager, Employee currentUser,FileManager fileManager ) {
        this.customerManager=customerManager;
        this.rentalManager=rentalManager;
        this.currentUser=currentUser;
        this.carManager=carManager;
        this.fileManager = fileManager;
        JFrame parentFrame = new JFrame("Car Manager");
        parentFrame.setSize(900, 400);
        parentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        parentFrame.setLayout(new FlowLayout());

        JPanel panel = new JPanel(new GridLayout(5, 1, 15, 15));
        parentFrame.add(panel);

        // ADD CAR----------------------------------------------
        JButton addCarButton = new JButton("Add Car");
        panel.add(addCarButton);
        addCarButton.addActionListener(e -> {
            JDialog dialog = new JDialog(parentFrame, "Add Car", true);
            dialog.setLayout(new BorderLayout());
            dialog.setLocationRelativeTo(parentFrame);

            JPanel form = new JPanel(new GridLayout(8, 2, 10, 10));

            JTextField idField = new JTextField();
            JTextField plateField = new JTextField();
            JTextField brandField = new JTextField();
            JTextField typeField = new JTextField();
            JTextField modelField = new JTextField();
            JTextField yearField = new JTextField();
            JTextField colorField = new JTextField();
            JTextField statusField = new JTextField("Available");

            addRow(form, "ID:", idField);
            addRow(form, "Plate:", plateField);
            addRow(form, "Brand:", brandField);
            addRow(form, "Type:", typeField);
            addRow(form, "Model:", modelField);
            addRow(form, "Year:", yearField);
            addRow(form, "Color:", colorField);
            addRow(form, "Status:", statusField);

            dialog.add(form, BorderLayout.CENTER);

            JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JButton add = new JButton("Add");
            JButton cancel = new JButton("Cancel");
            buttons.add(add);
            buttons.add(cancel);
            dialog.add(buttons, BorderLayout.SOUTH);

            add.addActionListener(ev -> {
                String id = idField.getText().trim();
                String plate = plateField.getText().trim();
                String brand = brandField.getText().trim();
                String type = typeField.getText().trim();
                String model = modelField.getText().trim();
                String year = yearField.getText().trim();
                String color = colorField.getText().trim();
                String status = statusField.getText().trim();

                if (id.isEmpty() || plate.isEmpty() || brand.isEmpty() || type.isEmpty() ||
                        model.isEmpty() || year.isEmpty() || color.isEmpty() || status.isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "All fields are required!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    Car car = new Car(id, plate, brand, type, model, year, color, status);
                    if (carManager.addCar(car)) {
                        fileManager.writeVehicles(carManager);
                        JOptionPane.showMessageDialog(dialog, "Car added successfully!", "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                        dialog.dispose();
                    } else {
                        JOptionPane.showMessageDialog(dialog,
                                "Car could not be added. Plate might already exist.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(dialog, "Error: " + ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            });

            cancel.addActionListener(ev -> dialog.dispose());

            dialog.pack();
            dialog.setVisible(true);
        });

        // SEARCH CAR-----------------------------------------
        JButton searchCarButton = new JButton("Search Car");
        panel.add(searchCarButton);

        searchCarButton.addActionListener(e -> {
            JDialog dialog = new JDialog(parentFrame, "Search Car", true);
            dialog.setLayout(new BorderLayout());
            dialog.setLocationRelativeTo(parentFrame);

            JPanel form = new JPanel(new GridLayout(8, 2, 10, 10));

            JTextField idField = new JTextField();
            JTextField plateField = new JTextField();
            JTextField brandField = new JTextField();
            JTextField typeField = new JTextField();
            JTextField modelField = new JTextField();
            JTextField yearField = new JTextField();
            JTextField colorField = new JTextField();
            JTextField statusField = new JTextField();

            addRow(form, "ID:", idField);
            addRow(form, "Plate:", plateField);
            addRow(form, "Brand:", brandField);
            addRow(form, "Type:", typeField);
            addRow(form, "Model:", modelField);
            addRow(form, "Year:", yearField);
            addRow(form, "Color:", colorField);
            addRow(form, "Status:", statusField);

            dialog.add(form, BorderLayout.CENTER);

            JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JButton search = new JButton("Search");
            JButton cancel = new JButton("Cancel");
            buttons.add(search);
            buttons.add(cancel);
            dialog.add(buttons, BorderLayout.SOUTH);

            search.addActionListener(ev -> {
                // Αναζήτηση με φιλτράρισμα στον client-side
                ArrayList<Car> allCars = carManager.getAllCars();
                ArrayList<Car> results = new ArrayList<>();

                String id = emptyToNull(idField.getText());
                String plate = emptyToNull(plateField.getText());
                String brand = emptyToNull(brandField.getText());
                String type = emptyToNull(typeField.getText());
                String model = emptyToNull(modelField.getText());
                String year = emptyToNull(yearField.getText());
                String color = emptyToNull(colorField.getText());
                String status = emptyToNull(statusField.getText());

                for (Car car : allCars) {
                    boolean matches = true;

                    if (id != null && !car.getId().toLowerCase().contains(id.toLowerCase())) {
                        matches = false;
                    }
                    if (plate != null && !car.getPlate().toLowerCase().contains(plate.toLowerCase())) {
                        matches = false;
                    }
                    if (brand != null && !car.getBrand().toLowerCase().contains(brand.toLowerCase())) {
                        matches = false;
                    }
                    if (type != null && !car.getType().toLowerCase().contains(type.toLowerCase())) {
                        matches = false;
                    }
                    if (model != null && !car.getModel().toLowerCase().contains(model.toLowerCase())) {
                        matches = false;
                    }
                    if (year != null && !car.getYear().toLowerCase().contains(year.toLowerCase())) {
                        matches = false;
                    }
                    if (color != null && !car.getColor().toLowerCase().contains(color.toLowerCase())) {
                        matches = false;
                    }
                    if (status != null && !car.getStatus().equalsIgnoreCase(status)) {
                        matches = false;
                    }

                    if (matches) {
                        results.add(car);
                    }
                }

                if (results.isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "No cars found matching criteria");
                } else {
                    // Δημιουργία JTable με τα αποτελέσματα
                    String[] cols = {"ID", "Plate", "Brand", "Type", "Model", "Year", "Color", "Status"};
                    Object[][] data = new Object[results.size()][8];

                    for (int i = 0; i < results.size(); i++) {
                        Car c = results.get(i);
                        data[i] = new Object[]{
                                c.getId(), c.getPlate(), c.getBrand(),
                                c.getType(), c.getModel(), c.getYear(),
                                c.getColor(), c.getStatus()
                        };
                    }

                    JTable table = new JTable(data, cols);
                    JScrollPane scrollPane = new JScrollPane(table);

                    JDialog resultsDialog = new JDialog(parentFrame, "Search Results", true);
                    resultsDialog.setSize(900, 400);
                    resultsDialog.setLocationRelativeTo(parentFrame);
                    resultsDialog.add(scrollPane);
                    resultsDialog.setVisible(true);
                }
            });

            cancel.addActionListener(ev -> dialog.dispose());

            dialog.pack();
            dialog.setVisible(true);
        });
        // VIEW ALLL CARS--------------------------------------
        JButton viewAllButton = new JButton("View All Cars");
        panel.add(viewAllButton);
        viewAllButton.addActionListener(e -> {
            ArrayList<Car> cars = carManager.getAllCars();

            JDialog dialog = new JDialog(parentFrame, "All Cars", true);
            dialog.setSize(900, 400);
            dialog.setLocationRelativeTo(parentFrame);

            if (cars.isEmpty()) {
                dialog.add(new JLabel("No cars available", SwingConstants.CENTER));
            } else {
                String[] cols = {"ID", "Plate", "Brand", "Type", "Model", "Year", "Color", "Status"};
                Object[][] data = new Object[cars.size()][8];

                for (int i = 0; i < cars.size(); i++) {
                    Car c = cars.get(i);
                    data[i] = new Object[]{
                            c.getId(), c.getPlate(), c.getBrand(),
                            c.getType(), c.getModel(), c.getYear(),
                            c.getColor(), c.getStatus()
                    };
                }

                JTable table = new JTable(data, cols);
                dialog.add(new JScrollPane(table));
            }

            dialog.setVisible(true);
        });
        parentFrame.setVisible(true);
        // EDIT CAR BUTTON--------------------------------------
        JButton editCarButton = new JButton("Edit Car");
        panel.add(editCarButton);
        editCarButton.addActionListener(e -> {
            JDialog dialog = new JDialog(parentFrame, "Edit Car", true);
            dialog.setLayout(new BorderLayout());
            dialog.setLocationRelativeTo(parentFrame);

            JPanel form = new JPanel(new GridLayout(1, 2, 10, 10));
            JLabel plateLabel = new JLabel("Enter Plate to edit:");
            JTextField plateField = new JTextField(10);
            form.add(plateLabel);
            form.add(plateField);

            dialog.add(form, BorderLayout.CENTER);

            JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JButton loadButton = new JButton("Load");
            JButton cancelButton = new JButton("Cancel");
            buttons.add(loadButton);
            buttons.add(cancelButton);
            dialog.add(buttons, BorderLayout.SOUTH);

            loadButton.addActionListener(ev -> {
                String plate = plateField.getText().trim();
                if (plate.isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "Plate cannot be empty!");
                    return;
                }

                Car car = carManager.searchByPlate(plate);
                if (car == null) {
                    JOptionPane.showMessageDialog(dialog, "Car not found!");
                    return;
                }

                openEditDialog(parentFrame, carManager, car);
                dialog.dispose();
            });

            cancelButton.addActionListener(ev -> dialog.dispose());
            dialog.pack();
            dialog.setVisible(true);
        });

parentFrame.setVisible(true);
    }
    // HELPERS-----------------------------------------------------------

    private void addRow(JPanel panel, String label, JTextField field) {
        panel.add(new JLabel(label));
        panel.add(field);
    }

    private String emptyToNull(String s) {
        s = s.trim();
        return s.isEmpty() ? null : s;
    }

    private void showCarInfo(JFrame parent, Car car) {
        JDialog dialog = new JDialog(parent, "Car Found", true);
        JPanel panel = new JPanel(new GridLayout(8, 2, 10, 10));

        panel.add(new JLabel("ID:")); panel.add(new JLabel(car.getId()));
        panel.add(new JLabel("Plate:")); panel.add(new JLabel(car.getPlate()));
        panel.add(new JLabel("Brand:")); panel.add(new JLabel(car.getBrand()));
        panel.add(new JLabel("Type:")); panel.add(new JLabel(car.getType()));
        panel.add(new JLabel("Model:")); panel.add(new JLabel(car.getModel()));
        panel.add(new JLabel("Year:")); panel.add(new JLabel(car.getYear()));
        panel.add(new JLabel("Color:")); panel.add(new JLabel(car.getColor()));
        panel.add(new JLabel("Status:")); panel.add(new JLabel(car.getStatus()));

        dialog.add(panel);
        dialog.pack();
        dialog.setVisible(true);
    }
    private void openEditDialog(JFrame parent, CarManager carManager, Car car) {
        JDialog dialog = new JDialog(parent, "Edit Car: " + car.getPlate(), true);
        dialog.setLayout(new BorderLayout());
        dialog.setLocationRelativeTo(parent);

        JPanel form = new JPanel(new GridLayout(8, 2, 10, 10));

        JTextField idField = new JTextField(car.getId());
        JTextField plateField = new JTextField(car.getPlate());
        JTextField brandField = new JTextField(car.getBrand());
        JTextField typeField = new JTextField(car.getType());
        JTextField modelField = new JTextField(car.getModel());
        JTextField yearField = new JTextField(car.getYear());
        JTextField colorField = new JTextField(car.getColor());
        JTextField statusField = new JTextField(car.getStatus());

        addRow(form, "ID:", idField);
        addRow(form, "Plate:", plateField);
        addRow(form, "Brand:", brandField);
        addRow(form, "Type:", typeField);
        addRow(form, "Model:", modelField);
        addRow(form, "Year:", yearField);
        addRow(form, "Color:", colorField);
        addRow(form, "Status:", statusField);

        dialog.add(form, BorderLayout.CENTER);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton saveButton = new JButton("Save");
        JButton cancelButton = new JButton("Cancel");
        buttons.add(saveButton);
        buttons.add(cancelButton);
        dialog.add(buttons, BorderLayout.SOUTH);

        saveButton.addActionListener(ev -> {
            String id = idField.getText().trim();
            String plate = plateField.getText().trim();
            String brand = brandField.getText().trim();
            String type = typeField.getText().trim();
            String model = modelField.getText().trim();
            String year = yearField.getText().trim();
            String color = colorField.getText().trim();
            String status = statusField.getText().trim();

            if (id.isEmpty() || plate.isEmpty() || brand.isEmpty() || type.isEmpty() ||
                    model.isEmpty() || year.isEmpty() || color.isEmpty() || status.isEmpty()) {
                JOptionPane.showMessageDialog(dialog, "All fields are required!", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            Car updatedCar = new Car(id, plate, brand, type, model, year, color, status);

            if (carManager.updateCar(car.getPlate(), updatedCar)) {
                fileManager.writeVehicles(carManager);
                JOptionPane.showMessageDialog(dialog, "Car updated successfully!", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                dialog.dispose();
            } else {
                JOptionPane.showMessageDialog(dialog,
                        "Car could not be updated. The new plate might already exist.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelButton.addActionListener(ev -> dialog.dispose());
        dialog.pack();
        dialog.setVisible(true);
    }
}