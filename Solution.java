package lintcode;

import java.util.Arrays;

public class Solution {

    public static int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length <= 2) {
            return 0;
        }
        Arrays.sort(nums);
        int rst = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] >= target) {
                    k--;
                } else {
                    rst += (k - j);
                    j++;
                }
            }
        }//END for
        return rst;
    }

    public static int threeSumClosest(int[] num, int target) {
        if (num == null || num.length < 3) {
            return Integer.MAX_VALUE;
        }
        Arrays.sort(num);
        long closest = (long) Integer.MAX_VALUE;
        for (int i = 0; i < num.length - 2; i++) {
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                int sum = num[i] + num[left] + num[right];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
                closest = Math.abs(sum - target) < Math.abs(closest - target)
                        ? (long) sum : closest;
            }//while
        }//for
        return (int) closest;
    }


    public static void main(String[] args) {
        int[] a =  {-1,2,1,-4};
        int target = 1;

        int[] a1 = {-2, 0, 1, 3};
        int target1 = 2;

        //int result = threeSumClosest(a, target);
        threeSumSmaller(a1, target1);
    }

}