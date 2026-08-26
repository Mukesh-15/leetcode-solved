class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] strNums = new String[n];

        for(int i = 0; i < n; i++){
            strNums[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        StringBuilder res = new StringBuilder();

        for(String s : strNums){
            res.append(s);
        }

        if(strNums[0].charAt(0) == '0') return "0";

        return res.toString();
    }
}