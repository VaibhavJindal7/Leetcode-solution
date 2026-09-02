class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int prod=1;
        for(int i=0;i<nums.length;i++){
            prod=prod*nums[i];
            nums[i]=prod;
            max = Math.max(max,prod);
            if(prod==0) prod=1;
        }
        int lm = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(lm==Integer.MIN_VALUE && nums[i]<0) lm = nums[i];
            else if(lm!=Integer.MIN_VALUE && nums[i]<0){
                if(i<nums.length-1 && nums[i+1]==0) max = Math.max(max,nums[i]/lm);
                if(i==nums.length-1) max = Math.max(max,nums[i]/lm);
            }
            if(nums[i]==0) lm = Integer.MIN_VALUE;
        }
        return max;
    }
}