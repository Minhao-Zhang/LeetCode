public class Solution {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        // int[] charCount = new int[26];
        // for (int i = 0; i < s.length(); i++) {
        //     charCount[s.charAt(i) - 97]++;
        // }
        // for (int i = 0; i < t.length(); i++) {
        //     charCount[t.charAt(i) - 97]--;
        // }
        // for (int i = 0; i < 26; i++) {
        //     if (charCount[i] != 0) return false;
        // }

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
