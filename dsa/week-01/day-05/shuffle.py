class Solution:
    def shuffle(slef,num:list[int],n:int)->list[int]:
        ans=[0]*(2*n)
        for i in range(n):
            ans[2*i]=num[i]
            ans[2*i+1]=num[i+n]
        return ans
sol=Solution();
size=3
num=[1,4,6,7,3,8]
r=sol.shuffle(num,size)
print("Shuffled List:",r)

