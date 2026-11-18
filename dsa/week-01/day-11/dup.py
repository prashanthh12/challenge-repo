def duplicate(nums):
    seen=set()
    for num in nums:
        if num in seen:
            return True
        seen.add(num)
    return False
v=[1,2,4,5,7,4,1,8]
print(duplicate(v))