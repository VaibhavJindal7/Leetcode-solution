class Solution {
    public int[] resultArray(int[] nums) {

        int[] arr1 = new int[nums.length];
        int[] arr2 = new int[nums.length];

        int p1 = 0;
        int p2 = 0;

        arr1[p1++] = nums[0];
        arr2[p2++] = nums[1];

        for (int i = 2; i < nums.length; i++) {
            if (arr1[p1 - 1] > arr2[p2 - 1]) {
                arr1[p1++] = nums[i];
            } else {
                arr2[p2++] = nums[i];
            }
        }

        int j = 0;

        for (int i = 0; i < p1; i++) {
            nums[j++] = arr1[i];
        }

        for (int i = 0; i < p2; i++) {
            nums[j++] = arr2[i];
        }

        return nums;
    }
}