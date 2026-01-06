package gui;
import api.CustomerManager;
import api.Customer;
import api.FileManager;
import api.RentalManager;
import javax.swing.*;
import java.awt.*;

public class CustomerManagerGui {
private FileManager fileManager;
    public CustomerManagerGui(CustomerManager customerManager1, RentalManager rentalManager1, FileManager fileManager) {
        this.fileManager=fileManager;
        JFrame ParentFrame = new JFrame("Welcome to Customer Manager ");
        ParentFrame.setSize(800,400);
        ParentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ParentFrame.setLayout(new FlowLayout());
        JPanel panel= new JPanel(new GridLayout(4,1,10,10));// se auto to panel tha valoume ola ta buttons k to panel sto frame .
        ParentFrame.add(panel);

        JButton addCustomerButton=new JButton("Add Customer");
        panel.add(addCustomerButton); // valame to addCustomer koumpi sthn arxiki othoni

        // ADD CUSTOMER  GUI START ---------------------------------------------------------------------------------
        addCustomerButton.addActionListener(e->{  // απο εδω κ κατω, εχει πατηθει το addCustomerButton
 JDialog addCustomerDialog=new JDialog( ParentFrame ,"Add Customer", true );
 addCustomerDialog.setLayout(new BorderLayout());// tou dinume layout
 addCustomerDialog.setLocationRelativeTo(ParentFrame);// to kentrarume sthn mesh tou megalou panel(window)
 JPanel addCustomerPanel=new JPanel(new GridLayout(5,2));
 addCustomerDialog.add(addCustomerPanel, BorderLayout.CENTER);



 JLabel afmLabel= new JLabel("AFM:");
 JLabel nameLabel= new JLabel("name:");
 JLabel surnameLabel= new JLabel("surname:");
 JLabel numberLabel = new JLabel("number:");
 JLabel emailLabel=new JLabel("email:");

 JTextField afmTextField=new JTextField(10);  // me to .getText() pairnw string
 JTextField nameTextField= new JTextField(20);
 JTextField surnameTextField= new JTextField(20);
 JTextField numberTextField= new JTextField(15);
 JTextField emailTextField= new JTextField(30);

// prwta vazeis ta labels kai meta ta fields , alla 1 label+field thn fora
 addCustomerPanel.add(afmLabel);
 addCustomerPanel.add(afmTextField);

 addCustomerPanel.add(nameLabel);
 addCustomerPanel.add(nameTextField);

 addCustomerPanel.add(surnameLabel);
 addCustomerPanel.add(surnameTextField);

 addCustomerPanel.add(numberLabel);
 addCustomerPanel.add(numberTextField);

 addCustomerPanel.add(emailLabel);
 addCustomerPanel.add(emailTextField);







 //  ADD+CANCEL BUTTONS HERE  -----------------------------------------------------
 JPanel buttonPanel= new JPanel(new FlowLayout(FlowLayout.RIGHT));
 JButton addButton= new JButton("Add");
 JButton cancelButton=new JButton("Cancel");

 buttonPanel.add(addButton);
 buttonPanel.add(cancelButton);
 addCustomerDialog.add(buttonPanel,BorderLayout.SOUTH);

 addButton.addActionListener(e1-> {// creates a new customer with the fields and inserts him into the list of customers
     if (afmTextField.getText().trim().isEmpty() || nameTextField.getText().trim().isEmpty() ||
             surnameTextField.getText().trim().isEmpty())
     {JOptionPane.showMessageDialog(addCustomerDialog, "Afm,name,surname cannot be empty");
         return;}
    Customer c1=new Customer(afmTextField.getText().trim(),nameTextField.getText().trim(),surnameTextField.getText().trim(),numberTextField.getText().trim()
            ,emailTextField.getText().trim());

     if (customerManager1.addCustomer(c1)){
         fileManager.writeCustomers(customerManager1);
         addCustomerDialog.dispose();}
     else{JOptionPane.showMessageDialog(addCustomerDialog,"error Customer hasnt been added");}
});
cancelButton.addActionListener(e2->{  addCustomerDialog.dispose();  }); // closes the window
 addCustomerDialog.pack();
 addCustomerDialog.setVisible(true);
        });// end of addCustomerButton

JButton editCustomerButton=new JButton("Edit Customer");
panel.add(editCustomerButton);
// EDIT CUSTOMER-----------------------------------------------------------------------------------------------------------------
editCustomerButton.addActionListener(e -> {
            JDialog editCustomerDialog = new JDialog(ParentFrame,"Edit Customer",true);
            editCustomerDialog.setLayout(new BorderLayout());// tou dinume layout
            editCustomerDialog.setLocationRelativeTo(ParentFrame);// to kentrarume sthn mesh tou megalou panel(window)
            JPanel editCustomerPanel=new JPanel(new GridLayout(5,2));
            editCustomerDialog.add(editCustomerPanel, BorderLayout.CENTER); // vazume to jpanel mesa sto jdialog

            JLabel afmLabel= new JLabel("AFM:");
            JLabel nameLabel= new JLabel("new name:");
            JLabel surnameLabel= new JLabel("new surname:");
            JLabel numberLabel = new JLabel("new number:");
            JLabel emailLabel=new JLabel("new email:");

            JTextField afmTextField=new JTextField(10);  // me to .getText() pairnw string
            JTextField nameTextField= new JTextField(20);
            JTextField surnameTextField= new JTextField(20);
            JTextField numberTextField= new JTextField(15);
            JTextField emailTextField= new JTextField(30);

            // prwta vazeis ta labels kai meta ta fields , alla 1 label+field thn fora
            editCustomerPanel.add(afmLabel);
            editCustomerPanel.add(afmTextField);

            editCustomerPanel.add(nameLabel);
            editCustomerPanel.add(nameTextField);

            editCustomerPanel.add(surnameLabel);
            editCustomerPanel.add(surnameTextField);

            editCustomerPanel.add(numberLabel);
            editCustomerPanel.add(numberTextField);

            editCustomerPanel.add(emailLabel);
            editCustomerPanel.add(emailTextField);

//  EDIT+CANCEL BUTTONS HERE  -----------------------------------------------------
            JPanel buttonPanel= new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JButton editButton= new JButton("Edit");
            JButton cancelButton=new JButton("Cancel");

            buttonPanel.add(editButton);
            buttonPanel.add(cancelButton);
            editCustomerDialog.add(buttonPanel,BorderLayout.SOUTH);


            editButton.addActionListener(e1-> {// edits the customer
                String afm=afmTextField.getText().trim();
                String newName = nameTextField.getText().trim();
                String newSurname = surnameTextField.getText().trim();
                String newNumber = numberTextField.getText().trim();
                String newEmail = emailTextField.getText().trim();

                if (newName.isEmpty()) newName = null; // if a variable is empty we make it null so it doesnt change from
                if (newSurname.isEmpty()) newSurname = null;  // the edit Customer method
                if (newNumber.isEmpty()) newNumber = null;
                if (newEmail.isEmpty()) newEmail = null;

                if (afm.isEmpty() )
                {JOptionPane.showMessageDialog(editCustomerDialog, "Afm cannot be empty");
                    return;}

                if (customerManager1.editCustomer(afm,newName,newSurname,newNumber,newEmail)
                ){fileManager.writeCustomers(customerManager1);
                    editCustomerDialog.dispose();}
                else{JOptionPane.showMessageDialog(editCustomerDialog,"error Customer hasn't been edited");}
            });
            cancelButton.addActionListener(e2->{  editCustomerDialog.dispose();  }); // closes the window
    editCustomerDialog.pack();
    editCustomerDialog.setVisible(true);
    });// -----------------------------------------

// SEARCH CUSTOMER -----------------------------------------------------------------------------------------------------
JButton searchCustomerButton=new JButton("Search Customer");
panel.add(searchCustomerButton);
 searchCustomerButton.addActionListener(e->{
     JDialog searchDialog= new JDialog(ParentFrame,"choose search type",true);
     searchDialog.setLayout(new GridLayout(4,1,10,10));
     searchDialog.setLocationRelativeTo(ParentFrame);
     JPanel searchButtonsPanel=new JPanel(new GridLayout(4,1,10,10));
  JButton searchByAfmButton= new JButton("Search By AFM");
     JButton searchByNameButton= new JButton("Search By Name");
     JButton searchByNumberButton= new JButton("Search By Number");
     JButton cancel= new JButton("Cancel");
     searchButtonsPanel.add(searchByAfmButton);
     searchButtonsPanel.add(searchByNameButton);
     searchButtonsPanel.add(searchByNumberButton);
     searchButtonsPanel.add(cancel);
     searchDialog.add(searchButtonsPanel);

// Search BY AFM --------------------------------------------
     searchByAfmButton.addActionListener(e1->{
         // label and field ------
         searchDialog.dispose();
         JDialog searchByAfmDialog= new JDialog(ParentFrame,"Search By Afm",true);
         JPanel searchByAfmPanel= new JPanel((new GridLayout(1,2,10,10)));
         searchByAfmDialog.setLayout(new BorderLayout());
         JLabel enterAfmLabel= new JLabel(("Enter AFM:"));  // writes enter afm
         JTextField enterAfmField=new JTextField(10); // reads the afm
         searchByAfmPanel.add(enterAfmLabel);
         searchByAfmPanel.add(enterAfmField);
         searchByAfmDialog.add(searchByAfmPanel,BorderLayout.CENTER);

         // Buttons -----
         JPanel buttonPanel= new JPanel(new FlowLayout(FlowLayout.RIGHT));
         JButton okButton=new JButton("Ok");
         JButton cancelButton= new JButton(("Cancel"));
         buttonPanel.add(okButton);
         buttonPanel.add(cancelButton);
         searchByAfmDialog.add(buttonPanel,BorderLayout.SOUTH);
         // Buttons actions listeners ------
         cancelButton.addActionListener(e2->{searchByAfmDialog.dispose();});
         okButton.addActionListener(e2->{
         String afm= enterAfmField.getText().trim();
             if (afm.isEmpty()) {JOptionPane.showMessageDialog(searchByAfmDialog,
                     "Please enter a non empty AFM", "Input Error", JOptionPane.WARNING_MESSAGE);
                 return;
             }


         Customer c1;
             c1=customerManager1.searchByAfm(afm);
             if(c1==null){JOptionPane.showMessageDialog(searchByAfmDialog,"Customer not found with given AFM");}
             else { // here we make the Customer Found JDialog------------------------------
                 // CustomerFound Form  START----------------------------
                 JDialog customerFoundDialog=new JDialog(ParentFrame,"Customer Found",true);
                 JPanel customerFoundPanel =new JPanel(new GridLayout(5,2));

                 addRowToPanel(customerFoundPanel, "AFM:", c1.getAfm());
                 addRowToPanel(customerFoundPanel, "Name:", c1.getName());
                 addRowToPanel(customerFoundPanel, "Surname:", c1.getSurname());
                 addRowToPanel(customerFoundPanel, "Number:", c1.getNumber());
                 addRowToPanel(customerFoundPanel, "Email:", c1.getEmail());
                 customerFoundDialog.setLayout(new BorderLayout());
                 customerFoundDialog.add(customerFoundPanel,BorderLayout.CENTER);

                 // CustomerFound Buttons START -----------
                 JPanel customerFoundButtonPanel= new JPanel(new FlowLayout(FlowLayout.RIGHT));
                 JButton customerFoundOkButton= new JButton("Ok");
                 customerFoundOkButton.addActionListener(e3->{customerFoundDialog.dispose();});
                 customerFoundButtonPanel.add(customerFoundOkButton);// button into panel
                 customerFoundDialog.add(customerFoundButtonPanel,BorderLayout.SOUTH); // panel into dialog
                 customerFoundDialog.pack();
                 customerFoundDialog.setVisible(true);
             }
         });

         searchByAfmDialog.pack();
         searchByAfmDialog.setVisible(true);
     });
// Search BY NAME -------------------
     searchByNameButton.addActionListener(e1->{
         searchDialog.dispose();
         JDialog searchByNameDialog= new JDialog(ParentFrame,"Search By Name",true);
         JPanel searchByNamePanel= new JPanel((new GridLayout(2,2,10,10)));
         searchByNameDialog.setLayout(new BorderLayout());
         JLabel enterNameLabel= new JLabel(("Enter Name:"));
         JTextField enterNameField=new JTextField(20);
         JLabel enterSurnameLabel= new JLabel(("Enter Surname:"));
         JTextField enterSurnameField=new JTextField(20);
         searchByNamePanel.add(enterNameLabel);
         searchByNamePanel.add(enterNameField);
         searchByNamePanel.add(enterSurnameLabel);
         searchByNamePanel.add(enterSurnameField);
         searchByNameDialog.add(searchByNamePanel,BorderLayout.CENTER);

         // Buttons -----
         JPanel buttonPanel= new JPanel(new FlowLayout(FlowLayout.RIGHT));
         JButton okButton=new JButton("Ok");
         JButton cancelButton= new JButton(("Cancel"));
         buttonPanel.add(okButton);
         buttonPanel.add(cancelButton);
         searchByNameDialog.add(buttonPanel,BorderLayout.SOUTH);
         // Buttons actions listeners ------
         cancelButton.addActionListener(e2->{searchByNameDialog.dispose();});
         okButton.addActionListener(e2->{
             String name= enterNameField.getText().trim();
             String surname= enterSurnameField.getText().trim();
             if (name.isEmpty() || surname.isEmpty()) {
                 JOptionPane.showMessageDialog(searchByNameDialog,
                         "Please enter both name and surname",
                         "Input Error",
                         JOptionPane.WARNING_MESSAGE);
                 return;
             }

             Customer c1;
             c1=customerManager1.searchByName(name, surname);
             if(c1==null){JOptionPane.showMessageDialog(searchByNameDialog,"Customer not found with given name and surname");}
             else {
                 // CustomerFound Form  START----------------------------
                 JDialog customerFoundDialog=new JDialog(ParentFrame,"Customer Found",true);
                 JPanel customerFoundPanel =new JPanel(new GridLayout(5,2));

                 addRowToPanel(customerFoundPanel, "AFM:", c1.getAfm());
                 addRowToPanel(customerFoundPanel, "Name:", c1.getName());
                 addRowToPanel(customerFoundPanel, "Surname:", c1.getSurname());
                 addRowToPanel(customerFoundPanel, "Number:", c1.getNumber());
                 addRowToPanel(customerFoundPanel, "Email:", c1.getEmail());
                 customerFoundDialog.setLayout(new BorderLayout());
                 customerFoundDialog.add(customerFoundPanel,BorderLayout.CENTER);

                 // CustomerFound Buttons START -----------
                 JPanel customerFoundButtonPanel= new JPanel(new FlowLayout(FlowLayout.RIGHT));
                 JButton customerFoundOkButton= new JButton("Ok");
                 customerFoundOkButton.addActionListener(e3->{customerFoundDialog.dispose();});
                 customerFoundButtonPanel.add(customerFoundOkButton);
                 customerFoundDialog.add(customerFoundButtonPanel,BorderLayout.SOUTH);
                 customerFoundDialog.pack();
                 customerFoundDialog.setVisible(true);
             }
         });

         searchByNameDialog.pack();
         searchByNameDialog.setVisible(true);
     });
     // Search BY NUMBER -------------------
     searchByNumberButton.addActionListener(e1 -> {
         searchDialog.dispose();
         JDialog searchByNumberDialog = new JDialog(ParentFrame, "Search By Number", true);
         JPanel searchByNumberPanel = new JPanel((new GridLayout(1, 2, 10, 10)));
         searchByNumberDialog.setLayout(new BorderLayout());
         JLabel enterNumberLabel = new JLabel(("Enter  Number:"));  // writes enter phone
         JTextField enterNumberField = new JTextField(10); // reads the phone
         searchByNumberPanel.add(enterNumberLabel);
         searchByNumberPanel.add(enterNumberField);
         searchByNumberDialog.add(searchByNumberPanel, BorderLayout.CENTER);

         // Buttons -----
         JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
         JButton okButton = new JButton("Ok");
         JButton cancelButton = new JButton(("Cancel"));
         buttonPanel.add(okButton);
         buttonPanel.add(cancelButton);
         searchByNumberDialog.add(buttonPanel, BorderLayout.SOUTH);

         // Buttons actions listeners ------
         cancelButton.addActionListener(e2 -> {
             searchByNumberDialog.dispose();
         });

         okButton.addActionListener(e2 -> {
             String number = enterNumberField.getText().trim();
             if (number.isEmpty()) {
                 JOptionPane.showMessageDialog(searchByNumberDialog,
                         "Please enter a non empty number",
                         "Input Error",
                         JOptionPane.WARNING_MESSAGE);
                 return;
             }

             Customer c1;
             c1 = customerManager1.searchByNumber(number);

             if (c1 == null) {
                 JOptionPane.showMessageDialog(searchByNumberDialog, "Customer not found with given  number");
             } else {
                 // CustomerFound Form START ----------------------------
                 JDialog customerFoundDialog = new JDialog(ParentFrame, "Customer Found", true);
                 JPanel customerFoundPanel = new JPanel(new GridLayout(5, 2));

                 addRowToPanel(customerFoundPanel, "AFM:", c1.getAfm());
                 addRowToPanel(customerFoundPanel, "Name:", c1.getName());
                 addRowToPanel(customerFoundPanel, "Surname:", c1.getSurname());
                 addRowToPanel(customerFoundPanel, "Number:", c1.getNumber());
                 addRowToPanel(customerFoundPanel, "Email:", c1.getEmail());
                 customerFoundDialog.setLayout(new BorderLayout());
                 customerFoundDialog.add(customerFoundPanel,BorderLayout.CENTER);

                 // CustomerFound Buttons START -----------
                 JPanel customerFoundButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                 JButton customerFoundOkButton = new JButton("Ok");
                 customerFoundOkButton.addActionListener(e3 -> {
                     customerFoundDialog.dispose();
                 });
                 customerFoundButtonPanel.add(customerFoundOkButton);
                 customerFoundDialog.add(customerFoundButtonPanel,BorderLayout.SOUTH);
                 customerFoundDialog.pack();
                 customerFoundDialog.setVisible(true);
             }
         });

         searchByNumberDialog.pack();
         searchByNumberDialog.setVisible(true);
     });



     cancel.addActionListener(e1 -> {searchDialog.dispose();});
     searchDialog.pack();
     searchDialog.setVisible(true);
 }); // search customer done

// Στο constructor του CustomerManagerGui, μετά το searchCustomerButton:
        JButton deleteCustomerButton = new JButton("Delete Customer");
        panel.add(deleteCustomerButton);

// DELETE CUSTOMER  ----------------------------------------------------------------------------------------
        deleteCustomerButton.addActionListener(e -> {
            JDialog deleteCustomerDialog = new JDialog(ParentFrame, "Delete Customer", true);
            deleteCustomerDialog.setLayout(new BorderLayout());
            deleteCustomerDialog.setLocationRelativeTo(ParentFrame);

            JPanel deleteCustomerPanel = new JPanel(new GridLayout(1, 2, 10, 10));
            deleteCustomerDialog.add(deleteCustomerPanel, BorderLayout.CENTER);

            JLabel afmLabel = new JLabel("Enter AFM to delete:");
            JTextField afmTextField = new JTextField(10);
            deleteCustomerPanel.add(afmLabel);
            deleteCustomerPanel.add(afmTextField);

            // DELETE + CANCEL BUTTONS
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            JButton deleteButton = new JButton("Delete");
            JButton cancelButton = new JButton("Cancel");
            buttonPanel.add(deleteButton);
            buttonPanel.add(cancelButton);
            deleteCustomerDialog.add(buttonPanel, BorderLayout.SOUTH);

            deleteButton.addActionListener(e1 -> {
                String afm = afmTextField.getText().trim();
                if (afm.isEmpty()) {
                    JOptionPane.showMessageDialog(deleteCustomerDialog, "AFM cannot be empty", "Input Error",
                            JOptionPane.WARNING_MESSAGE);
                    return;}
                if (customerManager1.deleteCustomer(afm, rentalManager1)) {
                    fileManager.writeCustomers(customerManager1);
                    JOptionPane.showMessageDialog(deleteCustomerDialog,
                            "Customer deleted ");
                    deleteCustomerDialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(deleteCustomerDialog,
                            "Failed to delete customer. Either not found or has active rentals");}
            });
            cancelButton.addActionListener(e1 -> {deleteCustomerDialog.dispose();});
            deleteCustomerDialog.pack();
            deleteCustomerDialog.setVisible(true);
        });

        ParentFrame.setVisible(true); // στο τελος του constructor panta to setVisisble
}
    private void addRowToPanel(JPanel panel, String labelText, String valueText) {  // all methods , outside of constructor
        panel.add(new JLabel(labelText));
        panel.add(new JLabel(valueText));}
}
