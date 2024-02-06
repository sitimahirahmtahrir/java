package com.example.springfolderapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Optional;
import java.util.UUID;

public class FileServiceTest {

    private FileService fileService = new FileService();

    @Test
    public void testAddFile() {
        Optional<File> file = fileService.getFileById(UUID.fromString("123e4567-e89b-12d3-a456-426614174000"));
        assertTrue(file.isEmpty());

        File newFile = fileService.addFile("Test File", "This is a test file.");
        assertEquals("Test File", newFile.getName());

        Optional<File> savedFile = fileService.getFileById(newFile.getId());
        assertTrue(savedFile.isPresent());
        assertEquals("Test File", savedFile.get().getName());
        assertEquals("This is a test file.", savedFile.get().getContent());
    }

    @Test
    public void testGetFileById() {
        File file = fileService.addFile("Test File", "This is a test file.");

        Optional<File> savedFile = fileService.getFileById(file.getId());
        assertTrue(savedFile.isPresent());
        assertEquals("Test File", savedFile.get().getName());
        assertEquals("This is a test file.", savedFile.get().getContent());

        Optional<File> emptyFile = fileService.getFileById(UUID.randomUUID());
        assertTrue(emptyFile.isEmpty());
    }

    @Test
    public void testGetAllFiles() {
        File file1 = fileService.addFile("Test File 1", "This is a test file 1.");
        File file2 = fileService.addFile("Test File 2", "This is a test file 2.");

        List<File> files = fileService.getAllFiles();
        assertEquals(2, files.size());

        assertTrue(files.contains(file1));
        assertTrue(files.contains(file2));
    }

    @Test
    public void testDeleteFileById() {
        File file = fileService.addFile("Test File", "This is a test file.");

        fileService.deleteFileById(file.getId());

        Optional<File> deletedFile = fileService.getFileById(file.getId());
        assertTrue(deletedFile.isEmpty());
    }

}