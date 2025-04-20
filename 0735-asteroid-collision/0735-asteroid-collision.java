class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int i: asteroids){
            boolean des = false;

            while(!st.isEmpty() && i<0 && st.peek() >0){
                int top = st.peek();
                if(top < -i){
                    st.pop();
                    //break;
                }
                else if(top == -i){
                    st.pop();
                    des = true;
                    break;
                }else {
                    des = true;
                    break;
                }
            }
            if(!des){
                st.push(i);
            }
        }
       // System.out.println(st);
        int[] res = new int[st.size()];
        if(st.size() > 0){
        for(int i =res.length-1 ; i>=0; i--){
            res[i] = st.pop();
        }
        }
        return res;
    }
}