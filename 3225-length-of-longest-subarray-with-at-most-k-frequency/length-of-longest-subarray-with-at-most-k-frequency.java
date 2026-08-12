class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int max=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int cnt=0;
        int left =0;
        int right =0;
        while(left <nums.length && right<nums.length){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(map.get(nums[right])>k){
                map.put(nums[left],map.get(nums[left])-1);
                left++;
            }
            max= Math.max(max,right-left+1);
            right++;
        }
        return max;
    }
}