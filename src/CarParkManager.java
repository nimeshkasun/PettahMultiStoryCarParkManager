
import datetime.DateTime;
import vehicle.Vehicle;
import java.math.BigDecimal;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
/**
 *
 * @author Nimesh Kasun
 */
public interface CarParkManager {

    public static final int MAX = 60; //Number of slots available in the Car Park or 9x60=540?

    public void addVehicle(Vehicle obj);

    public void deleteVehicle(String plateId);

    public void printVehiclesParked();

    public void printVehiclesPercentages();

    public void printLongestPark();

    public void printLatestPark();

    public void printVehicleByDay(String day, String month, String year);

    void displayParkingCharges();

    void printReceipt(String plateID);

}
