package gui;
import api.CustomerManager;
import api.Customer;
import com.sun.source.tree.ParenthesizedTree;

import javax.swing.*;
import java.awt.*;
public class CustomerManagerGui {

    public CustomerManagerGui(CustomerManager customerManager1) {
        JFrame ParentFrame = new JFrame("Welcome to Customer Manager ");
        ParentFrame.setSize(800,400);
        ParentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ParentFrame.setLayout(new FlowLayout());
        JPanel panel= new JPanel(new GridLayout(2,2));// se auto to panel tha valoume ola ta buttons k to panel sto frame .
        ParentFrame.add(panel);

        JButton addCustomerButton=new JButton("Add Customer");
        panel.add(addCustomerButton); // valame to addCustomer koumpi sthn arxiki othoni

        // ADD CUSTOMER  GUI START ---------------------------------------------------------------------------------
       // ----------------------------------------------------------------------------------------------------------
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

     if (customerManager1.addCustomer(c1)){addCustomerDialog.dispose();}
     else{JOptionPane.showMessageDialog(addCustomerDialog,"error Customer hasnt been added");}
});
cancelButton.addActionListener(e2->{  addCustomerDialog.dispose();  }); // closes the window
 addCustomerDialog.setVisible(true);
        });// end of addCustomerButton
//EDIT CUSTOMER GUI START--------------------------------------------------------------------------------------------------------------------
JButton editCustomerButton=new JButton("Edit Customer");
panel.add(editCustomerButton);

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
                ){editCustomerDialog.dispose();}
                else{JOptionPane.showMessageDialog(editCustomerDialog,"error Customer hasn't been edited");}
            });
            cancelButton.addActionListener(e2->{  editCustomerDialog.dispose();  }); // closes the window
    editCustomerDialog.pack();
    editCustomerDialog.setVisible(true);
    });

JButton searchCustomerButton=new JButton("Search by AFM");
panel.add(searchCustomerButton);
// SEARCH CUSTOMER -----------------------------------------------------------------------------------------------------
 searchCustomerButton.addActionListener(e->{
     JDialog searchDialog= new JDialog(ParentFrame,"choose search type",true);
     searchDialog.setLayout(new BorderLayout());
     searchDialog.setLocationRelativeTo(ParentFrame);
  JButton searchByAfmButton= new JButton("Search By AFM");
     JButton searchByNameButton= new JButton("Search By Name");
     JButton searchByNumberButton= new JButton("Search By Number");
     JButton cancel= new JButton("Cancel");
     searchDialog.add(searchByAfmButton);
     searchDialog.add(searchByNameButton);
     searchDialog.add(searchByNumberButton);
     searchDialog.add(cancel);

     searchByAfmButton.addActionListener(e->{
         JDialog searchByAfmDialog= new JDialog(searchDialog,"Search By Afm",true);
         searchByAfmDialog.setLayout(new BorderLayout());








     });









































 });















        ParentFrame.setVisible(true); // στο τελος του constructor panta to setVisisble
}}
