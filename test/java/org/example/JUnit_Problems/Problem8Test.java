package org.example.JUnit_Problems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class Problem8Test {

    private static final String TEST_FILE = "testfile.txt";
    private final FileProcessor fileProcessor = new FileProcessor();

    @BeforeEach
    void setup() throws IOException {
        Files.deleteIfExists(Path.of(TEST_FILE)); // Clean up before each test
    }

    @Test
    void testWriteAndReadFromFile() throws IOException {
        String content = "Hello, JUnit!";
        fileProcessor.writeToFile(TEST_FILE, content);

        String readContent = fileProcessor.readFromFile(TEST_FILE);
        assertEquals(content, readContent, "File content should match the written content");
    }

    @Test
    void testFileExistsAfterWriting() throws IOException {
        fileProcessor.writeToFile(TEST_FILE, "Sample Content");
        assertTrue(Files.exists(Path.of(TEST_FILE)), "File should exist after writing");
    }

    @Test
    void testReadFromNonExistentFile() {
        Exception exception = assertThrows(IOException.class, () -> {
            fileProcessor.readFromFile("nonexistent.txt");
        });
        assertTrue(exception.getMessage().contains("nonexistent.txt"));
    }

    @AfterEach
    void cleanup() throws IOException {
        Files.deleteIfExists(Path.of(TEST_FILE)); // Clean up after each test
    }
}
