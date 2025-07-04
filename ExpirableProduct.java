import java.time.LocalTime;

public class ExpirableProduct extends Product {
    String ExpirationDate;

    public ExpirableProduct(String name, double price, int quantity, String expirationDate) {
        super(name, price, quantity);
        this.ExpirationDate = expirationDate;
    }

    public String getExpiratinDate() {
        return ExpirationDate;
    }

    public boolean isExpired() {
        LocalTime currentTime = LocalTime.now();
        LocalTime expirationTime = LocalTime.parse(ExpirationDate);
        return currentTime.isAfter(expirationTime);

    }
}
