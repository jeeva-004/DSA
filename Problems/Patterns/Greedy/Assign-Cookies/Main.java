import java.util.*;

public class Main {

    static int assignCookies(int[] childs, int[] cookies) {
        if (cookies.length == 0)
            return 0;

        Arrays.sort(childs);
        Arrays.sort(cookies);

        int childPointer = 0, cookiePointer = 0;

        while (childPointer < childs.length && cookiePointer < cookies.length) {
            if (cookies[cookiePointer] >= childs[cookiePointer]) {
                childPointer++;
                cookiePointer++;
            } else
                cookiePointer++;
        }

        return childPointer;
    }

    public static void main(String[] args) {
        int[] childs = { 1, 2, 3 }, cookies = { 1, 2 };
        System.out.print(assignCookies(childs, cookies));
    }
}