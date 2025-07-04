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
        if (quantity > item.getQuantity()) {
            throw new IllegalArgumentException("Item: " + item.getName()+ " Available Quntity is less than requested quantity");
        }
        if (item instanceof ExpirableProduct) {
            ExpirableProduct expirableItem = (ExpirableProduct) item;
            if (expirableItem.isExpired()) {
                throw new IllegalArgumentException("Item: " + expirableItem.getName() + " is expired");
            }

    
        CartItem cartItem = new CartItem(item, quantity);
        items.add(cartItem);
        }
    }
    
    public List<CartItem> getItems() {
        return items;
    }
}
