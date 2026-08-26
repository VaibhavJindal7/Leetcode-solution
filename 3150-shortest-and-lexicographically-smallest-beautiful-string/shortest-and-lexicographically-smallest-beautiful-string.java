class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int l=0;
        int r=0;
        int cnt=0;
        int len=Integer.MAX_VALUE;

        while(r<s.length()){
            if(cnt<k){
                if(s.charAt(r)=='1') cnt++;
                r++;
            }else{
                len = Math.min(len,r-l);

                if(s.charAt(l)=='1') cnt--;
                l++;
            }
        }
         while(cnt==k){
            len = Math.min(len,r-l);

            if(s.charAt(l)=='1') cnt--;
            l++;
        }
        r=0;
        l=0;
        cnt=0;
        String ans ="";

        while(r<s.length()){
            if(cnt<k){
                if(s.charAt(r)=='1') cnt++;
                r++;
            }else{
                if(len==r-l){
                    String temp = s.substring(l,r);

                    if(ans.equals("") || temp.compareTo(ans) < 0){
                        ans = temp;
                    }
                }

                if(s.charAt(l)=='1') cnt--;
                l++;
            }
        }
        while(cnt==k){
            if(len==r-l){
                String temp = s.substring(l,r);

                if(ans.equals("") || temp.compareTo(ans)<0){
                    ans=temp;
                }
            }

            if(s.charAt(l)=='1') cnt--;
            l++;
        }
        return ans;
    }
}