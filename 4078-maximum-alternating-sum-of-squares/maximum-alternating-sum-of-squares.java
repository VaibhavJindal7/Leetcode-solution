class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0) nums[i]=-nums[i];
        }
        Arrays.sort(nums);
        int n = nums.length%2==0?nums.length/2:(nums.length/2+1);
        long ans=0;
        for(int i=nums.length-1;i>=0;i--){
            if(n>0){
               ans+=(long)nums[i]*nums[i];
               n--;
            }else{
                ans-=(long)nums[i]*nums[i];
            }
        }
        return ans;
    }
}