class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i=0;i<=s.length();i++) dp[i][t.length()]=1;

    for(int i=s.length()-1;i>=0;i--){
        for(int j=t.length()-1;j>=0;j--){
            if(s.charAt(i)==t.charAt(j)){
                dp[i][j]= dp[i+1][j+1]+dp[i+1][j];
            }else{
                dp[i][j]=dp[i+1][j];
            }
        }
    }
        return dp[0][0];
    }

    int dfs(String s, int i, String t, int j, HashMap<String, Integer> dp) {
        if (j == t.length())
            return 1;

        if (i == s.length())
            return 0;

        String key = i + "," + j;

        if (dp.containsKey(key))
            return dp.get(key);

        int take = 0;

        if (s.charAt(i) == t.charAt(j))
            take = dfs(s, i + 1, t, j + 1, dp);

        int nottake = dfs(s, i + 1, t, j, dp);

        dp.put(key, take + nottake);

        return take + nottake;
    }
}