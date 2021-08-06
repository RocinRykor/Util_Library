/**
 * @Author Steven Briggs
 * @Version 1.0
 * @Date 02-26-21
 * */

package studio.rrprojects.util_library;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.util.ArrayList;
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

    /**
     * Based on the way I set up my json files, I someimes want to just have a nice list of all the objects
     * This returns all the first level objects in the file as a <JSONObject> ArrayList
     *
     * @param jsonObject input JSONObject
     * @return ArrayList<JSONObject>
     */
    public static ArrayList<JSONObject> JsonToArrayList(JSONObject jsonObject) {

        ArrayList<JSONObject> myList = new ArrayList<>();
        Map<String, Object> tmpMap = jsonObject.toMap();

        tmpMap.forEach((key, value) -> {
            myList.add(jsonObject.getJSONObject(key));
        });

        return myList;
    }

    /**
     * MinimalJson has a nice built in defaulter for the get function if the key is not present, this recreates that for org.json
     * String Version
     *
     * @param object input JSONObject
     * @param searchKey String the key you are looking for
     * @param defaultsTo String if the key is not present, default to this string
     * @return String
     */
    public static String getString(JSONObject object, String searchKey, String defaultsTo) {
        String result;

        try {
            result = object.getString(searchKey);
        } catch (Exception e) {
            result = defaultsTo;
        }
        return result;
    }

    /**
     * MinimalJson has a nice built in defaulter for the get function if the key is not present, this recreates that for org.json
     * int Version
     *
     * @param object input JSONObject
     * @param searchKey String the key you are looking for
     * @param defaultsTo int if the key is not present, default to this int
     * @return int
     */
    public static int getInt(JSONObject object, String searchKey, int defaultsTo) {
        int result;

        try {
            result = object.getInt(searchKey);
        } catch (Exception e) {
            result = defaultsTo;
        }
        return result;
    }

    /**
     * MinimalJson has a nice built in defaulter for the get function if the key is not present, this recreates that for org.json
     * Boolean Version
     *
     * @param object input JSONObject
     * @param searchKey String the key you are looking for
     * @param defaultsTo boolean if the key is not present, default to this boolean
     * @return boolean
     */
    public static boolean getBool(JSONObject object, String searchKey, boolean defaultsTo) {
        boolean result;

        try {
            result = object.getBoolean(searchKey);
        } catch (Exception e) {
            result = defaultsTo;
        }
        return result;
    }
}
