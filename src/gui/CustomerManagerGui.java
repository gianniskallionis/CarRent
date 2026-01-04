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
        JPanel panel= new JPanel(new GridLayout(3,2));// se auto to panel tha valoume ola ta buttons k to panel sto frame .
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
// -------------------------------------------------------------------------------------------
        });// end of addCustomerButton











        ParentFrame.setVisible(true); // στο τελος του constructor panta to setVisisble
    }
}
