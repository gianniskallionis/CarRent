package api;

import java.util.ArrayList;

public class RentalManager {

    private ArrayList<Rental> rentalList;

    public RentalManager() {
        rentalList = new ArrayList<>();
    }

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
     *
     * @param customer
     * @return
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

    public boolean addRenting(Rental rental1) {
        if (rental1 == null) {
            return false;
        }
        rentalList.add(rental1);
        return true;
    }

    public ArrayList<Rental> getAllRentings() {
        return new ArrayList<>(rentalList);
    }


}


