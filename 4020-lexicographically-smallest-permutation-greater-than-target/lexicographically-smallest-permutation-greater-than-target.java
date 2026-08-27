class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] originalFreq = new int[26];
        for (int k = 0; k < n; k++) {
            originalFreq[s.charAt(k) - 'a']++;
        }

        for (int i = n - 1; i >= 0; i--) {
            int[] freq = originalFreq.clone();
            boolean prefixValid = true;

            for (int j = 0; j < i; j++) {
                int charIdx = target.charAt(j) - 'a';
                if (freq[charIdx] > 0) {
                    freq[charIdx]--;
                } else {
                    prefixValid = false;
                    break;
                }
            }

            if (!prefixValid) continue;

            int targetChar = target.charAt(i) - 'a';
            for (int nextChar = targetChar + 1; nextChar < 26; nextChar++) {
                if (freq[nextChar] > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(target.substring(0, i));
                    sb.append((char) (nextChar + 'a'));
                    freq[nextChar]--;

                    for (int c = 0; c < 26; c++) {
                        while (freq[c] > 0) {
                            sb.append((char) (c + 'a'));
                            freq[c]--;
                        }
                    }
                    return sb.toString();
                }
            }
        }

        return "";
    }
}