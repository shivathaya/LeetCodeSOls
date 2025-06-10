class Solution {
    public int maxDifference(String s) {

        Map<Character, Integer> hmp = new HashMap<>();
        for(char c: s.toCharArray()){
            hmp.put(c, hmp.getOrDefault(c,0)+1);
        }

        Integer maxOdd = Integer.MIN_VALUE;
        Integer minEvn = Integer.MAX_VALUE;
        List<Integer> lst = new ArrayList<>(hmp.values());

        for(Integer i: lst){
            if(i%2 == 0 && i<minEvn)
                minEvn = i;
            else if(i%2 != 0 && i>maxOdd)
                maxOdd = i;
        }
        //System.out.println(minEvn);
        //System.out.println(maxOdd);
       // System.out.println(1%2);
        return maxOdd - minEvn;
    }
}