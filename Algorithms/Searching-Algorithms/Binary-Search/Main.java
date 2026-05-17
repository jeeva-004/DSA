class Main {

    // Time Complexity O (Log n)

    public static int search(int[] arr, int target) {
        
        // find array is assending or deccending 

        boolean isAccending = arr[arr.length-1]>arr[0]?true:false;
        int s = 0, e = arr.length-1;
        while(s<=e){
        int mid = (s+e)/2;
        if(isAccending){
            if(target>arr[mid])
                s = mid+1;
            else if(target<arr[mid])
                e = mid-1;
            else
                return mid;
        }
        else{
            
            if(target>arr[mid])
                e = mid-1;
            else if(target<arr[mid])
                s = mid+1;
            else
                return mid;
        }
    }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 5,4,3,2,1 };
        System.out.println(search(arr, 3));
    }
}