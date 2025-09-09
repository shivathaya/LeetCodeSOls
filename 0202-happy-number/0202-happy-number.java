class Solution {
    public boolean isHappy(int n) {
        // set to track visited
        Set<Integer> checked = new HashSet<>();
        //if n is in visited then it will be equal to 1
        while(!checked.contains(n)){
            checked.add(n);
            n = sumSqur(n);
            if(n==1) return true;
        }
        return false;
    }

    public int sumSqur(int n){
        int sum = 0;    
        while(n>0){
            int dig = n%10;
            sum = sum + (dig*dig);
            n = n/10; 
        }
        return sum;
    }
}