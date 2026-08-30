class Solution {
    public int minimumDeletions(int[] nums) {
        if(nums.length==1) return 1;
    
        int midx=-1;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int maxi =-1;
        for(int i=0;i<nums.length;i++){
            if(min>nums[i]){
                min=nums[i];
                midx=i;
            }
            if(max<nums[i]){
                max=nums[i];
                maxi=i;
            }
        }
        
        int l=Math.max(midx,maxi)+1;
        int r = nums.length-Math.min(maxi,midx);
        int lr = Math.min(midx,maxi)+1+nums.length-Math.max(maxi,midx);
        return Math.min(l,Math.min(r,lr));
    }
}