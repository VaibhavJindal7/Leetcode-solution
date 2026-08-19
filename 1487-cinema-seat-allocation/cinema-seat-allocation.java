class Solution {
    public int maxNumberOfFamilies(int n, int[][] rs) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int[] r : rs) {
            map.put(r[0], map.getOrDefault(r[0], 0) | (1 << r[1]));
        }

        int ans = (n - map.size()) * 2;

        for (int mask : map.values()) {

            boolean left = (mask & 60) == 0;   
            boolean middle = (mask & 240) == 0; 
            boolean right = (mask & 960) == 0;  

            if (left && right)
                ans += 2;
            else if (left || middle || right)
                ans++;
        }

        return ans;
    }
}
