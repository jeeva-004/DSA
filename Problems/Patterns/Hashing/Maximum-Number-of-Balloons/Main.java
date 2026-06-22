import java.util.*;

class Main {

    static int numberOfBalloons(String text) {
        String answer = "balloon";
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < text.length(); i++) 
            if (answer.indexOf(text.charAt(i)) != -1) 
                map.put(text.charAt(i), map.getOrDefault(text.charAt(i), 0) +1);
        
        int a = map.getOrDefault('a',0);
        int b = map.getOrDefault('b',0);
        int l = map.getOrDefault('l',0);
        int o = map.getOrDefault('o',0);
        int n = map.getOrDefault('n',0);

        return Math.min(Math.min(a, b), Math.min(l/2, Math.min(o/2, n)));
    }

    public static void main(String[] args) {
        // String text = "krhizmmgmcrecekgyljqkldocicziihtgpqwbticmvuyznragqoyrukzopfmjhjjxemsxmrsxuqmnkrzhgvtgdgtykhcglurvppvcwhrhrjoislonvvglhdciilduvuiebmffaagxerjeewmtcwmhmtwlxtvlbocczlrppmpjbpnifqtlninyzjtmazxdbzwxthpvrfulvrspycqcghuopjirzoeuqhetnbrcdakilzmklxwudxxhwilasbjjhhfgghogqoofsufysmcqeilaivtmfziumjloewbkjvaahsaaggteppqyuoylgpbdwqubaalfwcqrjeycjbbpifjbpigjdnnswocusuprydgrtxuaojeriigwumlovafxnpibjopjfqzrwemoinmptxddgcszmfprdrichjeqcvikynzigleaajcysusqasqadjemgnyvmzmbcfrttrzonwafrnedglhpudovigwvpimttiketopkvqw";
        String text = "balloon";
        System.out.println(numberOfBalloons(text));
    }
}