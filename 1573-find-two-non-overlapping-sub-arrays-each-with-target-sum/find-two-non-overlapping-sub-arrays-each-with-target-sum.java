
class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;
        HashMap<Integer, Integer> mp = new HashMap<>();

        mp.put(0, -1);
        mp.put(arr[0], 0);

        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1];
            mp.put(arr[i], i);
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1000000);
        int ans = 1000000;

        for (int i = 0; i < n; i++) {

            int x = arr[i] - target;
            if (mp.containsKey(x)) {
                int p = mp.get(x);
                int len = i - p;

                dp[i] = (i > 0)
                    ? Math.min(dp[i - 1], len)
                    : len;

                if (p != -1 && dp[p] != 1000000) {
                    ans = Math.min(ans, len + dp[p]);
                }

            } else if (i > 0) {

                dp[i] = dp[i - 1];
            }
        }
        return ans == 1000000 ? -1 : ans;
    }
}