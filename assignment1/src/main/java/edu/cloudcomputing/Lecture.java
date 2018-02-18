package edu.cloudcomputing;

public class Lecture {
    private static Integer lectureID = 1;
    Integer id;
    private String notes;
    private String associatedMaterial;

    public Lecture(String notes, String associatedMaterial){
        this.lectureID = id++;
        this.notes = notes;
        this.associatedMaterial = associatedMaterial;
    }

    public Integer getID(){
        return id;
    }

    public void setNotes(String notes){
        this.notes = notes;
    }

    public String getNotes(){
        return notes;
    }

    public void setAssociatedMaterial(String associatedMaterial){
        this.associatedMaterial = associatedMaterial;
    }
}
