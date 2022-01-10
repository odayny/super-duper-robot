class Solution:
    def addBinary(self, a: str, b: str) -> str:
        acc = 0
        a = list(a)
        b = list(b)
        res = ''
        while a or b or acc :
            if a :
                acc += int(a.pop())
            if b :
                acc += int(b.pop())
            res += str(acc%2)
            acc //= 2
        return res[::-1]
        
