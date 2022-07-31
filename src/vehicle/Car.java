package vehicle;

import datetime.DateTime;
import java.awt.Color;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Nimesh Kasun
 */
public class Car extends Vehicle {

    private int doors;
    private Color color;

    public Car(String plateID) {
        // Call superclass constructor along with plateID
        super(plateID);
        // Set vehicle type to car
        this.vehicleType = vehicleType.Car;
        // Initialize slots needed
        this.slotsNeeded = 1.0;
    }

    // Return string version of the Car class along with its attributes
    @Override
    public String toString() {
        return "Car with plate id- " + this.plateId + ", entered at: " + this.entryTime.getDateTime();
    }

    public Car(String idPlate, String brand, String model, DateTime entryTime, int doors, Color color) {
        super(idPlate, brand, model, entryTime);
        this.doors = doors;
        this.color = color;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + doors;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Car other = (Car) obj;
        if (color == null) {
            if (other.color != null) {
                return false;
            }
        } else if (!color.equals(other.color)) {
            return false;
        }
        if (doors != other.doors) {
            return false;
        }
        return true;
    }
}
