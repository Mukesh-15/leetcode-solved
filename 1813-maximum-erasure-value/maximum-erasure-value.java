class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n + 1];

        for(int i = 1; i <= n; i++){
            prefix[i] = nums[i - 1] + prefix[i - 1];
        }

        int start = 0, res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            if(map.containsKey(nums[i])){
                int till = map.get(nums[i]) + 1;

                while(start != till){
                    map.remove(nums[start++]);
                }
            }

            map.put(nums[i], i);

            res = Math.max(res, prefix[i + 1] - prefix[start]);
        }

        return res;
    }
}