package studio.rrprojects.util_library;

public class DebugUtils {

    /**
     *  returns a random Integer within two values
     *
     * @param color Uses escape code colors
     * @param message Message to be displayed
     * @return Outputs a message to the console using escape code colors, for best results use ConsoleColors.class
     *
     */

    public static void newDebugOut(String color, String message) {

        System.out.println(color + message + ConsoleColors.RESET);

    }
}
