package com.example.springfolderapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class FolderService {

    private List<Folder> folders = new ArrayList<>();

    public Optional<Folder> getFolderById(UUID id) {
        return folders.stream()
                .filter(folder -> folder.getId().equals(id))
                .findFirst();
    }

    public List<Folder> getAllFolders() {
        return new ArrayList<>(folders);
    }

    public Folder addFolder(String name) {
        Folder folder = new Folder(UUID.randomUUID(), name);
        folders.add(folder);
        return folder;
    }

    public void deleteFolderById(UUID id) {
        folders.removeIf(folder -> folder.getId().equals(id));
    }

}