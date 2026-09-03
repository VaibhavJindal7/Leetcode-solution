class Solution {
    public boolean uniformArray(int[] nums1) {
      int minodd = Integer.MAX_VALUE;
      int ne =0;
      int no =0;
      for(int i=0;i<nums1.length;i++){
        if(nums1[i]%2==0){
            ne++;
            continue;
        }else{
            no++;
            minodd=Math.min(minodd,nums1[i]);
        }
      }  
      if(no==0 ||ne==0) return true;
      for(int i=0;i<nums1.length;i++){
         if(nums1[i]%2==0 && minodd>nums1[i]) return false;
      }
      return true;
    }
}