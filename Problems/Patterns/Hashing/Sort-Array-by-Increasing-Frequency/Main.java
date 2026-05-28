import java.util.*;

class Main {
    static int[] frequenceSort(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] sortedArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i]) + 1);
            else
                map.put(arr[i], 1);
        }
        int count = Integer.MAX_VALUE, val = 0, k = 0;
        while (k<sortedArr.length) {
            for (Map.Entry<Integer, Integer> m : map.entrySet()) {
                if(m.getValue()==count)
                    val = m.getKey()>val?m.getKey():val;
                else if (m.getValue() < count) {
                    count = m.getValue();
                    val = m.getKey();
                }
            }
            for (int j = 0; j < count; j++)
                sortedArr[k++] = val;
            map.remove(val);
            val = 0;
            count = Integer.MAX_VALUE;
        }
        System.out.print(Arrays.toString(sortedArr));
        return sortedArr;
    }

    public static void main(String[] args) {
        int[] arr = { 2,3,1,3,2 };
        System.out.println(frequenceSort(arr));
    }
}