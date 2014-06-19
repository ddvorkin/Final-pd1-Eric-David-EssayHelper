package Planner;
import java.util.*;


public class PlannerStructure {
    ArrayList<PlannerNode> queue = new ArrayList();
    
    public void enqueue(PlannerNode node){
        queue.add(node);
    }
    
    public void dequeue(){
        queue.remove(0);
    }
    
    public void lateDequeue(int index){
        if (queue.get(index).returnIsPast()){
            queue.remove(index);
        }
    }
    
    public void checkLate(){
        for (int queueCounter = 0; queueCounter < queue.size(); queueCounter++){
            if (queue.get(queueCounter).returnIsPast()){
                System.out.println(queue.get(queueCounter) + "is late. It is recommended that you remove this task and create another one if needed.");
            }
        }
    }
    
    public String toString(){
        String returnString = "";
        for (PlannerNode node: queue){
            returnString = returnString + node + "\n";
        }
        return returnString;
    }
    
    
    
}
