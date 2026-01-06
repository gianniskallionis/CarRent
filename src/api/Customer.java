package api;

import java.util.Objects;

/** a class that inherits from Person and adds 2 strings as fields. afm and number . it has getters and setters
 * for each and a constructor giving each String a value from the given parameter.
 *
 */
public class Customer extends Person {


    private String afm;
    private String number;

    /**
     * returns the Afm of the Api.Customer
     *
     * @return the Afm
     */
    public String getAfm() {
        return afm;
    }

    /**
     * sets the afm of the customer
     *
     * @param afm the new afm
     */
    public void setAfm(String afm) {
        if (afm == null) throw new IllegalArgumentException(("afm is null, it does not exist "));
        if (!afm.trim().matches("\\d{9}"))
            throw new IllegalArgumentException(("Afm is not 9 digits ")); // if not 9 digits trimmed, throw exception.
        this.afm = afm.trim();
    }

    /**
     * gets the number
     *
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * sets the  phone number of the customer after checking whether the parameter is null or an empty string
     *
     * @param number the new number
     */
    public void setNumber(String number) {
        if (number == null) throw new IllegalArgumentException(" phone number is null,it  does not exist ");
        if (!number.trim().matches("\\d{5,}"))
            throw new IllegalArgumentException("object number must be over 5 digits");
        this.number = number.trim();
    }


    /**
     * creates a new object of type : customer and throws an error if any data entry is wrong ,it also trims any spaces that may occur in the start
     * through the setters
     *
     * @param afm     the afm of the customer
     * @param name    the full name of the customer
     * @param number  the number of the customer
     * @param email   the email of the customer
     * @param surname the surname of the customer
     * @throws IllegalArgumentException if any argument is invalid
     */

    @SuppressWarnings({"AssignmentToMethodParameter"})
    public Customer(String afm, String name, String surname, String number, String email) {
        super(name, surname, email);
        setAfm(afm);
        setNumber(number);
    }

    /**
     * overrides of the equals method so i can compare 2 objects
     *
     * @param obj the reference object with which to compare.
     * @return true if the 2 objects being compared are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;     // if compared to oneself

        if (!(obj instanceof Customer)) return false; // if it is not a customer object it cant be equal

        Customer customerTemp = (Customer) obj;
        return (Objects.equals(this.afm, customerTemp.afm));
    }

    /**
     * Returns a hash code value for this employee.
     * The hash code is based on the username
     *
     * @return the hash code value
     */

    @Override
    public int hashCode() {
        return Objects.hash(afm);
    }


    /**Returns a string representation of this Customer.
     * Format: "Api.Employee [name=..., surname=...,email=...,Afm=...,number=...]"
     * @return string representation of the Customer
     */
    public String toString() {
        return String.format("Api.Customer [name= %s, Surname= %s, email= %s, Afm= %s, number=%s ]",
                getName(), getSurname(), getEmail(), getAfm(), getNumber());
    }


}












