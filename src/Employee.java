public class Employee extends Salon {
    private static int employeeIdCounter = 1000;
    public int employeeId;

    public Employee() {
        //shouldnt always be used since the system can be used by old employee
    }

    public Employee(String name) {
    }

    public Employee(String name, String email, String phone, String address) {
        super(name, email, phone, address);
        this.employeeId = ++employeeIdCounter;
    }

    public static void displayAppointment() {
        if (Customer.getAppointments().size() == 0) {
            System.out.println("No appointments for today. You can have the day off :)");
            return;
        }
        for (Appointment appointment: Customer.getAppointments()) {
            String header = "=".repeat(20) + " [ " + appointment.getId() + " ] " + "=".repeat(20);
            System.out.println(header);
            System.out.println(appointment);
            appointment.printServices();
            System.out.println("=".repeat(header.length()));
        }
    }

    public static void displayBill(String number) {
        for (Appointment appointment : Customer.getAppointments()) {
            if (appointment.getCustomer().getPhone().equals((number))) {
                appointment.getAppointment();
            }
        }
    }

    public static double offerDiscount(double discountPercentage, String number, double cost) {
        for (Appointment appointment : Customer.getAppointments()) {
            if ((appointment.getPhone().equals((number)))) {
                return discountPercentage * cost;
            }
        }
        return cost;
    }
}
