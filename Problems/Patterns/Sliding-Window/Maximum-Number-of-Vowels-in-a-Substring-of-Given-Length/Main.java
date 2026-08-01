public class Main {

    static int maxVowelsSubString(String s, int k) {

        if (k > s.length())
            return 0;

        int currentVowels = 0, maxVowels = Integer.MIN_VALUE;

        for (int right = 0; right < s.length(); right++) {

            if (isVowel(s.charAt(right)))
                currentVowels++;

            if (right >= k && isVowel(s.charAt(right - k)))
                currentVowels--;

            if (currentVowels == k)
                return k;

            maxVowels = maxVowels < currentVowels ? currentVowels : maxVowels;

        }

        return maxVowels;
    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;

        System.out.println(maxVowelsSubString(s, k));
    }
}