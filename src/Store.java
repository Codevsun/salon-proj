import java.util.ArrayList;

public class Store {
    private static ArrayList<Store> productsArray = new ArrayList<>();
    private double cost;
    private boolean isAvailable ;
    private String productName;

    public Store(String productName, double cost, boolean isAvailable) {
        this.productName = productName;
        this.cost = cost;
        this.isAvailable = isAvailable;
    }
    public Store(){}
    public static ArrayList<Store> getProductsArray() {
        return productsArray;
    }

    public static void setProductsArray(ArrayList<Store> productsArray) {
        Store.productsArray = productsArray;
    }

    public double getCost() {
        return cost;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public static void init() {
        productsArray.add(new Store("X Fine Hair leave- in conditioner", 65, true));
        productsArray.add(new Store("Nourish Daily Shampoo", 49.99, true));
        productsArray.add(new Store("Giovanni Curls Cream", 35.99, true));
        productsArray.add(new Store("Giovanni Gel", 20, true));
        productsArray.add(new Store("Promi Hair spray", 43.57, true));
        productsArray.add(new Store("GirlsNight cream", 139.23, true));
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }



    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

     public void addNewProduct(Store newProduct) {
         productsArray.add(newProduct);
     }

    public void productAvailability(String productName2, Boolean isAvailable) {
        if(productName2.equals(this.productName)){
            setAvailable(isAvailable);
        } // employee can edit this
    }
    public void productIfAvailable(ArrayList<Store> productsArray2){
        for(int i = 0 ; i < productsArray2.size();i ++){
            if (this.isAvailable){
                continue;
            }else {
                System.out.println("Sorry this item is not available at the moment");
                break;
            }
        }
    }


    @Override
    public String toString() {
        if (isAvailable){
        return productName +"\n"+
                "Price:  " + cost ;
        }
    return null;
}
}
