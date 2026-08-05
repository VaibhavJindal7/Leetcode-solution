class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        int[] vis = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<vis.length;i++){
            vis[i]=0;
            List<Integer> ls = new ArrayList<>();
            adj.add(ls);
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
        for(int i=0;i<n;i++) ans.add(i);
        for(int i=0;i<vis.length;i++){
            if(vis[i]==0){
                for(int a:adj.get(i)){
                    if(vis[a]!=0){
                          return ans;
                    }
                }
            }
        }
         List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
             if (vis[i] == 0)
                  ls.add(i);
        }
        return ls;
    }
}