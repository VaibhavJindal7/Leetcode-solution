class Solution {

    public boolean predictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                dp[i][j]=-1;
            }
          } 
        return  rec(nums,0,nums.length-1,dp)>=0;
    }
    int rec(int[] nums,int l,int r,int[][] dp){
        if(r==l){
            return nums[l];
        }
        
        if(dp[l][r]!=-1) return dp[l][r];
        int scorebyleft = nums[l]-rec(nums,l+1,r,dp);
        int scorebyright = nums[r]-rec(nums,l,r-1,dp);
        
        return dp[l][r] =Math.max(scorebyleft,scorebyright);
    }
}