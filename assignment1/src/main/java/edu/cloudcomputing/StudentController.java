package edu.cloudcomputing;

import com.sun.corba.se.spi.ior.iiop.AlternateIIOPAddressComponent;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Path("/student")
public class StudentController {
     static Map<Integer, Student> studentData = new HashMap<>();

     static {
         Student alice = new Student("Alice", "https://www.istockphoto.com/photo/concept-for-stylish-young-man-outdoors-gm496655806-78669259?irgwc=1&esource=AFF_IS_IR_SP_FreeImages_246195&asid=FreeImages&cid=IS", Program.CS);
         Student bob = new Student("Bob", "https://www.istockphoto.com/photo/smiling-man-with-crossed-arms-over-gray-background-gm511525632-86688467?irgwc=1&esource=AFF_IS_IR_SP_FreeImages_246195&asid=FreeImages&cid=IS", Program.INFO);
         Student kate  = new Student("Kate","https://www.istockphoto.com/photo/smiling-man-with-crossed-arms-over-gray-background-gm511525632-86688467?irgwc=1&esource=AFF_IS_IR_SP_FreeImages_246195&asid=FreeImages&cid=IS",Program.INFO);
         studentData.put(alice.id,alice);
         studentData.put(bob.id,bob);
         studentData.put(kate.id,kate);
     }

    private Student initStudent(int id){
        return studentData.get(id);
    }

    // Get all details of a particular student
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
        //RegisterService.studentRegisteredCourse.remove(id);

        /*Iterator<Map.Entry<String, LinkedHashSet<Student>>> courseIterator = RegisterService.courseContainsStudent.entrySet().iterator();
        while (courseIterator.hasNext()) {
            Map.Entry<String, LinkedHashSet<Student>> curr = courseIterator.next();
            curr.getValue().remove(student);
        }*/
        return new Alert(true, "The student record has been deleted");
    }
}


