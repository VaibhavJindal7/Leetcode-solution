class Solution {
    public void sortColors(int[] nums) {
        // int zero=0;
        // int one=0;
        // int two=0;
        // for(int a:nums){
        //     if(a==0) zero++;
        //     if(a==1) one++;
        //     if(a==2) two++;
        // }
        // int i=0;
        // while(zero!=0){
        //     nums[i++]=0;
        //     zero--;
        // }
        // while(one!=0){
        //     nums[i++]=1;
        //     one--;
        // }
        // while(two!=0){
        //     nums[i++]=2;
        //     two--;
        // }
        // return;
        int l=0;
        int H=nums.length-1;
        for(int i=0;i<=H;i++){
            if(nums[i]==0){
                int temp =nums[l];
                nums[l]=0;
                nums[i]= temp;
                l++;
            }
            else if(nums[i]==2){
                int temp=nums[H];
                nums[H]=2;
                nums[i]=temp;
                H--;
                i--;
            }
        }
    }
}