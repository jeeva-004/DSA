class Main{
    static void reverseArray(int arr[]) {
        // code here
        int[] temp = new int [arr.length];
        int size = 0;

        for(int i = arr.length-1; 0<=i; i--){
            temp[size++] = arr[i];
        }
        arr = temp;
        for(int num: arr){
            System.out.print(num+" ");
        }
    }

    public static void main(String[] args){
        int arr[] = {1};
        reverseArray(arr);
    }
}