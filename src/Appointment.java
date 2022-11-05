import java.util.ArrayList;
import java.util.UUID;

public class Appointment extends Customer {
    private final String id = UUID.randomUUID().toString();
    private final ArrayList<Service> serviceArrayList = new ArrayList<>();
    private Customer customer;

    public Appointment() {
    }


    public String getId() {
        return id;
    }

    public ArrayList<Service> getServicesArrayList() {
        return serviceArrayList;
    }

    public void printServices() {
        if (serviceArrayList.size() < 1) {
            System.out.println("Empty array");
            return;
        }
        for (Service service : serviceArrayList) {
            System.out.println("Service(" +
                    "name: " + service.getName() + ", " +
                    "cost: " + service.getCost() + ", " +
                    "stylist name: " + service.getStylistName() + ")");
        }
    }


    @Override
    public String toString() {
        return "Name: " + this.customer.getName() +
                "\nEmail: " + this.customer.getEmail() +
                "\nPhone Number: " + this.customer.getPhone() +
                "\nAddress: " + this.customer.getAddress() +
                "\nCustomer ID: " + getCustomerId();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer newCustomer) {
        this.customer = newCustomer;
    }


}
