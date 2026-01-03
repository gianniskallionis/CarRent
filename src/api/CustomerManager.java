package api;

import java.util.ArrayList;

/**
 * Api.CustomerManager
 * <p>
 * Σύντομη περιγραφή της κλάσης Api.CustomerManager.
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
     * Δημιουργεί ένα νέο αντικείμενο Api.CustomerManager.
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
        if(afm==null ) return null;

        for (Customer x:customersList)
        {if(x.getAfm().trim()                   .equals(afm.trim()))
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
        if(name==null || surname==null) return null;

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
     if (number==null) return null;
     for (Customer x:customersList)
     {if(x.getNumber().trim()     .equals(number.trim()))
         return x;}
     return null;}


    /**
     *
     * @param afm
     * @return
     */
    public boolean deleteCustomer(String afm) {
        Customer customer1 = searchByAfm(afm);             // SOS PREPEI NA RWTAEI TON LEASING MANAGER NA DEN AN YPARXOUN ENIKIASEIS PRIN DELETE
        if (customer1 != null) {
            customersList.remove(customer1);
            return true;
        } return false;}




    /**
     * Returns a list of all customers.
     *
     * @return a copy of the customer list
     */
    public ArrayList<Customer> getAllCustomers() {
        return new ArrayList<>(customersList);
    }





}
