package gui;

import api.Car;
import api.CarManager;
import api.RentingManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CarManagerGui {

    public CarManagerGui(CarManager carManager, RentingManager rentingManager) {

        JFrame parentFrame = new JFrame("Car Manager");
        parentFrame.setSize(900, 400);
        parentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        parentFrame.setLayout(new FlowLayout());

        JPanel panel = new JPanel(new GridLayout(2, 3, 10, 10));
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
                try {
                    Car car = new Car(idField.getText().trim(), plateField.getText().trim(), brandField.getText().trim(), typeField.getText().trim(), modelField.getText().trim(), yearField.getText().trim(), colorField.getText().trim(), statusField.getText().trim());

                    if (carManager.addCar(car)) {
                        dialog.dispose();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(dialog, "Car already exists or invalid data");
                    }
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(dialog, "Invalid input: " + ex.getMessage());
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

            JPanel form = new JPanel(new GridLayout(5, 2, 10, 10));

            JTextField plateField = new JTextField();
            JTextField brandField = new JTextField();
            JTextField modelField = new JTextField();
            JTextField colorField = new JTextField();
            JTextField statusField = new JTextField();

            addRow(form, "Plate:", plateField);
            addRow(form, "Brand:", brandField);
            addRow(form, "Model:", modelField);
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
                Car car = carManager.searchCombined(
                        emptyToNull(plateField.getText()),
                        emptyToNull(brandField.getText()),
                        emptyToNull(modelField.getText()),
                        emptyToNull(colorField.getText()),
                        emptyToNull(statusField.getText())
                );

                if (car == null) {
                    JOptionPane.showMessageDialog(dialog, "No car found");
                }
                else
                {
                    showCarInfo(parentFrame, car);
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
}