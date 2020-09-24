/**
 * First and last Index of repeated target ele target.
 * if left<target<mid =>Yes => check left side; update right = mid-1;
 * if mid<target<right => Yes => check right side; update left = mid+1; 
 * Time complexity is O(log(n));
 * Ran and accepted in leetcode succesfully.
 */

class Solution {
    
    int[] output = new int[]{-1,-1};
   
    public int[] searchRange(int[] nums, int target) {
        int left=0;
        int right = nums.length - 1;
        BinarySearch(nums, target, left, right, true);
        BinarySearch(nums, target, left, right, false);
        return output;
    }
    
    public void BinarySearch(int[] nums, int target, int left, int right, boolean isleft) { 
        
        while(left <= right) {
           int mid = left + (right - left)/2;
            
            // case 1
            // if mid == target 
            if(nums[mid] == target) {
                // May be first lies in the left; So check left & update right = mid-1;
                if(isleft) {
                    output[0] = mid;
                    right = mid-1;
                }
                // Second lies in the right; So check right & update left = mid+1;
                else {
                    output[1] = mid;
                    left = mid+1;
                }
            }
            
            // case 2
            // if mid < target
            // check right; update left = mid + 1;
            else if(nums[mid] < target) {
                left = mid+1;
            }
            // case 3
            // if mid > target
            // check left; update right = mid - 1;
            else {
                right = mid-1;
            }
            
        }
    }
}