class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
    
        int cnt = 0;
        int sum = 0;

        for(int i= cost.length -1 ; i>=0; i--){
            cnt++;
            if(cnt <=2)
                sum +=cost[i];
            if(cnt ==3)
                cnt =0;
            

        }


        return sum;

        


        
    }
}