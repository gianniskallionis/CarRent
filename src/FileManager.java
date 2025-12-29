import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {


    List<Customer>  readCustomer(){
        List<Customer> Customers = new ArrayList<Customer>();

        try(BufferedReader reader = new BufferedReader(new FileReader ("Customers.txt")  )  )
        {
reader.readLine();// ignores the 1st line as they are the formation: Afm,name,surname,number,
            String line;
            while(  (line= reader.readLine())  !=null){
            String[]parts= line.split(",",5);
            if(parts.length==5)
            {Customer newCustomer= new Customer(parts[0].trim(),parts[1].trim(),parts[2].trim(),parts[3].trim(),parts[4].trim());
Customers.add(newCustomer);}
            }
        }
 catch (IOException e){System.out.println("Error in Customers.txt");}
        return Customers;
    }


















}



