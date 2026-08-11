class Solution {
    public int missingInteger(int[] nums) {
        boolean[] map = new boolean[52];
        int sum = nums[0];
        map[sum] = true;
        int i = 1;

        for(i = 1; i < nums.length && nums[i] == nums[i - 1] + 1; i++){
            sum += nums[i];
            map[nums[i]] = true;
        }

        for(; i < nums.length; i++) map[nums[i]] = true;

        for(int j = sum; j < 52; j++){
            if(!map[j]) return j;
        }

        return sum;
    }
}