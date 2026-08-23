import java.util.*;
class Main {
    static int numRescueBoats(int[] people, int limit) {
        if (people.length == 0)
            return 0;
        Arrays.sort(people);
        int boats = 0;
        int left = 0, right = people.length - 1;
        while (left <= right) {
            if (people[left] + people[right] <= limit)
                left++;
            right--;
            boats++;
        }
        return boats;
    }
    public static void main(String[] args) {
        int[] people = { 1, 2 };
        System.out.println(numRescueBoats(people, 3));
    }
}