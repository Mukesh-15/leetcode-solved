class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] invoke : invocations){
            adj.get(invoke[0]).add(invoke[1]);
        }

        dfs(adj, k, visited);

        boolean valid = true;

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                for(int nei : adj.get(i)){
                    if(visited[nei]){
                        valid = false;
                        break;
                    }
                }
            }
        }

        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(valid && visited[i]){
                continue;
            }

            res.add(i);
        }

        return res;
    }

    private void dfs(List<List<Integer>> adj, int curr, boolean[] visited){
        visited[curr] = true;

        for(int nei : adj.get(curr)){
            if(!visited[nei]){
                dfs(adj, nei, visited);
            }
        }
    }
}