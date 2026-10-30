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
}
