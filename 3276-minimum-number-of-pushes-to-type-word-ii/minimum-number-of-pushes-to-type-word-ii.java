class Solution {
    public int minimumPushes(String word) {
      int cnt=1;
      int n=25;
      int[] arr = new int[26];
      for(int i=0;i<26;i++) arr[i]=0;
      for(int i=0;i<word.length();i++){
        arr[word.charAt(i)-'a']++;
      }  
      int ans=0;
      Arrays.sort(arr);
      for(int i=0;i<3;i++){
        for(int j =0;j<8;j++){
            int idx = n-j;
            ans+=arr[idx]*cnt;
        }
        n-=8;
        cnt++;
    }
    ans=ans+(arr[1]+arr[0])*4;
    return ans;
    }
}