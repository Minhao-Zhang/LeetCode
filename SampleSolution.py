from collections import Counter
import math
from typing import List


class SampleSolution:
    def canMakeArithmeticProgression(self, arr: List[int]) -> bool:
        arr.sort()
        diff=abs(arr[0] - arr[1])
        for i in range(1,len(arr)-1):
            if abs(arr[i] - arr[i+1]) != diff:
                return False
        return True
    
    def numDifferentIntegers(self, word: str) -> int:
        word = word + 'a'
        ht = dict() 
        
        tmpStr = ""
        for ch in word:
            if not 'a' <= ch <= 'z':
                tmpStr += ch
            else:
                if tmpStr != "":
                    ht[int(tmpStr)] = 1
                    tmpStr = "" 
        return len(ht)
    
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap = {}
        for i in range(len(nums)):
            complement = target - nums[i]
            if complement in hashmap:
                return [i, hashmap[complement]]
            hashmap[nums[i]] = i
    
    def arrayStringsAreEqual(self, word1: List[str], word2: List[str]) -> bool:
        return "".join(word1) == "".join(word2)
    
    def checkZeroOnes(self, s: str) -> bool:
        cnt_one, max_one = 0, 0
        cnt_zero, max_zero = 0, 0
        prev = None
        
        for c in s:
            if c == "1":
                cnt_one += 1
                max_one = max(max_one, cnt_one)
                cnt_zero = 0

            else:
                cnt_zero += 1
                max_zero = max(max_zero, cnt_zero)
                cnt_one = 0
            
            prev = c
        
        return max_one > max_zero
    
    def maxProfit(self, prices: List[int]) -> int:
        minPrice, maxProfit = float(math.inf), 0
        for price in prices:
            if price < minPrice:
                minPrice = price

            curProfit = price - minPrice
            if curProfit > maxProfit:
                maxProfit = curProfit

        return maxProfit
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
        i = len(s) - 1
        ans = []
        while i >= 0:
            if s[i] == '#':
                ans.append(chr(ord('`')+int(s[i-2:i])))
                i -= 3
            else:
                ans.append(chr(ord('`')+int(s[i])))
                i -= 1
        return ''.join(reversed(ans))
    
    def buildArray(self, target: List[int], n: int) -> List[str]:
        target_set = set(target)
        maximum = min(target[-1], n)
        output = []
        for i in range(1, maximum + 1):
            if i in target_set:
                output.append("Push")
            else:
                output.extend(["Push", "Pop"])
        
        return output
    
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        if not trust and n==1: return 1
        if len(trust) < n-1: return -1
        l1 = [a for a, b in trust]
        l2 = set(b for a,b in trust)
        miss_vals = set(range(1,n+1)) - set(l1)
        for val in miss_vals:
            l3 = [a for a, b in trust if b == val]
            if not l3: continue
            l3.append(val)
            l3.sort()
            if l3 == list(range(1,n+1)):
                return val            
        return -1
    
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        digits = []
        letters = []
        
        for l in logs:
            if l.split(" ")[1].isdigit():
                digits.append(l)
            else:
                letters.append(l)
        
        letters.sort(key=lambda log: log.split(" ", 1)[0])
        letters.sort(key=lambda log: log.split(" ", 1)[1])
        return letters + digits
    
    def combinationSum2(self, candidates: List[int], target: int) -> list[List[int]]:
        def backtrack(comb, remain, curr, results):

            if remain == 0:
                # make a deep copy of the resulted combination
                results.append(list(comb))
                return

            for next_curr in range(curr, len(candidates)):

                if next_curr > curr \
                  and candidates[next_curr] == candidates[next_curr-1]:
                    continue

                pick = candidates[next_curr]
                # optimization: skip the rest of elements starting from 'curr' index
                if remain - pick < 0:
                    break

                comb.append(pick)
                backtrack(comb, remain - pick, next_curr + 1, results)
                comb.pop()

        candidates.sort()

        comb, results = [], []
        backtrack(comb, target, 0, results)

        return results
    
    def minMaxGame(self, nums: List[int]) -> int:
        while len(nums) > 1:
            newnums = []
            for i in range(len(nums)//2):
                if i%2 == 0:
                    newnums.append(min(nums[2*i],nums[2*i+1]))
                else:
                    newnums.append(max(nums[2*i],nums[2*i+1]))
            nums = newnums
            
        return nums[0]
    
    def findLHS(self, nums: list[int]) -> int:
        c = Counter(nums)
        largestlength = 0 
        for n in c: 
            if n+1 in c: 
                largestlength = max(largestlength, c[n]+c[n+1])
                
        return largestlength
    
    def romanToInt(self, s: str) -> int:
        roman_table = {"I":1,"V":5,"X":10,"L":50,"C":100,"D":500,"M":1000}
        num = 0
        last = "I"
        for numeral in s[::-1]:
            if roman_table[numeral]<roman_table[last]:
                num -= roman_table[numeral]
            else:
                num += roman_table[numeral]
            last = numeral
        return num
    
    def countTriples(self, x: int) -> int:
        result = 0
        xsqrt = math.ceil(math.sqrt(x))
        gcd = math.gcd
        for m in range(1, xsqrt, 2):
            for n in range(2, xsqrt, 2):
                if gcd(m, n) == 1:
                    c = m ** 2 + n ** 2
                    result = result + x // c
        return 2 * result
    
    def isAnagram(self, s: str, t: str) -> bool:
        for c in 'abcdefghijklmnopqrstuvwxyz':
            if s.count(c) != t.count(c): return False
        return True