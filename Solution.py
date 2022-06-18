import math


class Solution:
    def minMaxGame(self, nums: list[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        newNums = [0] * int(len(nums)/2)
        for i in range(int(len(nums)/2)):
            if i % 2 == 0:
                newNums[i] = min(nums[2 * i], nums[2 * i + 1])
            else:
                newNums[i] = max(nums[2 * i], nums[2 * i + 1])
        return self.minMaxGame(newNums)        

    
    def findLHS(self, nums: list[int]) -> int:
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
