/**
 * @Author Steven Briggs
 * @Version 1.0
 * @Date 02-26-21
 * */

package studio.rrprojects.util_library;

import java.io.File;
import java.io.IOException;

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
     * @param dirPath The complete string path to a a directory - example - "/home/user/Documents/Test/Library"
     * @param fileName Name of the final in the indicated directory - example "Testing.txt" 
     */

    public static void createDirAndLoadFile(String dirPath, String fileName) {
        CreateDir(dirPath);
        
        String filepath = dirPath + File.separator + fileName;
        
        loadFileFromPath(filepath);
    }
}
