package me.partlysunny.sunbeam.util;

import com.google.common.base.Preconditions;

import java.io.InputStream;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public final class Files {

    public static void copy(String source, String destination, StandardCopyOption copyOption) {
        Preconditions.checkNotNull(source, "source cannot be null");
        Preconditions.checkNotNull(destination, "destination cannot be null");
        try (InputStream in = Files.class.getResourceAsStream(source)) {
            if (in == null) {
                throw new IllegalArgumentException("source file not found: " + source);
            }
            java.nio.file.Files.copy(in, Paths.get(destination), copyOption);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void copy(String source, String destination) {
        copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
    }

    public static void delete(String path) {
        Preconditions.checkNotNull(path, "path cannot be null");
        try {
            java.nio.file.Files.deleteIfExists(Paths.get(path));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Files() {
        throw new AssertionError("Cannot instantiate Files");
    }

}
