import java.util.ArrayList;
import java.util.List;
public class Cart {
    List<CartItem> items = new ArrayList<>();

    public void addItem(Product item, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        CartItem cartItem = new CartItem(item, quantity);
        items.add(cartItem);
    }
    
    public List<CartItem> getItems() {
        return items;
    }
}
