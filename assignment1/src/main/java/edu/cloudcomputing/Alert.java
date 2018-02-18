package edu.cloudcomputing;

public class Alert {
    private String message;
    private boolean status;

    public Alert(boolean status, String message){
        this.message = message;
        this.status = status;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
