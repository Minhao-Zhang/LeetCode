from collections import Counter
import math
from typing import List


class SampleSolution:
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