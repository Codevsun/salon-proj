import java.util.ArrayList;

public class Hair extends Service {
    private final ArrayList<Service> services = new ArrayList<>();

    public Hair() {
    }

    public static double hairServicesCost(int choice) {
        return switch (choice) {
            case 1 -> 120;
            case 2, 5 -> 100;
            case 3 -> 200;
            case 4 -> 50;
            default -> 0;
        };
    }

    public ArrayList<Service> getServices() {
        return services;
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

    public double costForEachType(Length hairLength) {
        return switch (hairLength) {
            case LONG -> getCost() + 100.0;
            case MEDIUM -> getCost() + 50.0;
            case SHORT -> getCost() + 20;
        };
    }


    enum Length {
        LONG,
        MEDIUM,
        SHORT
    }

}
