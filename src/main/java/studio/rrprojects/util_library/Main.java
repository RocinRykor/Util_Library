package studio.rrprojects.util_library;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String[] testWords = {"hourglass", "ant", "dinosaur", "bottle of coke"};

        for (String testWord : testWords) {
            System.out.println(TextUtils.getIndefiniteArticle(testWord) + " " + testWord);
        }

    }
}
