package com.reservation.Main;

import com.reservation.Model.Booking;
import com.reservation.Model.Bus;
import com.reservation.Service.*;
import com.sun.security.jgss.GSSUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        AddBusService addBusService = new AddBusService();
        BookTicketService bookTicketService = new BookTicketService();
        CancelTicketService cancelTicketService = new CancelTicketService();
        ViewBookingsService viewBookingsService = new ViewBookingsService();
        ViewBusesService viewBusesService = new ViewBusesService();
        PaymentService paymentService = new PaymentService();
        System.out.println("  __  ,  , _,    ,_   _, _,  _,,_ ,   ,_  ___,___,  _, ,  ,    _, ,  ,_, ___,_, , , ");
        System.out.println(" '|_) |  |(_,    |_) /_,(_, /_,|_)  /'|\\' | ' |   / \\,|\\ |   (_, \\_/(_,' | /_,|\\/| ");
        System.out.println(" _|_)'\\__| _)   '| \\'\\_  _)'\\_'| \\ \\/` |-\\ |  _|_,'\\_/ |'\\|    _), /` _)  |'\\_ | `| ");
        System.out.println("'        `'      '  `  `'     `'  `'   '  `' '     '   '  `   ' (_/  '    '   `'  ` ");
        System.out.println(":::::::::+++Login+++::::::::");
        while(true) {
            System.out.println("Enter userName ");
            String userName = sc.nextLine();
            System.out.println("Enter Password ");
            String password = sc.nextLine();
            if (userName.equals("admin") && password.equals("admin123") ) {
                System.out.println("-------------------------------------------");

                System.out.println("WelCome To the Bus reservation System");

                System.out.println("--------------------------------------------");

                while (true) {
                    System.out.println("press 1 : for add a bus ");
                    System.out.println("press 2 : for book a ticket ");
                    System.out.println("press 3 : for for make payment  ");
                    System.out.println("press 4 : cancel a ticket ");
                    System.out.println("press 5 : for view Bookings  ");
                    System.out.println("press 6 : for view Buses ");
                    System.out.println("press 7 for search booking");
                    System.out.println("press 8 : for Exit.... ");
                    System.out.println("Enter Your Choice : ");
                    int choice = Integer.parseInt(sc.nextLine());
                    switch (choice) {
                        case 1:
                        System.out.println("Enter bus name");
                        String busName = sc.nextLine();
                        System.out.println("Enter bus Number");
                        String busNumber = sc.nextLine();
                        System.out.println("Enter Total Seats ");
                        int totalSeat = Integer.parseInt(sc.nextLine());
                        System.out.println("Ente Departure time");
                        String departureTime = sc.nextLine();
                        System.out.println("Enter Arrival Time ");
                        String arrivalTime = sc.nextLine();
                        System.out.println("Enter source ");
                        String source = sc.nextLine();
                        System.out.println("Enter Destination");
                        String destination = sc.nextLine();
                        addBusService.AddBus(busName, busNumber, totalSeat, departureTime, arrivalTime, source, destination);
                        break;
                        case 2 :
                            System.out.println("These All Fields are required to book a Ticket");
                            System.out.println("________________________________________________");
                            System.out.print("Enter Passenger Name : ");
                            String pasengrName = sc.nextLine();
                            System.out.print("Enter Bus Id  : ");
                            int busId = Integer.parseInt(sc.nextLine());
                            System.out.print("Enter Seat Number : ");
                            int seatNumber = Integer.parseInt(sc.nextLine());
                            System.out.print("Enter Travel date in from of YYYY-MM-DD : ");
                            String travelDate = sc.nextLine();
                            System.out.print("Enter Travel Time : ");
                            String travelTime = sc.nextLine();
                            System.out.print("Enter total amount : ");
                            double amount = Double.parseDouble(sc.nextLine());
                            bookTicketService.bookTicket(pasengrName,busId,seatNumber,travelDate,travelTime,amount);
                            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                            break;
                        case 4 :
                            System.out.println("::::::::: CANCEL TICKET ::::::::");
                            System.out.println("_____________________________________");
                            System.out.print("Enter Ticket Id : ");
                            int ticketId =Integer.parseInt(sc.nextLine());
                            cancelTicketService.cancelTicket(ticketId);
                            System.out.println("Ticket Cancelled sucessfully ");
                            System.out.println("___________________________________________");
                            break;
                        case 5:
                            System.out.println("- : Showing Booking List : -");
                            List<Booking> allBookings = viewBookingsService.findAllBooking();
                            for(Booking s : allBookings){
                                System.out.println(s.getTicket_id()+" | "+s.getPassenger_name()+" | "+s.getBus_id()+" | "+s.getSeatNumber()+" | "+s.getTravel_date()+" | "+s.getTravet_time()+" | "+s.getAmount()+" | "+s.getStatus());
                            }
                            break;
                        case 6:
                            System.out.println("- : Showing Buses : -");
                            List<Bus> busList = viewBusesService.showAllBus();
                            for(Bus a : busList){
                                System.out.println(a.getId()+" | "+a.getBusName()+" | "+a.getBusNumber()+" | "+a.getTotalSeat()+" | "+ a.getArrivalTime()+" | "+a.getDepartureTime()+" | "+a.getSource()+" | "+a.getDestination());

                            }

                            System.out.println("--------------------------------------------");
                            break;
                        case 3 :
                            System.out.println("- : Payment mode : - ");
                            System.out.println("---------------------------------------------");
                            System.out.println("Press one for payment with card");
                            System.out.println("press two for payment with upi");
                            int userChoice = Integer.parseInt(sc.nextLine());
                            if (userChoice == 1){
                                System.out.print("Enter Card number : ");
                                String cardNumber = sc.nextLine();
                                System.out.print("Enter name of card Holder : ");
                                String cardHolder = sc.nextLine();
                                System.out.print("Enter CVV Number : ");
                                int cvv = Integer.parseInt(sc.nextLine());
                                System.out.print("Enter Amount : ");
                                int payment = Integer.parseInt(sc.nextLine());
                                paymentService.addPayment(cardNumber,cardHolder,cvv,payment);

                            }
                            else{
                                System.out.println("Payment redirected through upi");
                                System.out.println("tousif@ybl   Payment on this upi address ");
                            }
                            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
                            break;
                        case 7:
                            System.out.println("---------: Search Bar : ----------");
                            System.out.print("Enter Characters : ");
                            String chara = sc.nextLine();
                            SearchBarService searchBarService = new SearchBarService();
                            searchBarService.searchBar(chara);
                            System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
                            break;
                        case 8 :
                            System.out.println("::::::: EXITING :::::::");
                            System.exit(0);


                    }
                }
            }
            else {
                System.out.println("invalid credentials");
            }
        }
    }
}
