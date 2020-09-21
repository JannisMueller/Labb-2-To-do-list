package com.iths;

public class PrivateTask extends Task {

    private String subtask;

    public PrivateTask(String nameOfTask, String deadlineOfTask, int priority, String subtask) {
        super(nameOfTask, deadlineOfTask, priority);
        this.subtask = subtask;

    }

    public String getSubtask() {
        return subtask;
    }

}

