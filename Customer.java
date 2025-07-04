public class Customer {
    int Balance;
    Cart cart;

    public Customer(int balance) {
        this.Balance = balance;
        this.cart = new Cart();
    }

    public int getBalance() {
        return Balance;
    }

    public void addToCart(Product item, int quantity) {
        cart.addItem(item, quantity);
    }

    public void Checkout() {
        double total = 0;
        double ShippingCost = 0;
        double subtotal = 0;
    
        if (cart.getItems().isEmpty()) {
            throw new IllegalArgumentException("Cart is empty");
        }
        if (Balance <= 0) {
            throw new IllegalArgumentException("Balance must be greater than zero");
        }

        for (CartItem item : cart.getItems()) {
            if (item.Item.quantity > item.Item.getQuantity()) {
                throw new IllegalArgumentException("Item: " + item.Item.getName()+ " Available Quntity is less than requested quantity");
            }
            if (item.Item instanceof ExpirableProduct) {
                ExpirableProduct expirableItem = (ExpirableProduct) item.Item;
                if (expirableItem.isExpired()) {
                    throw new IllegalArgumentException("Item: " + expirableItem.getName() + " is expired and cannot be purchased.");
                }
            }
        
            if (item.Item instanceof ShippableProduct) {
                ShippableProduct shippableItem = (ShippableProduct) item.Item;
                ShippingCost += shippableItem.getShippingCost() * item.Quantity;
            }
            subtotal += item.Item.getPrice() * item.Quantity;
            total += item.Item.getPrice() * item.Quantity;
        }
        if (total > Balance) {
            throw new IllegalArgumentException("Insufficient balance.");
        }
        Balance -= total;
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Shipping Cost: $" + ShippingCost);
        System.out.println("Total: $" + total);
        System.out.println("Remaining Balance: $" + Balance);

    }
}
