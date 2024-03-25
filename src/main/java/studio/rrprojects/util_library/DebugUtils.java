package studio.rrprojects.util_library;

public class DebugUtils {

    /**
     * returns a System Out Message colored using escape colors
     *
     * @param escapeColor Uses escape code colors
     * @param message     Message to be displayed
     * @return Outputs a message to the console using escape code colors, for best results use ConsoleColors.class
     */

    public static void newDebugOut(String escapeColor, String message) {
        System.out.println(escapeColor + message + ConsoleColors.RESET);
    }

    public static void ErrorMsg(String message) {
        newDebugOut(ConsoleColors.RED, message);
    }

    public static void CautionMsg(String message) {
        newDebugOut(ConsoleColors.YELLOW, message);
    }

    public static void ProgressNormalMsg(String message) {
        newDebugOut(ConsoleColors.GREEN, message);
    }

    public static void VariableMsg(String message) {
        newDebugOut(ConsoleColors.BLUE, message);
    }

    public static void UnknownMsg(String message) {
        newDebugOut(ConsoleColors.PURPLE, message);
    }

    public static void DebugMsg(String message) {
        newDebugOut(ConsoleColors.CYAN, message);
    }


}
