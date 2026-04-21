import java.util.ArrayList;

class Main {
    static int secondHighest(String s) {
        char[] chars = s.trim().toCharArray();

        int secondLargeValue = Integer.MIN_VALUE;
        int count = 0;
        if (1 <= s.length() && s.length() <= 500) {
            for (int i = 0; i <= chars.length - 1; i++) {
                if (Character.isDigit(chars[i])) {
                    if (count > 1)
                        return secondLargeValue;
                    if (chars[i] > secondLargeValue) {
                        secondLargeValue = chars[i];
                        count++;
                    }
                }
            }

            return -1;
        }

        return 2;
    }

    public static void main(String[] args) {
        System.out.print(secondHighest("dfa12321"));
    }

}