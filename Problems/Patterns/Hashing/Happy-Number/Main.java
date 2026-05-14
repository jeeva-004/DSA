class Main {
    static boolean isHappy(int n) {
        boolean isHappy = true;
        while (isHappy) {
            String str = n + "";
            char[] charArr = str.toCharArray();

            int val = 0;

            for (char c : charArr) {
                int value = Character.getNumericValue(c);
                val += value * value;
                n = val;
            }
            if(n==1)
                isHappy = false;
        }
        if(n==1)
            return true;
        return false;

    }

    public static void main(String[] args) {
        isHappy(2);
    }
}