import java.util.ArrayList;

public class Store {
    private ArrayList<String> products = new ArrayList<String>();
    private double cost ;
    private boolean isAvailable = false ;

    public void setProducts(ArrayList<String> products) {
        this.products = products;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Store(ArrayList<String> products, double cost) {
        this.products = products;
        this.cost = cost;

    }

    public void menu() {}
    public boolean productAvailbility (){return true    ;}
    public void CalculateBill(){}

}
