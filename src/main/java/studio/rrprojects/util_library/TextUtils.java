package studio.rrprojects.util_library;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.text.NumberFormat;
import java.util.Locale;

public class TextUtils {

    /**
     * Converts a given string to title case, i.e., capitalizes the first letter of each word in the string.
     *
     * @param input the string to be converted to title case
     * @return the string in title case
     */
    public static String titleCase(String input) {

        StringBuilder titleCase = new StringBuilder(input.length());
        boolean nextTitleCase = true;

        for (char c : input.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            }

            titleCase.append(c);
        }

        return titleCase.toString();
    }

    /**
     * Shadowrun Specific, converts and integer to a more readable number (separated with commas) and adds the nuyen ¥ symbol to the end
     *
     * @param input Integer
     * @return String formatted and with currency symbol on the back
     */
    public static String IntToNuyen(int input) {
        //¥
        NumberFormat numberFormat = NumberFormat.getNumberInstance(new Locale("en_US"));
        return numberFormat.format(input) + "¥";
    }

    /**
     * Changes all underscores in a string to spaces
     *
     * @param input String with underscores
     * @return Outputs a String with spaces instead of underscores
     */
    public static String convertUnderscoreToSpace(String input) {
        return input.replaceAll("_", " ");
    }


    /**
     * Returns the approprate indefinate article ("a" or "an") for a given string
     *
     * @param string
     * @return string
     */
    public static String getIndefiniteArticle(String word) {
        // Check if the word starts with a vowel sound
        if (startsWithVowelSound(word)) {
            return "an";
        } else {
            return "a";
        }
    }

    private static boolean startsWithVowelSound(String word) {
        // Convert word to lowercase for case-insensitive comparison
        String lowerCaseWord = word.toLowerCase();

        // Check if the word starts with a vowel sound
        return lowerCaseWord.matches("^(e[aeiou]|h(ono?|our)|onc?e|uni(l|que)|u[bcfhkrst]?|yt)|[aeio]|([aeiou].*)");
    }

    public static void CenterPaneText(JTextPane textPane) {
        //I don't know exactly how this works yet, but it does so that's all that matters
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
    }
}
