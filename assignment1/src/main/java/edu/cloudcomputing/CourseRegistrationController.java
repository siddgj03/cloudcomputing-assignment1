package edu.cloudcomputing;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

import static edu.cloudcomputing.DataRepository.*;

@Path("/register")
public class CourseRegistrationController {

    // Student registers for a course
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}/{courseName}")
    public Alert registerCourse(@PathParam("id") Integer id, @PathParam("courseName") String courseName) {

        if (!studentData.containsKey(id)) {
            return new Alert(false, "No such student found");
        }
        Student student = studentData.get(id);

        if (!courseDetails.containsKey(courseName)) {
            return new Alert(false,"No such course");
        }
        Course course = courseDetails.get(courseName);

        if((studentRegisteredCourse.containsKey(id) && studentRegisteredCourse.get(id).contains(course)) || (courseContainsStudent.containsKey(courseName) && courseContainsStudent.get(courseName).contains(student))) {
            return new Alert(false, "student has already registered for this course");
        }

        if (!studentRegisteredCourse.containsKey(id)) {
            studentRegisteredCourse.put(id, new LinkedHashSet<Course>());
        }

        if (!courseContainsStudent.containsKey(courseName)) {
            courseContainsStudent.put(courseName, new LinkedHashSet<Student>());
        }

        studentRegisteredCourse.get(id).add(course);
        courseContainsStudent.get(courseName).add(student);

        return new Alert(true,"Student has registered for the course successfully");
    }

    // Delete a student for a registered course
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/{courseName}")
    public Alert deleteRegistration(@PathParam("id") Integer id, @PathParam("courseName") String courseName) {
        if (!studentData.containsKey(id)) {
            return new Alert(false, "No such student");
        }
        Student student = studentData.get(id);

        if (!courseDetails.containsKey(courseName)) {
            return new Alert(false,"No such course");
        }
        Course course = courseDetails.get(courseName);

        if (!studentRegisteredCourse.containsKey(id)) {
            return new Alert(false, "student has not registered any course");
        }

        if (!courseContainsStudent.containsKey(courseName)) {
            return new Alert(false, "course does not have any student");
        }

        if (!studentRegisteredCourse.get(id).contains(course) || !courseContainsStudent.get(courseName).contains(student)) {
            return new Alert(false,"Student has not registerred for the course");
        }

        studentRegisteredCourse.get(id).remove(course);
        courseContainsStudent.get(courseName).remove(student);

        return new Alert(true, "successfully removed student from registration for course ");
    }
}
