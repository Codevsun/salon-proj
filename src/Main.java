import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer();

        String[] hairServiceNames = {"Blow dry", "Hairstyle", "Retro", "Haircut", "Hair dye", "Treatment"};
        String[] nailsServiceNames = {"Pedicure", "Manicure", "Nails Art", "Hand Nails Color", "Foot Nails Color"};

        System.out.println("Welcome to FAB Beauty Salon \nChoose\n1.Employee\n2.Customer ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> {
                System.out.println("FAB Salon System Please choose a Service :\n " +
                        "1. Display Today's Appointments\n" +
                        "2. Add a new Employee\n" +
                        "3. Add a new Stylist \n" +
                        "4. Display Customer's Bill\n" +
                        "5. Offer A discount \n" +
                        "6. Exit 1");
                int employeeChoice = scanner.nextInt();
                ArrayList<Employee> employeesArray = new ArrayList<>();
                String phoneNumber;
                Employee emp = new Employee();
                switch (employeeChoice) {
                    case 1 -> Employee.displayAppointment();
                    case 2 -> {
                        while (employeesArray.size() < 15) {
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
                            employeesArray.add(employee);
                            emp.employeeId++;
                        }
                    }
                    case 3 -> {
                        Service.availableStylists();
                    }
                }
            }

            case 2 -> {
                System.out.println("Please Enter 1 to book an appointment\n0 to exist  ");
                int customerChoice = scanner.nextInt();

                if (customerChoice == 1) {
                    System.out.println("Welcome to FAB Beauty Salon, please enter your name ");
                    String name = scanner.next();
                    System.out.println("Email: ");
                    String email = scanner.next();
                    System.out.println("Phone number: ");
                    String phoneNumber1 = scanner.next();
                    System.out.println("Address: ");
                    String address = scanner.next();
                    while (true) {
                        System.out.println("""
                                Press 1 to add your Desired Services
                                Press 2 to view your added services
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
                                    Service service = new Service(hairServiceNames[customerHairChoice - 1], hairServicesCost(customerHairChoice), Service.getStylistById(stylistChoice));
                                    Appointment.getServicesArrayList().add(service);
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
                                    Appointment.getServicesArrayList().add(service);
                                }

                            }
                            Appointment appointment = new Appointment(name, email, phoneNumber1, address, customer.getCustomerId(), Appointment.getServicesArrayList());
                            Customer.bookAppointment(appointment);
                        } else if (servicesDesired == 2) {
                            Appointment customerAppointment = customer.getAppointment();
                            if (customerAppointment == null) {
                                System.out.println("You don't have any appointments yet");
                                continue;
                            }
                            System.out.println(customerAppointment);
                        } else if (servicesDesired == 0) {
//                            System.exit(0);
                            break;
                        }
                    }
                } else {
                    System.exit(0);
                }
            }

        }


    }

    public static double hairServicesCost(int choice) {
        if (choice == 1) {
            return 120;
        } else if (choice == 2) {
            return 100;
        } else if (choice == 3) {
            return 200;
        } else if (choice == 4) {
            return 50;
        } else if (choice == 5) {
            return 100;
        }


        return 0;
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



