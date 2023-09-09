class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        int i, j;
        boolean isValid = false;

        for(i = 0; i < s.length(); i++) {
            if(st.isEmpty() && (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']')) {
                return false;
            }

            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
            } else if(!st.isEmpty()){
                if((s.charAt(i) == ')' && st.peek() != '(') ||
                (s.charAt(i) == '}' && st.peek() != '{') ||
                (s.charAt(i) == ']' && st.peek() != '[')) {
                   return false;
                } else {
                    st.pop();
                }
            } else {
               return false;
            }
        }

        return st.isEmpty() ? true : false;
    }
}