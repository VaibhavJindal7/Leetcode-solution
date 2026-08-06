class Solution {
    public int smallestNumber(int n, int t) {
       if(n%10==0) return n;
       int val=1;
       int a=n+1;
       while(n!=0){
        int c=n%10;
        val*=c;
        n/=10;
       } 
       if(val%t==0) return a-1;
      while(a%10!=0){
        int b =a%10;
        val=(val/(b-1))*b;
        if(val%t==0) return a;
        a++;
      }
      return a;
    }
}