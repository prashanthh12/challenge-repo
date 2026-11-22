class Solution:
    def sub(self,n:int)->int:
        p=1
        s=0
        while n>0:
            d=n%10
            p=p*d
            s=s+d
            n=n//10
        return p-s
sol=Solution()
r=sol.sub(234)
print(r)