import java.util.*;

class Main {
    static String[] groupAnagrams(String[] words) { 
        List<List<String>> groupsOfAnagrams = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        HashSet<String> set = new HashSet<>();

        for (String s : words)
            set.add(s);

        for (String w : words) {
            // find frequency of current word
            // HashMap<Character, Integer> map = new HashMap<>();
            // for (int i = 0; i < w.length(); i++) {
            // if (map.containsKey(w.charAt(i)))
            // map.put(w.charAt(i), map.get(w.charAt(i) + 1));
            // else
            // map.put(w.charAt(i), 1);
            // }

            for (int i = 1; i < w.length(); i++) {
                if (w.charAt(i) < w.charAt(i - 1)) {
                    char temp = w.charAt(i - 1);
                    w = w.replace(w.charAt(i - 1), w.charAt(i));
                    w = w.replace(w.charAt(i), temp);
                }
                System.out.println(w);
            }

        }

        return words;
    }

    public static void main(String[] args) {
        String[] words = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(Arrays.toString(groupAnagrams(words)));
    }
}