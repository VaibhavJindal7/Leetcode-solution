class Solution {
    public boolean sumGame(String num) {
       int l=0;
       int r=0;
       int lsum=0;
       int rsum=0;
       for(int i=0;i<num.length()/2;i++){
          if(num.charAt(i)=='?') l++;
          else lsum+=num.charAt(i)-'0';
       } 
       for(int j=num.length()/2;j<num.length();j++){
        if(num.charAt(j)=='?') r++;
        else rsum+=num.charAt(j)-'0';
       }
       int dif = lsum-rsum;
       int qdif = r-l;
       if(qdif==0){
        return dif!=0;
       }
       if(Math.abs(qdif)%2!=0){
         return true;
       }
       return dif!=(qdif/2)*9;
    }
}