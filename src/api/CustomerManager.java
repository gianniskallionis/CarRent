package api;

import java.util.ArrayList;

/**
 * Api.CustomerManager
 * <p>
 * Σύντομη περιγραφή της κλάσης Api.CustomerManager. Customer Manager implements all the methods that a customer must have
 * it  creates an ArrayList where it saves all the instances of customers, it also has a constructor creating the empty List
 * it has  both add and edit functions adding and changing the fields of the customers. it also has search capabilities by afm,name,number
 * where each searches in the ArrayList  to find the instance
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
     * creates the empty List
     */
    public CustomerManager() {
        customersList = new ArrayList<>();   // initializing the ArrayList
    }

    /**
     * adds a customer to the arrayList after confirming the given parameter isn't null ;
     * @param customer1 the parameter given to add to the list
     * @return true if the addition was successfull, otherwise it returns false;
     */
    public boolean addCustomer(Customer customer1)
    {   if(customer1 == null || customer1.getAfm()==null ||searchByAfm(customer1.getAfm()) != null ) return false ;
        customersList.add(customer1);
        return true;
    }

    /** receives all the fields of the customer as arguments and  changes any of them except the afm which is immutable
     * if the user wishes to leave a field unchanged, he can leave the field as null
     * @param afm the afm of the customer
     * @param newName the NewName of the customer
     * @param newSurname the NewSurname of the Customer
     * @param newEmail the new Email of the customer
     * @param newNumber the new Number of the customer
     * @return true if it can edit the customer, false otherwise
     */
    public boolean editCustomer(String afm, String newName, String newSurname, String newNumber,String newEmail )
    {  if (this.searchByAfm(afm)==null) return false;
        if (newName!=null )this.searchByAfm(afm).setName(newName.trim());
        if (newSurname!=null ) this.searchByAfm(afm).setSurname(newSurname.trim());
        if (newNumber!=null )  this.searchByAfm(afm).setNumber(newNumber.trim());
        if (newEmail!=null )  this.searchByAfm(afm).setEmail(newEmail.trim());
        return true;
    }

    /**
     * searches in the arraylist for the customer that has matching afm if the given afm isn't null ;
     * @param afm a string that cross-references with all the afms of the arraylist to find a match and return said match
     * @return The Customer, is the one with the matching Afm from the argument
     */
    public Customer searchByAfm(String afm){
        if(afm==null ) return null;

        for (Customer x:customersList)
        {if(x.getAfm().trim()                   .equals(afm.trim()))
                return x;}
        return null;}

    /**
     *searches in the arraylist for the customer that has matching name and surname  if the given name,surname aren't null ;
     * @param name string that is given as argument
     * @param surname string that is given as argument
     * @return the matching customer if said customer is found, if he isn't found , it returns null . or if arguments are null;
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
     *searches the arraylist for the customer that has matching number if the given number isn't null
     * @param number the string given as argument
     * @return instance of customer if a customer with the number exists , else it returns false;
     */
 public Customer searchByNumber(String number){
     if (number==null) return null;
     for (Customer x:customersList)
     {if(x.getNumber().trim()     .equals(number.trim()))
         return x;}
     return null;}


    /**deletes the instance of the customer from the arrayList;
     * @param afm the afm of the customer  we want to delete
     * @param rentalManager the instance of rentalManager to check if this customer has or not an active rental
     *         if the customer has active rentals or is null, deletion cannot occur , otherwise we delete the customer
     *                      from the list
     * @return true if it can delete the customer, false if it failed to do so
     *
     *
     */
    public boolean deleteCustomer(String afm, RentalManager rentalManager) {
        Customer customer1 = searchByAfm(afm);
        if (customer1 == null) {
            return false;}
        if (rentalManager != null && rentalManager.hasActiveRentalsForCustomer(customer1)) {
            return false; }
        customersList.remove(customer1);
        return true;}



    /**
     * Returns a list of all customers.
     *
     * @return a copy of the customer list
     */
    public ArrayList<Customer> getAllCustomers() {
        return new ArrayList<>(customersList);
    }





}
