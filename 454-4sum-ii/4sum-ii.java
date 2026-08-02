class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int cnt=0;
        int n = nums1.length;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                mp.put(nums1[i]+nums2[j],mp.getOrDefault(nums1[i]+nums2[j],0)+1);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mp.containsKey(-(nums3[i]+nums4[j]))){
                    cnt+=mp.get(-(nums3[i]+nums4[j]));
                }
            }
        }
        return cnt;
    }
}