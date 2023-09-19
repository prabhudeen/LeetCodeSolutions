class Solution {
    public String decodeAtIndex(String s, long k) {

        long size = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                size = (size * (ch - '0'));
            } else {
                size++;
            }
        }

    
        for(int i = s.length() - 1; i >=0; i--) {
            k = k % size;
            char ch = s.charAt(i);
            if((k == 0 || k == size) && Character.isLetter(ch)) {
                return Character.toString(ch);
            }
            if(Character.isDigit(ch)) {
                size = size/(ch - '0');
            } else {
                size--;
            }
        }
        return null;
        
    }
}