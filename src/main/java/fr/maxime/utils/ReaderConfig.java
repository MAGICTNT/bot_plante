package fr.maxime.utils;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReaderConfig {

    private String filePatch;

    public ReaderConfig(String filePatch) {
        this.filePatch = filePatch;
    }

    public String getFilePatch() {
        return filePatch;
    }

    public void setFilePatch(String filePatch) {
        this.filePatch = filePatch;
    }

    public String returnValueByKey(String key) {
        try (FileReader reader = new FileReader(filePatch)) {
            JSONObject config = new JSONObject(new JSONTokener(reader));
            return config.getString(key);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public ArrayList<Map<String, String>> returnValueByKeyList(String key) {
        ArrayList<Map<String, String>> list = new ArrayList<>();
        try (FileReader reader = new FileReader(filePatch)) {
            JSONObject config = new JSONObject(new JSONTokener(reader));
            if (config.has(key)) {
                JSONObject commandObject = config.getJSONObject(key);
                for (String commandKey : commandObject.keySet()) {
                    Map<String, String> commandMap = new HashMap<>();
                    commandMap.put(commandKey, commandObject.getString(commandKey));
                    list.add(commandMap);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


}
