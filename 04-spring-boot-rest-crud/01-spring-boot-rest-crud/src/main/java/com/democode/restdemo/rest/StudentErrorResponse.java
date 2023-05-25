package com.democode.restdemo.rest;

public class StudentErrorResponse {
    private int errorMessage;
    private String message;

    private long timeStamp;

    public StudentErrorResponse() {
    }

    public StudentErrorResponse(int errorMessage, String message, long timeStamp) {
        this.errorMessage = errorMessage;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(int errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
