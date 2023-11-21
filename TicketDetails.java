import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Define a Ticket class to represent flight tickets
class Ticket {
    private String passengerName;
    private String seatNumber;
    private String ticketNumber;

    // Constructor to initialize ticket details
    public Ticket(String passengerName, String seatNumber, String ticketNumber) {
        this.passengerName = passengerName;
        this.seatNumber = seatNumber;
        this.ticketNumber = ticketNumber;
    }

    // Getter methods to access ticket details
    public String getPassengerName() {
        return passengerName;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }
}

// Main class for flight ticket details management
public class FlightTicketDetails {
    private List<Ticket> tickets;  // List to store ticket objects

    // Constructor to initialize the list of tickets
    public FlightTicketDetails() {
        tickets = new ArrayList<>();
    }

    // Method to add a ticket to the list
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    // Method to find a ticket by ticket number
    public Ticket findTicket(String ticketNumber) {
        for (Ticket ticket : tickets) {
            if (ticket.getTicketNumber().equals(ticketNumber)) {
                return ticket;
            }
        }
        return null;
    }

    // Method to display all ticket details
    public void displayTicketDetails() {
        System.out.println("Ticket Details:");
        for (Ticket ticket : tickets) {
            System.out.println("Ticket Number: " + ticket.getTicketNumber() +
                    ", Passenger Name: " + ticket.getPassengerName() +
                    ", Seat Number: " + ticket.getSeatNumber());
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        FlightTicketDetails flight = new FlightTicketDetails();  // Create an instance of FlightTicketDetails
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object to read user input
        String choice;  // Variable to store user's menu choice

        // Display menu and process user input until the user chooses to exit
        do {
            System.out.println("1. Add Ticket");
            System.out.println("2. Find Ticket");
            System.out.println("3. Display Ticket Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    // Add a ticket
                    System.out.print("Enter passenger name: ");
                    String passengerName = scanner.nextLine();
                    System.out.print("Enter seat number: ");
                    String seatNumber = scanner.nextLine();
                    System.out.print("Enter ticket number: ");
                    String ticketNumber = scanner.nextLine();
                    Ticket ticket = new Ticket(passengerName, seatNumber, ticketNumber);
                    flight.addTicket(ticket);
                    System.out.println("Ticket added successfully!");
                    break;

                case "2":
                    // Find a ticket
                    System.out.print("Enter ticket number: ");
                    ticketNumber = scanner.nextLine();
                    Ticket foundTicket = flight.findTicket(ticketNumber);
                    if (foundTicket != null) {
                        System.out.println("Ticket found! Passenger Name: " + foundTicket.getPassengerName() +
                                ", Seat Number: " + foundTicket.getSeatNumber());
                    } else {
                        System.out.println("Ticket not found!");
                    }
                    break;

                case "3":
                    // Display all ticket details
                    flight.displayTicketDetails();
                    break;

                case "4":
                    // Exit the program
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

            System.out.println();
        } while (!choice.equals("4"));  // Repeat until the user chooses to exit

        scanner.close();  // Close the Scanner object
    }
}
