# rogs can croak at the same time, so multiple "croak" are mixed.

# Return the minimum number of different frogs to finish all the croaks in the given string.

# A valid "croak" means a frog is printing five letters 'c', 'r', 'o', 'a', and 'k' sequentially. The frogs have to print all five letters to finish a croak. If the given string is not a combination of a valid "croak" return -1.

 

# Example 1:

# Input: croakOfFrogs = "croakcroak"
# Output: 1 
# Explanation: One frog yelling "croak" twice.
# Example 2:

# Input: croakOfFrogs = "crcoakroak"
# Output: 2 
# Explanation: The minimum number of frogs is two. 
# The first frog could yell "crcoakroak".
# The second frog could yell later "crcoakroak".
# Example 3:

# Input: croakOfFrogs = "croakcrook"
# Output: -1
# Explanation: The given string is an invalid combination of "croak" from different frogs.
 

# Constraints:

# 1 <= croakOfFrogs.length <= 105
# croakOfFrogs is either 'c', 'r', 'o', 'a', or 'k'.

class Solution:
    def minNumberOfFrogs(self, croak: str) -> int:
        #input:string of croak sounds
        #output:minimum number of differents frogs
        '''
        if the word "croak" is next to each other, then consider as one frog
        if the word "croak" is a permutation of two or more "croak", then count them separately
        
        create a list contains the word "croak"
        loop through the given string using two pointers technique
        
        one int to track the current 
        '''
       
        c, r, o, a, k, in_use, answer = 0, 0, 0, 0, 0, 0, 0
        for d in croak:
            if d == 'c':
                c, in_use = c+1, in_use+1
            elif d == 'r':
                r += 1
            elif d == 'o':
                o += 1
            elif d == 'a':
                a += 1
            else:
                k, in_use = k+1, in_use-1
                
            answer = max(answer, in_use)
            
            if c < r or r < o or o < a or a < k:
                return -1
            
        if in_use == 0 and c == r and r == o and o == a and a == k:
            return answer
        
        return -1        
                
            
        
        
   
        