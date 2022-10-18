import java.util.ArrayList;
import  java.util.UUID;
public class Customer extends Salon {

    String uniqueID = UUID.randomUUID().toString();

    private String customerId =  uniqueID ;

    private static ArrayList<Appointment> appointments = new ArrayList<>();

    public static ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public static void setAppointments(ArrayList<Appointment> appointments) {
        Customer.appointments = appointments;
    }
        public static void printAppointment(Appointment appointment){
            System.out.println(getAppointments());
        }
    public Customer(){}

    public Customer(String name, String email, String phone, String address, String customerId) {
        super(name, email, phone, address);
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }
    public static void bookAppointment (Appointment appointment) {
        appointments.add(appointment);
    }

    public Appointment getAppointment() {
        for (Appointment appointment: appointments) {
            if (appointment.getCustomerId().equals(this.customerId)) {
                return appointment;
            }
        }
        return null;
    }

    public void editAppointment  (){}
    public void cancelAppointment(){}

}
