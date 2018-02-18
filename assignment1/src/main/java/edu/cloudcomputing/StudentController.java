package edu.cloudcomputing;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Path("student")
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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Student getStudentInfo(@PathParam("id") int id) {
        return initStudent(id);
    }


}


