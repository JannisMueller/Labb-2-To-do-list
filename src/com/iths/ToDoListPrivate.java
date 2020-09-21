package com.iths;

import java.util.ArrayList;
import java.util.Comparator;

public class ToDoListPrivate extends ToDoList{

    private ArrayList<PrivateTask> toDoListPrivate = new ArrayList<>();


    //method that adds a new object task to the arraylist (toDoList)
    public void addTask(PrivateTask task) {
        toDoListPrivate.add(task);
    }

    //method that prints out the Todolist
    public void printToDoList() {
        for (int i = 0; i < toDoListPrivate.size(); i++) {
            System.out.println("Task " + (i + 1) + ": " + toDoListPrivate.get(i).getNameOfTask());
            System.out.println("*Deadline: " + toDoListPrivate.get(i).getDeadlineOfTask());
            System.out.println("*Priority:  " + toDoListPrivate.get(i).getPriority());
            System.out.println("*Subtask:  " + toDoListPrivate.get(i).getSubtask());
            System.out.println("--------------------------");
        }
    }

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

    // private method that returns the index of an task by the name of the task‚
    private int findIndex(String taskName) {
        for (int i = 0; i < this.toDoListPrivate.size(); i++) {
            PrivateTask task = this.toDoListPrivate.get(i);
            if (task.getNameOfTask().equalsIgnoreCase(taskName)) {
                return (i);
            }
        }
        return -1;
    }

    // method that removes a task from the list
    public void removeTask(String taskName) {
        int indexOfTask = findIndex(taskName);
        if (indexOfTask >= 0) {
            System.out.println("Task " + taskName + " is removed from your list");
            toDoListPrivate.remove(indexOfTask);
        } else {
            System.out.println("The task " + taskName + " is not in your List!");
        }
    }
    //method that finds the position of the task and updates the task
    public void updateTask(PrivateTask oldTask, PrivateTask newTask) {
        int foundPosition = findIndex(oldTask.getNameOfTask());
        if (foundPosition >= 0) {
            toDoListPrivate.set(foundPosition, newTask);
            System.out.println("The task " + oldTask.getNameOfTask() + " has been updated ");
        } else {
            System.out.println("The task  " + oldTask.getNameOfTask() + " is not in your List!");
        }
    }

    //method that finds a task and returns the object
    public Task queryTask(String namOfTask) {
        int position = findIndex(namOfTask);
        if (position >= 0) {
            return this.toDoListPrivate.get(position);
        }
        return null;
    }

    //method to find a task in the list and mark the task as done
    public void taskDone(PrivateTask oldTask) {
        int foundPosition = findIndex(oldTask.getNameOfTask());
        if (foundPosition >= 0) {
            oldTask.setNameOfTask(oldTask.getNameOfTask() + " - Done!");
        } else {
            System.out.println("Task not found");
        }

    }

    //method to sort the task by priority (descending order)
    public void sortAfterPriority(){
        toDoListPrivate.sort(Comparator.comparing(Task::getPriority, Comparator.reverseOrder()));
        System.out.println("Tasks sorted by their priority");
        System.out.println();
        printToDoList();
    }
}
