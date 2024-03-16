/**@author Alexander Leon
 * This class have a constructor for a bank account. It also allows to put
 * money in and take money out of the bank account.
 */
public class BankAccount {
    private int bankAccountNumber;
    private double balance;

    /**
     * This constructor takes an bankAccountNumber and sets initial balance
     * to zero.
     * @param bankAccountNumber
     */
    public BankAccount(int bankAccountNumber){
        this.bankAccountNumber = bankAccountNumber;
        this.balance = 0.0;
    }

    /** Method to get an account number and return it.
     * @return account number
     */
    public int getAccountNumber(){
        return bankAccountNumber;
    }

    /** Method to get the current account balance and return it.
     * @return balance
     */
    public double getBalance(){
        return balance;
    }

    /** Method that takes an amount and adds it to the current balance.
     * If the amount attempted to deposit is negative, it will throw an
     * IllegalArgumentException.
     * @param amount
     */
    public void depositFunds(double amount) {
        if (amount<0){
            throw new IllegalArgumentException("Attempted to deposit a " +
                    "negative amount: " + amount);
        }
        balance += amount;
    }

    /** Method that takes an amount and subtracts it from the current balance.
     * If the amount attempted to withdraw is greater than the current
     * account balance, this method will throw an InsufficientFundsException.
     * If the amount attempted to deposit is negative, it will throw an
     * IllegalArgumentException.
     * @param amount
     * @throws InsufficientFundsException
     */
    public void withdrawFunds (double amount) throws InsufficientFundsException{
        if(amount>balance) {
            //Checked Exception
            throw new InsufficientFundsException(amount-balance);
        } else if (amount < 0) {
            //Unchecked Exception
            throw new IllegalArgumentException("Attempted to withdraw a " +
                    "negative amount: " + amount);
        } else {
            balance -= amount;
        }
    }
}
