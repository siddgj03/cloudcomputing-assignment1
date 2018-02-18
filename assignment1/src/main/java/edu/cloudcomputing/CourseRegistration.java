package edu.cloudcomputing;

public class CourseRegistration {
    private Integer id;
    private String courseName;

    public CourseRegistration(String courseName){
        this.courseName = courseName;
    }

    public String getCourseName(){
        return courseName;
    }

    public Integer getId(){
        return id;
    }
}
