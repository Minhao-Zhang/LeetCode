import math
from typing import List
from functools import cmp_to_key


class Solution:
    class TreeNode:
        def __init__(self, val=0, left=None, right=None):
            self.val = val
            self.left = left
            self.right = right
            
    def findTilt(self, root: TreeNode) -> int:
        total_tilt = 0

        def valueSum(node):
            nonlocal total_tilt

            if not node:
                return 0

            left_sum = valueSum(node.left)
            right_sum = valueSum(node.right)
            tilt = abs(left_sum - right_sum)
            total_tilt += tilt

            return left_sum + right_sum + node.val

        valueSum(root)

        return total_tilt
    
    def freqAlphabets(self, s: str) -> str:
        res = ""
        i = len(s) - 1
        while (i >= 0):
            if s[i] == '#':
                num = int(s[i - 2 : i])
                i -= 3
            else:
                num = int(s[i : i + 1])
                i -= 1
            
            res = chr(num + 96) + res
        return res
        
    def buildArray(self, target: List[int], n: int) -> List[str]:
        res: List[str] = []
        index = 0
        i = 0
        while (i < n and index < len(target)):
            if target[index] == i + 1:
                res.append("Push")
                index += 1
            else: 
                res.append("Push")
                res.append("Pop")
            i += 1
        return res
    
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if n == 1: return 1
        
        truster: List[int] = [0]*n
        trustee: List[int] = [0]*n
        
        for i in range(len(trust)):
            truster[trust[i][0] - 1] += 1
            trustee[trust[i][1] - 1] += 1
        
        for i in range(n):
            if trustee[i] == n - 1 and truster[i] == 0:
                return i + 1
        
        return -1
    
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        def compare(x: str, y: str) -> int: 
            xInt = x.find(" ")
            yInt = y.find(" ")
            xChar = x[xInt + 1]
            yChar = y[yInt + 1]
            if xChar <= '9' :
                if yChar <= '9':
                    return 0
                else: 
                    return 1 
            if yChar <= '9':
                return -1
            
            temp = x[xInt:] == y[yInt:]
            if temp:
                return (x[:xInt + 1] > y[:yInt + 1]) * 2 - 1
            return (x[xInt:] > y[yInt:]) * 2 - 1
        return sorted(logs, key=cmp_to_key(compare))
        
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        res: list[list[int]] = list()
        if len(candidates) == 0:
            return res
        
        counts = [0]*51
        for i in candidates:
            counts[i] += 1
        
        self.combinationSum2Helper(counts, res, target, list(), 1)
        
        return res
    
    def combinationSum2Helper(self, counts: List[int], res: List[List[int]], target: int, path: List[int], index: int):
        if target == 0:
            res.append(path.copy())
            return
        
        for i in range(index, len(counts), 1):
            if i <= target and counts[i] > 0:
                counts[i] -= 1
                path.append(i)
                self.combinationSum2Helper(counts, res, target - i, path, i)
                path.pop()
                counts[i] += 1
            else:
                if i > target:
                    return
        
    def minMaxGame(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        newNums = [0] * int(len(nums)/2)
        for i in range(int(len(nums)/2)):
            if i % 2 == 0:
                newNums[i] = min(nums[2 * i], nums[2 * i + 1])
            else:
                newNums[i] = max(nums[2 * i], nums[2 * i + 1])
        return self.minMaxGame(newNums)        

    
    def findLHS(self, nums: List[int]) -> int:
        counts = {}
        for num in nums:
            if num not in counts:
                counts[num] = 1
            else:
                counts[num] = counts[num] + 1
        longest = 0
        for key in counts.keys():
            if (key + 1) in counts:
                temp = counts.get(key) + counts.get(key + 1)
                if temp > longest:
                    longest = temp
        
        return longest
    
    def romanToInt(self, s: str) -> int:
        ans = 0
        num = 0
        
        for c in list(s)[::-1]:
            if c == 'I':
                num = 1
            elif c == 'V':
                num = 5
            elif c == 'X':
                num = 10
            elif c == 'L':
                num = 50
            elif c == 'C':
                num = 100
            elif c == 'D':
                num = 500
            elif c == 'M':
                num = 1000
            else:
                raise Exception

            if 4 * num < ans:
                ans -= num
            else:
                ans += num
        return ans
        
    def countTriples(self, n: int) -> int:
        i = 2
        count = 0
        while True:
            for j in range(1, i, 1):
                if math.gcd(i, j) != 1 or (i % 2 == 1 and j % 2 == 1):
                    continue

                ij = i**2 + j**2
                if (ij <= n):
                    count += n//ij
                elif j == 1:
                    return 2*count
            i += 1

    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        sList = list(s)
        tList = list(t)
        charCount = [0]*26
        for i in range(len(s)):
            charCount[ord(sList[i]) - 97] += 1
            charCount[ord(tList[i]) - 97] -= 1

        for i in range(26):
            if charCount[i] != 0:
                return False

        return True
