/** @author Alexander Leon
 * Class for Cookie types. */
public class Cookie extends Dessert{
    private final int countOfCookies;
    private final double pricePerDozen;

    /**
     * Constructs a new cookie item
     */
    public Cookie(String name, int countOfCookies, double pricePerDozen) {
        super(name);
        // Initialize the numberOfCookies attribute
        this.countOfCookies = countOfCookies;
        // Initialize the pricePerDozen attribute
        this.pricePerDozen = pricePerDozen;
    }

    @Override
    public double getPrice() {
        return (countOfCookies / 12.0) * pricePerDozen;
    }

    public int getItemCount() {
        return countOfCookies;
    }

    public double getPricePerDozen() {
        return pricePerDozen;
    }

}
