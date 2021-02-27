/**
 * @Author Steven Briggs
 * @Version 1.0
 * @Date 02-26-21
 * */

package studio.rrprojects.util_library;

public class MathUtil {

    /**
     *  returns a random Integer within two values
     *
     * @param min Minimum value
     * @param max Maximum value
     * @return random value between min and max. If min > max, returns min
     *
     */
    
    public static int getRandomRange(int min, int max) {

        if (min > max) {
            System.out.println("Math Util - ERROR - Minimum value exceeds maximum value");
            return min;
        }

        return (int) ((Math.random() * (1 + max-min)) + min);
    }
}
