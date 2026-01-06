package api;

import java.util.ArrayList;

/**
 * it implements the methods required concerning the Rentals it has methods to add a rental , delete one and check to see if
 * a customer has an active rental . it stores the rentals in an arrayList of type <Rental>  so it can store all its fields as well.
 */
public class RentalManager {

    private ArrayList<Rental> rentalList;

    /**
     * creates new arraylist  of type rental
     */
    public RentalManager() {
        rentalList = new ArrayList<>();
    }

    /**
     * attempts to make a rental
     * @param r1 the rental
     * @return true if success , false if failed
     */
    public boolean rentCar(Rental r1) {

        if (r1 == null || r1.getCar() == null || r1.getCustomer() == null) {
            return false;
        }

        if (!r1.getCar().getStatus().equals("Available")) {
            return false;
        }

        r1.getCar().setStatus("Rented");
        rentalList.add(r1);
        return true;

    }

    /**
     * attempts to return a car thus ending a rental
     * @param r2 the rental it attempts to end
     * @return true if success, false if failed.
     */
    public boolean returnCar(Rental r2) {

        if (r2 == null) {
            return false;
        }

        if (!r2.getCar().getStatus().equals("Rented")) {
            return false;
        }

        r2.getCar().setStatus("Available");

        return true;

    }

    /**
     *  takes as argument a customer and returns all his active rentals
     * @param c1 the customer
     * @return a arraylist with his active rentals, null if it couldn't do it
     */
    public ArrayList<Rental> CustomerRentings(Customer c1) {

        ArrayList<Rental> customerRentingsList = new ArrayList<>();

        if (c1 == null) {
            return customerRentingsList;
        }

        for (Rental r : rentalList) {
            if (r.getCustomer().equals(c1)) {
                customerRentingsList.add(r);
            }
        }

        return customerRentingsList;

    }

    /**
     * takes an instance of a car and returns the history of its rentals
     * @param car1 instance of c ar
     * @return history of its rentals
     */
    public ArrayList<Rental> CarRentings(Car car1) {

        ArrayList<Rental> carRentingsList = new ArrayList<>();

        if (car1 == null) {
            return carRentingsList;
        }

        for (Rental r : rentalList) {
            if (r.getCar().equals(car1)) {
                carRentingsList.add(r);
            }
        }

        return carRentingsList;

    }

    /**
     * checks whether or not a customer has an active rental .
     * @param customer instance of customer
     * @return true if it was succesfull. false if it failed.
     */
    public boolean hasActiveRentalsForCustomer(Customer customer) {
        if (customer == null) return false;
        for (Rental rental : rentalList) {
            if (rental.getCustomer().equals(customer) &&
                    rental.getCar().getStatus().equals("Rented")) {
                return true;
            }
        }
        return false;
    }

    /**
     * adds a rental to the list
     * @param rental1 the list to add
     * @return true if success, false if failed.
     */
    public boolean addRenting(Rental rental1) {
        if (rental1 == null) {
            return false;
        }
        rentalList.add(rental1);
        return true;
    }

    /**
     * returns a copy of the list of all the rentals
     * @return the list which is a copy of the original
     */
    public ArrayList<Rental> getAllRentings() {
        return new ArrayList<>(rentalList);
    }


}


