class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        int i = 0;
        while(i < n){
            int idx = nums[i] - 1;

            if(nums[i] > 0 && nums[i] <= n && nums[idx] != nums[i]){
                int temp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = temp;
            }else{
                i++;
            }
        }

        for(i = 0; i < n; i ++){
            if(nums[i] != i + 1) return i + 1;
        }

        return n + 1;
    }
}