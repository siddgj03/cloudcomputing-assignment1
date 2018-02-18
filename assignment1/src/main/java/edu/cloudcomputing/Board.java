package edu.cloudcomputing;

public class Board {
    private static Integer BoardID = 1;
    Integer id;
    private String message;

    public Board(String message){
        this.id = BoardID++;
        this.message = message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public Integer getId(){
        return id;
    }
}
