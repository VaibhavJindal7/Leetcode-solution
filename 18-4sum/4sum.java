class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n-3;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int j = i+1;
            int k = i+2;
            while(j<n-2){
                int l=n-1;
                while(k<l){
                long sum = (long)nums[i]+nums[j]+nums[k]+nums[l];
                if(sum==target){
                    List<Integer> ls = new ArrayList<>();
                    ls.add(nums[i]);
                    ls.add(nums[j]);
                    ls.add(nums[k]);
                    ls.add(nums[l]);
                    ans.add(ls);
                    k++;
                    l--;
                    while(l>k && nums[k]==nums[k-1]) k++;
                    while(l>k && nums[l]==nums[l+1]) l--;
                }else if(sum>target){
                    l--;
                }else{
                    k++;
                }
                }
                j++;
                while(j<n-2 && nums[j]==nums[j-1]) j++;
                k=j+1;
            }
        }
        return ans;
    }
}