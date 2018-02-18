package edu.cloudcomputing;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Path("/course")
public class CourseController {
    static Map<String, Course> courseDetails = new HashMap<>();

    static {
        Board boardAlgo1 = new Board("Searching and Sorting");
        Lecture lectureAlgo1 = new Lecture("Algo notes 1", "Assigment One");
        Course algo = new Course("INFO6205");
        algo.getCourseBoard().add(boardAlgo1);
        algo.getCourseLecture().add(lectureAlgo1);

        Board boardUser1 = new Board("User experience");
        Lecture lectureUser1 = new Lecture("UX Notes 1", "Assignment One");
        Course userExperience = new Course("CS7280");
        userExperience.getCourseBoard().add(boardUser1);
        userExperience.getCourseLecture().add(lectureUser1);

        courseDetails.put(algo.getCourseName(), algo);
        courseDetails.put(userExperience.getCourseName(), userExperience);
    }

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

    // Add a new course
    @POST
    @Path("{studentName}/{image}/{program}")
    public Alert addCourse(@PathParam("studentName") )
        if (courseInfo.getCourseName() == null) {
            return gson.toJson(new OperationMessage(false, "Please give a course name"));
        }
        if (courseDetails.containsKey(courseInfo.getCourseName())) {
            return gson.toJson(new OperationMessage(false, "Course already exists"));
        }
        CourseMap.courseMap.put(courseInfo.getCourseName(), courseInfo);
        return gson.toJson(new OperationMessage(true, "successfully added the course"));
    }


