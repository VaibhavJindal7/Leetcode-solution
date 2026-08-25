class Solution {
    public int missingMultiple(int[] nums, int k) {
        int[] pres = new int[nums.length+1];
        for(int x : nums){
            if (x%k==0 && x/k<=nums.length) pres[x/k]=1;
        }
        for(int i=1;i<=nums.length;i++) if(pres[i]==0) return k*i;
        return k*(nums.length+1);
    }
}