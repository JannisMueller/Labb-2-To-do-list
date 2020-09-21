package com.iths;

public class SchoolTask extends Task {

    private String nameOfClass;
    private String subtask;


    public SchoolTask(String nameOfTask, String deadlineOfTask, int priority, String nameOfClass, String subtask) {
        super(nameOfTask, deadlineOfTask, priority);
        this.nameOfClass = nameOfClass;
        this.subtask = subtask;
    }

    public String getNameOfClass() {
        return nameOfClass;
    }

    public String getSubtask() {
        return subtask;
    }

}


