import java.util.*;
import java.util.HashMap;;

public class Main {

    //using HashMap
    static int leastInterval(char[] tasks, int gap) {
        int maxOccur = 0, maxEqualOccur = 0;

        HashMap<Character, Integer> freq = new HashMap<>();

        for (char task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
            maxOccur = maxOccur < freq.get(task) ? freq.get(task) : maxOccur;
        }

        for (Map.Entry<Character, Integer> m : freq.entrySet()) {
            if (maxOccur == m.getValue())
                maxEqualOccur++;
        }

        int leastIntervals = (maxOccur - 1) * (gap + 1) + maxEqualOccur;

        return leastIntervals < tasks.length ? tasks.length : leastIntervals;
    }


    //using premitive array
    static int minInterval(char[] tasks, int gap){
        int maxOccur = 0, maxEqualOccur = 0;
        int[] freq = new int[26];

        //count frequencies
        for(int task = 0; task<tasks.length; task++){
            freq[tasks[task]-'A']++;
            
            maxOccur = maxOccur<freq[tasks[task]-'A']?freq[tasks[task]-'A']:maxOccur;
        }


        for(int i = 0; i<freq.length; i++)
            if(freq[i]==maxOccur)
                maxEqualOccur++;

    
        int minInterval = (maxOccur - 1) * (gap+1) + maxEqualOccur;

        return minInterval<tasks.length?tasks.length:minInterval;
    }

    public static void main(String[] args) {
        char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
        int gap = 3;

        System.out.println(leastInterval(tasks, gap));
        System.out.println(minInterval(tasks, gap));
    }
}