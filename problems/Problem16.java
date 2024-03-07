package problems;

import java.util.Arrays;

public class Problem16 {
    public static int threeSumClosest(int[] nums, int target) {
        int ans = 0;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target)
                    return target;

                if (Math.abs(sum - target) < diff) {
                    diff = Math.abs(sum - target);
                    ans = sum;
                }

                if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { -1, 2, 1, -4 };
        System.out.println(threeSumClosest(nums, 1));
    }

}