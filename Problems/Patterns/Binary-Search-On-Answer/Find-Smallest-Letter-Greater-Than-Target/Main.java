class Main {

    static char nextGreatestLetter(char[] letters, char target) {
        if (target == letters[letters.length - 1] || target > letters[letters.length - 1] || target == 'z')
            return letters[0];
        
        int s = 0, e = letters.length - 1;
        char greatestCharacter = ' ';

        while (s <= e) {
            int mid = (s + e) / 2;
            if (target < letters[mid]) {
                e = mid - 1;
                greatestCharacter = letters[mid];
            } else
                s = mid + 1;
        }
        return greatestCharacter;
    }

    public static void main(String[] args) {
        char[] letters = { 'c', 'f', 'j' };
        System.out.println(nextGreatestLetter(letters, 'g'));
    }
}