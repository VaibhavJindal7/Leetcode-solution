class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int pro=1;
        int p =n;
        while(p!=0){
            int b = p%10;
            sum+=b;
            pro*=b;
            p=p/10;
        }

        return n%(sum+pro)==0 ? true : false;
    }
}