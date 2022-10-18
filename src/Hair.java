import java.util.ArrayList;

public class Hair extends Service {
    private final ArrayList<Service> services = new ArrayList<>();

    public Hair() {
    }

    public void displayMenu() {
        System.out.println("1.Blow dry\n" +
                "2.HairStyle\n" +
                "3.Retro\n" +
                "4.Haircut\n" +
                "5.Hair Dye\n" +
                "6.Treatment");
    }

    public double costForEachType(String hairLength) {
        if (hairLength.equals("Long")) {
            return getCost() + 100.0;
        } else if (hairLength.equals(("Medium"))) {
            return getCost() + 50.0;
        } else if (hairLength.equals("Short")) {
            return getCost() + 20;
        } else return 0;
    }

    public double totalBill() {
        return 0;
    }

    public ArrayList<Service> getServices() {
        return services;
    }

}
