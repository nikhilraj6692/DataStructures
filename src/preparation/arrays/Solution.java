package preparation.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution1 {

    public static void main(String[] args)
    {
        int[] output = Solution.timeTaken(new int[]{3,3,4,5,5,5}, new int[]{1,0,1,0,1,0});
        for(int num:output){
            System.out.print(num + " ");
        }
    }


    static class Solution {


        public static int[] timeTaken(int[] arrival, int[] state) {
            int doorLastUsed = -1;
            int doorLastUsedFor = -1;
            int[] output = new int[arrival.length];

            List<Integer> leftOverPersons = new ArrayList<>();
            Map<Integer, List<Integer>> secondToPersonMap = new HashMap<>();
            for(int i=0;i<arrival.length;i++){
                leftOverPersons.add(i);
                secondToPersonMap.put(i, new ArrayList<>());
            }
            for(int i=0;i<arrival.length;i++) {

                secondToPersonMap.compute(arrival[i], (k,v)->v==null?
                    new ArrayList<>():v).add(i);
            }
            secondToPersonMap.entrySet().stream().forEach(e->System.out.println(e.getKey() + " :: " + e.getValue()));

            List<Integer> persons = new ArrayList<>();
            int currSecond = 0;
            while(!leftOverPersons.isEmpty()) {
                persons.addAll(null==secondToPersonMap.get(currSecond)?new ArrayList<>():secondToPersonMap.get(currSecond));
                int personSelected = -1;
                if(persons.size() > 0 && persons.size()==1) {
                    output[persons.get(0)] = currSecond;
                    doorLastUsed = currSecond;
                    doorLastUsedFor = state[persons.get(0)];
                    personSelected = persons.get(0);
                } else if (persons.size() > 0){
                    //check if all persons have same direction to go
                    boolean enter = false;
                    boolean exit = false;
                    for(int person:persons) {
                        if(state[person]==0){
                            enter = true;
                        }else{
                            exit = true;
                        }
                    }
                    boolean sameDirection=true;
                    if(enter&exit) {
                        //not same direction
                        sameDirection = false;
                    }
                    if(sameDirection) {
                        personSelected = persons.get(0);
                        output[personSelected] = currSecond;
                        doorLastUsed = currSecond;
                        doorLastUsedFor = state[personSelected];
                    }else if(doorLastUsed!=-1 && currSecond == doorLastUsed + 1) {
                        if(doorLastUsedFor == 0) {
                            for(int person:persons) {
                                if(state[person]==0) {
                                    output[person] = currSecond;
                                    personSelected=person;
                                    doorLastUsed = currSecond;
                                    doorLastUsedFor = state[person];
                                    break;
                                }
                            }
                        } else {
                            for(int person:persons) {
                                if(state[person]==1) {
                                    output[person] = currSecond;
                                    personSelected=person;
                                    doorLastUsed = currSecond;
                                    doorLastUsedFor = state[person];
                                    break;
                                }
                            }
                        }
                    } else {
                        for(int person:persons) {
                            if(state[person]==1) {
                                output[person] = currSecond;
                                personSelected=person;
                                doorLastUsed = currSecond;
                                doorLastUsedFor = state[person];
                                break;
                            }
                        }
                    }
                }
                persons.remove((Integer) personSelected);
                leftOverPersons.remove((Integer) personSelected);
                System.out.println(persons);
                currSecond++;
            }
            System.out.println(leftOverPersons);

            return output;
        }
    }
}