class Solution {
    public int longestSubsequence(int[] nums) {
        int a = 0;
        boolean nonZero = false;

        for (int x : nums) {
            a ^= x;
            if (x != 0) {
                nonZero = true;
            }
        }

        if (a != 0) {
            return nums.length;
        }

        if (nonZero) {
            return nums.length - 1;
        }

        return 0;
    }
}