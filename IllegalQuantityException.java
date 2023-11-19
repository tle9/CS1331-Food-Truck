/**
 * CS1331 HW7.
 * @author Tri Le
 * @version 11/14/2022
 */
//checked excepton.
public class IllegalQuantityException extends Exception {
    /**
     * This method help to check if the input in text field is a number or not.
     * @param quantity the quantity of hamburger, hot dog, pizza,
     * or french fries.
     */
    public IllegalQuantityException(String quantity) {
        super("Quantity '" + quantity + "' is not a number.");
    }
}