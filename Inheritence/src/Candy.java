/** @author Alexander Leon
 * Class for Candy types. */
public class Candy extends Dessert{
    private final double weightPounds;
    private final double pricePerPound;


    /**
     * Constructs a candy item
     */
    public Candy(String name, double weightPounds, double pricePerPound) {
        super(name);
        this.weightPounds = weightPounds;
        this.pricePerPound = pricePerPound;
    }

    public double getWeightInPounds() {
        return weightPounds;
    }

    public double getPricePerPound() {
        return pricePerPound;
    }

    @Override
    public double getPrice() {
        return weightPounds * pricePerPound;
    }
}
