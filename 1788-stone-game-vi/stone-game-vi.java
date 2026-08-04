class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        Integer[] idxs = new Integer[n];

        for(int i = 0; i < n; i++){
            idxs[i] = i;
        }

        Arrays.sort(idxs, (a, b) -> Integer.compare(aliceValues[b] + bobValues[b], aliceValues[a] + bobValues[a]));

        int alice = 0, bob = 0;
        
        for(int i = 0; i < n; i++){
            if(i % 2 == 0){
                alice += aliceValues[idxs[i]];
            }else{
                bob += bobValues[idxs[i]];
            }
        }

        return (alice > bob) ? 1 : (bob > alice) ? -1 : 0;
    }
}