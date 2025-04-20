class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int highest = Arrays.stream(candies).max().getAsInt();
        List<Boolean> res = new ArrayList<>();

        for(int i : candies){
           res.add(i+extraCandies >= highest);
        }
        return res;
    }
}