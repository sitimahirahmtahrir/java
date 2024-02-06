package com.example.springfolderapp;

public class File {

    private UUID id;
    private String name;
    private String content;

    public File(UUID id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}