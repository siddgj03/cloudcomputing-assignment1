package edu.cloudcomputing;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Set;

import static edu.cloudcomputing.DataRepository.allcourses;
import static edu.cloudcomputing.DataRepository.courseDetails;

@Path("/course")
public class CourseController {

    private Course initCourse(String courseName){
        return courseDetails.get(courseName);
    }

    // Get all details of a particular course
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{courseName}")
    public Course getCourseInfo(@PathParam("courseName") String courseName) {
        return initCourse(courseName);
    }

    // Get all courses with details
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Set<Course> allcourse() {
        return allcourses;
    }

    // add a lecture
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/lecture/{courseName}")
    public Alert addLecture(@PathParam("courseName") String courseName) {
        if (!courseDetails.containsKey(courseName)) {
            return new Alert(false, "Invalid course");
        }
        Course course = courseDetails.get(courseName);
        Lecture lecture = new Lecture("Algo notes 2", "Assignment 2");
        if (lecture == null || (lecture.getAssociatedMaterial() == null && lecture.getNotes() == null)) {
            return new Alert(false, "Pleas give a valid lecture");
        }

        courseDetails.get(courseName).getCourseLecture().add(lecture);
        return new Alert(true, "Lecture added successfully");
    }

}

