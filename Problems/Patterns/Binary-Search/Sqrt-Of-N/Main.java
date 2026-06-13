class Main{
    static int SqrtOfN(int n){
        int s = 1, e = n;

        while(s<=n){
            int mid = s+(e-s)/2;

            if(mid<n/mid)
                s = mid+1;
            else if(mid>n/mid)
                e = mid-1;
            else
                return mid;
        }
        return e;
    }
    public static void main(String[] args){
        System.out.println(SqrtOfN(25));
    }
}