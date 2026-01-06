package gui;
import api.Customer;
import api.EmployeeManager;
import api.Employee;
import api.FileManager;

import javax.swing.*;
import java.awt.*;


public class EmployeeManagerGUI {
    private FileManager fileManager;

    public EmployeeManagerGUI(EmployeeManager employeeManager1,FileManager fileManager) {
        this.fileManager=fileManager;
        JFrame ParentFrame = new JFrame("Welcome to Employee Manager ");
        ParentFrame.setSize(800, 400);
        ParentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ParentFrame.setLayout(new FlowLayout());
        JPanel panel = new JPanel(new GridLayout(2, 2));// se auto to panel tha valoume ola ta buttons k to panel sto frame .
        JButton addUserButton = new JButton("Add User");
        JButton deleteUserButton = new JButton("Delete User");
        JButton searchUserButton = new JButton("Search User");
        JButton cancelButton = new JButton("Cancel");
        panel.add(addUserButton);
        panel.add(searchUserButton);
        panel.add(deleteUserButton);
        panel.add(cancelButton);
        ParentFrame.add(panel);
        cancelButton.addActionListener(e1 -> {
            ParentFrame.dispose();
        });

        // ADD USER
        addUserButton.addActionListener(e -> {
            JDialog addUserDialog = new JDialog(ParentFrame, "Add User", true);
            addUserDialog.setLayout(new BorderLayout());// tou dinume layout
            addUserDialog.setLocationRelativeTo(ParentFrame);// to kentrarume sthn mesh tou megalou panel(window)
            JPanel addUserPanel = new JPanel(new GridLayout(5, 2));
            addUserDialog.add(addUserPanel, BorderLayout.CENTER);
            JLabel nameLabel = new JLabel("Name:");
            JLabel surnameLabel = new JLabel("Surname:");
            JLabel usernameLabel = new JLabel("Username:");
            JLabel emailLabel = new JLabel("Email:");
            JLabel passwordLabel = new JLabel("Password:");

            JTextField nameTextField = new JTextField(20);  // me to .getText() pairnw string
            JTextField surnameTextField = new JTextField(20);
            JTextField usernameTextField = new JTextField(30);
            JTextField emailTextField = new JTextField(35);
            JTextField passwordTextField = new JTextField(30);

// prwta vazeis ta labels kai meta ta fields , alla 1 label+field thn fora
            addUserPanel.add(nameLabel);
            addUserPanel.add(nameTextField);

            addUserPanel.add(surnameLabel);
            addUserPanel.add(surnameTextField);

            addUserPanel.add(usernameLabel);
            addUserPanel.add(usernameTextField);

            addUserPanel.add(emailLabel);
            addUserPanel.add(emailTextField);

            addUserPanel.add(passwordLabel);
            addUserPanel.add(passwordTextField);

            //  ADD+CANCEL BUTTONS HERE  -----------------------------------------------------
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JButton addButton = new JButton("Add");
            JButton cancelAddButton = new JButton("Cancel");

            buttonPanel.add(addButton);
            buttonPanel.add(cancelAddButton);
            addUserDialog.add(buttonPanel, BorderLayout.SOUTH);

            addButton.addActionListener(e1 -> {// creates a new customer with the fields and inserts him into the list of customers
                if (nameTextField.getText().trim().isEmpty() || surnameTextField.getText().trim().isEmpty() ||
                        usernameTextField.getText().trim().isEmpty() || emailTextField.getText().trim().isEmpty()
                        || passwordTextField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(addUserDialog, "name,surname,username,email,password cannot be empty");
                    return;
                }
                Employee emp1 = new Employee(nameTextField.getText().trim(), surnameTextField.getText().trim(), usernameTextField.getText().trim(), emailTextField.getText().trim()
                        , passwordTextField.getText().trim());

                if (employeeManager1.addUser(emp1)) {
                    fileManager.writeEmployees(employeeManager1);
                    addUserDialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(addUserDialog, "error User hasn't been added");
                }
            });
            cancelAddButton.addActionListener(e2 -> {
                addUserDialog.dispose();
            }); // closes the window
            addUserDialog.pack();
            addUserDialog.setVisible(true);
        });

        // Delete User
        deleteUserButton.addActionListener(e -> {
            JDialog deleteUserDialog = new JDialog(ParentFrame, "Delete User", true);
            deleteUserDialog.setLayout(new BorderLayout());
            deleteUserDialog.setLocationRelativeTo(ParentFrame);

            JPanel deleteUserPanel = new JPanel(new GridLayout(1, 2, 10, 10));
            deleteUserDialog.add(deleteUserPanel, BorderLayout.CENTER);

            JLabel usernameLabel = new JLabel("Enter Username to delete:");
            JTextField usernameTextField = new JTextField(10);
            deleteUserPanel.add(usernameLabel);
            deleteUserPanel.add(usernameTextField);

            // DELETE + CANCEL BUTTONS
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JButton deleteButton = new JButton("Delete");
            JButton cancelDeleteButton = new JButton("Cancel");
            buttonPanel.add(deleteButton);
            buttonPanel.add(cancelDeleteButton);
            deleteUserDialog.add(buttonPanel, BorderLayout.SOUTH);

            deleteButton.addActionListener(e1 -> {

                if (usernameTextField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(deleteUserDialog, "Username cannot be empty", "Input Error",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                Employee emp2 = employeeManager1.searchByUsername(usernameTextField.getText().trim());
                if (emp2 == null) {
                    JOptionPane.showMessageDialog(deleteUserDialog, "User not found");
                    return;
                }
                if (employeeManager1.deleteUser(emp2)) {
                    fileManager.writeEmployees(employeeManager1);
                    JOptionPane.showMessageDialog(deleteUserDialog,
                            "User deleted ");
                    deleteUserDialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(deleteUserDialog,
                            "Failed to delete User");
                }
            });
            cancelDeleteButton.addActionListener(e1 -> {
                deleteUserDialog.dispose();
            });
            deleteUserDialog.pack();
            deleteUserDialog.setVisible(true);
        });

/// SEARCH USER -----------------------------------------------------------------------------------------------------
        searchUserButton.addActionListener(e -> {
            JDialog searchDialog = new JDialog(ParentFrame, "choose search type", true);
            searchDialog.setLayout(new GridLayout(2, 1, 10, 10));
            searchDialog.setLocationRelativeTo(ParentFrame);
            JPanel searchButtonsPanel = new JPanel(new GridLayout(4, 1, 10, 10));
            JButton searchByUsernameButton = new JButton("Search By Username");
            JButton searchByEmailButton = new JButton("Search By Email");
            searchButtonsPanel.add(searchByUsernameButton);
            searchButtonsPanel.add(searchByEmailButton);
            searchDialog.add(searchButtonsPanel);
            searchDialog.setPreferredSize(new Dimension(500, 300));

            // --- ADD LISTENERS BEFORE showing the dialog ---
            // SEARCH BY USERNAME
            searchByUsernameButton.addActionListener(e1 -> {
                searchDialog.dispose();
                JDialog searchByUsernameDialog = new JDialog(ParentFrame, "Search By Username", true);
                JPanel searchByUsernamePanel = new JPanel(new GridLayout(1, 2, 10, 10));
                searchByUsernameDialog.setLayout(new BorderLayout());
                JLabel searchByUsernameLabel = new JLabel("Enter  Username:");
                JTextField searchByUsernameField = new JTextField(10);
                searchByUsernamePanel.add(searchByUsernameLabel);
                searchByUsernamePanel.add(searchByUsernameField);
                searchByUsernameDialog.add(searchByUsernamePanel, BorderLayout.CENTER);

                JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                JButton okButton = new JButton("Ok");
                JButton cancelSearchButton = new JButton("Cancel");
                buttonPanel.add(okButton);
                buttonPanel.add(cancelSearchButton);
                searchByUsernameDialog.add(buttonPanel, BorderLayout.SOUTH);

                cancelSearchButton.addActionListener(e2 -> searchByUsernameDialog.dispose());

                okButton.addActionListener(e2 -> {
                    String username = searchByUsernameField.getText().trim();
                    if (username.isEmpty()) {
                        JOptionPane.showMessageDialog(searchByUsernameDialog,
                                "Please enter a non empty username",
                                "Input Error",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    Employee em1 = employeeManager1.searchByUsername(username);

                    if (em1 == null) {
                        JOptionPane.showMessageDialog(searchByUsernameDialog, "User not found with given username");
                    } else {
                        JDialog UserFoundDialog = new JDialog(ParentFrame, "User Found", true);
                        UserFoundDialog.setLayout(new BorderLayout());
                        JPanel UserFoundPanel = new JPanel(new GridLayout(5, 2));
                        addRowToPanel(UserFoundPanel, "Name:", em1.getName());
                        addRowToPanel(UserFoundPanel, "Surname:", em1.getSurname());
                        addRowToPanel(UserFoundPanel, "Username:", em1.getUsername());
                        addRowToPanel(UserFoundPanel, "Email:", em1.getEmail());
                        addRowToPanel(UserFoundPanel, "Password:", em1.getPassword());
                        UserFoundDialog.add(UserFoundPanel,BorderLayout.CENTER);

                        JPanel customerFoundButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                        JButton customerFoundOkButton = new JButton("Ok");
                        customerFoundOkButton.addActionListener(e3 -> UserFoundDialog.dispose());
                        customerFoundButtonPanel.add(customerFoundOkButton);
                        UserFoundDialog.add(customerFoundButtonPanel,BorderLayout.SOUTH);
                        UserFoundDialog.pack();
                        UserFoundDialog.setLocationRelativeTo(ParentFrame);
                        UserFoundDialog.setVisible(true);
                    }
                });

                searchByUsernameDialog.pack();
                searchByUsernameDialog.setVisible(true);
            });

            // SEARCH BY EMAIL
            searchByEmailButton.addActionListener(e1 -> {
                searchDialog.dispose();
                JDialog searchByEmailDialog = new JDialog(ParentFrame, "Search By Email", true);
                JPanel searchByEmailPanel = new JPanel(new GridLayout(1, 2, 10, 10));
                searchByEmailDialog.setLayout(new BorderLayout());
                JLabel searchByEmailLabel = new JLabel("Enter Email:");
                JTextField searchByEmailField = new JTextField(10);
                searchByEmailPanel.add(searchByEmailLabel);
                searchByEmailPanel.add(searchByEmailField);
                searchByEmailDialog.add(searchByEmailPanel, BorderLayout.CENTER);

                JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                JButton okButton = new JButton("Ok");
                JButton cancelSearchButton = new JButton("Cancel");
                buttonPanel.add(okButton);
                buttonPanel.add(cancelSearchButton);
                searchByEmailDialog.add(buttonPanel, BorderLayout.SOUTH);

                cancelSearchButton.addActionListener(e2 -> searchByEmailDialog.dispose());

                okButton.addActionListener(e2 -> {
                    String email = searchByEmailField.getText().trim();
                    if (email.isEmpty()) {
                        JOptionPane.showMessageDialog(searchByEmailDialog,
                                "Please enter a non empty email",
                                "Input Error",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    Employee em1 = employeeManager1.searchByEmail(email);

                    if (em1 == null) {
                        JOptionPane.showMessageDialog(searchByEmailDialog, "User not found with given email");
                    } else {
                        JDialog UserFoundDialog = new JDialog(ParentFrame, "User Found", true);
                        UserFoundDialog.setLayout(new BorderLayout());
                        JPanel UserFoundPanel = new JPanel(new GridLayout(5, 2));
                        addRowToPanel(UserFoundPanel, "Name:", em1.getName());
                        addRowToPanel(UserFoundPanel, "Surname:", em1.getSurname());
                        addRowToPanel(UserFoundPanel, "Username:", em1.getUsername());
                        addRowToPanel(UserFoundPanel, "Email:", em1.getEmail());
                        addRowToPanel(UserFoundPanel, "Password:", em1.getPassword());
                        UserFoundDialog.add(UserFoundPanel,BorderLayout.CENTER);

                        JPanel userFoundButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                        JButton userFoundOkButton = new JButton("Ok");
                        userFoundOkButton.addActionListener(e3 -> UserFoundDialog.dispose());
                        userFoundButtonPanel.add(userFoundOkButton);
                        UserFoundDialog.add(userFoundButtonPanel,BorderLayout.SOUTH);
                        UserFoundDialog.pack();
                        UserFoundDialog.setVisible(true);
                    }
                });

                searchByEmailDialog.pack();
                searchByEmailDialog.setVisible(true);
            });

            // finally show the choice dialog after listeners are attached
            searchDialog.pack();
            searchDialog.setVisible(true);
        });

        ParentFrame.setVisible(true);
    }private void addRowToPanel(JPanel panel, String labelText, String valueText) {  // all methods , outside of constructor
        panel.add(new JLabel(labelText));
        panel.add(new JLabel(valueText));}

}
