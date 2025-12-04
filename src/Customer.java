/**
 *
 */
public class Customer {


    private String afm;
    private String fullname;
    private String number;
    private String email;

    /**
     * returns the Afm of the Customer
     * @return the Afm
     */
    public String getAfm() {
        return afm;
    }

    /** returns the full name of the customer
     *
     * @return the full name
     */

    public String getFullname() {
        return fullname;
    }

    /**
     * returns the phone number of the customer
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     *  returns the email of the customer
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * sets the afm of the customer
     * @param afm the new afm
     */
    public void setAfm(String afm) {
        this.afm = afm;
    }

    /**
     * sets the full name of the customer
     * @param fullname the new full name
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * sets the  phone number of the customer
     * @param number the new number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * sets the email of the customer
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * creates a new object of type : customer and throws an error if any data entry is wrong ,it also trims any spaces that may occur in the start
     * @param afm the afm of the customer
     * @param fullname the full name of the customer
     * @param number   the number of the customer
     * @param email     the email of the customer
     * @throws IllegalArgumentException if any argument is invalid
     */

    @SuppressWarnings({"AssignmentToMethodParameter", "ReassignedVariable"})
    public Customer(String afm, String fullname, String number,String email)
{
    if (afm != null) afm = afm.trim();
    if (fullname != null) fullname = fullname.trim();
    if (number != null) number = number.trim();
    if (email != null) email = email.trim();

    if (fullname==null || fullname.isEmpty()) throw new IllegalArgumentException("invalid full name ");
    if( email==null || !(email.contains("@"))) throw new IllegalArgumentException("invalid email");
    if ( afm==null || !(afm.matches("\\d{9}"))) throw new IllegalArgumentException(" invalid afm, it  has to be 9 digits");
    if (number==null || number.isEmpty()) throw new IllegalArgumentException("invalid phone number");
    this.afm=afm;
    this.fullname=fullname;
    this.number=number;
    this.email=email;
}











}