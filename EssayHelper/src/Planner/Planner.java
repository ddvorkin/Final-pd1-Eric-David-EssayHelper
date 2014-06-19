package Planner;

public class Planner {
    PlannerStructure planner = new PlannerStructure();
    
    public void addTask(String givenTaskName, int givenHour, int givenMinute, int givenSecond){
        PlannerNode newNode = new PlannerNode(givenTaskName,givenHour,givenMinute,givenSecond);
        planner.enqueue(newNode);
    }
    
    public void listAllTasks(){
        System.out.println(planner);
    }
}
