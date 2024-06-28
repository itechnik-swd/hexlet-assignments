package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {

    private String path;
    private Map<String, String> database;

    public FileKV(String path, Map<String, String> database) {
        this.path = path;
        this.database = new HashMap<>(database);
        Utils.writeFile(path, Utils.serialize(database));
    }

    @Override
    public void set(String key, String value) {
        Map<String, String> data = Utils.unserialize(Utils.readFile(path));
        data.put(key, value);
        Utils.writeFile(path, Utils.serialize(data));
    }

    @Override
    public void unset(String key) {
        Map<String, String> data = Utils.unserialize(Utils.readFile(path));
        data.remove(key);
        Utils.writeFile(path, Utils.serialize(data));
    }

    @Override
    public String get(String key, String defaultValue) {
        Map<String, String> data = Utils.unserialize(Utils.readFile(path));
        return data.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        Map<String, String> data = Utils.unserialize(Utils.readFile(path));
        return new HashMap<>(data);
    }
}
// END
