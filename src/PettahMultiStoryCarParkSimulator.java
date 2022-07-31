/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Nimesh Kasun
 */
import CarParkData.CarPark;
import QueueManager.*;
import java.util.concurrent.ConcurrentLinkedDeque;

public class PettahMultiStoryCarParkSimulator {

    private final CarPark carPark;

    // Entrance 1-9
    private ConcurrentLinkedDeque entry1Queue;
    private ConcurrentLinkedDeque entry2Queue;
    private ConcurrentLinkedDeque entry3Queue;
    private ConcurrentLinkedDeque entry4Queue;
    private ConcurrentLinkedDeque entry5Queue;
    private ConcurrentLinkedDeque entry6Queue;
    private ConcurrentLinkedDeque entry7Queue;
    private ConcurrentLinkedDeque entry8Queue;
    private ConcurrentLinkedDeque entry9Queue;

    public PettahMultiStoryCarParkSimulator() {
        PettahMultiStoryCarParkManager manager = new PettahMultiStoryCarParkManager();
        // Set the current car park managed to an Pettah car park
        this.carPark = manager.getCarPark();

        // Initialize all the queues for each entrance of this car park
        entry1Queue = new ConcurrentLinkedDeque();
        entry2Queue = new ConcurrentLinkedDeque();
        entry3Queue = new ConcurrentLinkedDeque();
        entry4Queue = new ConcurrentLinkedDeque();
        entry5Queue = new ConcurrentLinkedDeque();
        entry6Queue = new ConcurrentLinkedDeque();
        entry7Queue = new ConcurrentLinkedDeque();
        entry8Queue = new ConcurrentLinkedDeque();
        entry9Queue = new ConcurrentLinkedDeque();
    }

    /**
     * Method which simulates the Pettah Multi-story car park with synthetic
     * traffic
     */
    public void startSimulation() {
        System.out.println("Simulation started!");
        // Create 9 Threads which will keep on randomly adding vehicles to each entrance queue of this car park
        Thread entry1Queue = new Thread(new EntryQueue("Entry 1 Queue", 500, this.entry1Queue));
        Thread entry2Queue = new Thread(new EntryQueue("Entry 2 Queue", 500, this.entry2Queue));
        Thread entry3Queue = new Thread(new EntryQueue("Entry 3 Queue", 500, this.entry3Queue));
        Thread entry4Queue = new Thread(new EntryQueue("Entry 4 Queue", 500, this.entry4Queue));
        Thread entry5Queue = new Thread(new EntryQueue("Entry 5 Queue", 500, this.entry5Queue));
        Thread entry6Queue = new Thread(new EntryQueue("Entry 6 Queue", 500, this.entry6Queue));
        Thread entry7Queue = new Thread(new EntryQueue("Entry 7 Queue", 500, this.entry7Queue));
        Thread entry8Queue = new Thread(new EntryQueue("Entry 8 Queue", 500, this.entry8Queue));
        Thread entry9Queue = new Thread(new EntryQueue("Entry 9 Queue", 500, this.entry9Queue));

        // Create 9 Threads which will continuously add the first vehicle in each entrance queue to this car park
        Thread entrance1 = new Thread(new Entry("Entrance 1", 500, this.entry1Queue, this.carPark));
        Thread entrance2 = new Thread(new Entry("Entrance 2", 500, this.entry2Queue, this.carPark));
        Thread entrance3 = new Thread(new Entry("Entrance 3", 500, this.entry3Queue, this.carPark));
        Thread entrance4 = new Thread(new Entry("Entrance 4", 500, this.entry4Queue, this.carPark));
        Thread entrance5 = new Thread(new Entry("Entrance 5", 500, this.entry5Queue, this.carPark));
        Thread entrance6 = new Thread(new Entry("Entrance 6", 500, this.entry6Queue, this.carPark));
        Thread entrance7 = new Thread(new Entry("Entrance 7", 500, this.entry7Queue, this.carPark));
        Thread entrance8 = new Thread(new Entry("Entrance 8", 500, this.entry8Queue, this.carPark));
        Thread entrance9 = new Thread(new Entry("Entrance 9", 500, this.entry9Queue, this.carPark));

        // Create 9 Threads which will simulate vehicles leaving from each exit of this car park
        Thread exit1 = new Thread(new Exit("Exit 1", 2000, this.entry1Queue, this.carPark));
        Thread exit2 = new Thread(new Exit("Exit 2", 2000, this.entry2Queue, this.carPark));
        Thread exit3 = new Thread(new Exit("Exit 3", 2000, this.entry3Queue, this.carPark));
        Thread exit4 = new Thread(new Exit("Exit 4", 2000, this.entry4Queue, this.carPark));
        Thread exit5 = new Thread(new Exit("Exit 5", 2000, this.entry5Queue, this.carPark));
        Thread exit6 = new Thread(new Exit("Exit 6", 2000, this.entry6Queue, this.carPark));
        Thread exit7 = new Thread(new Exit("Exit 7", 2000, this.entry7Queue, this.carPark));
        Thread exit8 = new Thread(new Exit("Exit 8", 2000, this.entry8Queue, this.carPark));
        Thread exit9 = new Thread(new Exit("Exit 9", 2000, this.entry9Queue, this.carPark));

        // Start randomly adding vehicles to entrance 1-9 queues
        // Start entering vehicles to this car park from the entrance 1-9 queues
        // Simulate vehicles leaving from exit 1-9
        entrance1.start();
        entry1Queue.start();
        exit1.start();

        entrance2.start();
        entry2Queue.start();
        exit2.start();

        entrance3.start();
        entry3Queue.start();
        exit3.start();

        entrance4.start();
        entry4Queue.start();
        exit4.start();

        entrance5.start();
        entry5Queue.start();
        exit5.start();

        entrance6.start();
        entry6Queue.start();
        exit6.start();

    }

    public static void main(String[] args) {
        PettahMultiStoryCarParkSimulator simulator = new PettahMultiStoryCarParkSimulator();
        simulator.startSimulation();
    }

}
