/**
 * CS1331 HW7.
 * @author Tri Le
 * @version 11/14/2022
 */
//uncheck exception.
public class NegativeQuantityException extends RuntimeException {
    /**
     * This method help to check if the input in text field is a positive value or not.
     * @param quantity the quantity of hamburger, hot dog, pizza,
     * or french fries.
     */
    public NegativeQuantityException(String quantity) {
        super("Quantity '" + quantity + "' is not positive.");
    }
}