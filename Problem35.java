// https://leetcode.com/problems/search-insert-position/description/

public class Problem35 {
    public static int searchInsert(int[] nums, int target) {

        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1; // Update l correctly when nums[mid] < target
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                return mid; // Return mid when nums[mid] == target
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 6 };
        System.out.println(searchInsert(nums, 5)); // Output should be 2
    }
}
