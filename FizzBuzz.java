/**
 * A class that prints the numbers from 1 to the limit (including the limit
 * value), each on a separate line, replacing the multiples of the first and
 * second arguments with "Fizz", "Buzz", or "FizzBuzz" as appropriate.
 * @author Alexander Leon
 */
public class FizzBuzz {
    /**
     * The main method expects three command line arguments. The first argument
     * will be the upper limit for the numbers to print, the second argument
     * will be the number whose multiples will be replaced with "Fizz", and the
     * third argument will be the number whose multiples will be replaced by
     * "Buzz". Numbers that are multiples of both the second and third argument
     * will be replaced by "FizzBuzz".
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        // Error checking if there are exactly three arguments
        if (args.length != 3) {
            System.out.println("Expected 3 arguments. Please provide three" +
				"arguments: limit, Fizz and Buzz");
        } else {
            int upperLimit = Integer.parseInt(args[0]);
            int fizzNumber = Integer.parseInt(args[1]);
            int buzzNumber = Integer.parseInt(args[2]);

            for (int i = 1; i <= upperLimit; i++) {
                if (i % fizzNumber == 0 && i % buzzNumber == 0) {
                    System.out.println("FizzBuzz");
                } else if (i % fizzNumber == 0) {
                    System.out.println("Fizz");
                } else if (i % buzzNumber == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println(i);
                }
            }
        }
    }
}