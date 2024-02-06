package com.example.springfolderapp;

import java.util.UUID;

public class Folder {

    private UUID id;
    private String name;
    private List<File> files;

    public Folder(UUID id, String name) {
        this.id = id;
        this.name = name;
        this.files = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<File> getFiles() {
        return new ArrayList<>(files);
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void removeFile(File file) {
        files.remove(file);
    }

}