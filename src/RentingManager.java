import java.util.ArrayList;

public class RentingManager {

    private ArrayList<Renting> rentingList;

    public RentingManager() {
        rentingList = new ArrayList<>();
    }

    public boolean rentCar(Renting r1) {

        if (r1==null || r1.getCar()==null || r1.getCustomer()==null) {
            return false;
        }

        if (!r1.getCar().getStatus().equals("Available")) {
            return false;
        }

        r1.getCar().setStatus("Rented");
        rentingList.add(r1);

        return true;

    }

    public boolean returnCar(Renting r2) {

        if (r2==null) {
            return false;
        }

        if (!r2.getCar().getStatus().equals("Rented")) {
            return false;
        }

        r2.getCar().setStatus("Available");

        return true;

    }

    public ArrayList<Renting> CustomerRentings(Customer c1) {

        ArrayList<Renting> CustomerRentingsList=new ArrayList<>();

        if (c1==null) {
            return CustomerRentingsList;
        }

        for (Renting r : rentingList) {
            if (r.getCustomer().equals(c1)) {
                CustomerRentingsList.add(r);
            }
        }

        return CustomerRentingsList;

    }

    public ArrayList<Renting> CarRentings(Car car1) {

        ArrayList<Renting> CarRentingsList =new ArrayList<>();

        if (car1==null) {
            return CarRentingsList;
        }

        for (Renting r : rentingList) {
            if (r.getCar().equals(car1)) {
                CarRentingsList.add(r);
            }
        }

        return CarRentingsList;
        
    }

    public boolean addRenting(Renting renting1) {
        if (renting1==null) {
            return false;
        }
        rentingList.add(renting1);
        return true;
    }

    public ArrayList<Renting> getAllRentings() {
        return new ArrayList<>(rentingList);
    }

}


