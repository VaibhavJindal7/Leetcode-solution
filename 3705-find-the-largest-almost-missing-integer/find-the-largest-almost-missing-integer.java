class Solution {
    public int largestInteger(int[] nums, int k) {
        int f=0;
        if(nums.length==0) return -1;
        int l=0;
        ArrayList<Integer> arr = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!hs.contains(nums[i])) hs.add(nums[i]);
            else arr.add(nums[i]);
        }
        for(int i=0;i<arr.size();i++) hs.remove(arr.get(i));
        int max=Integer.MIN_VALUE;
        if(k==1){
            for(int a:hs) max = Math.max(max,a);
            return max==Integer.MIN_VALUE ? -1 : max;
        }else if(k==nums.length){
            for(int b:nums) max= Math.max(max,b);
            return max;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[0]==nums[i]) f++;
        }
        for(int j=0;j<nums.length-1;j++){
            if(nums[nums.length-1]==nums[j]) l++;
        }
        if(l>0 && f>0) return -1;
        else if(l==0 && f==0) return Math.max(nums[0],nums[nums.length-1]);
        else if(l>0) return nums[0];
        return nums[nums.length-1];
    }
}