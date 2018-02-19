package edu.cloudcomputing;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.Map;
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

    // Get all courses
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Set<Course> allcourse() {
        return allcourses;
    }

}

