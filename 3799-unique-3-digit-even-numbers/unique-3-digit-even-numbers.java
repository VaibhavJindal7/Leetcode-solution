class Solution {
    public int totalNumbers(int[] digits) {
        int n =digits.length;
        int ans=0;
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(i!=j && j!=k && i!=k){
                        int x = digits[i]*100+digits[j]*10+digits[k];
                        if(x%2==0 && !hs.contains(x)&& x>99){
                            hs.add(x);
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}