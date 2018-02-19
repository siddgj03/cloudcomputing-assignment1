package edu.cloudcomputing;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class DataRepository {
    static Map<Integer, Student> studentData = new HashMap<>();
    static Map<String, Course> courseDetails = new HashMap<>();
    static Set<Course> allcourses = new LinkedHashSet<>();

    static Map<Integer, LinkedHashSet<Course>> studentRegisteredCourse = new HashMap<>();
    static Map<String, LinkedHashSet<Student>> courseContainsStudent = new HashMap<>();

    static {
        Board boardAlgo1 = new Board("Searching and Sorting");
        Lecture lectureAlgo1 = new Lecture("Algo notes 1", "Assigment One");
        Course algo = new Course("INFO6205");
        algo.getCourseBoard().add(boardAlgo1);
        algo.getCourseLecture().add(lectureAlgo1);
        allcourses.add(algo);

        Board boardUser1 = new Board("User experience");
        Lecture lectureUser1 = new Lecture("UX Notes 1", "Assignment One");
        Course userExperience = new Course("CS7280");
        userExperience.getCourseBoard().add(boardUser1);
        userExperience.getCourseLecture().add(lectureUser1);
        allcourses.add(userExperience);
        courseDetails.put(algo.getCourseName(), algo);
        courseDetails.put(userExperience.getCourseName(), userExperience);
    }

    static {
        Student alice = new Student("Alice", "https://www.istockphoto.com/photo/concept-for-stylish-young-man-outdoors-gm496655806-78669259?irgwc=1&esource=AFF_IS_IR_SP_FreeImages_246195&asid=FreeImages&cid=IS", Program.CS);
        Student bob = new Student("Bob", "https://www.istockphoto.com/photo/smiling-man-with-crossed-arms-over-gray-background-gm511525632-86688467?irgwc=1&esource=AFF_IS_IR_SP_FreeImages_246195&asid=FreeImages&cid=IS", Program.INFO);
        Student kate  = new Student("Kate","https://www.istockphoto.com/photo/smiling-man-with-crossed-arms-over-gray-background-gm511525632-86688467?irgwc=1&esource=AFF_IS_IR_SP_FreeImages_246195&asid=FreeImages&cid=IS",Program.INFO);
        studentData.put(alice.id,alice);
        studentData.put(bob.id,bob);
        studentData.put(kate.id,kate);
    }
}
