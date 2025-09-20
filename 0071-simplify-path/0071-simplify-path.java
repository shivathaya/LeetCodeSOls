class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String cur = "";
        path = path+"/";

        for(Character c : path.toCharArray()){
            
            if(c == '/'){
                if(cur.equals("..") && !stack.isEmpty()){
                    stack.pop();
                }
                else{
                    if(!cur.equals("") && !cur.equals(".") && !cur.equals("..")){
                        System.out.println(stack.toString());
                        System.out.println(cur);
                         System.out.println(c);
                        stack.push(cur);
                    }

                }
                cur = "";
            }
            else{
                cur = cur+c;
            }
        }
        StringBuilder res = new StringBuilder();
        if(!stack.isEmpty()){
            for(String s: stack){
                res.append("/"+s);
            }

        }else res.append("/");
        return res.toString();
    }
}