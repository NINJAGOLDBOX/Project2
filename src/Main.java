import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Task> taskList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        promptUser();
	    int userInput = input.nextInt();
	    while(userInput != 0){
	        if(userInput == 1){
	            addTask(taskList);
            }else if(userInput == 2){
	            removeTask(taskList);
            }else if(userInput == 3){
	            updateTask(taskList);
            }else if(userInput == 4){
	            listTasks(taskList);
            }else if(userInput == 5){
                listTaskByPrio(taskList);
            }else{
                System.out.println("That is not a valid command.");
            }
	        promptUser();
	        userInput = input.nextInt();
        }
    }

    static void promptUser(){
        System.out.println("Please choose an option:");
        System.out.println("(1) Add a task.");
        System.out.println("(2) Remove a task.");
        System.out.println("(3) Update a task.");
        System.out.println("(4) List all tasks.");
        System.out.println("(5) List by Priority.");
        System.out.println("(0) Exit.");
    }
    static void addTask(ArrayList<Task> a){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter task name.");
        String taskName = input.nextLine();
        System.out.println("Please enter description of the task.");
        String descName = input.nextLine();
        System.out.println("Please enter priority number 0-5.");
        int prioInt = input.nextInt();
        input.nextLine();
        a.add(new Task(taskName, descName, prioInt));
    }
    static void removeTask(ArrayList<Task> a){
        Scanner input = new Scanner(System.in);
        System.out.println("Which task would you like to remove?");
        int userInput = input.nextInt();
        a.remove(userInput);
    }

    static void updateTask(ArrayList<Task> a){
        Scanner input = new Scanner(System.in);
        System.out.println("Which would you like to update?");
        int userInput = input.nextInt();
        input.nextLine();
        System.out.println("Please enter task name.");
        String taskName = input.nextLine();
        System.out.println("Please enter description of the task.");
        String descName = input.nextLine();
        System.out.println("Please enter priority number 0-5.");
        int prioInt = input.nextInt();
        input.nextLine();
        Task updatedTask = new Task(taskName, descName, prioInt);
        a.set(userInput, updatedTask);
    }

    static void listTaskByPrio(ArrayList<Task> a){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter priority number 0-5.");
        int prioInt = input.nextInt();
        input.nextLine();
        for(int i = 0; i < a.size(); i++){
            if(prioInt == a.get(i).getPriority()){
                System.out.println(a.get(i));
            }
        }
    }

    static void listTasks(ArrayList<Task> a){
        System.out.println(a);
    }
}