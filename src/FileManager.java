import java.io.*;

public class FileManager {


    CustomerManager  readCustomers(){
        CustomerManager Customers = new CustomerManager(); // list of which i will read from
        try(BufferedReader reader = new BufferedReader(new FileReader ("customers.csv")  )  ) // opens file
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
 catch (IOException e){System.out.println("Error  Reading in customers.csv");}
        return Customers;}

    public  void writeCustomers(CustomerManager CustomersToWrite){
        try (BufferedWriter writer = new BufferedWriter(    (new FileWriter("customers.csv")   )    )     )// opens file to write with writer
        {
writer.write("afm,name,surname,number,email");  // writes the structure
writer.newLine();  // continues to the next line  , same function as \n
 for(Customer c: CustomersToWrite.getAllCustomers()){ // for all the Customers in the list
writer.write(c.getAfm()+","+  c.getName()+","+c.getSurname() +","+ c.getNumber()+","+ c.getEmail() ); // writes the data with "," to seperate .
writer.newLine();//  goes to the next line for the next batch of writing
 }
}
catch(IOException e ){System.out.println("Error  Writing in customers.csv");}
}

  EmployeeManager readEmployees() {
      EmployeeManager users = new EmployeeManager(); // hashmap of which i will read from
      try (BufferedReader reader = new BufferedReader((new FileReader("employees.csv")))) {
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

      } catch (IOException e) {System.out.println("Error  Reading in employees.csv");}
      return users;
  }

  public void writeEmployees(EmployeeManager UsersToWrite){
      try (BufferedWriter writer = new BufferedWriter(    (new FileWriter("employees.csv")   )    )     )// opens file to write with writer
      {
          writer.write("name,surname,username,email,password");  // writes the structure
          writer.newLine();  // continues to the next line  , same function as \n
          for(Employee c: UsersToWrite.getAllEmployees()){ // for all the employees in the list
              writer.write(c.getName()+","+  c.getSurname()+","+c.getUsername() +","+ c.getEmail()+","+ c.getPassword() ); // writes the data with "," to seperate .
              writer.newLine();//  goes to the next line for the next batch of writing
          }
      }
      catch(IOException e ){System.out.println("Error  Writing in employees.csv");}
  }

    /**
     * the method checks whether  the file has already been created, if it has NOT, it creates it , and adds 2 customers
     * in it using the Customer constructor, the addCustomer method that adds the customer to the list, and the cm1 customer Manager list
     * which then is written in the customers.csv file via the writeCustomers method.
     * @return  true if the file initializes in the function it returns . if the file already exists , it returns false.
     */
  public boolean initializeCustomers() {
    File file = new File("customers.csv");

      try {
          if ((file.exists()  && file.length()>0 )            ) {
              System.out.println("File already exists.");
              return false;
          } else {
              System.out.println("customers.csv initiated now ");
              CustomerManager cm1=new CustomerManager();
              cm1.addCustomer(new Customer("123456789","giannis","antetokounmpo",
                      "6912345678","giannisAntetokounmpo@gmail.com")    );
             cm1.addCustomer(new Customer("113456789","kostas","antetokounmpo",
                     "6911345678","kostasAntetokounmpo@gmail.com"));
             writeCustomers(cm1);
             return true;}
      } catch (Exception e) {
          System.out.println("error in customers.csv");
          return false;
      }
    }
 public boolean initializeEmployees(){
      File file=new File("employees.csv");
 try {
     if ((file.exists() && file.length() > 0)) {
         System.out.println("File already exists.");
         return false;
     }  // name, surname,username,email,password
     else {
         System.out.println("employees.csv initialized  now ");
         EmployeeManager em1 = new EmployeeManager();
         em1.addUser(new Employee("John", "Smith", "jsmith", "john.smith@test.com", "password1"));
         em1.addUser(new Employee("Mary", "Jones", "mjones", "mary.jones@test.com", "password2"));
         em1.addUser(new Employee("Tom", "Brown", "tbrown", "tom.brown@test.com", "password3"));
         em1.addUser(new Employee("Anna", "White", "awhite", "anna.white@test.com", "password4"));
         em1.addUser(new Employee("Luke", "Hall", "lhall", "luke.hall@test.com", "password5"));
         writeEmployees(em1);
         return true;
     }
 } catch(Exception e) {System.out.println("Error in employees.csv file "); return false;}
     }










 }









  }

















  }




















































