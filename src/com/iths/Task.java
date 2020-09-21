package com.iths;

public class Task {

    private String nameOfTask;
    private String deadlineOfTask;
    private int priority;


    public Task(String nameOfTask, String deadlineOfTask, int priority) {
        this.nameOfTask = nameOfTask;
        this.deadlineOfTask = deadlineOfTask;
        this.priority = priority;
    }

    public String getNameOfTask() {
        return nameOfTask;
    }

    public void setNameOfTask(String nameOfTask) {
        this.nameOfTask = nameOfTask;
    }

    public String getDeadlineOfTask() {
        return deadlineOfTask;
    }

    public int getPriority() {
        return priority;
    }

}


