class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int[] arr = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            arr[i]= Math.abs(nums1[i]-nums2[i]);
        }
        Arrays.sort(arr);
        long ans=0;
        long x =k1+k2;
        long sum = 0;
        for (int d : arr) sum += d;
        if (x >= sum) return 0;
        for(int i=nums1.length-1;i>=0;i--){
            int n = nums1.length-i;
            long target = (i > 0) ? arr[i - 1] : 0;
            long canReduce = (long) arr[i] - target;
            long totalNeeded = canReduce * n;
            if(x<totalNeeded){
                 long nn = arr[i]-x/n;
                 long a = x%n;
                 ans += (nn-1)*a*(nn-1) + nn*nn*(n-a);
                 for(int j=0;j<i;j++){
                ans+=(long)arr[j]*arr[j];
            }
            return ans;
            }else{
                x-=totalNeeded;
                if(i==0) return 0;
            }
        }
        return ans;
    }
}