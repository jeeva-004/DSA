public class Main{
    
    static int missingPossitiveInteger(int[] arr, int k){
        int current = 1, index = 0, missingCount = 0;

        while(true){
            if(index<arr.length && arr[index]==current)
                index++;
            else{
                missingCount++;
                if(missingCount==k)
                    return current;
            }

            current++;
        }

    }

    public static void main(String[] args){
        int[] arr = {2,3,4,6};
        int k = 2;

        System.out.print(missingPossitiveInteger(arr, k));
    }
}