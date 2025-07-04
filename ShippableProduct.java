public class ShippableProduct extends Product{
    double Weight;

    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.Weight = weight;
    }

    double getWeight(){
        return Weight;
    }
    
}
