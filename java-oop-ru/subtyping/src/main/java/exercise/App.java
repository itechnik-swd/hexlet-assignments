package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> originalMap = storage.toMap();
        Set<Map.Entry<String, String>> entries = originalMap.entrySet();

        for (Map.Entry<String, String> entry : entries) {
            storage.unset(entry.getKey());
        }
        for (Map.Entry<String, String> entry : originalMap.entrySet()) {
            storage.set(entry.getValue(), entry.getKey());
        }
    }
}
// END
