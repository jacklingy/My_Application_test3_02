package edu.ncu.myapplication_test3_02;

public class Movie {
    private String name;
    
    private String description;
    
    private int coverId;
    
    public Movie(String name, String description, int coverId) {
        this.name = name;
        this.description = description;
        this.coverId = coverId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription
    
    (String description) {
        this.description = description;
    }
    
    public int getCoverId() {
        return coverId;
    }
    
    public void setCoverId(int coverId) {
        this.coverId = coverId;
    }
}
