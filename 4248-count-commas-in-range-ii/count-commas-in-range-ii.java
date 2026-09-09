class Solution {
    public long countCommas(long n) {
        if(n<1000) return 0;
        long ans=0;
        long a =999;
        int cnt=1;
        while(a<n){
            long x = a*1000 +999;
            if(x<n){
               a =x;
               cnt++;
            }
            else break;
        }
        ans += (n-a)*cnt;
        cnt--;
        while(a>999){
            ans += (a-a/1000)*cnt;
            a=a/1000;
            cnt--;
        }
        return ans;
    }
}