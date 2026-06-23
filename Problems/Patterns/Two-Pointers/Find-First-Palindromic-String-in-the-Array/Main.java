class Main{
    
        static String firstPalindrome(String[] words) {
        int start = 0;
        while(start<words.length){
            int s = 0, e = words[start].length()-1;
            while(s<=e){
                if(words[start].charAt(s)!=words[start].charAt(e)){
                    start++;
                    break;
                }
                else{
                    s++;
                    e--;
                }
            }

            if(s>e)
                return words[start];
        }

        return "";
    }

    
    
    public static void main(String[] args){
        String[] words = {"abc","car","ada","racecar","cool"};
        System.out.print(firstPalindrome(words));
    }
}