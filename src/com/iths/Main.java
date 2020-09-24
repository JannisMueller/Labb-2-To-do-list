package com.iths;

import java.util.Scanner;

public class Main {

    public static TodoListSchool toDoListSchool = new TodoListSchool();
    public static ToDoListPrivate toDoListPrivate = new ToDoListPrivate();

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean exitProgram = false;
        int choiceMenu = 0;

        System.out.println("\t - Welcome to the Task-Manager -\t");
        System.out.println("Enter 1 to create a to-do list for private tasks!" +
                            "\nEnter 2 to create a to-do list for school task!");


        int choiceList  = scanner.nextInt();
        scanner.nextLine();
        while(choiceList != 1 && choiceList != 2) {
            System.out.println("Please choose between option 1 or 2!");
            choiceList = scanner.nextInt();
            scanner.nextLine();
        }


        if(choiceList==1) {
            System.out.println("\t- Task Manager for Private Tasks -\t");
            printMenu();

            while(!exitProgram) {

                System.out.println("\n" +
                        "What would you like to do? (Press 0 for all options)");
                choiceMenu = scanner.nextInt();
                scanner.nextLine();
                while(!(choiceMenu >= 0 && choiceMenu<9)) {
                    System.out.println("Please enter a number between 0-8!");
                    choiceMenu = scanner.nextInt();
                    scanner.nextLine();
                }

                switch (choiceMenu) {
                    case 0:
                        printMenu();
                        break;
                    case 1:
                        toDoListPrivate.printToDoList();
                        break;
                    case 2:
                        addTaskPrivate();
                        break;
                    case 3:
                        removeTaskPrivate();
                        break;
                    case 4:
                        updateTaskPrivate();
                        break;
                    case 5:
                        findTaskPrivate();
                        break;
                    case 6:
                        taskDonePrivate();
                        break;
                    case 7:
                        toDoListPrivate.sortAfterPriority();
                        break;
                    case 8:
                        exitProgram = true;
                        System.out.println("Good bye and thank you for using our Task Manager for private tasks!");
                        break;

                }
            }
                } else if (choiceList==2) {
                    System.out.println("\t- Task Manager for school-related tasks -\t");
                    printMenu();
                    while (!exitProgram){

                        System.out.println("\nWhat would you like to do? (Press 0 for all options)");
                        choiceMenu = scanner.nextInt();
                        scanner.nextLine();
                        while(!(choiceMenu >= 0 && choiceMenu<9)){
                            System.out.println("Please enter a number between 0-8!");
                           choiceMenu = scanner.nextInt();
                            scanner.nextLine();
                        }

                        switch (choiceMenu) {
                            case 0:
                                printMenu();
                                break;
                            case 1:
                                toDoListSchool.printToDoList();

                                break;
                            case 2:
                                addTaskSchool();
                                break;
                            case 3:
                                removeTaskSchool();
                                break;
                            case 4:
                                updateTaskSchool();
                                break;
                            case 5:
                                findTaskSchool();
                                break;
                            case 6:
                                taskDoneSchool();
                                break;
                            case 7:
                                toDoListSchool.sortAfterPriority();
                                break;
                            case 8:
                                exitProgram = true;
                                System.out.println("Good bye and thank you for using our Task Manager for school tasks!");
                                break;

                                }
                                }

                } else {
                    exitProgram = true;
                    System.out.println("Good Bye!");
             }
             }

    // method that creates a new task (object) with the input from the user and saves the task to the do-list
    public static void addTaskSchool(){
        System.out.print("Enter the name of the Task: ");
        String nameOfTask = scanner.nextLine();

        System.out.print("Enter the deadline of the Task: ");
        String deadlineOfTask = scanner.nextLine();

        System.out.print("Enter the Priority the Task (1-5): ");
        int priority = scanner.nextInt();
        scanner.nextLine();
        while(!(priority >= 1 && priority<6)){
            System.out.println("Please enter a number between 1-5 for prioritizing the task!");
            priority = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.print("Enter the Name of the class: ");
        String nameOfClass = scanner.nextLine();

        System.out.print("Enter the subtask of the Task: ");
        String subtask = scanner.nextLine();

        // creating a new object with the information provided by the user
        SchoolTask task = new SchoolTask(nameOfTask,deadlineOfTask,priority,nameOfClass,subtask);

        //calling method addTask in the Task-class
        toDoListSchool.addTask(task);
    }
    // method that creates a new task (object) with the input from the user and saves the task to the do-list
    public static void addTaskPrivate(){
        System.out.print("Enter the name of the Task: ");
        String nameOfTask = scanner.nextLine();

        System.out.print("Enter the deadline of the Task: ");
        String deadlineOfTask = scanner.nextLine();

        System.out.print("Enter the Priority the Task (1-5): ");
        int priority = scanner.nextInt();
        scanner.nextLine();
        while(!(priority >= 1 && priority<6)){
            System.out.println("Please enter a number between 1-5 for prioritizing the task!");
            priority = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.print("Enter the subtask of the Task: ");
        String subtask = scanner.nextLine();

        // creating a new object with the information provided by the user
        PrivateTask task = new PrivateTask(nameOfTask,deadlineOfTask,priority,subtask);

        //calling method addTask in the Task-class
        toDoListPrivate.addTask(task);
    }

    // method that checks if the task is in the arraylist
    public static void findTaskSchool(){
        System.out.print("Enter the Name of the task you are searching for: ");
        String nameOfTask = scanner.nextLine();
        toDoListSchool.findTask(nameOfTask);
    }
    // method that checks if the task is in the arraylist
    public static void findTaskPrivate(){
        System.out.print("Enter the Name of the task you are searching for: ");
        String nameOfTask = scanner.nextLine();
        toDoListPrivate.findTask(nameOfTask);
    }

    // method that removes a task from the list
    public static void removeTaskSchool(){
        System.out.print("Enter the Name of the task you would like to remove: ");
        String nameOfTask = scanner.nextLine();
        toDoListSchool.removeTask(nameOfTask);

    }
    // method that removes a task from the list
    public static void removeTaskPrivate(){
        System.out.print("Enter the Name of the task you would like to remove: ");
        String nameOfTask = scanner.nextLine();
        toDoListPrivate.removeTask(nameOfTask);

    }

    //method that finds the position of the task and updates the task
    public static void updateTaskSchool(){
        System.out.print("Enter the Name of the task you would like to update ");
        String nameOfOldTask = scanner.nextLine();

        SchoolTask oldTask = (SchoolTask) toDoListSchool.queryTask(nameOfOldTask);

        if(oldTask == null){
            System.out.println("Task not in the List");
        } else {
            System.out.print("Enter the name of the new Task: ");
            String nameOfTask = scanner.nextLine();

            System.out.print("Enter the deadline of the new Task: ");
            String deadlineOfTask = scanner.nextLine();

            System.out.print("Enter the Priority the new Task: ");
            int priority = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter the Name of the Class: ");
            String nameOfClass = scanner.nextLine();

            System.out.print("Enter the new subtask of the new Task: ");
            String subtask = scanner.nextLine();

            // creating a new object with the information provided by the user
            SchoolTask newTask = new SchoolTask(nameOfTask, deadlineOfTask, priority, nameOfClass,subtask);

            toDoListSchool.updateTask(oldTask, newTask);
        }
    }
    //method that finds the position of the task and updates the task
    public static void updateTaskPrivate(){
        System.out.print("Enter the Name of the task you would like to update ");
        String nameOfOldTask = scanner.nextLine();

        PrivateTask oldTask = (PrivateTask) toDoListPrivate.queryTask(nameOfOldTask);

        if(oldTask == null){
            System.out.println("Task not in the List");
        } else {

            System.out.print("Enter the name of the new Task: ");
            String nameOfTask = scanner.nextLine();

            System.out.print("Enter the deadline of the new Task: ");
            String deadlineOfTask = scanner.nextLine();

            System.out.print("Enter the Priority the new Task: ");
            int priority = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter the new subtask of the new Task: ");
            String subtask = scanner.nextLine();



            // creating a new object with the information provided by the user
            PrivateTask newTask =  new PrivateTask(nameOfTask, deadlineOfTask, priority,subtask);

            toDoListPrivate.updateTask(oldTask, newTask);
        }
    }

    //method prints the instructions for the user of the program
    public static void printMenu (){
        System.out.println(
                "\nYou can choose between the following alternatives: " +
                "\n0 - Show alternatives" +
                "\n1 - Show to-do list" +
                "\n2 - Add task to list" +
                "\n3 - Remove task from list" +
                "\n4 - Update existing task " +
                "\n5 - Search in to-do list" +
                "\n6 - Mark a task as done" +
                "\n7 - Sort the tasks by their priority" +
                "\n8 - Exit the program");
    }

    //method to find a task in the list and marks the task as done
    public static void taskDoneSchool(){
        System.out.println("Which task should be marked as done?");
        String nameTaskDone = scanner.nextLine();
        SchoolTask taskDone = (SchoolTask) toDoListSchool.queryTask(nameTaskDone);

        if(taskDone == null){
            System.out.println("Task not in the List");

        } else {
            toDoListSchool.taskDone(taskDone);
            System.out.println("Task " + nameTaskDone + " marked as done! Good job!" );
        }
    }

    //method to find a task in the list and marks the task as done
    public static void taskDonePrivate(){
        System.out.println("Which task should be marked as done?");
        String nameTaskDone = scanner.nextLine();
       PrivateTask taskDone = (PrivateTask) toDoListPrivate.queryTask(nameTaskDone);

        if(taskDone == null){
            System.out.println("Task not in the List");

        } else {
            toDoListPrivate.taskDone(taskDone);
            System.out.println("Task " + nameTaskDone + " marked as done! Good job!" );
        }
    }
    
    }