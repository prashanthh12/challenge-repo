class Solution:
    def runarr(self,nums:list[int])->list[int]:
            for i in range(1,len(nums)):
                  nums[i]=nums[i]+nums[i-1]
            return nums
sol=Solution()
no=[1,3,5,7]
print("sum:",sol.runarr(no))