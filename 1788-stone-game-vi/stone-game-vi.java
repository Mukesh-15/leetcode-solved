class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(aliceValues[b] + bobValues[b], aliceValues[a] + bobValues[a]));

        for(int i = 0; i < n; i++){
            pq.add(i);
        }

        int alice = 0, bob = 0;
        boolean aliceTurn  = true;

        while(!pq.isEmpty()){
            if(aliceTurn){
                alice += aliceValues[pq.poll()];
            }else{
                bob += bobValues[pq.poll()];
            }

            aliceTurn = !aliceTurn;
        }

        return (alice > bob) ? 1 : (bob > alice) ? -1 : 0;
    }
}