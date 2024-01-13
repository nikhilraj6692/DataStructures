package preparation.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Test16MaxFrequencyElement
{

    public static void main(String[] args)
    {
        FreqStack fs = null;
        String[] commands = new String[]{"FreqStack","push","push","push","push","push","push","pop","push","pop","push","pop","push","pop","push","pop","pop","pop","pop","pop","pop"};
        int[] val = new int[]{4,0,9,3,4,2,6,1,1,4};
        int pushedCounter = 0;
        for(String command : commands) {
            if(command == "FreqStack") {
                fs = new FreqStack();
            } else if(command == "push") {
                fs.push(val[pushedCounter++]);
            } else{
                fs.pop();
            }
        }
    }
    static class FreqStack {
        Map<Integer, Integer> valToFreqMap;
        Map<Integer, Stack<Integer>> freqToPositionMap;
        int maxFreq = -1;

        public FreqStack() {
            this.valToFreqMap = new HashMap<>();
            this.freqToPositionMap = new HashMap<>();
        }

        public void push(int val) {
            Integer freq = valToFreqMap.get(val);
            if(null == freq) {
                freq = 0;
            }
            valToFreqMap.put(val, ++freq);


            Stack<Integer> st = freqToPositionMap.get(freq);
            if(null == st) {
                st = new Stack<Integer>();
            }
            st.push(val);
            freqToPositionMap.put(freq, st);

            if(freq > maxFreq)
                maxFreq = freq;


        }

        /*
        1,[4,0,9,3,2]
        2,[4]
        */
        public int pop() {
            System.out.println(freqToPositionMap);
            Stack<Integer> st = freqToPositionMap.get(maxFreq);
            //this is the only element with max freq, pop its value and remove
            //the frequency from map, as well as maxFreq will be one smaller now
            int val = -1;
            if(st.size() == 1){
                val = st.pop();
                freqToPositionMap.remove(maxFreq);
                maxFreq--;
            } else {
                //there are more than one elements with same frequency
                //and we have to return topmost element
                val = st.pop();
            }
            System.out.println(val);

            //also decrease frequency of val
            Integer freq = valToFreqMap.get(val);
            if(freq == 1) {
                valToFreqMap.remove(val);
            } else{
                valToFreqMap.put(val, --freq);
            }

            return val;
        }
    }



/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
}
