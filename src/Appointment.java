import java.util.ArrayList;
import java.util.UUID;

public class Appointment extends Customer {
    private final String id = UUID.randomUUID().toString();
    private ArrayList<Service> serviceArrayList = new ArrayList<>();
    private Customer customer;
    public Appointment() {
    }

    public Appointment(ArrayList<Service> serviceArrayList, Customer customer) {
        this.serviceArrayList = serviceArrayList;
        this.customer = customer;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Service> getServicesArrayList() {
        return serviceArrayList;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() +
                "\nEmail: " + this.getEmail() +
                "\nPhoneNumber: " + this.getPhone() +
                "\nAddress: " + this.getAddress() +
                "\nCustomer ID: " + getCustomerId() +
                "\nAppointment: \n" + getServicesArrayList();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer newCustomer) {
        this.customer = newCustomer;
    }

    public void setServiceArrayList(ArrayList<Service> serviceArrayList) {
        this.serviceArrayList = serviceArrayList;
    }
}
