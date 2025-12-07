import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * CustomerManager
 * <p>
 * Σύντομη περιγραφή της κλάσης CustomerManager.
 *
 * @author giannis
 * @version 07-Dec-25
 * @since 2025
 */
public class CustomerManager {

    /**
     * arraylist that has all the customers
     */
    private ArrayList<Customer> customersList;

    /**
     * Δημιουργεί ένα νέο αντικείμενο CustomerManager.
     */
    public CustomerManager() {
        customersList = new ArrayList<>();   // initializing the ArrayList
    }


    public boolean addCustomer(Customer customer1)
    {   if(customer1 == null || customer1.getAfm()==null ||searchByAfm(customer1.getAfm()) != null ) return false ;
        customersList.add(customer1);
        return true;
    }
    public Customer searchByAfm(String afm){
        for (Customer x:customersList)
        {if(x.getAfm().equals(afm))
                return x;}
        return null;}

    public  Customer searchByName (String name, String surname)
    {
        for (Customer x:customersList)
        {
            if(   (x.getName().trim()).equals(name.trim()) && (x.getSurname().trim()).equals(surname.trim())    )
        return x;}
        return null;}

 public Customer searchByNumber(String number){
     for (Customer x:customersList)
     {if(x.getNumber().equals(number))
         return x;}
     return null;}







}
