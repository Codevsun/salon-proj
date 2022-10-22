import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    private static final boolean isRunning = true;

    public static void main(String[] args) {
        Service.init();
        Store.init();
        Customer customer = new Customer();
        String[] hairServiceNames = {"Blow dry", "Hairstyle", "Retro", "Haircut", "Hair dye", "Treatment"};
        String[] nailsServiceNames = {"Pedicure", "Manicure", "Nails Art", "Hand Nails Color", "Foot Nails Color"};

        while (isRunning) {
            System.out.println(prettyPrint("Welcome to FAB Beauty Salon"));
            System.out.println("""
                    Select an option from the menu
                    1. Employee
                    2. Customer
                    3. Salon's Store""");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> employee();
                case 2 -> customer(customer, hairServiceNames, nailsServiceNames);
                case 3 -> salonStore();
            }
        }
    }

    private static void salonStore() {
        ArrayList<Store> cart = new ArrayList<>();
        System.out.println("""
                Welcome to FAB's Beauty
                "1. Enter the store
                "2. Exit""");
        int serviceProducts = scanner.nextInt();
        if (serviceProducts == 1) {
            while (true) {
                System.out.println("1. add to cart\n0.Done  ");
                int customerChoice = scanner.nextInt();
                if (customerChoice == 1) {
                    System.out.println("Our Products ");
                    int i = 0;
                    for (Store store : Store.getProductsArray()) {
                        System.out.print(i + 1 + ".");
                        System.out.println(store);
                        i++;
                    }
                    System.out.println("Enter your product ");
                    int productChoice = scanner.nextInt();
                    cart.add(Store.getProductsArray().get(productChoice - 1));

                } else if (customerChoice == 2) {
                    for (Store s : cart) {
                        System.out.println(s);
                    }
                    double total = 0;
                    for (Store store : cart) {
                        total += store.getCost();
                    }
                    System.out.println("Total: " + total);
                } else if (customerChoice == 0) {
                    break;
                }
            }
        } else if (serviceProducts == 0) {
            System.exit(0);
        }
    }

    private static void customer(Customer customer, String[] hairServiceNames, String[] nailsServiceNames) {
        System.out.println(prettyPrint("customer"));
        System.out.println("""
                1. Book Appointment
                2. Edit Appointment
                3. Cancel Appointment
                0. Go Back""");
        int customerChoice = scanner.nextInt();

        switch (customerChoice) {
            case 1 -> bookCustomerAppointment(customer, hairServiceNames, nailsServiceNames);
            case 2 -> editCustomerAppointment(customer);
            case 3 -> cancelCustomerAppointment(customer);
        }
    }

    private static void cancelCustomerAppointment(Customer customer) {
        if (customer.getAppointment() == null) {
            System.out.println("* You don't have any appointments");
            return;
        }

        System.out.println("Are you sure you want to cancel? [y/n]");
        String yesNo = scanner.next();

        if (yesNo.equalsIgnoreCase("y")) {
            customer.cancelAppointment();
        }
    }

    private static void bookCustomerAppointment(Customer customer, String[] hairServiceNames, String[] nailsServiceNames) {
        Appointment newAppointment = new Appointment();
        newAppointment.setCustomer(customer);

        System.out.println(prettyPrint("Welcome to FAB salon"));
        System.out.println("Please enter your name ");
        String name = scanner.next();
        customer.setName(name);

        System.out.println("Email: ");
        String email = scanner.next();
        customer.setEmail(email);

        System.out.println("Phone number: ");
        String phoneNumber = scanner.next();
        customer.setPhone(phoneNumber);

        System.out.println("Address: ");
        String address = scanner.next();
        customer.setAddress(address);

        loop:
        while (true) {
            System.out.println("""
                    1. to add your desired services
                    2. to view your added services
                    3. to edit your Appointment
                    4. to cancel your Appointment
                    Press 0 to Exit""");
            int servicesDesired = scanner.nextInt();
            switch (servicesDesired) {
                case 1 -> addDesiredService(hairServiceNames, nailsServiceNames, newAppointment);
                case 2 -> viewAddedServices(newAppointment);
                case 3 -> editCustomerAppointment(customer);
                case 4 -> customer.cancelAppointment();
                case 0 -> {
                    break loop;
                }
                default -> System.out.println("Invalid input");
            }
        }
        if (newAppointment.getServicesArrayList().size() > 0) {
            Customer.bookAppointment(newAppointment);
        }
    }

    private static void editCustomerAppointment(Customer customer) {
        String editAppointmentMessage = prettyPrint("Edit Appointment");
        System.out.println(editAppointmentMessage);
        while (true) {
            System.out.println("""
                    What wold you like to edit?
                     1. Name
                     2. Email
                     3. Phone Number
                     4. Address
                     5. Change stylist2
                     0. Go back
                     """);
            int editChoice = scanner.nextInt();
            String newName = "", newEmail = "", newPhoneNumber = "", newAddress = "", newStylist = "";
            switch (editChoice) {
                case 1 -> {
                    System.out.println("Please enter the new Name");
                    newName = scanner.next();
                }
                case 2 -> {
                    System.out.println("Please enter the new Email");
                    newEmail = scanner.next();
                }
                case 3 -> {
                    System.out.println("Please enter the new Phone Number");
                    newPhoneNumber = scanner.next();
                }
                case 4 -> {
                    System.out.println("Please enter the new Address");
                    newAddress = scanner.next();
                }
                case 5 -> {
                    int i = 0;
                    Service serviceToEdit;
                    System.out.println("Which service would you like to change the stylist?");
                    for (Service service : customer.getAppointment().getServicesArrayList()) {
                        System.out.println((i + 1) + " -> " + service.toString());
                        i++;
                    }
                    int serviceEditChoice = scanner.nextInt();

                    serviceToEdit = customer.getAppointment().getServicesArrayList().get(serviceEditChoice - 1);

                    System.out.println("Choose your preferred stylist");
                    Service.availableStylists();
                    int newStylistChoice = Main.scanner.nextInt();
                    newStylist = Service.getStylistArrayList().get(newStylistChoice - 1).getName();
                    serviceToEdit.setStylistName(newStylist);
                }
                case 0 -> {
                    return;
                }
            }
            System.out.println("editChoice=" + editChoice);
            customer.editAppointment(editChoice, newName, newEmail, newPhoneNumber, newAddress);
            System.out.println(prettyPrintFooter(editAppointmentMessage.length()));
        }
    }

    private static void viewAddedServices(Appointment newAppointment) {
        if (newAppointment == null) {
            System.out.println("You don't have any appointments yet");
            return;
        }
        String header = prettyPrint("Added services");
        System.out.println(header);
        System.out.println(newAppointment);
        newAppointment.printServices();
        System.out.println(prettyPrintFooter(header.length()));
    }

    private static void addDesiredService(String[] hairServiceNames, String[] nailsServiceNames, Appointment newAppointment) {
        System.out.println("What would you like to to do today\n1. Hair \n2. Nails");
        int customerService = scanner.nextInt();
        switch (customerService) {
            case 1 -> {
                Hair hair = new Hair();
                hair.displayMenu();
                System.out.println("Choose your service: ");
                int customerHairChoice = scanner.nextInt();
                System.out.println("Choose your hair stylists");
                Service.availableStylists();
                int stylistChoice = scanner.nextInt();
                System.out.println("What's your hair's length ?[Long, Medium, Short] ");
                String customersHairLength = scanner.next();
                customersHairLength = customersHairLength.toUpperCase();
                hair.setCost(hairServicesCost(customerHairChoice));
                hair.setCost(hair.costForEachType(Hair.Length.valueOf(customersHairLength)));
                Service service = new Service(hairServiceNames[customerHairChoice - 1], hair.getCost(), Service.getStylistById(stylistChoice));
                newAppointment.getServicesArrayList().add(service);
            }

            case 2 -> {
                Nails nails = new Nails();
                nails.displayMenu();
                System.out.println("Choose your service");
                int customerNailsChoice = scanner.nextInt();
                System.out.println("Choose your Nails stylists");
                Service.availableStylists();
                int stylistChoice = scanner.nextInt();
                Service service = new Service(nailsServiceNames[customerNailsChoice - 1], nailsServiceCost(customerNailsChoice), Service.getStylistById(stylistChoice));
                newAppointment.getServicesArrayList().add(service);
            }

        }
    }

    private static void employee() {
        System.out.println("""
                FAB Salon System Please choose a Service :
                1. Display Today's Appointments
                2. Add a new Employee
                3. Add a new Stylist
                4. Display Customer's Bill
                5. Offer A discount
                6. Exit""");
        int employeeChoice = scanner.nextInt();
        ArrayList<Employee> employeesArray = new ArrayList<>();
        switch (employeeChoice) {
            case 1 -> Employee.displayAppointment();
            case 2 -> {
                while (employeesArray.size() < 15) {
                    employeesArray.add(employeeSurvey());
                }
            }
            case 3 -> Service.addStylist(employeeSurvey());
            case 4 -> {
                System.out.println("Enter the Costumer's Phone Number to display the bill");
                String costumersPhoneNumber = scanner.next();
                Employee.displayBill(costumersPhoneNumber);
            }
            case 5 -> {
                System.out.println("Enter the customer's Phone Number to Offer a discount ");
                String costumersPhoneNumber = scanner.next();
                Employee.displayBill(costumersPhoneNumber);
                System.out.println("please enter customer's old total");
                double costumerOldTotal = scanner.nextInt();
                System.out.println("""
                        What Type of Discount you would like to offer ?
                         1.Golden
                         2.Silver
                         3.Bronze""");
                int employeesChoiceForTheDiscount = scanner.nextInt();
                double discountedTotal = Employee.offerDiscount(discountPercentage(employeesChoiceForTheDiscount), costumersPhoneNumber, costumerOldTotal);
                System.out.println("you total after discount is: " + discountedTotal);
            }
        }
    }


    public static double discountPercentage(int choice) {
        return switch (choice) {
            case 1 -> 0.5;
            case 2 -> 0.3;
            case 3 -> 0.1;
            default -> 0;
        };
    }

    public static double hairServicesCost(int choice) {
        return switch (choice) {
            case 1 -> 120;
            case 2, 5 -> 100;
            case 3 -> 200;
            case 4 -> 50;
            default -> 0;
        };
    }

    public static Employee employeeSurvey() {
        String phoneNumber;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your Name :");
        String name = scanner.next();

        do {
            System.out.println("Please enter your phoneNumber :");
            phoneNumber = scanner.next();
            if (Main.isInvalidMobileNumber(phoneNumber)) {
                System.out.println("Invalid number");
            }
        } while (isInvalidMobileNumber(phoneNumber));

        System.out.println("Email :");
        String email = scanner.next();
        System.out.println("Address");
        String address = scanner.next();
        return new Employee(name, email, phoneNumber, address);
    }

    public static boolean isInvalidMobileNumber(String phone) {
        //phone doesnt contain special characters if its a saudi no.
        return (phone.length() <= 10 ||
                ((!phone.contains("+1" + "((\\\\d{3}-)){1,2}\\\\d{4}"))
                        && (!phone.contains("+966" + "d{9}"))))
                && ((phone.length() != 10) ||
                phone.contains("(") && !(phone.contains(")") &&
                        !(phone.contains("-"))));

    }

    public static double nailsServiceCost(int choice) {
        return switch (choice) {
            case 1 -> 70;
            case 2 -> 200;
            case 3 -> 230;
            case 4, 5 -> 50;
            default -> 0;
        };
    }

    public static String prettyPrint(String header) {
        String repeat = "=".repeat(25);
        return repeat + " [ " + header.toUpperCase() + " ] " + repeat;
    }

    public static String prettyPrintFooter(int headerLength) {
        return "=".repeat(headerLength);
    }

}



