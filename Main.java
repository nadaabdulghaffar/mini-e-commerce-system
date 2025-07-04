public class Main {
    public static void main(String[] args) {
        Product Table = new Product("Table", 10.0, 5);
        ExpirableProduct ExpriedMilk = new ExpirableProduct("Milk", 2.5, 10, "2023-10-31T23:59:59");
        ExpirableProduct Bread = new ExpirableProduct("Bread", 1.5, 20, "2025-8s-30T23:59:59");
        ShippableProduct Laptop = new ShippableProduct("Laptop", 999.99, 2, 2.5);

        Customer customer = new Customer(1000);

        customer.addToCart(Table, 2);
        // customer.addToCart(ExpriedMilk, 1);
        customer.addToCart(Bread, 3);
        customer.addToCart(Laptop, 1);
        customer.Checkout();
     
    }
}
