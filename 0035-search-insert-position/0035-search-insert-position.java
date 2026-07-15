class Solution {

    public int searchInsert(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start ) / 2;

            if (nums[mid] == target) {
                return mid; // means we found the trget index so return it
            }
            else if (nums[mid] > target) {
                end = mid - 1; // move to left for searching target index
            }
            else {
                // nums[mid] < target
                start = mid + 1;
            }
        }
        // if target not found that means we needs to instert it so return start as new index of that target
        return start;
    }
}