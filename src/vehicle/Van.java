package vehicle;

import datetime.DateTime;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Nimesh Kasun
 */
public class Van extends Vehicle {

    private double cargoVolume;

    public Van(String plateID) {
        // Call superclass constructor along with plateID
        super(plateID);
        // Set vehicle type to van
        this.vehicleType = vehicleType.Van;
        // Initialize slots needed
        this.slotsNeeded = 2.0;
    }

    // Return string version of the Van class along with its attributes
    @Override
    public String toString() {
        return "Van with plate id- " + this.plateId + ", entered at: " + this.entryTime.getDateTime();
    }

    public Van(String idPlate, String brand, String model, DateTime entryTime, double cargoVolume) {
        super(idPlate, brand, model, entryTime);
        this.cargoVolume = cargoVolume;
    }

    public double getCargoVolume() {
        return cargoVolume;
    }

    public void setCargoVolume(double cargoVolume) {
        this.cargoVolume = cargoVolume;
    }
}
