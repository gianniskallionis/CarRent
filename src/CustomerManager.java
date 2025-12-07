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

    /**
     *
     * @param customer1
     * @return
     */
    public boolean addCustomer(Customer customer1)
    {   if(customer1 == null || customer1.getAfm()==null ||searchByAfm(customer1.getAfm()) != null ) return false ;
        customersList.add(customer1);
        return true;
    }

    /**
     *
     * @param afm
     * @param newName
     * @param newSurname
     * @param newEmail
     * @param newNumber
     */
    public boolean editCustomer(String afm, String newName, String newSurname, String newEmail, String newNumber)
    {  if (this.searchByAfm(afm)==null) return false;
        if (newName!=null )this.searchByAfm(afm).setName(newName.trim());
        if (newSurname!=null ) this.searchByAfm(afm).setSurname(newSurname.trim());
        if (newEmail!=null )  this.searchByAfm(afm).setEmail(newEmail.trim());
        if (newNumber!=null )  this.searchByAfm(afm).setNumber(newNumber.trim());
        return true;
    }

    /**
     *
     * @param afm
     * @return
     */
    public Customer searchByAfm(String afm){
        for (Customer x:customersList)
        {if(x.getAfm().equals(afm))
                return x;}
        return null;}

    /**
     *
     * @param name
     * @param surname
     * @return
     */
    public  Customer searchByName (String name, String surname)
    {
        for (Customer x:customersList)
        {
            if(   (x.getName().trim()).equals(name.trim()) && (x.getSurname().trim()).equals(surname.trim())    )
        return x;}
        return null;}

    /**
     *
     * @param number
     * @return
     */
 public Customer searchByNumber(String number){
     for (Customer x:customersList)
     {if(x.getNumber().equals(number))
         return x;}
     return null;}







}
