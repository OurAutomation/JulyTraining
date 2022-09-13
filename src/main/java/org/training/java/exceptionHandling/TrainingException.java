package org.training.java.exceptionHandling;

public class TrainingException extends  Exception {
    String message;
    public TrainingException(String message) {
        super(message);
        this.message = message;
    }

    public String returnMessage() {
        return message;
    }
}
