class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radient = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int n = senate.length();

        for(int i=0; i<n; i++){
            if(senate.charAt(i) == 'R'){
                radient.offer(i);
            } else{
                dire.offer(i);
            }
        }

        while(!radient.isEmpty() && !dire.isEmpty()){
            int ridx = radient.poll();
            int didx = dire.poll();

            if(ridx<didx){
                radient.offer(ridx+n);
            } else{
                dire.offer(didx+n);
            }
        }
    return radient.isEmpty()?"Dire" : "Radiant" ;

    }
}