/**
 * @Author Steven Briggs
 * @Version 1.0
 * @Date 02-26-21
 * */

package studio.rrprojects.util_library;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class JSONUtil {

    /**
     * Gives a JSONObject given a loaded file.
     *
     * @param file loaded ".json" file
     * @return JSONObject
     */

    public static JSONObject loadJsonFromFile(File file) {
        InputStream is = null;

        try {
            is = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        JSONTokener token = new JSONTokener(is);

        return new JSONObject(token);
    }

    /**
     * takes a JSONObject and writes it to the given file with PrettyPrint
     *
     * @param jsonObject JSONObject to write to a file
     * @param file File to write the JSONObject to
     */

    public static void WriteJsonToFile(JSONObject jsonObject, File file) {
        FileWriter writer = null;

        try {
            writer = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        jsonObject.write(writer, 2, 1); //Non-zero values give PrettyPrint

        try {
            assert writer != null;
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * I don't like that fact that the JSONObject.toMap() function outputs a <String, Object> HashMap
     * So I made one myself, with blackjack and hookers
     *
     * @param jsonObject input JSONObject
     * @return Map<String, JSONObject>
     */
    public static Map<String, JSONObject> JsonToMap(JSONObject jsonObject) {

        Map<String, JSONObject> myMap = new HashMap<>();
        Map<String, Object> tmpMap = jsonObject.toMap();

        tmpMap.forEach((key, value) -> {
            myMap.put(key, jsonObject.getJSONObject(key));
        });

        return myMap;
    }
}
