/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject2;

/**
 *
 * @author Prajwal
 */

import java.util.Arrays;
import java.util.Scanner;

class Flight {
    String flightNumber;
    String departureTime;

    public Flight(String flightNumber, String departureTime) {
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + flightNumber + '\'' +
                ", departureTime='" + departureTime + '\'' +
                '}';
    }
}

public class Mavenproject2 {
    public static void main(String[] args) {
        // Create an array to store flights
        

        // Take input for flight details from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of flights: ");
        int numFlights = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Create an array to store the flights
        Flight[] flights = new Flight[numFlights];
        for (int i = 0; i < flights.length; i++) {
            System.out.print("Enter flight number for Flight " + (i + 1) + ": ");
            String flightNumber = scanner.nextLine();
            System.out.print("Enter departure time for Flight " + (i + 1) + ": ");
            String departureTime = scanner.nextLine();
            while (Integer.parseInt(departureTime) > 12) {
                System.out.println("Invalid departure time! Please enter a valid time (not greater than 12): ");
                departureTime = scanner.nextLine();
            }
            flights[i] = new Flight(flightNumber, departureTime);
        }

        // Display the unsorted flights
        System.out.println("Unsorted Flights:");
        displayFlights(flights);

        // Sort the flights based on
        bubbleSort(flights);

        // Display the sorted flights
        System.out.println("\nSorted Flights:");
        displayFlights(flights);
    }

    // Bubble Sort algorithm for sorting flights based on departure time
    private static void bubbleSort(Flight[] flights) {
        int n = flights.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (flights[j].getDepartureTime().compareTo(flights[j + 1].getDepartureTime()) > 0) {
                    // Swap flights
                    Flight temp = flights[j];
                    flights[j] = flights[j + 1];
                    flights[j + 1] = temp;
                }
            }
        }
    }
    // private static void quickSort(Flight[] flights, int low, int high) {
    //     if (low < high) {
    //         int partitionIndex = partition(flights, low, high);
    //         quickSort(flights, low, partitionIndex - 1);
    //         quickSort(flights, partitionIndex + 1, high);
    //     }
    // }

    // private static int partition(Flight[] flights, int low, int high) {
    //     String pivot = flights[high].getDepartureTime();
    //     int i = low - 1;

    //     for (int j = low; j < high; j++) {
    //         if (flights[j].getDepartureTime().compareTo(pivot) < 0) {
    //             i++;
    //             Flight temp = flights[i];
    //             flights[i] = flights[j];
    //             flights[j] = temp;
    //         }
    //     }

    //     Flight temp = flights[i + 1];
    //     flights[i + 1] = flights[high];
    //     flights[high] = temp;

    //     return i + 1;
    // }

    // Display the flights
    private static void displayFlights(Flight[] flights) {
        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }
}

