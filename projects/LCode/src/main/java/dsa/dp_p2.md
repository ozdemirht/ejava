
**Problem**: Given an array of integers cost[] of length n, where cost[i]
is the cost of the ith step on a staircase.
Once the cost is paid, we can either climb one or two steps.
We can either start from the step with index 0, or the step with index 1.
The task is to find the minimum cost to reach the top.

**Solution**:

File: [dp_p2_java](./dp_p2.java)

Solution : d[i] = min(d[i-2],d[i-1])+c[i]

Error Case
 - Input-E1 : {}, expected: 0

Happy Path
- Input-H1 : {10}, expected:0
- Input-H2 : {1,10}, expected:1
- Input-H3 : {1,10,1}, expected:2  , 1 step and 2 step

ALG-1: Memoization, recursive, Top-Down
- Time Complexity: O(n), because it needs to calculate d[i] without re-calculating the already calculated sub-problems. 
- Space Complexity: O(n), to store answers to the previously solved problem (d[j], j<i). Call stack is O(n).

ALG-2: Tabulation with an array, iterative, bottom-up 
- Time Complexity: O(n), because it needs to calculate d[i] without re-calculating the already calculated sub-problems.
- Space Complexity: O(n), to store answers to the previously solved problem (d[j], j<i)

ALG-3: Tabulation with 2 previous solutions, iterative, bottom-up 
- because it only needs to know the solution to the previous 2, iterative
- Time Complexity: O(n), because it needs to calculate d[i] without re-calculating the already calculated sub-problems.
- Space Complexity: O(1)

ALG-4: Memoization, iterative


***