public class Employee extends User {
    private static int employeeIdCounter = 1000;
    public int employeeId;


    public Employee(String name, String email, String phone, String address) {
        super(name, email, phone, address);
        this.employeeId = ++employeeIdCounter;
    }

    public static void display() {
        if (Customer.getAppointments().size() == 0) {
            System.out.println("No appointments for today. You can have the day off :)");
            return;
        }
        for (Appointment appointment : Customer.getAppointments()) {
            String header = "=".repeat(20) + " [ " + appointment.getId() + " ] " + "=".repeat(20);
            System.out.println(header);
            System.out.println(appointment);
            appointment.printServices();
            System.out.println("=".repeat(header.length()));
        }
    }

    public static void display(String number) {

        for (Appointment appointment : Customer.getAppointments()) {
            if (appointment.getCustomer().getPhone().equals(number)) {
                System.out.println(appointment);
                appointment.printServices();
                break;
            }
        }
    }

    public static String offerDiscount(double discountPercentage, double cost) {
        return "The discount on your bill is " + discountPercentage * 100 + "%" + "\n" + "Customer's new Total is " + cost * discountPercentage;

    }
}