class Solution {
    public long smallestNumber(long num) {

       long newlongNumber = (num < 0) ? num * -1 : num;
       String stringNumber = String.valueOf(newlongNumber);
       char charArray[] = stringNumber.toCharArray();
       Arrays.sort(charArray);
       if(num < 0) reversCharArray(charArray);
       else  checkLeadingZeroesAndShift(charArray);

       Long answer = Long.parseLong(new String(charArray));
       return (num < 0) ? answer * -1 : answer;
        
    }

    private void reversCharArray(char charArray[]) {
        for(int i = 0; i<charArray.length/2; i++) {
            char temp = charArray[i];
            charArray[i] = charArray[charArray.length - 1 - i];
            charArray[charArray.length - 1 - i] = temp;
        }
    }

    private void checkLeadingZeroesAndShift(char charArray[]) {
        if(charArray.length <= 1) return;
        int i = 0;
        while(i < charArray.length && charArray[i] == '0') i++;

        char temp = charArray[0];
        charArray[0] = charArray[i];
        charArray[i] = temp;
    }
}