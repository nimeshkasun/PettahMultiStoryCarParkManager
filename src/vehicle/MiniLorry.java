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
public class MiniLorry extends Vehicle {

    private double cargoVolume;

    public MiniLorry(String plateID) {
        // Call superclass constructor along with plateID
        super(plateID);
        // Set vehicle type to mini lorry
        this.vehicleType = vehicleType.MiniLorry;
        // Initialize slots needed
        this.slotsNeeded = 3.0;
    }

    // Return string version of the MiniLorry class along with its attributes
    @Override
    public String toString() {
        return "Mini Lorry with plate id- " + this.plateId + ", entered at: " + this.entryTime.getDateTime();
    }

    public MiniLorry(String regNumber, String brand, String model, DateTime entryTime, double cargoVolume) {
        super(regNumber, brand, model, entryTime);
        this.cargoVolume = cargoVolume;
    }

    public double getCargoVolume() {
        return cargoVolume;
    }

    public void setCargoVolume(double cargoVolume) {
        this.cargoVolume = cargoVolume;
    }

}
