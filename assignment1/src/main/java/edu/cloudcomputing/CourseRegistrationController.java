package edu.cloudcomputing;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

@Path("register")
public class CourseRegistrationController {
    static Map<String, LinkedHashSet<Student>> courseWithListOfStudents = new HashMap<>();

    private LinkedHashSet<Student> initCourseWithAllStudents(String courseName){
        return courseWithListOfStudents.get(courseName);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{courseName}")
    public LinkedHashSet<Student> getAllStudents(@PathParam("courseName") String courseName) {
        return initCourseWithAllStudents(courseName);
    }
}
