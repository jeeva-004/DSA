import java.util.HashSet;

public class Main {

    static boolean containsDuplicate(int[] arr) {
        HashSet<Integer> lookUpSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++)
            if (lookUpSet.contains(arr[i]))
                return true;
            else
                lookUpSet.add(arr[i]);

        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3};

        System.out.println(containsDuplicate(arr));
    }
}
