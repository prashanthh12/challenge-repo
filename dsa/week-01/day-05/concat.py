class Solution:
    def concat(self,nums:list[int])->list[int]:
        n=len(nums)
        ans=[0]*(2*n)
        for i in range(n):
            ans[i]=nums[i]
            ans[i+n]=nums[i]
        return ans
sol=Solution()
no=[1,2,1]
print("Concated List:",sol.concat(no))