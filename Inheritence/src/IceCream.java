/** @author Alexander Leon
 * Class for IceCream types. */
public class IceCream extends Dessert{
    private final double price;
    /**
     * Constructs a new IceCream item
     */
    public IceCream(String name, double price) {
        super(name);
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

}
