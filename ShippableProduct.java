public class ShippableProduct extends Product{
    double Weight;

    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.Weight = weight;
    }

    double getWeight(){
        return Weight;
    }
    
    double getShippingCost() {
        double shippingRate = 2.7; //Assuming shipping rate per kg
        return Weight * shippingRate;
    }
}
