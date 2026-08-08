class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int idx=0;
        int[] ans = new int[m];
        int[] rt = new int[n];
        int j=m-1;
        int a=n-1;
        int rtval=0;
        while(a>=0){
            if(j>=0 && word1.charAt(a)==word2.charAt(j)){
                rtval++;
                j--;
            }
            rt[a]=rtval;
            a--;
        }
        int canchange =1;
        int jk=0;
        int i=0;
        while(i<n && jk<m){
           if( word1.charAt(i)!=word2.charAt(jk)){
             if(i<n-1 && canchange==1 && m-jk-1<=rt[i+1]){
                ans[jk]=i;
                canchange = 0;
                jk++;
             }
           }else{
            ans[jk]=i;
            jk++;
           }
           i++;
        }
        return jk==m ?ans:new int[0];
    }
}