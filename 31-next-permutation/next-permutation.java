class Solution {
    public void nextPermutation(int[] nums) {

        int pivotIndex = findPivotIntex(nums);
        if(pivotIndex == -1) { 
            reversArray(nums, 0);
            return;
        }
        for(int i = nums.length - 1; i> pivotIndex; i --) {
            if(nums[i] > nums[pivotIndex]) {
                int temp = nums[i];
                nums[i] = nums[pivotIndex];
                nums[pivotIndex] = temp;
                break;
            }
        }
        reversArray(nums, pivotIndex + 1);       
    }

    private int findPivotIntex(int []nums) {
        int i = 0;
        for(i = nums.length - 1; i>=1; i--) {
            if(nums[i] > nums[i-1] ) return i - 1;
        }

        return -1;
    }

    private void reversArray(int nums[], int startIndex) {
        int i = startIndex, j = nums.length - 1;
        while(i<j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}