/**
 *
 */
public class Customer extends Person {


    private String afm;
    private String number;

    /**
     * returns the Afm of the Customer
     * @return the Afm
     */
    public String getAfm() {
        return afm;
    }

    /**
     * sets the afm of the customer
     * @param afm the new afm
     */
    public void setAfm(String afm) {
        this.afm = afm;
    }

    /** gets the number
     *
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * sets the  phone number of the customer
     * @param number the new number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * creates a new object of type : customer and throws an error if any data entry is wrong ,it also trims any spaces that may occur in the start
     * @param afm the afm of the customer
     * @param name the full name of the customer
     * @param number   the number of the customer
     * @param email     the email of the customer
     * @param surname the surname of the customer
     * @throws IllegalArgumentException if any argument is invalid
     */

    @SuppressWarnings({"AssignmentToMethodParameter", "ReassignedVariable"})
    public Customer(String afm, String name, String surname , String number,String email){
    super(name, surname, email);
 if (surname!=null) surname=surname.trim();
 if (afm != null) afm = afm.trim();

    if ( afm==null || !(afm.matches("\\d{9}"))) throw new IllegalArgumentException(" invalid afm, it  has to be 9 digits");
    if (number==null || number.isEmpty()) throw new IllegalArgumentException("invalid phone number");
    this.afm=afm;
    this.number=number;

}











}