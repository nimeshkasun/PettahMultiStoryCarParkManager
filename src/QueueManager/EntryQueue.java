/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QueueManager;

/**
 *
 * @author Nimesh Kasun
 */
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedDeque;
import vehicle.*;

public class EntryQueue implements Runnable {

    private String name;
    private ConcurrentLinkedDeque queue;
    private final int SLEEP;

    public EntryQueue(String name, int sleep, ConcurrentLinkedDeque queue) {
        this.queue = queue;
        this.SLEEP = sleep;
        this.name = name;
    }

    // Name of the current thread
    public String getName() {
        return name;
    }

    private String getRandomPlateID(int len) {
        // Vocabulary to generate the ID from
        String VOCAB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder plateID = new StringBuilder();
        Random rnd = new Random();
        while (plateID.length() < len) {
            int index = (int) (rnd.nextFloat() * VOCAB.length());
            plateID.append(VOCAB.charAt(index));
        }
        return plateID.toString();
    }

    private Vehicle generateRandomVehicle() {
        // Generate a random plate ID
        String plateID = getRandomPlateID(6);
        Random rnd = new Random();
        double randomDouble = rnd.nextDouble() * 14.0;
        Vehicle newVehicle;

        // Cars were given a higher chance due to higher availability of slots in the car park
        if (randomDouble <= 2.0) {
            newVehicle = new Car(plateID);
        } else if (randomDouble <= 4.0) {
            newVehicle = new Motorbike(plateID);
        } else if (randomDouble <= 6.0) {
            newVehicle = new Lorry(plateID);
        } else if (randomDouble <= 8.0) {
            newVehicle = new MiniLorry(plateID);
        } else if (randomDouble <= 10.0) {
            newVehicle = new Bus(plateID);
        } else if (randomDouble <= 12.0) {
            newVehicle = new Minibus(plateID);
        } else {
            newVehicle = new Van(plateID);
        }

        return newVehicle;
    }

    // Executes the runnable
    @Override
    public void run() {
        // Continuously generate a random vehicle and add it to the back of the entrance queue
        while (true) {
            // Generate a random vehicle
            Vehicle vehicleToEnter = this.generateRandomVehicle();
            try {
                // Add vehicle to queue
                queue.add(vehicleToEnter);
            } catch (Exception e) {
                System.out.println("Error when adding vehicle to queue.");
            }
            try {
                // Sleep the thread giving other threads a chance to run
                Thread.sleep(SLEEP);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
