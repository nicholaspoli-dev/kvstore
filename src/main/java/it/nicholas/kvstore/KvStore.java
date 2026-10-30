package it.nicholas.kvstore;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class KvStore {

    private final Path path;

    public KvStore (Path path) {
        this.path = path;
    }

    public void put(String key, String value) throws IOException {
        // scrivere su un file "data.db" una riga nel formato
        // "P chiave=valore"

        Files.write(
                path,
                List.of("P " + key + "=" + value),
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        );
    }

    public String get(String key) throws IOException {

        if (!Files.exists(path)) {
            return null;
        }

        List<String> lines = Files.readAllLines(
                path,
                StandardCharsets.UTF_8
        );

        String value = null;

        for(int i = 0; i < lines.size(); i++) {
            String[] slices = lines.get(i).split(" ", 2);
            String[] pair = slices[1].split("=", 2);

            if (pair[0].equals(key)) {
                value = pair[1];
            }
        }
        return value;
    }
}
