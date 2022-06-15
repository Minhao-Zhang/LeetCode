import math


class SampleSolution:
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