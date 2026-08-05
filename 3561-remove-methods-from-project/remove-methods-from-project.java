class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        int[] vis = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<vis.length;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<invocations.length;i++){
            int a = invocations[i][0];
            int b = invocations[i][1];
            adj.get(a).add(b);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        vis[k]=1;
        while(!q.isEmpty()){
            int node = q.remove();
            for(int i:adj.get(node)){
                if(vis[i]==1) continue;
                q.add(i);
                vis[i]=1;
            }
        }
        List<Integer> ans = new ArrayList<>();
       for (int[] edge : invocations) {
           int u = edge[0];
           int v = edge[1];

           if (vis[u] == 0 && vis[v] == 1) {
                for (int i = 0; i < n; i++) ans.add(i);
                return ans;
            }
        }
         
        for (int i = 0; i < n; i++) {
             if (vis[i] == 0)
                  ans.add(i);
        }
        return ans;
    }
}