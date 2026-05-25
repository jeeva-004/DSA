import java.util.*;

class Main {
    static String[] groupAnagrams(String[] words) {
        List<List<String>> groupsOfAnagrams = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        // HashSet<String> set = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> mapCopy = new HashMap<>();

        // for (String s : words)
        // set.add(s);

        for (int i = 0; i < words.length; i++) {
            // find frequency of current word
            for (int j = 0; j < words[i].length(); j++) {
                if (map.containsKey(words[i].charAt(j)))
                    map.put(words[i].charAt(j), map.get(words[i].charAt(j)) + 1);
                else
                    map.put(words[i].charAt(j), 1);
            }

            mapCopy = map;
            for(int k = 0; k<words.length; k++){
                if(words[i]==words[k])
                    tempList.add(words[k]);
                else{
                    while(mapCopy.containsKey(words[k]))
                }
            }

        }

        return words;
    }

    public static void main(String[] args) {
        String[] words = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(Arrays.toString(groupAnagrams(words)));
    }
}