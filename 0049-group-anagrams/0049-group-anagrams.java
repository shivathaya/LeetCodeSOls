class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> opMap = new HashMap<>();

        for(String str : strs){
            char[] arStr = str.toCharArray();
            Arrays.sort(arStr);
            String s = String.valueOf(arStr);
            opMap.computeIfAbsent(s, k -> new ArrayList<>()).add(str);
            //System.out.println(str);
            //List<String> lst = opMap.getOrDefault(s, new ArrayList<String>());
            //lst.add(str);
        }

        return new ArrayList<>(opMap.values());
    }
}