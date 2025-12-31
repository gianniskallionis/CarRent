import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {


    CustomerManager  readCustomers(){
        CustomerManager Customers = new CustomerManager(); // list of which i will read from
        try(BufferedReader reader = new BufferedReader(new FileReader ("Customers.csv")  )  ) // opens file
        {
reader.readLine();// ignores the 1st line as they are the formation: Afm,name,surname,number,email.
            String line;

            while(  (line= reader.readLine())  !=null){ // oso yparxoun grammes
            String[]parts= line.split(",",5);  // xwrise thn kathe grammh se 5 strings (afm,name,surname,number,email
            if(parts.length==5)      // an diavase swsta ta 5 strings
            {
            if( Customers.searchByAfm(parts[0].trim())!=null) continue ; // elegxw an yparxei hdh sthn lista customer me to afm auto , an yparxei skiparw thn grammh
                Customer newCustomer= new Customer(parts[0].trim(),parts[1].trim(),parts[2].trim(),parts[3].trim(),parts[4].trim());
                Customers.addCustomer(newCustomer);}
            }
        }
 catch (IOException e){System.out.println("Error  Reading in Customers.csv");}
        return Customers;}

    public  void writeCustomers(CustomerManager CustomersToWrite){
        try (BufferedWriter writer = new BufferedWriter(    (new FileWriter("Customers.csv")   )    )     )// opens file to write with writer
        {
writer.write("afm,name,surname,number,email");  // writes the structure
writer.newLine();  // continues to the next line  , same function as \n
 for(Customer c: CustomersToWrite.getAllCustomers()){ // for all the Customers in the list
writer.write(c.getAfm()+","+  c.getName()+","+c.getSurname() +","+ c.getNumber()+","+ c.getEmail() ); // writes the data with "," to seperate .
writer.newLine();//  goes to the next line for the next batch of writing
 }
}
catch(IOException e ){System.out.println("Error  Writing in Customers.csv");}
}

  EmployeeManager readUsers() {
      EmployeeManager users = new EmployeeManager(); // hashmap of which i will read from
      try (BufferedReader reader = new BufferedReader((new FileReader("Users.csv")))) {
          reader.readLine(); // ignores the 1st line cuz its  the structure
          String line;
          while ((line = reader.readLine()) != null) //  while there are lines to be read
          {
              String[] parts = line.split(",", 5);  // xwrise thn kathe grammh se 5 strings (name,surname,username,email,password)
              if (parts.length == 5)      // an diavase swsta ta 5 strings
              {
                  if (users.searchByEmail(parts[3].trim()) != null || users.searchByUsername(parts[2].trim()) != null) continue; // an yparxei  sthn lista user me to username,email auto , skiparw thn grammh
                  Employee newEmployee = new Employee(parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim(), parts[4].trim());
                  users.addUser(newEmployee);
              }
          }

      } catch (IOException e) {System.out.println("Error  Reading in Users.csv");}
      return users;
  }

  public void writeUsers(EmployeeManager UsersToWrite){
      try (BufferedWriter writer = new BufferedWriter(    (new FileWriter("Users.csv")   )    )     )// opens file to write with writer
      {
          writer.write("name,surname,username,email,password");  // writes the structure
          writer.newLine();  // continues to the next line  , same function as \n
          for(Employee c: UsersToWrite.getAllEmployees()){ // for all the employees in the list
              writer.write(c.getName()+","+  c.getSurname()+","+c.getUsername() +","+ c.getEmail()+","+ c.getPassword() ); // writes the data with "," to seperate .
              writer.newLine();//  goes to the next line for the next batch of writing
          }
      }
      catch(IOException e ){System.out.println("Error  Writing in Users.csv");}
  }




  }

















  }




















































