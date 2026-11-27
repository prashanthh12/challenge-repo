class Sol:
    def custrich(self,accounts:list[list[int]])->int:
        mw=0
        for acnt in accounts:
            sum=0
            for amt in acnt:
                sum=sum+amt
            if sum>mw:
                mw=sum
        return mw
sol=Sol()
acnt=[[6,4,2],[3,7,1]]
print("Rich",sol.custrich(acnt))