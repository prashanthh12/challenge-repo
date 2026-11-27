class Sol:
    def findNum(self,nums:list[int])->int:
        count=0
        for num in nums:
            digits=0
            while num>0:
                num=num//10
                digits+=1
            if digits%2==0:
                count+=1
        return count
sl=Sol()
no=[45,693,78365,4024]
print("Count:",sl.findNum(no))