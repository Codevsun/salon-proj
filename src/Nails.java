import java.util.ArrayList;

public class Nails extends Service {
    private ArrayList<Service> services = new ArrayList<Service>() ;

    public Nails(ArrayList<Service> services) {
        this.services = services;
    }

    public Nails() {}

    public void displayMenu(){
        System.out.println("1.Pedicure" +
                "\n2.Manicure\n" +
                        "3.Nail Art\n" +
                "4.Nails color");
    }
    public double costForEachLength(){return 0;}
    public double totalBill(){return 0;}

    public ArrayList<Service> getServices() {
        return services;
    }
}
