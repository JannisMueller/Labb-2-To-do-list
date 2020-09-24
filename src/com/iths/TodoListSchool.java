package com.iths;

import java.util.ArrayList;
import java.util.Comparator;

public class TodoListSchool extends ToDoList {

    private ArrayList<SchoolTask> toDoListSchool = new ArrayList<>();

    //method that adds a new object task to the arraylist (toDoList)
    public void addTask(SchoolTask task) {
        toDoListSchool.add(task);
    }

    @Override
    //method that prints out the Todolist
    public void printToDoList() {
        for (int i = 0; i < toDoListSchool.size(); i++) {
            System.out.println("Task " + (i + 1) + ": " + toDoListSchool.get(i).getNameOfTask());
            System.out.println("*Deadline: " + toDoListSchool.get(i).getDeadlineOfTask());
            System.out.println("*Priority:  " + toDoListSchool.get(i).getPriority());
            System.out.println("*Name of class:  " + toDoListSchool.get(i).getNameOfClass());
            System.out.println("*Subtask:  " + toDoListSchool.get(i).getSubtask());
            System.out.println("--------------------------");


        }

    }

    @Override
    // method that checks of the task is in the arraylist
    public boolean findTask(String taskName) {
        if (findIndex(taskName) >= 0) {
            System.out.println("The task is in the list and its saved as task number " + (findIndex(taskName) + 1));
            return true;
        } else {
            System.out.println("The item is not in your List");
            return false;
        }

    }

    // private method that returns the index of an task when provided with the name of the task.
    private int findIndex(String taskName) {
        for (int i = 0; i < this.toDoListSchool.size(); i++) {
            SchoolTask task = this.toDoListSchool.get(i);
            if (task.getNameOfTask().equalsIgnoreCase(taskName)) {
                return (i);
            }
        }
        return -1;
    }

    @Override
    // method that removes a task from the list
    public void removeTask(String taskName) {
        int indexOfTask = findIndex(taskName);
        if (indexOfTask >= 0) {
            System.out.println("Task " + taskName + " is removed from your list");
            toDoListSchool.remove(indexOfTask);
        } else {
            System.out.println("The task " + taskName + " is not in your List!");
        }
    }

    //method that finds the position of the task and updates the task
    public void updateTask(SchoolTask oldTask, SchoolTask newTask) {
        int foundPosition = findIndex(oldTask.getNameOfTask());
        if (foundPosition >= 0) {
            toDoListSchool.set(foundPosition, newTask);
            System.out.println("The task " + oldTask.getNameOfTask() + " has been updated ");
        } else {
            System.out.println("The task  " + oldTask.getNameOfTask() + " is not in your List!");
        }
    }

    //method that finds a task and returns the object
    public Task queryTask(String namOfTask) {
        int position = findIndex(namOfTask);
        if (position >= 0) {
            return this.toDoListSchool.get(position);
        }
        return null;
    }

    //method to find a task in the list and marks the task as done
    public void taskDone(SchoolTask oldTask) {
        int foundPosition = findIndex(oldTask.getNameOfTask());
        if (foundPosition >= 0) {
            oldTask.setNameOfTask(oldTask.getNameOfTask() + " - Done!");
        } else {
            System.out.println("Task not found");
        }
    }

    @Override
    //method to sort the task by priority (descending order)
    public void sortAfterPriority() {
        toDoListSchool.sort(Comparator.comparing(Task::getPriority, Comparator.reverseOrder()));
        System.out.println("Tasks sorted by their priority");
        System.out.println();
        printToDoList();


    }
}
