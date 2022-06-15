public class Solution {
    public static int countTriples(int n) {
        int count = 0;
        for (int i = 4; i < n; i++) {
            for (int j = 3; j < i; j++) {
                int ij = i*i + j*j;
                int sqrt = (int)Math.sqrt(ij);
                if (sqrt*sqrt == ij && sqrt <= n) count += 2;
            }
        }
        return count;
    }
    
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCount[sArray[i] - 97]++;
            charCount[tArray[i] - 97]--;
        }
        for (int i = 0; i < 26; i++) {
            if (charCount[i] != 0) return false;
        }

        return true;
    }
}
