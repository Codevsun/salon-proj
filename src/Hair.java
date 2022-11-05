import java.util.ArrayList;
import java.util.Collections;

public class Hair extends Service {
    private final ArrayList<String> services = new ArrayList<>();

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

    public ArrayList<String> getServices() {
        return services;
    }

    public void print(String title) {
        String[] hairServiceNames = {"Blow dry", "Hairstyle", "Retro", "Haircut", "Hair dye", "Treatment"};
        Collections.addAll(services, hairServiceNames);
        int i = 0;
        System.out.println("------------------------------------------------------------------------------------"
                + title +
                "------------------------------------------------------------------------------------");
        for (String s : services) {
            System.out.println(i + 1 + ". " + s);
            i++;
        }
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
