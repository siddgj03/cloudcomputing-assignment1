package edu.cloudcomputing;

public class Student {
    private String studentName;
    private String image;
    private static Integer studentID = 0;
    Integer id;
    Program program;

    Student(String studentName, String image,Program program){
        id = studentID++;
        this.studentName = studentName;
        this.image = image;
        this.program = program;
    }

    public void setstudentName(String name){
        this.studentName = studentName;
    }

    public String getstudentName(){
        return studentName;
    }

    public void setImage(String image){
        this.image= image;
    }

    public String getImage() {
        return image;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public Program getProgram(){
        return program;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", image='" + image + '\'' +
                ", id=" + id +
                ", program=" + program +
                '}';
    }
}
