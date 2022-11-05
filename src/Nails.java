import java.util.ArrayList;
import java.util.Collections;

public class Nails extends Service {
    private final ArrayList<String> services = new ArrayList<>();


    public Nails() {
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

    public ArrayList<String> getServices() {
        return services;
    }

    public void print(String nail_title) {
        String[] nailsServiceNames = {"Pedicure", "Manicure", "Nails Art", "Hand Nails Color", "Foot Nails Color"};
        Collections.addAll(services, nailsServiceNames);
        int i = 0;
        System.out.println("------------------------------------------------------------------------------------"
                + nail_title +
                "------------------------------------------------------------------------------------");
        for (String s : services) {

            System.out.println(i + 1 + ". " + s);
            i++;
        }
    }


}
