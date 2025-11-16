
**Problem**: You are given two non-empty linked lists representing two non-negative integers. Add

**Solution**    

**File**: [prob_2_java](./prob_2.java)

Error Case
 - Input-E1: List-1:[], List-2:[], Expected: []
 - Input-E2: List-1:[], List-2:[1], Expected: [1]
 
Happy Cases:
 - Input-H1: List-1:[1], List-2:[8], Expected: [9]
 - Input-H2: List-1:[1], List-2:[9], Expected: [1,0]
 - Input-H2: List-1:[9,9,1], List-2:[9], Expected: [1,0,0,0]

Algorithm
- Use 2 stacks
  - traverse from left to right in a list while pushing to a stack
  - top of stack will have the right most digit
- while both stacks are not empty
  - pop from both stack as the digit, summing from right to left
  - keep track of 'carry'
- If one of them are not empty, then continue to calc with using carry
- If both of them are empty, then add 'carry' 

Analysis
- Space complexity: O(max(A.size(),B.size()))
- Time complexity: O(max(M,N)) because
  - Putting them to stacks,O(max(M,N))
  - Processing steps: O(max(M,N))
  - Linear 

***
