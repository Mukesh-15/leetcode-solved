class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int[] freq = new int[26];

        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }

        int n = s.length();
        boolean leave = true;
        char middle = 0;

        if(n % 2 == 0){
            leave = false;
        }

        for(int i = 0; i < 26; i++){
            if(freq[i] % 2 != 0){
                if(leave){
                    leave = false;
                    middle = (char)('a' + i);
                }else{
                    return "";
                }
            }
        }

        String res = helper("", target, freq, 0, middle, false);

        return res == null ? "" : res;
    }

    private String helper(String curr, String target, int[] freq, int idx, char middle, boolean greater){
        int half = target.length() / 2;

        if(idx == half){
            StringBuilder rev = new StringBuilder(curr);
            rev.reverse();

            String res = curr;

            if(target.length() % 2 != 0){
                res += middle;
            }

            res += rev.toString();

            if(res.compareTo(target) > 0){
                return res;
            }

            return null;
        }

        int start = 0;

        if(!greater){
            start = target.charAt(idx) - 'a';
        }

        for(int i = start; i < 26; i++){
            if(freq[i] < 2){
                continue;
            }

            freq[i] -= 2;

            boolean newGreater = greater;

            if(!greater && i > target.charAt(idx) - 'a'){
                newGreater = true;
            }

            String hmm;

            if(newGreater){
                hmm = buildSmallest(curr + (char)('a' + i), freq, middle, target.length());
            }else{
                hmm = helper(curr + (char)('a' + i), target, freq, idx + 1, middle, false);
            }

            freq[i] += 2;

            if(hmm != null){
                return hmm;
            }
        }

        return null;
    }

    private String buildSmallest(String curr, int[] freq, char middle, int n){
        StringBuilder half = new StringBuilder(curr);

        for(int i = 0; i < 26; i++){
            while(freq[i] >= 2){
                half.append((char)('a' + i));
                freq[i] -= 2;
            }
        }

        StringBuilder rev = new StringBuilder(half);
        rev.reverse();

        String res = half.toString();

        if(n % 2 != 0){
            res += middle;
        }

        res += rev.toString();

        return res;
    }
}
