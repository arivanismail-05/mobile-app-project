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

    public String getImageUrl() {
        if (category.contains("Home")) return "https://images.icon-icons.com/362/PNG/512/Home_36756.png";
        if (category.contains("Work")) return "https://images.icon-icons.com/259/PNG/128/ic_work_128_28755.png";
        if (category.contains("Restaurant")) return "https://images.icon-icons.com/548/PNG/512/1455554772_line-68_icon-icons.com_53366.png";
        if (category.contains("Shopping")) return "https://images.icon-icons.com/281/PNG/256/Shopping-icon_30277.png";
        if (category.contains("Travel")) return "https://images.icon-icons.com/1363/PNG/512/travel-holiday-vacation-328_89069.png";
        if (category.contains("Hospital")) return "https://images.icon-icons.com/2227/PNG/512/hospital_health_clinic_urban_buildings_medical_icon_134527.png";
        if (category.contains("Fun")) return "https://images.icon-icons.com/810/PNG/512/clapperboard_cinema_icon-icons.com_66131.png";
        return "https://images.icon-icons.com/810/PNG/512/clapperboard_cinema_icon-icons.com_66131.png";
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