public class Main{

    static String longestCommonPrefix(String[] strs) {

        if(strs.length==0)
            return "";
        if(strs.length==1)
            return strs[0];

        StringBuilder longestPrefix = new StringBuilder(strs[0]);

        for(int i = 0; i<strs.length; i++){
            if(strs[i].isEmpty())
                return "";

            int j = 0;
            for(j = 0; j<strs[i].length(); j++){
                if(j>=longestPrefix.length()|| longestPrefix.charAt(j)!=strs[i].charAt(j)){
                    longestPrefix.delete(j, longestPrefix.length());
                    break;
                }
            }

            if(j<longestPrefix.length())    
                longestPrefix.delete(j, longestPrefix.length());
        }

        return longestPrefix.toString();
    }

    public static void main(String[] args){
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}