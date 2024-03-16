/** @author Alexander Leon
 * Class for Sundae types. */
public class Sundae extends IceCream{
    // Stores the topping dessert for the sundae
    private final Dessert topping;
    /**
     * Constructs a new Sundae item
     */
    public Sundae(IceCream iceCream, Dessert topping) {
        super(iceCream.getName() + " topped with " + topping.getName(),
                iceCream.getPrice() + topping.getPrice());
        this.topping = topping;
    }
}
