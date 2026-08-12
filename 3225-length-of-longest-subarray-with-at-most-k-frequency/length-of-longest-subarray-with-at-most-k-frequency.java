class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int prev = 0, res = 0;

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            while(map.getOrDefault(nums[i], 0) > k){
                // System.out.println(prev + " " + nums[prev]);
                
                map.put(nums[prev], map.get(nums[prev]) - 1);
                prev++;
            }


            res = Math.max(res, i - prev + 1);
        }

        return res;
    }
}