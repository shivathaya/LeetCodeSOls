class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        //potions.sort();
        Arrays.sort(potions);
        int len = potions.length;
        int[] res = new int[spells.length];
        for(int i = 0; i< spells.length; i++){
            res[i] = bsearch(potions, spells[i], success);
        }
        return res;
    }

    public int bsearch(int[] potions, int spl,  long success){
        //int len = potions.length;
        int l = 0;
        int h = potions.length - 1;
        int count = 0;
        while(l <= h){
            int mid = l + (h-l)/2;

            if((long)potions[mid] * spl >= success){
                count = potions.length - mid;
                //System.out.println(mid);
                h = mid-1;
            }else{
                l = mid +1;
            }
        }
        return count;

    }
}