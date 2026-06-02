class Solution {
    public String removeDuplicateLetters(String s) {

        //find last occurrance of each ele
        int[] lastOccr = new int[26];
        for(int i=0; i<s.length(); i++){
            lastOccr[s.charAt(i) - 'a'] = i;
        }

        Deque<Character> stack = new ArrayDeque<>();
        Set<Character> present = new HashSet<>();

        for(int i= 0; i<s.length(); i++){
            // if visite skip
            if(present.contains(s.charAt(i)))
                continue;

            //pop chars from stack if lexiologically small and appper again later

            while(!stack.isEmpty() && stack.peek() > s.charAt(i) && lastOccr[stack.peek() - 'a'] > i){
                char c = stack.pop();
                present.remove(c);
            }
            
            stack.push(s.charAt(i));
            present.add(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();

        for(char c: stack){
            sb.append(c);
        }
        return sb.reverse().toString();

    }
}