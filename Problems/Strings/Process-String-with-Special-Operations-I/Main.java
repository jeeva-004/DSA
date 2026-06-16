import java.util.*;

class Main {

    static String processStr(String s) {
        s = s.toLowerCase().replaceAll("[^a-z*%#]", "");
        // * remove last char, %reverse a string, # duplicate the current string
        StringBuilder result = new StringBuilder("");

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                result.append(s.charAt(i));
                continue;
            }
            result = switch (s.charAt(i)) {
                case '#' -> {
                    result.append(result.toString());
                    yield result;
                }
                case '*' -> {
                    if (!result.isEmpty())
                        result.deleteCharAt(result.length() - 1);
                    yield result;
                }
                case '%' -> {
                    result.reverse();
                    yield result;
                }
                default -> {
                    yield result;
                }

            };
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "z*#";
        System.out.print(processStr(s));
    }
}