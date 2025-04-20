class Solution {
    public String removeStars(String s) {
        Stack<Character> stk = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '*')
                stk.pop();
            else
                stk.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : stk)
            sb.append(ch);
        return sb.toString();
        // return new StringBuilder(stk.toString().replace(',',' ').replace('[',' ').replace(']',' ').replaceAll(" ","")).toString();
    }
}