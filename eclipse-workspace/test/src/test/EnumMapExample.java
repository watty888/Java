package test;

import java.util.*;

public class EnumMapExample {
	
	public enum STATE { NEW, RUNNING, WAITING, FINISHED }
	
	public static void main(String args[]) {
		
		EnumMap<STATE, String> stateMap = new EnumMap<>(STATE.class);
		
		stateMap.put(STATE.RUNNING, "Program is running");
        stateMap.put(STATE.WAITING, "Program is waiting");
        stateMap.put(STATE.NEW, "Program has just created");
        stateMap.put(STATE.FINISHED, "Program has finished");
        
        System.out.println("Size of EnumMap in java: " + stateMap.size());
        
        System.out.println("EnumMap: " + stateMap);
        
        System.out.println("EnumMap key : " + STATE.NEW +" value: " + stateMap.get(STATE.NEW));
        
        Iterator<STATE> enumKeySet = stateMap.keySet().iterator();
        while(enumKeySet.hasNext()){
            STATE currentState = enumKeySet.next();
            System.out.println("key : " + currentState + " value : " + stateMap.get(currentState));
        }
        
        System.out.println("Does stateMap has :" + STATE.NEW + " : " 
                +  stateMap.containsKey(STATE.NEW));

        System.out.println("Does stateMap has :" + STATE.NEW + " : " + stateMap.containsValue(null));

	}
	
}
