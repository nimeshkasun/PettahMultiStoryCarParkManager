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
public class Motorbike extends Vehicle {

    private String engineSize;

    public Motorbike(String plateID) {
        // Call superclass constructor along with plateID
        super(plateID);
        // Set vehicle type to motorbike
        this.vehicleType = vehicleType.Motorbike;
        // Initialize slots needed
        this.slotsNeeded = (1.0 / 3.0);
    }

    // Return string version of the Motorbike class along with its attributes
    @Override
    public String toString() {
        return "Motorbike with plate id- " + this.plateId + ", entered at: " + this.entryTime.getDateTime();
    }

    public Motorbike(String idPlate, String brand, String model, DateTime entryTime, String engineSize) {
        super(idPlate, brand, model, entryTime);
        this.engineSize = engineSize;
    }

    public String getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(String engineSize) {
        this.engineSize = engineSize;
    }
}
