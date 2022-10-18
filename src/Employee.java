public class Employee extends Salon {
    public int employeeId;
    private static int employeeIdCounter = 1000;

    public Employee() {
        this.employeeId = ++employeeIdCounter;
    }

    public Employee(String name) {}

    public Employee(String name, String email, String phone, String address) {
        super(name, email, phone, address);
        this.employeeId = ++employeeIdCounter;
    }

    public static void displayAppointment() {

    }

    public void displayBill(Customer c) {


    }

    public double offerDiscount(double discountPercentage, double totalBill) {
        return 0;
    }

    @Override
    public String toString() {
        String sd = super.toString();
        return "Employee{" +
                "employeeId=" + employeeId +
                '}' + sd;
    }
}
