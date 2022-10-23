import java.util.ArrayList;

public class Nails extends Service {
    private ArrayList<Service> services = new ArrayList<Service>() ;

    public Nails(ArrayList<Service> services) {
        this.services = services;
    }

    public Nails() {}

    public void displayMenu(){
        System.out.println("""
                1.Pedicure"\040
                2.Manicure
                3.Nail Art
                4.Nails color""");
    }
    public static double nailsServiceCost(int choice) {
        return switch (choice) {
            case 1 -> 70;
            case 2 -> 200;
            case 3 -> 230;
            case 4, 5 -> 50;
            default -> 0;
        };
    }

    public ArrayList<Service> getServices() {
        return services;
    }
}
