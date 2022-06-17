import math


class SampleSolution:
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