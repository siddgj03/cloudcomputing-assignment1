package edu.cloudcomputing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Course {
    private String courseName;
    private Set<Board> courseBoard;
    private List<String> courseRoster;
    private Set<Lecture> courseLecture;

    Course(){
        this.courseName = courseName;
        courseBoard = new HashSet<>();
        courseRoster = new ArrayList<>();
        courseLecture = new HashSet<>();
    }

    public void setCourseName(String courseName){
        this.courseName = courseName;
    }

    public String getCourseName(){
        return courseName;
    }

    public Set<Board> getborad(){
        return courseBoard;
    }

    public Set<Lecture> getLecture(){
        return courseLecture;
    }

    public void setRoster(List<String> roster){
        this.courseRoster = roster;
    }

    public List<String> getRoster(){
        return courseRoster;
    }
}