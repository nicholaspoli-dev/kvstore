package it.nicholas.kvstore;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        KvStore k = new KvStore(Path.of("data.db"));
        k.put("nome", "Luca");
        KvStore k2 = new KvStore(Path.of("data.db"));
        k2.put("nome", "Mario");
    }
}
