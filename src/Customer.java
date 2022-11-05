import java.util.ArrayList;
import java.util.UUID;

public class Customer extends User {

    private static final ArrayList<Appointment> appointments = new ArrayList<>();

    private final String customerId;

    public Customer() {
        this.customerId = UUID.randomUUID().toString();
    }


    public static ArrayList<Appointment> getAppointments() {
        return appointments;
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
            if (appointment.getCustomer().equals(this)) {
                switch (choice) {
                    case 1 -> {
                        if (name.isBlank()) {
                            return;
                        }
                        setName(name);
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
        getAppointments().remove(getAppointment());
    }

}


