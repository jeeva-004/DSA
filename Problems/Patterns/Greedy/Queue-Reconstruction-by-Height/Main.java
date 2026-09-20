import java.util.*;

public class Main{
    
    //people[0] - height, people[1] - k (how many taller people should before its)

    static int[][] constructQueue(int[][] people){
        Arrays.sort(people, (a, b)->{
            if(a[0]!=b[0])
                return Integer.compare(a[0], b[0]);
            
            return Integer.compare(b[1], a[1]);
        });

        ArrayList<int[]> correctPositioned = new ArrayList<>();

        for(int i = people.length-1; i>=0; i--){
            int[] person = people[i];

            correctPositioned.add(person[1], person);
        }

        int[][] constructedQueue = new int[people.length][2];

        for(int p = 0; p<people.length; p++){
            constructedQueue[p] = correctPositioned.get(p);
        }

        return constructedQueue;
    }   

    public static void main(String[] args){
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};

        int[][] constructedQueue = constructQueue(people);

        for(int[] person: constructedQueue)
            System.out.print(Arrays.toString(person)+" "); 
    }
}