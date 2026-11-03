
class Solution {
    int n;
    long[][] tree;
    long neg = Long.MIN_VALUE / 4;
    int mod = 1000000007;

    public int maximumSumSubsequence(int[] nums, int[][] queries) {
        n = nums.length;
        tree = new long[4 * n][4];

        build(1, 0, n - 1, nums);

        long ans = 0;

        for (int[] q : queries) {
            update(1, 0, n - 1, q[0], q[1]);

            long best = 0;

            for (int i = 0; i < 4; i++) {
                best = Math.max(best, tree[1][i]);
            }

            ans = (ans + best) % mod;
        }

        return (int) ans;
    }

    void build(int node, int l, int r, int[] nums) {
        if (l == r) {
            tree[node][0] = 0;
            tree[node][1] = neg;
            tree[node][2] = neg;
            tree[node][3] = nums[l];
            return;
        }

        int mid = (l + r) / 2;

        build(node * 2, l, mid, nums);
        build(node * 2 + 1, mid + 1, r, nums);

        merge(node);
    }

    void update(int node, int l, int r, int pos, int val) {
        if (l == r) {
            tree[node][0] = 0;
            tree[node][1] = neg;
            tree[node][2] = neg;
            tree[node][3] = val;
            return;
        }

        int mid = (l + r) / 2;

        if (pos <= mid) {
            update(node * 2, l, mid, pos, val);
        } else {
            update(node * 2 + 1, mid + 1, r, pos, val);
        }

        merge(node);
    }

    void merge(int node) {
        long[][] temp = new long[2][2];

        for (int a = 0; a < 2; a++) {
            for (int d = 0; d < 2; d++) {

                long case1 = tree[node * 2][a * 2 + 1]
                           + tree[node * 2 + 1][d];

                long case2 = tree[node * 2][a * 2]
                           + tree[node * 2 + 1][d];

                long case3 = tree[node * 2][a * 2]
                           + tree[node * 2 + 1][2 + d];

                temp[a][d] = Math.max(case1,
                               Math.max(case2, case3));
            }
        }

        tree[node][0] = temp[0][0];
        tree[node][1] = temp[0][1];
        tree[node][2] = temp[1][0];
        tree[node][3] = temp[1][1];
    }
}
