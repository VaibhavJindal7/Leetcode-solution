class Solution {
    public int maximumLengthSubstring(String s) {
        int[] arr = new int[26];
        int left=0;
        int right=0;
        int max=0;
        while(right<s.length()){
            
                arr[s.charAt(right)-'a']++;
            
                while(arr[s.charAt(right)-'a']>2){
                    arr[s.charAt(left)-'a']--;
                    left++;
                }
            
            max=Math.max(max,right-left+1);
            right++;
        }
        return max;
    }
}