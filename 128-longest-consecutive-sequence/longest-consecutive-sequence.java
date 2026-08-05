class Solution {
    public int longestConsecutive(int[] nums) {
        // ee question chesi waste but urike bore kotti chesthuna..
        HashSet<Integer> set = new HashSet<>();

        for(int i : nums) set.add(i);

        int res = 0;

        for(int i : set){
            if(!set.contains(i - 1)){
                int curr = i;
                int len = 1;

                while(set.contains(curr + 1)){
                    curr++;
                    len++;
                }

                res = Math.max(res, len);
            }
        }

        return res;
    }
}
