'''
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
'''

'''
Approach 1: Brute Force
Time Complexity: O(n^2)
Space Complexity: O(1)
'''

nums=[1,3,4,2]
target=6
targetList=[]
flag=False
for i in range(len(nums)):
    for j in range(i,+1,len(nums),1):
        if(nums[i]+nums[j]==target):
            targetList.append(i)
            targetList.append(j)
            flag=True
            break
    if(flag==True):
        break
for num in targetList:
    print(num)

'''
Approach 2: Two-pass Hash Table

hashMap={}
for i in range(len(nums)):
    hashMap[nums[i]]=i
for i in range(len(nums)):
    complement = target-nums[i]
    if complement in hashMap and hashMap[complement]!=i:
        return [i, hashMap[complement]]

Time: T(n)=O(n)
Space: S(n)=O(n)

Approach 3: One-pass Hash Table

hashMap={}
for i in range(len(nums)):
    complement=target-num[i]
    if complement in hashMap:
        return [i, hashMap[complement]]
    hashMap[nums[i]]=i

Time: T(n)=O(n)
Space: S(n)=O(n)
'''
