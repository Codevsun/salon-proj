import java.util.ArrayList;
import java.util.UUID;

public class Customer extends Salon {

    private static ArrayList<Appointment> appointments = new ArrayList<>();
//    String uniqueID = UUID.randomUUID().toString();
    private final String customerId;

    public Customer() {
        this.customerId = UUID.randomUUID().toString();
    }

    public Customer(String name, String email, String phone, String address) {
        super(name, email, phone, address);
        this.customerId = UUID.randomUUID().toString();
    }

    public static ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public static void setAppointments(ArrayList<Appointment> appointments) {
        Customer.appointments = appointments;
    }

    public static void printAppointment(Appointment appointment) {
        System.out.println(getAppointments());
    }

    public static void bookAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public String getCustomerId() {
        return customerId;
    }

    public Appointment getAppointment() {
        for (Appointment appointment : appointments) {
            if (appointment.getCustomer().equals(this)) {
                return appointment;
            }
        }
        return null;
    }

    public void editAppointment(int choice, String name, String email, String phoneNumber, String address) {
        for (Appointment appointment : appointments) {
            System.out.println(appointment.getCustomer().equals(this));
            if (appointment.getCustomer().equals(this)) {
                System.out.println("editAppointment got choice set to " + choice);
                switch (choice) {
                    case 1 -> {
                        if (name.isBlank()) {
                            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                            return;
                        }
                        System.out.println("Old: " + getName());
                        setName(name);
                        System.out.println("New: " + getName());
                    }
                    case 2 -> {
                        if (email.isBlank())
                            return;
                        setEmail(email);
                    }
                    case 3 -> {
                        if (phoneNumber.isBlank())
                            return;
                        setPhone(phoneNumber);
                    }
                    case 4 -> {
                        if (address.isBlank())
                            return;
                        setAddress(address);
                    }
                    default -> {
                        return;
                    }
                }

            }

        }


    }

    public void cancelAppointment() {
        for (Appointment appointment : appointments) {
            if (appointment.getCustomerId().equals(this.customerId)) {
                appointments.remove(appointments);
            }
        }
    }


}


