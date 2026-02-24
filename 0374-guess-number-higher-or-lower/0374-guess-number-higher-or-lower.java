/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1;
        int h = n;
        int mid = 0;
        //int sol = 0;
        while(l <= h){
            //mid = (l + h)/2;
            mid = l + (h - l) / 2;
            int gss = guess(mid);
            if(gss == 0){
                return mid;
            }else if(gss == -1){
                h = mid -1;
            }else{
                l = mid + 1;
            }
        }
        return -1;
    }
}