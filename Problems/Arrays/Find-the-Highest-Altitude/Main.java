class Main{

    static int largestAltitude(int[] arr){
        if(arr.length==0) return 0;
        
        int altitude = 0, max = 0;
        
        for(int n: arr){
            max+=n;
            if(max>altitude)
                altitude = max;
        }
        
        return altitude;
    }

    public static void main(String[] args){
        int[] arr = {-5,1,5,0,-7};
    }
}