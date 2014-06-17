package Planner;

import java.util.*;

public class PlannerNode {
    private String TaskName;
    private Calendar startTime;
    private Calendar endTime;
    private boolean isPast = false;
    
    public PlannerNode(String givenTaskName, int givenHour, int givenMinute, int givenSecond){
        TaskName = givenTaskName;
        startTime = startTime.getInstance();
        endTime = endTime.getInstance();
        endTime.set(5555, 1 , 1, givenHour, givenMinute, givenSecond);
    }
        
    public String returnBeginTime(){
        String returnTime; 
        String[] AM_PM = {"AM", "PM"};
        returnTime =  "Started on: \n" + startTime.get(startTime.HOUR) + ":" + startTime.get(startTime.MINUTE) + "." + startTime.get(startTime.SECOND) + " " + AM_PM[startTime.get(startTime.AM_PM)];
        return returnTime;
    }
    
    public String returnEndTime(){
        String returnTime;
        String[] AM_PM = {"AM", "PM"};
        returnTime = "Ending at: \n" + endTime.get(endTime.HOUR) + ":" + endTime.get(endTime.MINUTE) + "." + startTime.get(startTime.SECOND) + " " + AM_PM[endTime.get(endTime.AM_PM)];
        return returnTime;
    }
    
    public void checkTimePast(){
        if (endTime.get(endTime.HOUR) < startTime.get(startTime.HOUR) && (endTime.get(endTime.AM_PM) == startTime.get(startTime.AM_PM))){
            isPast = true;
        }
        
    }
    
    public static void main(String [] args){
        PlannerNode test = new PlannerNode("Finishing This Shit",11,25,0);
        System.out.println(test.returnBeginTime());
        System.out.println(test.returnBeginTime());
        System.out.println(test.returnEndTime());
    }
}
