import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Ticket {
    private String passengerName;
    private String seatNumber;
    private String ticketNumber;

    public Ticket(String passengerName, String seatNumber, String ticketNumber) {
        this.passengerName = passengerName;
        this.seatNumber = seatNumber;
        this.ticketNumber = ticketNumber;
    }

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

public class FlightTicketDetails {
    private List<Ticket> tickets;

    public FlightTicketDetails() {
        tickets = new ArrayList<>();
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public Ticket findTicket(String ticketNumber) {
        for (Ticket ticket : tickets) {
            if (ticket.getTicketNumber().equals(ticketNumber)) {
                return ticket;
            }
        }
        return null;
    }

    public void displayTicketDetails() {
        System.out.println("Ticket Details:");
        for (Ticket ticket : tickets) {
            System.out.println("Ticket Number: " + ticket.getTicketNumber() +
                    ", Passenger Name: " + ticket.getPassengerName() +
                    ", Seat Number: " + ticket.getSeatNumber());
        }
    }

    public static void main(String[] args) {
        FlightTicketDetails flight = new FlightTicketDetails();
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("1. Add Ticket");
            System.out.println("2. Find Ticket");
            System.out.println("3. Display Ticket Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
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
                    flight.displayTicketDetails();
                    break;
                case "4":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

            System.out.println();
        } while (!choice.equals("4"));

        scanner.close();
    }
}