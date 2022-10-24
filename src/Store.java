import java.util.ArrayList;

public class Store {
    private static final ArrayList<Store> productsArray = new ArrayList<>();
    private double cost;
    private boolean isAvailable;
    private String productName;

    public Store(String productName, double cost, boolean isAvailable) {
        this.productName = productName;
        this.cost = cost;
        this.isAvailable = isAvailable;
    }

    public Store() {
    }

    public static ArrayList<Store> getProductsArray() {
        return productsArray;
    }

    public static void init() {
        productsArray.add(new Store("X Fine Hair leave- in conditioner", 65, true));
        productsArray.add(new Store("Nourish Daily Shampoo", 49.99, true));
        productsArray.add(new Store("Giovanni Curls Cream", 35.99, true));
        productsArray.add(new Store("Giovanni Gel", 20, true));
        productsArray.add(new Store("Promi Hair spray", 43.57, true));
        productsArray.add(new Store("GirlsNight cream", 139.23, true));
    }

    public double getCost() {
        return cost;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getProductName() {
        return productName;
    }


    public void addNewProduct(Store newProduct) {
        productsArray.add(newProduct);
    }

    public void productAvailability(String productName2, Boolean availableOrNot) {
        Store.productsArray.forEach(product -> {
            if (productName2.equals(product.getProductName())) {
                product.setAvailable(availableOrNot);

            } // employee can edit this
        });
    }

    public boolean productIfAvailable(int index) {
        return getProductsArray().get(index).isAvailable();
    }

    @Override
    public String toString() {
        if (isAvailable) {
            return productName + "\n" +
                    "Price:  " + cost;
        }
        return null;
    }
}
