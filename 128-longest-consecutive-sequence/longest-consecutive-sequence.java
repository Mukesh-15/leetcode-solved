class Solution {
    public int longestConsecutive(int[] nums) {
        // ee question chesi waste but urike bore kotti chesthuna..
        HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0;

        for(int i : nums){
            if(map.containsKey(i)) continue;

            int left = map.getOrDefault(i - 1, 0);
            int right = map.getOrDefault(i + 1, 0);

            int len = left + right + 1;

            map.put(i, len);

            map.put(i - left, len);
            map.put(i + right, len);

            res = Math.max(res, len);
        }

        return res;
    }
}