import java.util.*;

class Main {
    static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (true) {
            String str = n + "";
            char[] charArr = str.toCharArray();
            int val = 0;

            for (char ch : charArr) {
                int value = Character.getNumericValue(ch);
                val += value * value;
            }
            if (val == 1)
                return true;
            if (set.contains(val))
                break;
            else
                set.add(val);
            n = val;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}