package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
// BEGIN
import static org.assertj.core.api.Assertions.assertThat;
// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.TRUNCATE_EXISTING);
    }

    // BEGIN
    @Test
    void setTest() {
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of());
        storage.set("key", "value");
        assertThat(storage.get("key", "default")).isEqualTo("value");
    }

    @Test
    void unsetTest() {
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "10"));
        storage.unset("key");
        assertThat(storage.get("key", "def")).isEqualTo("def");
    }

    @Test
    void getTest() {
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key2", "value2"));
        assertThat(storage.get("key2", "def")).isEqualTo("value2");
    }

    @Test
    void toMapTest() {
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key3", "value3"));
        assertThat(storage.toMap()).isEqualTo(Map.of("key3", "value3"));
    }
    // END
}
