public class Solution {
    public static int romanToInt(String s) {
        int result = 0;
        char[] sArray = s.toCharArray();
        for (int i = 0; i < sArray.length; i++) {
            if (i < sArray.length - 1) {
                switch(sArray[i]) {
                    case 'I': 
                        if (sArray[i + 1] == 'V' || sArray[i + 1] == 'X') {
                            result -= 1;
                        } else {
                            result += 1; 
                        }
                        break;
                    case 'V': result += 5; break;
                    case 'X': 
                        if (sArray[i + 1] == 'L' || sArray[i + 1] == 'C') {
                            result -= 10;
                        } else {  
                            result += 10; 
                        }
                        break;
                    case 'L': result += 50; break;
                    case 'C': 
                        if (sArray[i + 1] == 'D' || sArray[i + 1] == 'M') {
                            result -= 100;
                        } else {
                            result += 100; 
                        }
                        break;
                    case 'D': result += 500; break;
                    case 'M': result += 1000; break;
                }
            } else {
                switch(sArray[i]) {
                    case 'I': result += 1; break;
                    case 'V': result += 5; break;
                    case 'X': result += 10; break;
                    case 'L': result += 50; break;
                    case 'C': result += 100; break;
                    case 'D': result += 500; break;
                    case 'M': result += 1000; break;
                }
            }
        }
        return result;
    }
    
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
