package edu.cloudcomputing;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

import static edu.cloudcomputing.DataRepository.studentData;

@Path("/student")
public class StudentController  {

    private Student initStudent(int id){
        return studentData.get(id);
    }

    // Get details of a particular student
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Student getStudentInfo(@PathParam("id") int id) {
        return initStudent(id);
    }


    // Create a new Student
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{studentName}/{image}/{program}")
    public Alert addStudent(@PathParam("studentName") String studentName,@PathParam("image") String image,@PathParam("program") String program) {
        Student studentInfo = new Student(studentName,image,Program.valueOf(program));
        if (studentInfo.getstudentName() == null ) {
            return new Alert(false, "Add a Valid Name");
        }

        if (studentInfo.getProgram() == null) {
            return new Alert(false, "Register for an existing program");
        }
        studentData.put(studentInfo.id, studentInfo);

        return new Alert(true, "Student created with id " + studentInfo.id);
    }


    // Get details of all students
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Map<Integer, Student> allStudents() {
        return studentData;
    }

    // Delete a particular student
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Alert deleteStudent(@PathParam("id") Integer id) {
        if (!studentData.containsKey(id)) {
            return new Alert(false, "No student with this id is present");
        }

        Student student = studentData.get(id);
        studentData.remove(id);
        return new Alert(true, "The student record has been deleted");
    }
}


