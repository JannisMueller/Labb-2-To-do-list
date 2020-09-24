package com.iths;

import java.util.ArrayList;


public abstract class ToDoList  {

    private ArrayList<Task> toDoList = new ArrayList<>();

    //method that adds a new object task to the arraylist (toDoList)
    public void addTask(Task task) {
        toDoList.add(task);
    }

    //method that prints out the Todolist
    public abstract void printToDoList();

    // method that checks of the task is in the arraylist
    public abstract boolean findTask(String taskName);

    // private method that returns the index of an task when provided with the name of the task.
    private int findIndex(String taskName) {
        for (int i = 0; i < this.toDoList.size(); i++) {
            Task task = this.toDoList.get(i);
            if (task.getNameOfTask().equalsIgnoreCase(taskName)) {
                return (i);
            }
        }
        return -1;
    }

    // method that removes a task from the list
    public abstract void removeTask(String taskName);

    //method that finds the position of the task and updates the task
    public void updateTask(Task oldTask, Task newTask) {
        int foundPosition = findIndex(oldTask.getNameOfTask());
        if (foundPosition >= 0) {
            toDoList.set(foundPosition, newTask);
            System.out.println("The task " + oldTask.getNameOfTask() + " has been updated ");
        } else {
            System.out.println("The task  " + oldTask.getNameOfTask() + " is not in your List!");
        }
    }

    //method that finds a task and returns the object
    public Task queryTask(String namOfTask) {
        int position = findIndex(namOfTask);
        if (position >= 0) {
            return this.toDoList.get(position);
        }
        return null;
    }

    //method to find a task in the list and marks the task as done
    public void taskDone(Task oldTask) {
        int foundPosition = findIndex(oldTask.getNameOfTask());
        if (foundPosition >= 0) {
            oldTask.setNameOfTask(oldTask.getNameOfTask() + " - Done!");
        } else {
            System.out.println("Task not found");
        }

    }

    //method to sort the tasks by their given priority (descending order)
    public abstract void sortAfterPriority();
}





