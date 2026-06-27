import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HotelReservation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Room lists setup
        ArrayList<Integer> singleRooms = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> doubleRooms = new ArrayList<>(Arrays.asList(6, 7, 8, 9, 10));
        ArrayList<Integer> deluxeRooms = new ArrayList<>(Arrays.asList(11, 12, 13, 14, 15));
        ArrayList<Integer> familyRooms = new ArrayList<>(Arrays.asList(16, 17, 18, 19, 20));

        while (true) {
            System.out.println("\n--- ROOM RESERVATION SYSTEM (BM HOTEL) ---");
            System.out.println("A. Single Room  - Rs. 1000/day");
            System.out.println("B. Double Room  - Rs. 1750/day");
            System.out.println("C. Deluxe Room  - Rs. 3000/day");
            System.out.println("D. Family Room  - Rs. 4000/day");
            System.out.println("Type 'exit' to stop the application.");
            System.out.println("------------------------------------------");

            System.out.print("Enter Customer Name: ");
            String name = in.nextLine();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Enter Email ID: ");
            String email = in.nextLine();

            System.out.print("Enter Contact Number: ");
            String phone = in.nextLine();

            System.out.print("Select Room Category (A/B/C/D): ");
            String choice = in.nextLine().trim().toUpperCase();

            String selectedCategory = "";
            int pricePerDay = 0;
            ArrayList<Integer> activeRoomPool = null;

            // Map user input choice to the correct variables
            if (choice.equals("A")) {
                selectedCategory = "Single Room";
                pricePerDay = 1000;
                activeRoomPool = singleRooms;
            } else if (choice.equals("B")) {
                selectedCategory = "Double Room";
                pricePerDay = 1750;
                activeRoomPool = doubleRooms;
            } else if (choice.equals("C")) {
                selectedCategory = "Deluxe Room";
                pricePerDay = 3000;
                activeRoomPool = deluxeRooms;
            } else if (choice.equals("D")) {
                selectedCategory = "Family Room";
                pricePerDay = 4000;
                activeRoomPool = familyRooms;
            } else {
                System.out.println("ERROR: Invalid category selected! Please try again.");
                continue;
            }

            // Check if any rooms are actually available in that collection
            System.out.println("Available numbers for " + selectedCategory + ": " + activeRoomPool);
            if (activeRoomPool.isEmpty()) {
                System.out.println("Sorry, no rooms are currently available in this specific category.");
                continue;
            }

            System.out.print("How many rooms do you want to book? ");
            int numRooms = in.nextInt();
            in.nextLine(); // Clear scanner line buffer

            if (numRooms <= 0 || numRooms > activeRoomPool.size()) {
                System.out.println("ERROR: You requested an invalid quantity of rooms.");
                continue;
            }

            System.out.print("Enter room numbers separated by space (e.g., 1 3): ");
            String roomString = in.nextLine();
            String[] roomTokens = roomString.split(" ");
            
            ArrayList<Integer> temporarySelection = new ArrayList<>();
            boolean validationFlag = true;

            for (String token : roomTokens) {
                try {
                    int roomNum = Integer.parseInt(token);
                    if (activeRoomPool.contains(roomNum)) {
                        temporarySelection.add(roomNum);
                    } else {
                        System.out.println("ERROR: Room " + roomNum + " is not in the available list!");
                        validationFlag = false;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("ERROR: Please enter numbers only.");
                    validationFlag = false;
                }
            }

            // Verify requested quantity matches successful parsed items
            if (!validationFlag || temporarySelection.size() != numRooms) {
                System.out.println("Booking failed due to invalid room numbers selection.");
                continue;
            }

            System.out.print("Enter number of stay days: ");
            int totalDays = in.nextInt();
            in.nextLine(); // Clear scanner line buffer

            System.out.print("Enter Booking Start Date (DD-MM-YYYY): ");
            String reservationDate = in.nextLine();

            // Calculate overall total amount
            int totalBill = numRooms * totalDays * pricePerDay;

            // Remove the booked rooms safely from original pools
            for (int roomToDeduct : temporarySelection) {
                activeRoomPool.remove(Integer.valueOf(roomToDeduct));
            }

            // Print standard business output statement
            System.out.println("\n=================================================");
            System.out.println("               RESERVATION RECEIPT               ");
            System.out.println("=================================================");
            System.out.println("Customer Name : " + name);
            System.out.println("Contact Phone : " + phone);
            System.out.println("Email Address : " + email);
            System.out.println("Room Type     : " + selectedCategory);
            System.out.println("Rooms Secured : " + temporarySelection);
            System.out.println("Total Days    : " + totalDays);
            System.out.println("Starting Date : " + reservationDate);
            System.out.println("Grand Total   : Rs. " + totalBill);
            System.out.println("=================================================");
            System.out.println("Status: Confirmed Successfully!\n");
        }

        in.close();
        System.out.println("System stopped safely.");
    }
}

