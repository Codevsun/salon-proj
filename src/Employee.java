import java.util.ArrayList;

public class Employee extends Salon {
    public int employeeId;
    private static int employeeIdCounter = 1000;

    public Employee() {
        //shouldnt always be used since the system can be used by old employee
        }

    public Employee(String name) {}

    public Employee(String name, String email, String phone, String address) {
        super(name, email, phone, address);
        this.employeeId = ++employeeIdCounter;
    }

    public static void displayAppointment() {
        System.out.println(Customer.getAppointments()); //is it working ?
    }

    public static void displayBill(String number) {
        for (Appointment appointment: Customer.getAppointments()) {
            if ((appointment.getPhone().equals((number)))){
                appointment.getAppointment();
            }
    }}

    public static double offerDiscount(double discountPercentage, String number) {
        for (Appointment appointment : Customer.getAppointments()) {
            if ((appointment.getPhone().equals((number)))) {
                return discountPercentage;
            }
        }
        return discountPercentage;
    }
}
