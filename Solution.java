import java.util.*;

public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }

        return null;
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String s1 = "";
        String s2 = "";
        
        for (String s : word1) {
            s1 += s;
        }
        for (String s : word2) {
            s2 += s;
        }

        return s1.equals(s2);
    }

    public static boolean checkZeroOnes(String s) {
        int zeroCount = 0;
        int oneCount = 0;
        int zeroLen = 0;
        int oneLen = 0;

        for (char c : s.toCharArray()) {
            if (c == '0') {
                zeroCount++;
                zeroLen = Math.max(zeroCount, zeroLen);
                oneCount = 0;
            } else {
                oneCount++;
                oneLen = Math.max(oneCount, oneLen);
                zeroCount = 0;
            }
        }
        return oneLen > zeroLen;
    }
    
    public static int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for (int i : prices) {
            if (i < min) {
                min = i;
            } else {
                profit = Math.max(i - min, profit);
            }
        }
        return profit;
    }

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
        String res = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            int num = 0;
            if (s.charAt(i) == '#') {
                num = Integer.parseInt(s.substring(i - 2, i));
                i -= 2;
            } else {
                num = Integer.parseInt(s.substring(i, i + 1));
            }

            res = (char) (num + 96) + res;
        }

        return res;
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
        for (int i = logs.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                String[] fst = logs[j].split(" ");
                String[] sec = logs[j + 1].split(" ");
                boolean swap = false;
                if (fst[1].charAt(0) < 97 && sec[1].charAt(0) < 97) {
                    swap = false;
                } else if (fst[1].charAt(0) < 97 && sec[1].charAt(0) >= 97) {
                    swap = true;
                } else if (fst[1].charAt(0) >= 97 && sec[1].charAt(0) < 97) {
                    swap = false;
                } else {
                    int res = 0;
                    int index = 1;
                    while (res == 0 && index < Math.min(fst.length, sec.length)) {
                        res = fst[index].compareTo(sec[index]);
                        index++;
                    }
                    if (res == 0) {
                        if (fst.length != sec.length) {
                            if (fst.length < sec.length) {
                                swap = false;
                            } else {
                                swap = true;
                            }
                        } else {
                            if (fst[0].compareTo(sec[0]) > 0) {
                                swap = true;
                            }
                        }
                    } else {
                        if (res > 0) {
                            swap = true;
                        }
                    }
                }

                if (swap) {
                    String front = logs[j];
                    String back = logs[j + 1];
                    logs[j] = back;
                    logs[j + 1] = front;
                }
            }
        }

        return logs;
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        Arrays.sort(candidates);
        combinationSum2Helper(result, curr, 0, target, candidates);
        return result;
    }

    private static void combinationSum2Helper(List<List<Integer>> result, List<Integer> curr, int start, int target,
            int[] candidates) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(curr));
            return;
        }
        if (target < 0) {
            return;
        }

        int prev = -1;
        for (int i = start; i < candidates.length; i++) {
            if (prev != candidates[i]) { // each time start from different element
                curr.add(candidates[i]);
                combinationSum2Helper(result, curr, i + 1, target - candidates[i], candidates); // and use next element
                                                                                                // only
                curr.remove(curr.size() - 1);
                prev = candidates[i];
            }
        }
    }

    public static int minMaxGame(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.min(nums[0], nums[1]);
        }
        int[] newNums = new int[nums.length / 2];
        for (int i = 0; i < newNums.length; i += 2) {
            newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
            newNums[i + 1] = Math.max(nums[2 * i + 2], nums[2 * i + 3]);
        }
        return minMaxGame(newNums);
    }

    public static int findLHS(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        counts = new TreeMap<>(counts);
        List<Integer> keys = new ArrayList<>(counts.keySet());
        int maxCount = 0;
        for (int i = 0; i < keys.size() - 1; i++) {
            if (keys.get(i) == keys.get(i + 1) - 1) {
                int curCount = counts.get(keys.get(i)) + counts.get(keys.get(i + 1));
                if (curCount > maxCount) {
                    maxCount = curCount;
                }
            }
        }

        return maxCount;
    }

    public static int romanToInt(String s) {
        int result = 0;
        char[] sArray = s.toCharArray();
        for (int i = 0; i < sArray.length; i++) {
            if (i < sArray.length - 1) {
                switch (sArray[i]) {
                    case 'I':
                        if (sArray[i + 1] == 'V' || sArray[i + 1] == 'X') {
                            result -= 1;
                        } else {
                            result += 1;
                        }
                        break;
                    case 'V':
                        result += 5;
                        break;
                    case 'X':
                        if (sArray[i + 1] == 'L' || sArray[i + 1] == 'C') {
                            result -= 10;
                        } else {
                            result += 10;
                        }
                        break;
                    case 'L':
                        result += 50;
                        break;
                    case 'C':
                        if (sArray[i + 1] == 'D' || sArray[i + 1] == 'M') {
                            result -= 100;
                        } else {
                            result += 100;
                        }
                        break;
                    case 'D':
                        result += 500;
                        break;
                    case 'M':
                        result += 1000;
                        break;
                }
            } else {
                switch (sArray[i]) {
                    case 'I':
                        result += 1;
                        break;
                    case 'V':
                        result += 5;
                        break;
                    case 'X':
                        result += 10;
                        break;
                    case 'L':
                        result += 50;
                        break;
                    case 'C':
                        result += 100;
                        break;
                    case 'D':
                        result += 500;
                        break;
                    case 'M':
                        result += 1000;
                        break;
                }
            }
        }
        return result;
    }

    public static int countTriples(int n) {
        int count = 0;
        for (int i = 4; i < n; i++) {
            for (int j = 3; j < i; j++) {
                int ij = i * i + j * j;
                int sqrt = (int) Math.sqrt(ij);
                if (sqrt * sqrt == ij && sqrt <= n)
                    count += 2;
            }
        }
        return count;
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCount[sArray[i] - 97]++;
            charCount[tArray[i] - 97]--;
        }
        for (int i = 0; i < 26; i++) {
            if (charCount[i] != 0)
                return false;
        }

        return true;
    }
}
