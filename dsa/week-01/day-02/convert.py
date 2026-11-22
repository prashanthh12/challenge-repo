class Solution:
    def convertT(self,celsius:float)->list[float]:
        k=celsius+273.00
        f=celsius*1.80+32.00
        return [k,f]
sol=Solution()
result=sol.convertT(36.50)
print(result)
