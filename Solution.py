class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t): return False

        sList = list(s)
        tList = list(t)
        charCount = [0]*26
        for i in range(len(s)):
            charCount[ord(sList[i]) - 97] += 1
            charCount[ord(tList[i]) - 97] -= 1
        
        for i in range(26):
            if charCount[i] != 0: return False
        
        return True