class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length-1;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<=n-2;i++){
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int j = i+1;
            int k = nums.length-1;
            while(k>j){
            int sum=nums[i]+nums[j]+nums[k];
            if(sum==0){
            List<Integer> ls = new ArrayList<>();
            ls.add(nums[i]);
            ls.add(nums[j]);
            ls.add(nums[k]);
            ans.add(ls);
            j++;
            k--;
            while(j<k && nums[j]==nums[j-1]) j++;
            while(j<k && nums[k]==nums[k+1]) k--;
            }else if(sum>0){
                k--;
            }else{
                j++;
            }
        }
        }
        return ans;
    }
}