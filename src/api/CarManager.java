package api;

import api.Car;

import java.util.ArrayList;

/**
 *  creates an arrayList to store cars in  has multiple methods of search and methods to add  , update and get all cars
 */
public class CarManager {

    private ArrayList<Car> carsList;

    /**
     * creates a new arraylist of type car
     */
    public CarManager() {
        carsList=new ArrayList<>();
    }

    /**
     * searches the arraymap trying to find a match using the argument
     * @param plate string
     * @return car if found, null if not found
     */
    public Car searchByPlate(String plate) {

        if (plate==null) {
            return null;
        }

        for (Car c:carsList) {
            if (c.getPlate().trim().equals(plate.trim())) {
                return c;
            }
        }

        return null;
    }

    /**
     * searches the arraymap trying to find a match using the argument
     * @param brand string
     * @return car if found, null if not .
     */
    public Car searchByBrand(String brand) {

        if (brand==null) {
            return null;
        }

        for (Car c:carsList) {
            if (c.getBrand().trim().equals(brand.trim())) {
                return c;
            }
        }

        return null;
    }

    /**
     * searches the arraymap trying to find a match using the argument
     * @param model string
     * @return car if found null ,if not.
     */
    public Car searchByModel(String model) {

        if (model==null) {
            return null;
        }

        for (Car c:carsList) {
            if (c.getModel().trim().equals(model.trim())) {
                return c;
            }
        }

        return null;
    }

    /**
     * searches the arraymap trying to find a match using the argument
     * @param color string
     * @return car if found, null if not
     */
    public Car searchByColor(String color) {

        if (color==null) {
            return null;
        }

        for (Car c:carsList) {
            if (c.getColor().trim().equals(color.trim())) {
                return c;
            }
        }

        return null;
    }

    /**
     * searches the arraymap trying to find a match using the argument
     * @param status string
     * @return car if found, null if not
     */
    public Car searchByStatus(String status) {

        if (status==null) {
            return null;
        }

        for (Car c:carsList) {
            if (c.getStatus().trim().equals(status.trim())) {
                return c;
            }
        }

        return null;
    }

    /**
     * adds a car in the list
     * @param car1 the given car
     * @return true if success, false if failed.
     */
    public boolean addCar(Car car1) {

        if (car1==null || car1.getPlate()==null || searchByPlate(car1.getPlate())!=null ) {
            return false;
        }
        carsList.add(car1);
        return true;
    }

    /**
     * a search method using ALL the fields , ( if any is not to be used it is left null)
     * @param plate string
     * @param brand string
     * @param model string
     * @param color string
     * @param status string
     * @return a  ArrayList<car>  if search successful, null if not
     */
    public ArrayList<Car> searchCombined(String plate, String brand, String model, String color, String status) {
    ArrayList<Car> results = new ArrayList<>();

    for (Car car : carsList) {
        boolean matches = true;

        if (plate != null && !car.getPlate().toLowerCase().contains(plate.toLowerCase())) {
            matches = false;
        }
        if (brand != null && !car.getBrand().toLowerCase().contains(brand.toLowerCase())) {
            matches = false;
        }
        if (model != null && !car.getModel().toLowerCase().contains(model.toLowerCase())) {
            matches = false;
        }
        if (color != null && !car.getColor().toLowerCase().contains(color.toLowerCase())) {
            matches = false;
        }
        if (status != null && !car.getStatus().toLowerCase().contains(status.toLowerCase())) {
            matches = false;
        }

        if (matches) {
            results.add(car);}}
    return results;}

    /**
     * creates a copy of the arraylist and  it returns in
     * @return a copy of the arraylist<car>
     */
    public ArrayList<Car> getAllCars() {
        return new ArrayList<>(carsList);
    }

    /**
     * removes the car, since if isnt  required in the pdf, i didn't use it in the gui
     * @param plate the argument to search for the car
     * @return true if the car is removed, false if the process failed
     */
    public boolean removeCar(String plate) {
        if (plate == null) return false;
        for (int i = 0; i < carsList.size(); i++) {
            if (carsList.get(i).getPlate().trim().equalsIgnoreCase(plate.trim())) {
                carsList.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * gives the old plate  of the car and a new instance of car , and it changes it fields
     * @param oldPlate string
     * @param updatedCar instance of car
     * @return true if success, false if failed.
     */
    public boolean updateCar(String oldPlate, Car updatedCar) {
        if (oldPlate == null || updatedCar == null) return false;

        if (!oldPlate.trim().equalsIgnoreCase(updatedCar.getPlate().trim())) {
            if (searchByPlate(updatedCar.getPlate()) != null) {
                return false;
            }
        }

        if (!removeCar(oldPlate)) {
            return false;
        }
        return addCar(updatedCar);
    }

}
