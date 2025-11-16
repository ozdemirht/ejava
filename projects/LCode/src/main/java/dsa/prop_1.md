

**Problem**: Given an array of integers nums and an integer target, 
return indices of the two numbers such that they add up to target.

Additions

If there are not enough numbers, return [-1, -1]

Error Cases 
- Input-1: [] and target=2 expected output: [-1 -1]
- Input-2: [2] and target=2 expected output: [-1 -1]

Happy Cases
- Input-3: [2,3] and target=5 expected output: [0, 1]
- Input-4: [2,3] and target=4 expected output: [-1, -1]
- Input-5: [2,4,6] and target=5 expected output: [-1, -1]
- Input-6: [2,4,6] and target=10 expected output: [1, 2]
- 

Alg-1: for i for j , 
  - Time Complexity: O(n^2)
  - Space Complexity: O(1)

Alg-2:
```
a) sort Time Complexity: O(n log n),
b) binary search on sorted array, another index array
   Time Complexity : n times binary search, find_index_of(i,j,new_target) where new_target=target-a[i]
   Time Complexity : O(n log n)
    
a-b) Time Complexity: O(n log n)

a-b) Space complexity: O(n)
```