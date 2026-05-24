class Main {

    static int findMinDistance(int[] distance, int start, int destination) {
        int sTof = 0, sTob = 0;
        int i = 0, j = 0;
        if (start > destination) {
            i = start;
            while (true) {
                if (i == distance.length)
                    i = 0;
                if (i == destination)
                    break;
                sTof += distance[i];
                i++;
            }
            j = start - 1;
            while (j >= destination) {
                sTob += distance[j];
                j--;
            }
        } else {
            i = start;
            while (i < destination) {
                sTof += distance[i];
                i++;
            }

            j = start - 1;
            while (true) {
                if (j < 0)
                    j = distance.length - 1;
                sTob += distance[j];
                if (j == destination)
                    break;
                j--;
            }
        }
        return Math.min(sTof, sTob);
    }

    public static void main(String[] args) {
        int start = 22, destination = 0;
        int[] distance = { 6, 47, 48, 31, 10, 27, 46, 33, 52, 33, 38, 25, 32, 45, 36, 3, 0, 33, 22, 53, 8, 13, 18, 1,
                44, 41, 14, 5, 38, 25, 48 };
        // int[] distance = { 3,14,5,2,21,12,17,24,11,16,15,4,9 };
        System.out.println(findMinDistance(distance, start, destination));
    }
}