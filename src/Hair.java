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

    public double costForEachType(Length hairLength) {
        return switch (hairLength) {
            case LONG -> getCost() + 100.0;
            case MEDIUM -> getCost() + 50.0;
            case SHORT -> getCost() + 20;
        };
    }

    public void totalBill() {
        System.out.println(this.getCost());
    }

    public ArrayList<Service> getServices() {
        return services;
    }

    enum Length {
        LONG,
        MEDIUM,
        SHORT
    }

}
