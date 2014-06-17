package Planner;

import java.util.*;

public class PlannerNode {
    private String TaskName;
    private Calendar startTime;
    private Calendar endTime;
    
    public PlannerNode(String givenTaskName, int givenDay, int givenHour, int givenMinute, int givenSecond){
        TaskName = givenTaskName;
        startTime = startTime.getInstance();
        endTime = endTime.getInstance();
        endTime.set(5555, 1 , givenDay, givenHour, givenMinute, givenSecond);
    }
        
    public String returnBeginTime(){
        String returnTime;
        String[] monthList = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}; 
        String[] AM_PM = {"AM", "PM"};
        returnTime =  "Started on: \n" + startTime.get(startTime.HOUR) + ":" + startTime.get(startTime.MINUTE) + "." + startTime.get(startTime.SECOND) + " " + AM_PM[startTime.get(startTime.AM_PM)] + " " + monthList[startTime.get(startTime.MONTH)] + " " + startTime.get(startTime.DATE) + ", " + startTime.get(startTime.YEAR);
        return returnTime;
    }
    
    public String returnEndTime(){
        String returnTime;
        String[] monthList = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}; 
        String[] AM_PM = {"AM", "PM"};
        returnTime = "Ending at: \n" + endTime.get(endTime.HOUR) + ":" + endTime.get(endTime.MINUTE) + "." + startTime.get(startTime.SECOND) + " " + AM_PM[endTime.get(endTime.AM_PM)] + " " + monthList[startTime.get(startTime.MONTH)] + " " + endTime.get(startTime.DATE) + ", " + startTime.get(endTime.YEAR);
        return returnTime;
    }
    public static void main(String [] args){
        PlannerNode test = new PlannerNode("oss",14,12,1,1);
        System.out.println(test.returnBeginTime());
        System.out.println(test.returnBeginTime());
    }
}
