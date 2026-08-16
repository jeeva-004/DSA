import java.util.Arrays;

public class Main {
    // 0 = red, 1 = while, 2 = blue. the array contains those values only sort the
    // colors.

    static void sortColors(int[] colors) {
        quickSort(colors, 0, colors.length - 1);
    }

    static void quickSort(int[] colors, int low, int high) {
        if(low>=high)
            return;
        int s = low, e = high, mid = (s+e)/2, pivot = colors[mid];

        while(s<=e){
            while(colors[s]<pivot)
                s++;
            while(colors[e]>pivot)
                e--;

            if(s<=e){
                int temp = colors[s];
                colors[s] = colors[e];
                colors[e] = temp;
                e--;
                s++;
            }
        }

        quickSort(colors, low, e);
        quickSort(colors, s, high);
    }

    public static void main(String[] args) {
        int[] colors = {1,2,1,2,0,0,1,0,1};

        sortColors(colors);

        System.out.println(Arrays.toString(colors));
    }
}