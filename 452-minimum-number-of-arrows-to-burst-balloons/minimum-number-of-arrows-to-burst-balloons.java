class Solution {
    public int findMinArrowShots(int[][] points) {
        int i, j; 
        int n = points.length;
        int counts = 1;
        Arrays.sort(points, (arr1, arr2) -> {
            if(arr1[1] == arr2[1]) return 0;
            if(arr1[1] < arr2[1]) return -1;
            return 1;
        });
        int mxPoint = points[0][1];
        for(i = 1; i < n; i++) {
            int curPoints[] = points[i];
            if(curPoints[0] > mxPoint) {
                counts++;
               mxPoint = curPoints[1];
            }
        }
        return counts;
    }
}