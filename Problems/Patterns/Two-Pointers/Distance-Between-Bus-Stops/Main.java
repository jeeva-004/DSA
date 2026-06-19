class Main {

    static int findMinDistance(int[] distance, int start, int destination) {
        if(start==destination)
            return 0;
        
        int forward = 0, backward = 0, i = 0, j = 0;

        if(start>destination){
            //finding forward sum of distance
            i = start;
            while(true){
                if(i==distance.length)
                    i = 0;
                if(i==destination)
                    break;
                forward+=distance[i];
                i++;
            }

            //finding backward sum of distance
            j = start-1;
            while(j>=destination){
                backward+=distance[j];
                j--;
            }
        }
        else{
            //finding forward sum of distance
            i = start;
            while(i<destination){
                forward+=distance[i];
                i++;
            }

            //finding backward sum of distance
            j = start-1;
            while(true){
                if(j<0)
                    j = distance.length-1;
                if(j==destination)
                    break;
                backward+=distance[j];
                j--;
            }
        }

        return Math.min(forward, backward);
    }

    public static void main(String[] args) {
        int start = 1, destination = 3;
        int[] distance = { 1,2,3,4,5 };
        // int[] distance = { 3,14,5,2,21,12,17,24,11,16,15,4,9 };
        System.out.println(findMinDistance(distance, start, destination));
    }
}