import java.util.ArrayList;

public class Appointment extends Customer {
    private static ArrayList<Service> serviceArrayList = new ArrayList<>();


    public Appointment() {
    }

    public Appointment(String name, String email, String phone, String address, String customerId, ArrayList<Service> serviceArrayList) {
        super(name, email, phone, address, customerId);
        Appointment.serviceArrayList = serviceArrayList;

    }

    public static ArrayList<Service> getServicesArrayList() {
        return serviceArrayList;
    }

    @Override
    public String toString() {
//        return "Appointment{" +
//                "servicesArrayList=" + servicesArrayList +
//                '}';
        return "Name: " + this.getName() +
                "\nEmail: " + this.getEmail() +
                "\nPhoneNumber: " + this.getPhone() +
                "\nAddress: " + this.getAddress() +
                "\nCustomer ID: " + getCustomerId() +
                "\nAppointment: \n" + serviceArrayList.toString();
    }

//    public String toSString(Appointment appointment) {
//        return "Name\n:" + appointment.getName()
//                + "Email:\n" + appointment.getEmail() +
//                "PhoneNumber\n" + appointment.getPhone() + "" +
//                "Address\n" + appointment.getAddress() +
//                "Customer ID\n" + getCustomerId();
//
//    }


}
