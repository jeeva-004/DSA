public class Main{
    
    static int maxScore(int[] cardPoints, int k){
        int maxscore = 0, i = 0, left = 0, right = cardPoints.length-k, currentScore = 0, j = cardPoints.length-1;

        //initialize currentSocre

        while(i<left){
            currentScore+=cardPoints[i];
            i++;
        }

        while(j>=right){
            currentScore+=cardPoints[j];
            j--;
        }

        maxscore = currentScore;

        while(left<k && right<cardPoints.length){
            currentScore-=cardPoints[right];
            currentScore+=cardPoints[left];

            maxscore = maxscore<currentScore?currentScore:maxscore;
            left++;
            right++;
        }

        return maxscore;
    }    

    public static void main(String[] args){
        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;

        System.out.print(maxScore(cardPoints, k));
    }
}