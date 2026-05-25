import java.util.*;

class Main {

    static ArrayList<String> commonChars(String[] words) {
        ArrayList<String> commonChars = new ArrayList<>();
        String checkWord = words[0];
        for (int i = 0; i < checkWord.length(); i++) {
            boolean common = true;
            for (int j = 1; j < words.length; j++) {
                if (words[j].indexOf(checkWord.charAt(i)) != -1) {
                    String s = checkWord.charAt(i) + "";
                    words[j] = words[j].replaceFirst(s, "");
                    continue;
                }
                else{
                    common = false;
                    break;
                }
            }
            if(common)
                commonChars.add(checkWord.charAt(i)+"");
        }
        return commonChars;
    }

    public static void main(String[] args) {
        // String[] words = { "cool","lock","cook" };
        String[] words = { "bella", "label", "roller" };
        System.out.println(commonChars(words));
    }
}
