package com.example.geovault.Base;

public class PlaceModel {
    private String title;
    private String location;
    private String category;
    private String note;
    private boolean isVisited;

    public PlaceModel(String title, String location, String category, String note, boolean isVisited) {
        this.title = title;
        this.location = location;
        this.category = category;
        this.note = note;
        this.isVisited = isVisited;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    public boolean isVisited() { return isVisited; }
    public void setVisited(boolean visited) { isVisited = visited; }
}