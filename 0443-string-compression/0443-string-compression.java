class Solution {
    public int compress(char[] chars) {
        int read = 0;
        int write = 0;
        int n = chars.length;

        while(read < n){
            char cur = chars[read];
            int count = 0;

            while(read<n && chars[read] == cur){
                read++;
                count++;
            }

            chars[write++] = cur;

            if(count > 1){
                for(char c: Integer.toString(count).toCharArray())
                    chars[write++] = c;
            }
        }

        return write;
    }
}