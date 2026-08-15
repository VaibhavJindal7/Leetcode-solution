class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p1 = 0;
        int p2 = 0;
        int cnt = 0;
        int r = nums1.length + nums2.length;
        int mid = r / 2;

        int prev = 0;
        int curr = 0;

        while (cnt <= mid) {
            prev = curr;

            if (p1 < nums1.length && 
                (p2 >= nums2.length || nums1[p1] <= nums2[p2])) {
                curr = nums1[p1];
                p1++;
            } else {
                curr = nums2[p2];
                p2++;
            }

            cnt++;
        }

        if (r % 2 == 0) {
            return (double)(prev + curr) / 2;
        } else {
            return (double)curr;
        }
    }
}