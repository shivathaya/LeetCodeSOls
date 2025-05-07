class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        while(i< s.length()){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                int strtidx = i;
                while(Character.isDigit(s.charAt(i))){
                    i++;
                }
                stack.push(s.substring(strtidx,i));
                continue;
            } else if(ch == '['){
                stack.push("[");
            } else if(ch == ']'){
                StringBuilder encoded = new StringBuilder();
                while(!stack.peek().equals("[")){
                    encoded.insert(0, stack.pop());
                }
                stack.pop();  // remove [

                int repet = Integer.parseInt(stack.pop());
                String rep = encoded.toString().repeat(repet);
                stack.push(rep);
            } else{
                stack.push(String.valueOf(ch));
            }
            i++;
        }

        StringBuilder sb = new StringBuilder();
        for(String str : stack){
            sb.append(str);
        }
        return sb.toString();
    }
}