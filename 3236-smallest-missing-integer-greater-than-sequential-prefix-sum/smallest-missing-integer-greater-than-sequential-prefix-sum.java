class Solution {
    public int missingInteger(int[] nums) {
       HashSet<Integer> hs = new HashSet<>();
       for(int a : nums) hs.add(a);
       int sum=nums[0];
       int i=1;
           while(i<nums.length && nums[i-1]+1==nums[i]){
            sum+=nums[i];
            i++;
           }  
       while(true){
         if(hs.contains(sum)) sum++;
         else break;
       }
       return sum;
    }
}