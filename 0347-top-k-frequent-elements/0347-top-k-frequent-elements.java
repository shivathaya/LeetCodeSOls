class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        PriorityQueue<Integer> minQueue = new PriorityQueue<>((a,b) -> freqMap.get(a) - freqMap.get(b));

        for(int n: nums){
            freqMap.put(n, freqMap.getOrDefault(n, 0)+1);
        }

        for(Integer num: freqMap.keySet()){
            minQueue.add(num);
            System.out.println(minQueue.toString());
            if(minQueue.size() > k)
                minQueue.poll();
        }

        int[] result = new int[minQueue.size()];

        int i=0;
        while(!minQueue.isEmpty()){
            result[i] = minQueue.poll();
            i++;
        }

        return result;
    }
}