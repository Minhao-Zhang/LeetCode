import java.util.HashMap;

public class SampleSolution {
    public static int findLHS(int[] nums) {
        HashMap < Integer, Integer > map = new HashMap < > ();
        int res = 0;
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key: map.keySet()) {
            if (map.containsKey(key + 1))
                res = Math.max(res, map.get(key) + map.get(key + 1));
        }
        return res;
    }
    
    public static int romanToInt(String S) 
    {
        int ans = 0, num = 0;
        
        for (int i = S.length()-1; i >= 0; i--) 
        {
            switch(S.charAt(i)) 
            {
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;
            }
            if (4 * num < ans) ans -= num;
            else ans += num;
        }
        return ans;
    }
    
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
