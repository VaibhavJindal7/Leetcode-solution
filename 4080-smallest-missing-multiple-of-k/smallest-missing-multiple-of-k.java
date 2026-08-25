class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> hs = new HashSet<>();
        for(int x:nums) hs.add(x);
        for(int i=1;i<=nums.length;i++){
            if(!hs.contains(k*i)){
                return k*i;
            }
        }
       return k*(nums.length+1);
    }
}