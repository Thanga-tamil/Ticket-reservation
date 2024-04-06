import java.util.*;

class Ticket {
    private String eventName;
    private int seatNumber;
    private double price;

    public Ticket(String eventName, int seatNumber, double price) {
        this.eventName = eventName;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    public String getEventName() {
        return eventName;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return "Ticket for " + eventName + ", Seat Number: " + seatNumber + ", Price: Rs:" + price;
    }
}

class TicketReservationSystem {
    private static final int MAX_SEATS = 100;
    private static final double TICKET_PRICE = 150;
    private static boolean[] seats = new boolean[MAX_SEATS]; // true means seat is booked

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Book Ticket");
            System.out.println("2. Display Available Seats");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    bookTicket();
                    break;
                case 2:
                    displayAvailableSeats();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void bookTicket() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter event name: ");
        String eventName = scanner.nextLine();
        System.out.print("Enter number of tickets: ");
        int numTickets = scanner.nextInt();

        if (numTickets <= 0 || numTickets > MAX_SEATS) {
            System.out.println("Invalid number of tickets!");
            return;
        }

        int bookedTickets = 0;
        for (int i = 0; i < MAX_SEATS && bookedTickets < numTickets; i++) {
            if (!seats[i]) {
                seats[i] = true;
                bookedTickets++;
                Ticket ticket = new Ticket(eventName, i + 1, TICKET_PRICE);
                System.out.println("Ticket booked successfully: " + ticket);
            }
        }
        if (bookedTickets < numTickets) {
            System.out.println("Sorry, tickets are not available for all requested seats.");
        }
    }

    private static void displayAvailableSeats() {
        System.out.println("Available Seats:");
        for (int i = 0; i < MAX_SEATS; i++) {
            if (!seats[i]) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
    }
}
