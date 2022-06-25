import java.util.*;

public class SampleSolution {
    private int totalTilt = 0;

    public int findTilt(TreeNode root) {
        this.totalTilt = 0;
        this.findTiltHelper(root);
        return this.totalTilt;
    }

    private int findTiltHelper(TreeNode node) {
        if (node == null)
            return 0;

        int leftSum = this.findTiltHelper(node.left);
        int rightSum = this.findTiltHelper(node.right);
        int tilt = Math.abs(leftSum - rightSum);
        this.totalTilt += tilt;

        return node.val + leftSum + rightSum;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static String freqAlphabets(String s) {
        char[] ch = s.toCharArray();
        char[] c = new char[s.length()];
        int a = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 2 < s.length() && ch[i + 2] == '#') {
                c[a++] = (char) ((ch[i] - '0') * 10 + (ch[i + 1] - '1') + 'a');
                i += 2;
            } else {
                c[a++] = (char) ((ch[i] - '1') + 'a');
            }
        }
        String st = String.valueOf(c).trim();
        return st;
    }

    public static List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < n && index < target.length; i++) {
            if (target[index] == i + 1) {
                res.add("Push");
                index++;
            } else {
                res.add("Push");
                res.add("Pop");
            }
        }
        return res;
    }

    public static int findJudge(int n, int[][] trust) {
        if (n == 1)
            return 1;
        int[] truster = new int[n];
        int[] trustee = new int[n];
        for (int i = 0; i < trust.length; i++) {
            truster[trust[i][0] - 1]++;
            trustee[trust[i][1] - 1]++;
        }

        for (int i = 0; i < n; i++) {
            if (trustee[i] == n - 1 && truster[i] == 0) {
                return i + 1;
            }
        }

        return -1;
    }

    public static String[] reorderLogFiles(String[] logs) {
        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int s1SpaceIndex = s1.indexOf(' ');
                int s2SpaceIndex = s2.indexOf(' ');
                char s1FirstCharacter = s1.charAt(s1SpaceIndex + 1);
                char s2FirstCharacter = s2.charAt(s2SpaceIndex + 1);

                if (s1FirstCharacter <= '9') {
                    if (s2FirstCharacter <= '9')
                        return 0;
                    else
                        return 1;
                }
                if (s2FirstCharacter <= '9')
                    return -1;

                int preCompute = s1.substring(s1SpaceIndex + 1).compareTo(s2.substring(s2SpaceIndex + 1));
                if (preCompute == 0)
                    return s1.substring(0, s1SpaceIndex).compareTo(s2.substring(0, s2SpaceIndex));
                return preCompute;
            }
        };
        Arrays.sort(logs, myComp);
        return logs;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0)
            return res;

        int[] counts = new int[51];
        for (int c : candidates)
            counts[c]++;

        combinationSum2Helper(counts, res, target, new ArrayList<Integer>(), 1);

        return res;
    }

    private void combinationSum2Helper(int[] counts, List<List<Integer>> res, int target, List<Integer> path,
            int index) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < counts.length; i++) {
            if (i <= target && counts[i] > 0) {
                counts[i]--;
                path.add(i);
                combinationSum2Helper(counts, res, target - i, path, i);
                path.remove(path.size() - 1);
                counts[i]++;
            } else if (i > target)
                return;
        }
    }

    public static int minMaxGame(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int[] newNums = new int[nums.length / 2];
        for (int i = 0; i < nums.length / 2; i++) {
            if (i % 2 == 0)
                newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
            else
                newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
        }
        return minMaxGame(newNums);
    }

    public static int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1))
                res = Math.max(res, map.get(key) + map.get(key + 1));
        }
        return res;
    }

    public static int romanToInt(String S) {
        int ans = 0, num = 0;

        for (int i = S.length() - 1; i >= 0; i--) {
            switch (S.charAt(i)) {
                case 'I':
                    num = 1;
                    break;
                case 'V':
                    num = 5;
                    break;
                case 'X':
                    num = 10;
                    break;
                case 'L':
                    num = 50;
                    break;
                case 'C':
                    num = 100;
                    break;
                case 'D':
                    num = 500;
                    break;
                case 'M':
                    num = 1000;
                    break;
            }
            if (4 * num < ans)
                ans -= num;
            else
                ans += num;
        }
        return ans;
    }

    public static int countTriples(int n) {
        int x = 2;
        int sum = 0;

        while (true) {
            for (int y = 1; y < x; y++) {
                if (gcd(x, y) != 1 || ((x % 2) == 1 && (y % 2) == 1)) {
                    continue;
                }

                int res = x * x + y * y;
                if (res <= n) {
                    sum += n / res;
                } else if (y == 1) {
                    return 2 * sum;
                }
            }
            x++;
        }
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
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
