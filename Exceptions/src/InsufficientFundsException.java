/**@author Alexander Leon
 * This class extends Exception to throw a checked exception.
 * This exception is to avoid withdrawing more money than is in the account.
 */
public class InsufficientFundsException extends Exception{
    private double shortfall;

    /** Constructor that takes the amount of the shortfall and stores it in a
     * member variable.
     * @param shortfall
     */
    public InsufficientFundsException (double shortfall){
        super("You need more money!");
        this.shortfall = shortfall;
    }

    /** Method to access the shortfall amount given in the constructor
     * @return shortfall
     */
    public double getShortfallAmount(){
        return shortfall;
    }
}
