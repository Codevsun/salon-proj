import java.util.ArrayList;

public class Hair extends Service {
    private final ArrayList<Service> services = new ArrayList<>();

    public Hair() {
    }

    public void displayMenu() {
        System.out.println("""
                1.Blow dry
                2.HairStyle
                3.Retro
                4.Haircut
                5.Hair Dye
                6.Treatment""");
    }

    public double costForEachType(String hairLength) {
        return switch (hairLength) {
            case "Long" -> getCost() + 100.0;
            case "Medium" -> getCost() + 50.0;
            case "Short" -> getCost() + 20;
            default -> 0;
        };
    }

    public void totalBill() {
        System.out.println(this.getCost());
    }

    public ArrayList<Service> getServices() {
        return services;
    }

}
