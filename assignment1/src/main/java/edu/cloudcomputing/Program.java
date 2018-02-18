package edu.cloudcomputing;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public enum Program {
    INFO, CS;
    private Set<Course> course;
    private Set<Student> students;
    private Map<Program,Set<Course>> programMap;

    Program(){
        programMap = new HashMap<>();
    }

    public Set<Course> getCourses(){
        return course;
    }

    public Set<Student> getStudents(){
        return students;
    }

    public boolean addCourse(Course course){
        return this.addCourse(course);
    }

    public boolean addStudents(Student student){
        return this.addStudents(student);
    }
}
