import java.util.*;

class Main {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> indexs = new ArrayList<>();
        int start = 0, currentValue = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = start; j < arr.length; j++) {
                if (currentValue < target) {
                    currentValue += arr[j];
                    if (currentValue == target) {
                        indexs.add(start + 1);
                        indexs.add(j + 1);
                        return indexs;
                    }
                } else {
                    currentValue = 0;
                    start++;
                    break;
                }
            }
        }
        indexs.add(-1);
        return indexs;
    }

    public static void main(String[] args) {
        int[] arr = {49 ,23 ,2 ,22,50 ,8 ,27, 43, 40, 26, 13, 1, 11, 4, 20};
        ArrayList indexs = subarraySum(arr, 112);

        for(int i = 0; i<indexs.size(); i++){
            System.out.print(indexs.get(i)+" ");
        }
    }
}