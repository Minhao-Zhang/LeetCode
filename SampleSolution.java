public class SampleSolution {
    public static int countTriples(int n) {
        int x = 2;
        int sum = 0;
        
        while(true) {
            for(int y = 1; y < x; y++) {
                if (gcd(x, y) != 1 || ((x % 2) == 1 && (y % 2) == 1)) {
                    continue;
                }
                
                int res = x * x + y * y;
                if(res <= n) {
                    sum += n / res;
                } else if (y == 1) {
                    return 2 * sum;
                }
            }
            x++;
        }
    }
    
    public static int gcd(int a, int b) {
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    
    public static boolean isAnagram(String s, String t) {
        int[] freq = new int[26];
        
        for (char c : s.toCharArray()) {
            freq[c - 'a'] += 1;
        }
        
        for (char c : t.toCharArray()) {
            freq[c - 'a'] -= 1;
        }
        
        for (int i : freq) {
            if (i != 0) {
                return false;
            }
        }
        
        return true;
    }
}
