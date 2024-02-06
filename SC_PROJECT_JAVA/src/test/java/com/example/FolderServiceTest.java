package com.example.springfolderapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Optional;
import java.util.UUID;

public class FolderServiceTest {

    private FolderService folderService = new FolderService();

    @Test
    public void testAddFolder() {
        Optional<Folder> folder = folderService.getFolderById(UUID.fromString("123e4567-e89b-12d3-a456-426614174000"));
        assertTrue(folder.isEmpty());

        Folder newFolder = folderService.addFolder("Test Folder");
        assertEquals("Test Folder", newFolder.getName());

        Optional<Folder> savedFolder = folderService.getFolderById(newFolder.getId());
        assertTrue(savedFolder.isPresent());
        assertEquals("Test Folder", savedFolder.get().getName());
    }

    @Test
    public void testGetFolderById() {
        Folder folder = folderService.addFolder("Test Folder");

        Optional<Folder> savedFolder = folderService.getFolderById(folder.getId());
        assertTrue(savedFolder.isPresent());
        assertEquals("Test Folder", savedFolder.get().getName());

        Optional<Folder> emptyFolder = folderService.getFolderById(UUID.randomUUID());
        assertTrue(emptyFolder.isEmpty());
    }

    @Test
    public void testGetAllFolders() {
        Folder folder1 = folderService.addFolder("Test Folder 1");
        Folder folder2 = folderService.addFolder("Test Folder 2");

        List<Folder> folders = folderService.getAllFolders();
        assertEquals(2, folders.size());

        assertTrue(folders.contains(folder1));
        assertTrue(folders.contains(folder2));
    }

    @Test
    public void testDeleteFolderById() {
        Folder folder = folderService.addFolder("Test Folder");

        folderService.deleteFolderById(folder.getId());

        Optional<Folder> deletedFolder = folderService.getFolderById(folder.getId());
        assertTrue(deletedFolder.isEmpty());
    }

}