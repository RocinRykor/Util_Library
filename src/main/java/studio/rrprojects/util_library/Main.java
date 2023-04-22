package studio.rrprojects.util_library;

import org.json.JSONObject;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        //TestFunction();
    }

    private static void TestFunction() {
        String dirPath = System.getProperty("user.home") + File.separator + "Documents" + File.separator + "Test" + File.separator;
        String inputFileName = "input.json";
        String outputFileName = "output.json";

        JSONObject object = JSONUtil.loadJsonFromFile(FileUtil.loadFileFromPath(dirPath + inputFileName));

        JSONUtil.WriteJsonToFile(object, FileUtil.loadFileFromPath(dirPath + outputFileName));
    }
}
