import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Service.init();
        Store.init();
        Customer customer = new Customer();
        String[] hairServiceNames = {"Blow dry", "Hairstyle", "Retro", "Haircut", "Hair dye", "Treatment"};
        String[] nailsServiceNames = {"Pedicure", "Manicure", "Nails Art", "Hand Nails Color", "Foot Nails Color"};

        System.out.println("""
                Welcome to FAB Beauty Salon
                Choose
                1.Employee
                2.Customer
                3.Salon's Store
                """);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> {
                System.out.println("""
                        FAB Salon System Please choose a Service :
                        1. Display Today's Appointments
                        2. Add a new Employee
                        3. Add a new Stylist
                        4. Display Customer's Bill
                        5. Offer A discount
                        6. Exit 1""");
                int employeeChoice = scanner.nextInt();
                ArrayList<Employee> employeesArray = new ArrayList<>();
                Employee emp = new Employee();
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
                        System.out.println("Enter the Costumer's Phone Number to Offer a discount ");
                        String costumersPhoneNumber = scanner.next();
                        System.out.println("""
                                What Type of Discount you would like to offer ?
                                 1.Golden
                                 2.Silver
                                 3.Bronze""");
                        int employeesChoiceForTheDiscount = scanner.nextInt();
                        Employee.offerDiscount(discountPercentage(employeesChoiceForTheDiscount), costumersPhoneNumber);
                    }
                    case 6 -> {
                    }
                }
            }

            case 2 -> {
                System.out.println("Please Enter 1 to book an appointment\n0 to exist  ");
                int customerChoice = scanner.nextInt();

                if (customerChoice == 1) {
                    Appointment newAppointment = new Appointment();
                    System.out.println("Welcome to FAB Beauty Salon, please enter your name ");
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
                    newAppointment.setCustomer(customer);

                    while (true) {
                        System.out.println("""
                                1. to add your desired services
                                2. to view your added services
                                3. to edit your Appointment
                                4. to cancel your Appointment
                                Press 0 to Exit""");
                        int servicesDesired = scanner.nextInt();

                        if (servicesDesired == 1) {
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
                                    hair.setCost(hairServicesCost(customerHairChoice));
                                    hair.setCost(hair.costForEachType(customersHairLength));
                                    Service service = new Service(hairServiceNames[customerHairChoice - 1], hair.getCost(), Service.getStylistById(stylistChoice));
                                    newAppointment.getServicesArrayList().add(service);
                                    newAppointment.setCustomer(customer);
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

                            Customer.bookAppointment(newAppointment);
                        } else if (servicesDesired == 2) {
                            Appointment customerAppointment = customer.getAppointment();
                            if (customerAppointment == null) {
                                System.out.println("You don't have any appointments yet");
                                continue;
                            }
                            System.out.println(customerAppointment);
                            customerAppointment.printServices();
                        } else if (servicesDesired == 3) {
                            loop:
                            while (true) {
                                System.out.println("""
                                        What wold you like to edit?
                                         1. Name
                                         2. Email
                                         3. Phone Number
                                         4. Address
                                         5. Change stylist2
                                         6. Go back
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
                                    case 6 -> {
                                        break loop;
                                    }
                                }
                                System.out.println("editChoice=" + editChoice);
                                customer.editAppointment(editChoice, newName, newEmail, newPhoneNumber, newAddress);
                            }

                        } else if (servicesDesired == 4) {
                            customer.cancelAppointment();

                        } else if (servicesDesired == 0) {
                            break;
                        }
                    }
                } else {
                    System.exit(0);
                }
            }
            case 3 -> {
                ArrayList<Store> cart = new ArrayList<>();
                System.out.println("Welcome to FAB's Beauty Press " +
                        "1. Enter the store" +
                        "2. Exit");
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
                }

                else if (serviceProducts == 0) {
                    System.exit(0);
                }
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
            if (!Main.isValidMobileNumber(phoneNumber)) {
                System.out.println("Invalid number");
            }
        }
        while (!isValidMobileNumber(phoneNumber));
        System.out.println("Email :");
        String email = scanner.next();
        System.out.println("Address");
        String address = scanner.next();
        Employee employee = new Employee(name, email, phoneNumber, address);
        return employee;
    }

    public static boolean isValidMobileNumber(String phone) {

        //phone doesnt contain special characters if its a saudi no.
        return (phone.length() > 10 &&
                ((phone.contains("+1" + "((\\\\d{3}-)){1,2}\\\\d{4}"))
                        || (phone.contains("+966" + "d{9}"))))
                || ((phone.length() == 10) &&
                !(phone.contains("(") && !(phone.contains(")") &&
                        !(phone.contains("-")))));

    }

    public static double nailsServiceCost(int choice) {
        if (choice == 1) {
            return 70;
        } else if (choice == 2) {
            return 200;
        } else if (choice == 3) {
            return 200;
        } else if (choice == 4 || choice == 5) {
            return 50;
        }
        return 0;
    }

}



