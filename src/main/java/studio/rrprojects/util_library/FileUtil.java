/**
 * @Author Steven Briggs
 * @Version 1.0
 * @Date 02-26-21
 * */

package studio.rrprojects.util_library;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class FileUtil {

    /**
     *  Loads a file from a given string path.
     *  Will not attempt to create directories
     *
     * @param path The complete string path to a file - example - "/home/user/Documents/Test/Library/Testing.txt"
     * @return this file
     */
    public static File loadFileFromPath(String path) {
        File file = new File(path);

        if (!file.exists()) {
            System.out.println("FileUtil - " + path + " does not exist, attempting to create");
            try {
                if (file.createNewFile()) {
                    System.out.println("FileUtil - " + path + " created successful");
                }
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        return file;
    }

    public static File loadFileFromResource(String path) throws URISyntaxException {
        InputStream is = FileUtil.class.getResourceAsStream(path);
        printInputStream(is);

        System.out.println("getResource: " + path);
        File file = getFileFromResource(path);
        printFile(file);

        return file;
    }

    public static JSONObject getJsonFromResource(String path) {
        InputStream is = FileUtil.class.getResourceAsStream(path);

        if (is == null) {
            DebugUtils.ErrorMsg("INPUT STREAM IS NULL: " + path);
            return null;
        }

        JSONTokener token = new JSONTokener(is);

        return new JSONObject(token);
    }

    // print input stream
    private static void printInputStream(InputStream is) {

        try (InputStreamReader streamReader =
                     new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // print a file
    private static void printFile(File file) {

        List<String> lines;
        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static File getFileFromResource(String fileName) throws URISyntaxException {

        ClassLoader classLoader = FileUtil.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {

            // failed if files have whitespaces or special characters
            //return new File(resource.getFile());

            return new File(resource.toURI());
        }

    }

    /**
     *  Loads a creates all subdirectories along a given path
     *
     * @param dirPath The complete string path to a a directory- example - "/home/user/Documents/Test/Library"
     */

    public static void CreateDir(String dirPath) {
        File file = new File(dirPath);

        if (file.mkdirs()) {
            System.out.println("FileUtil - " + dirPath + " does not exist, attempting to create");
        }
    }

    /**
     *  Loads a creates all subdirectories along a given path, then loads the file in the directory, creating it as needed
     *
     * @param dirPath The complete string path to a directory - example - "/home/user/Documents/Test/Library"
     * @param fileName Name of the final in the indicated directory - example "Testing.txt" 
     */

    public static void createDirAndLoadFile(String dirPath, String fileName) {
        CreateDir(dirPath);
        
        String filepath = dirPath + File.separator + fileName;
        
        loadFileFromPath(filepath);
    }
}
